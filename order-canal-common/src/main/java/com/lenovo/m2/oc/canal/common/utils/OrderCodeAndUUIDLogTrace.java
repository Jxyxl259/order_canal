package com.lenovo.m2.oc.canal.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @description: 线程日志追踪
 * @author:
 * @create: 2019-08-27 10:40
 */
public class OrderCodeAndUUIDLogTrace {


    private String orderCode;
    private String uuid;

    public OrderCodeAndUUIDLogTrace(String orderCode){
        this.orderCode = orderCode;
        this.uuid = StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }

    public void initTrace() {
        MDC.put("hunterid", String.format("[%s-%s]", orderCode, uuid));
    }

    public void removeTracert() {
        MDC.remove("hunterid");
    }

    @Override
    public String toString() {
        return String.format("%s_%s", orderCode, uuid);
    }
}
