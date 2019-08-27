package com.lenovo.m2.oc.canal.test;

import com.lenovo.m2.arch.framework.domain.RemoteResult;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 10:24
 */
public class SimpleTest {

    @Test
    public void test_final(){

        ExecutorService executor = Executors.newFixedThreadPool(5);
        int threadNumber = 0;
        try {
            for(int i = 0 ; i < 10 ; i++) {

                final Integer threadNo = threadNumber;
                    executor.submit(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    String orderCodeStr = threadNo + "23333";
                                    String orderTrace = String.format("%s_%s",orderCodeStr, UUID.randomUUID().toString().replace("-", ""));

                                    System.out.println("transToESService start, threadNO:{"+threadNo+"} traceId:{"+orderTrace+"} " );
                                    Thread.currentThread().sleep(2000);
                                    System.out.println("transToESService end");
                                }
                            } catch (Exception e) {
                                System.out.println("Run MessageConsumerOrderCenter consumer catch Exception. " + e);
                            }
                        }
                    });
                threadNumber++;
            }
        } catch(Exception e) {
            System.out.println("Run message consumer catch Exception. " + e);
        }

        try {
            Thread.currentThread().sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

