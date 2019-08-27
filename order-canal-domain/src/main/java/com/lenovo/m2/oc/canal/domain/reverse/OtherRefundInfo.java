package com.lenovo.m2.oc.canal.domain.reverse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;

import java.io.Serializable;
import java.util.Date;

public class OtherRefundInfo implements Serializable {

    public static final int APPROVAL_STATUS_PENDING = 0;       //待审核
    public static final int APPROVAL_STATUS_APPROVAL =1;       //审核通过
    public static final int APPROVAL_STATUS_REJECT = 2;        //审核拒绝
    public static final int APPROVAL_STATUS_INVALID = 3;       //作废

    public static final int REFUND_STATUS_PENDING = 0;         //待退款
    public static final int REFUND_STATUS_REFUNDED = 1;        //已退款


    private long id;                //主键ID

    private int type;               //退款类型

    private long reverseId;         //反向订单号

    private long orderId;           //订单号

    private int reverseType;        //反向订单类型

    private Money realAmount;       //退款金额

    private int approvalStatus;     //审核状态:0 待审核; 1 审核通过; 2 审核拒绝; 3 作废

    private int shopId;

    private String faId;

    private String faName;

    private String remark;

    private String rejectReason;    //拒绝原因

    private int refundStatus;       //退款状态: 0 待退款; 1 已退款

    private String refundPayment;   //退款方式

    private String refundTraceNo;   //退款流水号

    private String refundOperator;  //退款操作人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date refundTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getReverseId() {
        return reverseId;
    }

    public void setReverseId(long reverseId) {
        this.reverseId = reverseId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getReverseType() {
        return reverseType;
    }

    public void setReverseType(int reverseType) {
        this.reverseType = reverseType;
    }

    public Money getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Money realAmount) {
        this.realAmount = realAmount;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getFaId() {
        return faId;
    }

    public void setFaId(String faId) {
        this.faId = faId;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public int getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(int refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundPayment() {
        return refundPayment;
    }

    public void setRefundPayment(String refundPayment) {
        this.refundPayment = refundPayment;
    }

    public String getRefundTraceNo() {
        return refundTraceNo;
    }

    public void setRefundTraceNo(String refundTraceNo) {
        this.refundTraceNo = refundTraceNo;
    }

    public String getRefundOperator() {
        return refundOperator;
    }

    public void setRefundOperator(String refundOperator) {
        this.refundOperator = refundOperator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    @Override
    public String toString() {
        return "OtherRefundInfo{" +
                "id=" + id +
                ", type=" + type +
                ", reverseId=" + reverseId +
                ", orderId=" + orderId +
                ", reverseType=" + reverseType +
                ", realAmount=" + realAmount +
                ", approvalStatus=" + approvalStatus +
                ", shopId=" + shopId +
                ", faId='" + faId + '\'' +
                ", faName='" + faName + '\'' +
                ", remark='" + remark + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                ", refundStatus=" + refundStatus +
                ", refundPayment='" + refundPayment + '\'' +
                ", refundTraceNo='" + refundTraceNo + '\'' +
                ", refundOperator='" + refundOperator + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
