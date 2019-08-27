package com.lenovo.m2.oc.canal.service.consumer.kafka;

import com.alibaba.fastjson.JSON;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.oc.canal.common.utils.OrderCodeAndUUIDLogTrace;
import com.lenovo.m2.oc.canal.service.TransToESService;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * update by licy13 on 2017/5/12
 */
public class KafkaConsumer{

    private static Logger LOGGER = LogManager.getLogger(KafkaConsumer.class.getName());

    private final String TYPE_TRANS_TO_ES = "transToES";// 全量库订单信息转移到 ES

    private String type;
    private String topicName;
    private String groupName;
    private ExecutorService executor;
    private KafkaConsumerOptions options;
    private ConsumerConnector connector;

    @Resource(name = "TransOrderInfoToESService")
    private TransToESService transToESService;


    public KafkaConsumer(KafkaConsumerOptions kafkaConsumerOption, String topicName, String groupName, String type) {
        this.options = kafkaConsumerOption;
        this.topicName = topicName;
        this.groupName = groupName;
        this.type = type;
    }

    public KafkaConsumer() {

    }

    public void initialize() {
        Properties props = new Properties();
        props.put("zookeeper.connect", this.options.getConnectionZk());
        props.put("group.id", this.groupName);
        props.put("zookeeper.session.timeout.ms", this.options.getZkSessionTimeout());
        props.put("zookeeper.sync.time.ms", this.options.getZkSyncTime());
        props.put("auto.commit.interval.ms", this.options.getAutoCommitInterval());
        props.put("rebalance.backoff.ms", this.options.getRebalanceBackOff());
        props.put("rebalance.max.retries", this.options.getRebalanceMaxRetries());
        props.put("auto.offset.reset", this.options.getAutoOffsetReset());
        ConsumerConfig config = new ConsumerConfig(props);
        this.connector = Consumer.createJavaConsumerConnector(config);
    }


    /**
     * 多线程消费，建议和partition数量一致
     */
    public void run(int partitionNum) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topicName, new Integer(partitionNum));// 描述读取哪个topic，需要几个线程读
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = connector.createMessageStreams(topicCountMap);// 创建Streams
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topicName);// 每个线程对应于一个KafkaStream
        // now launch all the threads
        executor = Executors.newFixedThreadPool(streams.size());
        // now create an object to consume the messages
        int threadNumber = 0;
        try {
            for(final KafkaStream stream : streams) {

                final Integer threadNo = threadNumber;
                if (TYPE_TRANS_TO_ES.equals(type)) {
                    executor.submit(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                ConsumerIterator<byte[], byte[]> it = stream.iterator();
                                while (it.hasNext()) {
                                    String orderCodeStr = new String(it.next().message());
                                    if(StringUtils.isEmpty(orderCodeStr)){
                                        LOGGER.error("trans order to es ,kafka consumer receive an empty msg ");
                                        continue;
                                    }
                                    OrderCodeAndUUIDLogTrace trace = new OrderCodeAndUUIDLogTrace(orderCodeStr);
                                    LOGGER.info("transToESService start, threadNO:{} traceId:{} ", threadNo, trace.toString());
                                    RemoteResult result = transToESService.injectData2ES(Long.parseLong(orderCodeStr));
                                    LOGGER.info("transToESService return, {}", JSON.toJSONString(result));
                                    trace.removeTracert();
                                }
                            } catch (Exception e) {
                                LOGGER.error("Run MessageConsumerOrderCenter consumer catch Exception. " + e);
                            }
                        }
                    });
                }
                threadNumber++;
            }
        } catch(Exception e) {
            LOGGER.error("Run message consumer catch Exception. " + e);
        }
    }

    public void shutdown() {
        LOGGER.info("KafkaConsumer shutdown topicName={}", topicName);
        if (connector != null) {
            connector.shutdown();
        }
        if (executor != null) {
            executor.shutdown();
        }
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                LOGGER.info("KafkaConsumer shutdown: Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch(InterruptedException e) {
            LOGGER.info("KafkaConsumer shutdown: Interrupted during shutdown, exiting uncleanly");
        }
    }

}