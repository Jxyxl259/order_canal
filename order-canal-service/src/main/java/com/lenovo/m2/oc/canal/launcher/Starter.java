package com.lenovo.m2.oc.canal.launcher;

import com.lenovo.m2.oc.canal.service.consumer.kafka.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 项目启动类
 * @author: jiangxy9
 * @create: 2019-08-26 20:30
 */
public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    private static volatile boolean running = true;

    private static ApplicationContext ctx;


    public static void main(String[] args) {
        LOGGER.info("SOA服务启动 start. ready go！");

        try {
            ctx = new ClassPathXmlApplicationContext(
                    new String[]{
                            "applicationContext-conf.xml",
                            "applicationContext-dao.xml",
                            "applicationContext-manager.xml",
                            "applicationContext-tx.xml",
                            "applicationContext-kafka.xml",
                            "applicationContext-propertiesResource.xml",
                            "applicationContext-redis.xml"

                    }
            );

            // 启动两个线程 ，一个消费kafka， 一个启动 canalConsumer
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            // 消费转移全量库成功的 kafka消息 Topic : SEND_ORDERID
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    KafkaConsumer kafkaConsumer = (KafkaConsumer) ctx.getBean("kafkaConsumerTransToOrderCenterFinish");
                    kafkaConsumer.run(10);
                }
            });

            // 启动 canalConsumer
            executorService.submit(
//                    new Runnable() {
//                @Override
//                public void run() {
//                    KafkaConsumer kafkaConsumer = (KafkaConsumer) ctx.getBean("kafkaConsumerPipelineSecondFinishToThrow");
//                    kafkaConsumer.run(10);
//                }
            });

            LOGGER.info("canal consumer started succeed!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            running = false;
            LOGGER.error("canal consumer started failed ! Exception=[" + e.getMessage() + "]", e);
            System.exit(1);
        }
        synchronized (Starter.class) {
            while (running) {
                try {
                    Starter.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

}
