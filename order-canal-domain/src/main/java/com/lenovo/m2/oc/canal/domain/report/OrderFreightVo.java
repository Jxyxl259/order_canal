package com.lenovo.m2.oc.canal.domain.report;

import com.lenovo.m2.arch.framework.domain.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-12-06.
 */
public class OrderFreightVo implements Serializable {

    private Integer shopId;

    private Long id;

    private String outId;

    private String lenovoId;

    private Money totalPay;

    private Money freight;

    private Integer payment;

    private Date paidTime;

    private String customerCode;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getLenovoId() {
        return lenovoId;
    }

    public void setLenovoId(String lenovoId) {
        this.lenovoId = lenovoId;
    }

    public Money getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Money totalPay) {
        this.totalPay = totalPay;
    }

    public Money getFreight() {
        return freight;
    }

    public void setFreight(Money freight) {
        this.freight = freight;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }
}
