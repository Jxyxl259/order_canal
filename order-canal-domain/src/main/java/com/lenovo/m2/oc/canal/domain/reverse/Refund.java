package com.lenovo.m2.oc.canal.domain.reverse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;
import com.lenovo.m2.arch.tool.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiazy on 2016/6/29.
 */
public class Refund implements Serializable {



    public final static int  REFUND_STATUS_CANCEL= -1; //作废
    public final static int AUDIT_STATUS_PROCEED = 0;//退款中
    public final static int AUDIT_STATUS_SUCCESS = 1;//已退款
    public final static int AUDIT_STATUS_HALF_SUCCESS = 2;//BTCP已经同步但没有退款
    public final static String DIRTYPE_REFUND_CODE = "2000";//直营类型不在ordercenter-soa生成退款单

    private long id;

    private long reverseId;    //反向单号

    private long orderId;

    private String refundTraceNo;    //退款流水号

    private Money shouldAmount;    //应退金额

    private Money realAmount;     //实退金额

    private Money totalAmount;     //小计

    private Money refundManual;//手工返款

    private Money personalizationAmount;//私人订制价格

    private Money deductibleAmount;   //差额

    private Money totalLineTax;   //税额

    private String deductibleReason;   //差额原因

    private int refundStatus;    //退款订单状态

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateBy;

    private int version;

    private Tenant tenant;

    private Money otherDeductionAmount;         //手工扣除金额

    private String otherDeductionReason;        //手工扣除金额原因

    private String inputAmount;//页面传值

    private String batchNo; //退款流水号

    private Date refundTime; //退款时间

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public String getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(String inputAmount) {
        this.inputAmount = inputAmount;
    }

    public Money getOtherDeductionAmount() {
        return otherDeductionAmount;
    }

    public void setOtherDeductionAmount(Money otherDeductionAmount) {
        this.otherDeductionAmount = otherDeductionAmount;
    }

    public String getOtherDeductionReason() {
        return otherDeductionReason;
    }

    public void setOtherDeductionReason(String otherDeductionReason) {
        this.otherDeductionReason = otherDeductionReason;
    }

    public Money getRefundManual() {
        return refundManual;
    }

    public void setRefundManual(Money refundManual) {
        this.refundManual = refundManual;
    }

    public Money getPersonalizationAmount() {
        return personalizationAmount;
    }

    public void setPersonalizationAmount(Money personalizationAmount) {
        this.personalizationAmount = personalizationAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReverseId() {
        return reverseId;
    }

    public void setReverseId(long reverseId) {
        this.reverseId = reverseId;
    }

    public String getRefundTraceNo() {
        return refundTraceNo;
    }

    public void setRefundTraceNo(String refundTraceNo) {
        this.refundTraceNo = refundTraceNo;
    }

    public Money getShouldAmount() {
        return shouldAmount;
    }


    public Money getRealAmount() {
        return realAmount;
    }


    public Money getDeductibleAmount() {
        return deductibleAmount;
    }

    public void setShouldAmount(Money shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public void setRealAmount(Money realAmount) {
        this.realAmount = realAmount;
    }

    public void setDeductibleAmount(Money deductibleAmount) {
        this.deductibleAmount = deductibleAmount;
    }

    public String getDeductibleReason() {
        return deductibleReason;
    }

    public void setDeductibleReason(String deductibleReason) {
        this.deductibleReason = deductibleReason;
    }

    public int getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(int refundStatus) {
        this.refundStatus = refundStatus;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Money getTotalLineTax() {
        return totalLineTax;
    }

    public void setTotalLineTax(Money totalLineTax) {
        this.totalLineTax = totalLineTax;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Money totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "id=" + id +
                ", reverseId=" + reverseId +
                ", refundTraceNo='" + refundTraceNo + '\'' +
                ", shouldAmount=" + shouldAmount +
                ", realAmount=" + realAmount +
                ", deductibleAmount=" + deductibleAmount +
                ", deductibleReason='" + deductibleReason + '\'' +
                ", refundStatus=" + refundStatus +
                ", createTime='" + createTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", version=" + version +
                '}';
    }

    public static String getRefundTraceNo(long orderCode,String  payTraceNo,String reverseId){
        if(StringUtils.isEmpty(payTraceNo)){
            return "";
        }
        StringBuffer  stringBuffer  =new StringBuffer(String.valueOf(orderCode));
        stringBuffer.append(payTraceNo);
        stringBuffer.append(reverseId);
        return stringBuffer.toString();
    }
}
