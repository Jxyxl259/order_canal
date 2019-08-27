package com.lenovo.m2.oc.canal.domain.ordercenter;

import java.io.Serializable;

/**
 * CTO 扩展信息字段
 */
public class Cv implements Serializable {
    private String orderId;
    private String Id;
    private String option;
    private String value;
    private String isselect;
    private String picUrl;
    private String char_des;
    private String charvalue_des;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIsselect() {
        return isselect;
    }

    public void setIsselect(String isselect) {
        this.isselect = isselect;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getChar_des() {
        return char_des;
    }

    public void setChar_des(String char_des) {
        this.char_des = char_des;
    }

    public String getCharvalue_des() {
        return charvalue_des;
    }

    public void setCharvalue_des(String charvalue_des) {
        this.charvalue_des = charvalue_des;
    }

/*    @Override
    public String toString() {
        return "Cv{" +
                "orderId='" + orderId + '\'' +
                ", Id='" + Id + '\'' +
                ", option='" + option + '\'' +
                ", value='" + value + '\'' +
                ", isselect='" + isselect + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", char_des='" + char_des + '\'' +
                ", charvalue_des='" + charvalue_des + '\'' +
                '}';
    }*/
}
