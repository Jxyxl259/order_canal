package com.lenovo.m2.oc.canal.service.consumer.kafka;

/**
 * kafka 消费者参数
 *
 * @Author licy13
 * @Date 2017/5/12
 */

public class KafkaConsumerOptions {
    private String connectionZk;
    private String zkSessionTimeout;
    private String zkSyncTime;
    private String autoCommitInterval;
    private String rebalanceBackOff;
    private String rebalanceMaxRetries;
    private String autoOffsetReset;

    public KafkaConsumerOptions() {
    }

    public String getConnectionZk() {
        return this.connectionZk;
    }

    public void setConnectionZk(String connectionZk) {
        this.connectionZk = connectionZk;
    }


    public String getZkSessionTimeout() {
        return this.zkSessionTimeout;
    }

    public void setZkSessionTimeout(String zkSessionTimeout) {
        this.zkSessionTimeout = zkSessionTimeout;
    }

    public String getZkSyncTime() {
        return this.zkSyncTime;
    }

    public void setZkSyncTime(String zkSyncTime) {
        this.zkSyncTime = zkSyncTime;
    }

    public String getAutoCommitInterval() {
        return this.autoCommitInterval;
    }

    public void setAutoCommitInterval(String autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public String getRebalanceBackOff() {
        return this.rebalanceBackOff;
    }

    public void setRebalanceBackOff(String rebalanceBackOff) {
        this.rebalanceBackOff = rebalanceBackOff;
    }

    public String getRebalanceMaxRetries() {
        return this.rebalanceMaxRetries;
    }

    public void setRebalanceMaxRetries(String rebalanceMaxRetries) {
        this.rebalanceMaxRetries = rebalanceMaxRetries;
    }

    public String getAutoOffsetReset() {
        return this.autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

}
