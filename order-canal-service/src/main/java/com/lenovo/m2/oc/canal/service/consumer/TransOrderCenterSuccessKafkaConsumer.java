package com.lenovo.m2.oc.canal.service.consumer;

import com.lenovo.kafka.api.core.factory.KafkaConsumerOptions;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.ordercenter.soa.common.util.PropertiesUtil;
import com.lenovo.m2.ordercenter.soa.manager.discount.OrderDiscountManager;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: transService-soa 成功将订单转移到全量库后 kafka消息消费
 * @author: jiangxy9
 * @create: 2019-07-03 18:20
 */
@Component("transOrderCenterSuccessKafkaConsumer")
public class TransOrderCenterSuccessKafkaConsumer {

    private static Logger LOGGER = LoggerFactory.getLogger(TransOrderCenterSuccessKafkaConsumer.class);

    @Resource(name = "orderDiscountManager")
    private OrderDiscountManager orderDiscountManager;

    /**
     * 订单 成功转移全量库，kafka consumer
     */
    @Resource(name = "transOrderCenterSuccessKafkaConsumerOptions")
    private KafkaConsumerOptions kafkaConsumerOptions;

    private ConsumerConnector consumerConnector;
    private ExecutorService executor;
    private final int consumeThreadNum = Integer.parseInt(PropertiesUtil.getProperty("transOrderCenterSuccess.consumer.threads"));// UP leConf 配置


    /**
     * kafka consumer config
     * @param kafkaConsumerOptions
     * @return
     */
    private static ConsumerConfig createConsumerConfig(KafkaConsumerOptions kafkaConsumerOptions) {
        Properties props = new Properties();
        props.put("zookeeper.connect", kafkaConsumerOptions.getConnectionZk());
        props.put("group.id", kafkaConsumerOptions.getGroupName());
        props.put("zookeeper.session.timeout.ms", kafkaConsumerOptions.getZkSessionTimeout());
        props.put("zookeeper.sync.time.ms", kafkaConsumerOptions.getZkSyncTime());
        props.put("auto.commit.interval.ms", kafkaConsumerOptions.getAutoCommitInterval());
        return new ConsumerConfig(props);
    }


    @PostConstruct
    public void injectKafkaConsumerConfig(){
        this.consumerConnector = Consumer.createJavaConsumerConnector(createConsumerConfig(this.kafkaConsumerOptions));
        this.executor = Executors.newFixedThreadPool(consumeThreadNum);
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(kafkaConsumerOptions.getTopicName(), consumeThreadNum);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(kafkaConsumerOptions.getTopicName());
        LOGGER.info("topic : transferOrderCenter, consumer init success, streams size:"+streams.size());

        for (final KafkaStream stream : streams) {
            TransferOrderCenterSuccessConsumerWorker worker = new TransferOrderCenterSuccessConsumerWorker(stream);
            executor.submit(worker);
        }
    }


    /**
     * 订单成功转移全量库 kafka consumer worker
     */
    private class TransferOrderCenterSuccessConsumerWorker extends Thread{
        private Logger log = LoggerFactory.getLogger(TransferOrderCenterSuccessConsumerWorker.class);
        private KafkaStream m_stream;

        private TransferOrderCenterSuccessConsumerWorker(KafkaStream m_stream){
            this.m_stream = m_stream;
        }

        @Override
        public void run() {
            ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
            while (it.hasNext()) {
                String orderId = new String(it.next().message());
                log.info("TransOrderCenterSuccess consumer Start, orderId -> [" + orderId + "]");
                if (StringUtils.isEmpty(orderId)) {
                    log.error("TransferOrderCenterSuccess consumer expected receive an orderId, but received nothing.");
                    continue;
                }
                try {
                    RemoteResult re = orderDiscountManager.injectData2ES(Long.valueOf(orderId));
                    log.info("Save orderDiscount to ES result -> {}", re.getResultMsg());
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                log.info("trans2OrderCenter Consumer end");
            }
        }
    }



    @PreDestroy
    public void shutdown() {
        if (consumerConnector != null) consumerConnector.shutdown();
        if (executor != null) executor.shutdown();
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }

}
