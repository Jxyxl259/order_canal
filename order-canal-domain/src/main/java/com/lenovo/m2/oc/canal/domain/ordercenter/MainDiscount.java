package com.lenovo.m2.oc.canal.domain.ordercenter;

import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;

import java.io.Serializable;
import java.util.Date;

public class MainDiscount implements Serializable {
    private Long orderId;

    private Money discountImmediacy;

    private Money discountFirst;

    private Money discountCoupons;

    private Money discountCouponCode;

    private Money discountFullReduce;

    private Money discountInnerBuyMoney;

    private Money discountAmount; //集分宝优惠

    private Integer discountLeDou;

    private Integer rewardLeDouNum;

    private Integer rewardCredit;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    private Main main;

    private Tenant tenant;

    private Money payCash;//现金支付金额

    private Long payPoint;//积分支付金额

    //预售优惠
    private Money discountPresell;


    public Money getPayCash() {
        return payCash;
    }

    public void setPayCash(Money payCash) {
        this.payCash = payCash;
    }

    public Long getPayPoint() {
        return payPoint;
    }

    public void setPayPoint(Long payPoint) {
        this.payPoint = payPoint;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Money getDiscountImmediacy() {
        return discountImmediacy;
    }

    public void setDiscountImmediacy(Money discountImmediacy) {
        this.discountImmediacy = discountImmediacy;
    }

    public Money getDiscountFirst() {
        return discountFirst;
    }

    public void setDiscountFirst(Money discountFirst) {
        this.discountFirst = discountFirst;
    }

    public Money getDiscountCoupons() {
        return discountCoupons;
    }

    public void setDiscountCoupons(Money discountCoupons) {
        this.discountCoupons = discountCoupons;
    }

    public Money getDiscountCouponCode() {
        return discountCouponCode;
    }

    public void setDiscountCouponCode(Money discountCouponCode) {
        this.discountCouponCode = discountCouponCode;
    }

    public Money getDiscountFullReduce() {
        return discountFullReduce;
    }

    public void setDiscountFullReduce(Money discountFullReduce) {
        this.discountFullReduce = discountFullReduce;
    }

    public Money getDiscountInnerBuyMoney() {
        return discountInnerBuyMoney;
    }

    public void setDiscountInnerBuyMoney(Money discountInnerBuyMoney) {
        this.discountInnerBuyMoney = discountInnerBuyMoney;
    }

    public Integer getDiscountLeDou() {
        return discountLeDou;
    }

    public void setDiscountLeDou(Integer discountLeDou) {
        this.discountLeDou = discountLeDou;
    }

    public Integer getRewardLeDouNum() {
        return rewardLeDouNum;
    }

    public void setRewardLeDouNum(Integer rewardLeDouNum) {
        this.rewardLeDouNum = rewardLeDouNum;
    }

    public Integer getRewardCredit() {
        return rewardCredit;
    }

    public void setRewardCredit(Integer rewardCredit) {
        this.rewardCredit = rewardCredit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Money getDiscountPresell() {
        return discountPresell;
    }

    public void setDiscountPresell(Money discountPresell) {
        this.discountPresell = discountPresell;
    }


    //    @Override
//    public String toString() {
//        return "MainDiscount{" +
//                "orderId=" + orderId +
//                ", discountImmediacy=" + discountImmediacy +
//                ", discountFirst=" + discountFirst +
//                ", discountCoupons=" + discountCoupons +
//                ", discountCouponCode=" + discountCouponCode +
//                ", discountFullReduce=" + discountFullReduce +
//                ", discountInnerBuyMoney=" + discountInnerBuyMoney +
//                ", discountLeDou=" + discountLeDou +
//                ", rewardLeDouNum=" + rewardLeDouNum +
//                ", rewardCredit=" + rewardCredit +
//                ", createTime=" + createTime +
//                ", updateTime=" + updateTime +
//                ", version=" + version +
//                '}';
//    }
}