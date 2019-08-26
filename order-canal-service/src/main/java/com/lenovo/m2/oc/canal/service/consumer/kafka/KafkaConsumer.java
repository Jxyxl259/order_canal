package com.lenovo.m2.oc.canal.service.consumer.kafka;


import com.lenovo.m2.buy.order.transferservice.service.PrepareForThrowService;
import com.lenovo.m2.buy.order.transferservice.service.toordercenter.SMBTransferToOrderCenterService;
import com.lenovo.m2.buy.order.transferservice.service.toordercenter.TransferToOrderCenterService;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * update by licy13 on 2017/5/12
 */
public class KafkaConsumer {

    private static Logger LOGGER = LogManager.getLogger(KafkaConsumer.class.getName());
    private final String TYPE_ORDERCENTER = "ordercenter";//执行全量库方法
    private final String TYPE_THROW = "throw";//执行抛单库方法

    private String type;
    private String topicName;
    private String groupName;
    private ExecutorService executor;
    private KafkaConsumerOptions options;
    private ConsumerConnector connector;

    @Autowired
    private TransferToOrderCenterService transferToOrderCenterService;


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

                if (TYPE_ORDERCENTER.equals(type)) {
                    executor.submit(new MessageConsumerOrderCenter(stream, threadNumber, topicName, transferToOrderCenterService,smbTransferToOrderCenterService));
                } else if (TYPE_THROW.equals(type)) {
                    executor.submit(new MessageConsumerThrow(stream, threadNumber, topicName, prepareForThrowService));
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



    private static Logger LOGGER = LogManager.getLogger(KafkaConsumer.class.getName());
    private final String TYPE_ORDERCENTER = "ordercenter";//执行全量库方法
    private final String TYPE_THROW = "throw";//执行抛单库方法

    private String type;
    private String topicName;
    private String groupName;
    private ExecutorService executor;
    private KafkaConsumerOptions options;
    private ConsumerConnector connector;

    @Autowired
    private TransferToOrderCenterService transferToOrderCenterService;
    @Autowired
    private SMBTransferToOrderCenterService smbTransferToOrderCenterService;
    @Autowired
    private PrepareForThrowService prepareForThrowService;

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

                if (TYPE_ORDERCENTER.equals(type)) {
                    executor.submit(new MessageConsumerOrderCenter(stream, threadNumber, topicName, transferToOrderCenterService,smbTransferToOrderCenterService));
                } else if (TYPE_THROW.equals(type)) {
                    executor.submit(new MessageConsumerThrow(stream, threadNumber, topicName, prepareForThrowService));
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