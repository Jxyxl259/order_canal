package com.lenovo.m2.oc.canal.domain.ordercenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;

import java.io.Serializable;
import java.util.Date;

public class MainBelonging implements Serializable {


    /**
     * 预售方式--非预售订单
     */
    public static final int PRESELLWAY_UN = 0;
    /**
     * 预售方式--全款
     */
    public static final int PRESELLWAY_FULL = 1;
    /**
     * 预售方式--订金
     */
    public static final int PRESELLWAY_CUB = 2;

    /**
     * 未抛送
     */
    public static final int THROWEDSTATUS_NOTSEND = 0;

    /**
     * 已抛送
     */
    public static final int THROWEDSTATUS_SEND = 1;

    /**
     * 抛送失败
     */
    public static final int THROWEDSTATUS_SEND_FAIL = 2;

    /**
     * 抛送成功
     */
    public static final int THROWEDSTATUS_SEND_SUCCESS = 3;


    private Long orderId;

    private String clientIP;

    private String clientSystemName;

    private String clientBrowserName;

    private String c1LenovoId;

    private String enterprise;

    private String enterpriseCode;

    private String enrolledGroup;

    private String contractNo;

    private String activityID;

    private String activityName;

    private Integer activityMode;

    private String customerRemark;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private Date createTime;

    private Date updateTime;

    private Integer version;


    private Main main;

    private int isNeedToSend;//是否邮寄合同0否 1是

    private String pactCode;//合同编号

    private Date pactTakeEffectTime;//合同生效时间

    private String pactSendID;//合同id

    private String pactUrl;//合同链接

    private String companyName;//公司名称

    private String customerOrderCodeSon;//第三方订单号子订单号

    private String customerOrderCode;//第三方订单号主订单号

    private Integer submitOrderWay;//smb下单方式 1静默下单，2手工下单，3询价单

    private Long storeId;//门店ID

    private Date paidTime;


    private boolean hasComment;//是否评论

    private int presellway;//预售方式(0:非预售订单 1:全款 2:订金)

    private Money deposit;//预售定金

    private Money restPayment;//尾款金额

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date depositEndTime;//定金支付超时日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tailPaymentDay;//尾款支付超时日期

    private int tailDeliveryDay;//尾款支付几天发货

    private String preSaleMobile;//预售尾款手机号

    private  String throwedFailureReason; //抛单失败原因

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private  Date throwedTime; //抛单失败原因
    private  int accountType;//慧商 对私 1 对公2
    private Money creditLine;//信用支付额度
    private String skuType;//商品类型集合，多个商品逗号隔开：0普通，10定制无字，11定制有字，20cto无需审核，21cto需要审核
    private Tenant tenant;


    private String deliverGoodsType;//送货方式:L1空运，L2陆运，S2自取
    private String referenceNumber;//账单参考编码
    private Money handingFee;//手续费
    private Money totalTax;//总税额
    private Integer throwedStatus;//抛单状态 0 未抛单  1 已抛单  2 抛单失败  3 抛单成功

    //全网营销2.0
    private String storeCode;//发货门店编码
    private Long originStoreId;//来源门店id
    private String originStoreCode;//来源门店编码

    //推广信息
    private  String  spreadType;
    private  String  spreadChannel;
    private  String  spreadId;

    public String getSpreadId() {
        return spreadId;
    }

    public void setSpreadId(String spreadId) {
        this.spreadId = spreadId;
    }

    public String getSpreadType() {
        return spreadType;
    }

    public void setSpreadType(String spreadType) {
        this.spreadType = spreadType;
    }

    public String getSpreadChannel() {
        return spreadChannel;
    }

    public void setSpreadChannel(String spreadChannel) {
        this.spreadChannel = spreadChannel;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Long getOriginStoreId() {
        return originStoreId;
    }

    public void setOriginStoreId(Long originStoreId) {
        this.originStoreId = originStoreId;
    }

    public String getOriginStoreCode() {
        return originStoreCode;
    }

    public void setOriginStoreCode(String originStoreCode) {
        this.originStoreCode = originStoreCode;
    }

    public Integer getThrowedStatus() {
        return throwedStatus;
    }

    public void setThrowedStatus(Integer throwedStatus) {
        this.throwedStatus = throwedStatus;
    }

    public Money getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Money totalTax) {
        this.totalTax = totalTax;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Money getHandingFee() {
        return handingFee;
    }

    public void setHandingFee(Money handingFee) {
        this.handingFee = handingFee;
    }

    public String getDeliverGoodsType() {
        return deliverGoodsType;
    }

    public void setDeliverGoodsType(String deliverGoodsType) {
        this.deliverGoodsType = deliverGoodsType;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getThrowedFailureReason() {
        return throwedFailureReason;
    }

    public void setThrowedFailureReason(String throwedFailureReason) {
        this.throwedFailureReason = throwedFailureReason;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Date getThrowedTime() {
        return throwedTime;
    }

    public void setThrowedTime(Date throwedTime) {
        this.throwedTime = throwedTime;
    }

    public int getIsNeedToSend() {
        return isNeedToSend;
    }

    public void setIsNeedToSend(int isNeedToSend) {
        this.isNeedToSend = isNeedToSend;
    }

    public String getPactCode() {
        return pactCode;
    }

    public void setPactCode(String pactCode) {
        this.pactCode = pactCode;
    }

    public Date getPactTakeEffectTime() {
        return pactTakeEffectTime;
    }

    public void setPactTakeEffectTime(Date pactTakeEffectTime) {
        this.pactTakeEffectTime = pactTakeEffectTime;
    }

    public String getPactSendID() {
        return pactSendID;
    }

    public void setPactSendID(String pactSendID) {
        this.pactSendID = pactSendID;
    }

    public String getPactUrl() {
        return pactUrl;
    }

    public void setPactUrl(String pactUrl) {
        this.pactUrl = pactUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerOrderCodeSon() {
        return customerOrderCodeSon;
    }

    public void setCustomerOrderCodeSon(String customerOrderCodeSon) {
        this.customerOrderCodeSon = customerOrderCodeSon;
    }

    public String getCustomerOrderCode() {
        return customerOrderCode;
    }

    public void setCustomerOrderCode(String customerOrderCode) {
        this.customerOrderCode = customerOrderCode;
    }

    public Integer getSubmitOrderWay() {
        return submitOrderWay;
    }

    public void setSubmitOrderWay(Integer submitOrderWay) {
        this.submitOrderWay = submitOrderWay;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP == null ? null : clientIP.trim();
    }

    public String getClientSystemName() {
        return clientSystemName;
    }

    public void setClientSystemName(String clientSystemName) {
        this.clientSystemName = clientSystemName == null ? null : clientSystemName.trim();
    }

    public String getClientBrowserName() {
        return clientBrowserName;
    }

    public void setClientBrowserName(String clientBrowserName) {
        this.clientBrowserName = clientBrowserName == null ? null : clientBrowserName.trim();
    }

    public String getC1LenovoId() {
        return c1LenovoId;
    }

    public void setC1LenovoId(String c1LenovoId) {
        this.c1LenovoId = c1LenovoId == null ? null : c1LenovoId.trim();
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise == null ? null : enterprise.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getEnrolledGroup() {
        return enrolledGroup;
    }

    public void setEnrolledGroup(String enrolledGroup) {
        this.enrolledGroup = enrolledGroup == null ? null : enrolledGroup.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID == null ? null : activityID.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Integer getActivityMode() {
        return activityMode;
    }

    public void setActivityMode(Integer activityMode) {
        this.activityMode = activityMode;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark == null ? null : customerRemark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
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

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public int getPresellway() {
        return presellway;
    }

    public void setPresellway(int presellway) {
        presellway = presellway;
    }

    public Money getDeposit() {
        return deposit;
    }


    public Money getRestPayment() {
        return restPayment;
    }

    public void setDeposit(Money deposit) {
        this.deposit = deposit;
    }

    public void setRestPayment(Money restPayment) {
        this.restPayment = restPayment;
    }

    public Date getDepositEndTime() {
        return depositEndTime;
    }

    public void setDepositEndTime(Date depositEndTime) {
        this.depositEndTime = depositEndTime;
    }

    public Date getTailPaymentDay() {
        return tailPaymentDay;
    }

    public void setTailPaymentDay(Date tailPaymentDay) {
        this.tailPaymentDay = tailPaymentDay;
    }

    public int getTailDeliveryDay() {
        return tailDeliveryDay;
    }

    public void setTailDeliveryDay(int tailDeliveryDay) {
        this.tailDeliveryDay = tailDeliveryDay;
    }

    public String getPreSaleMobile() {
        return preSaleMobile;
    }

    public void setPreSaleMobile(String preSaleMobile) {
        this.preSaleMobile = preSaleMobile;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public Money getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Money creditLine) {
        this.creditLine = creditLine;
    }
//    @Override
//    public String toString() {
//        return "MainBelonging{" +
//                "orderId=" + orderId +
//                ", clientIP='" + clientIP + '\'' +
//                ", clientSystemName='" + clientSystemName + '\'' +
//                ", clientBrowserName='" + clientBrowserName + '\'' +
//                ", c1LenovoId='" + c1LenovoId + '\'' +
//                ", enterprise='" + enterprise + '\'' +
//                ", enterpriseCode='" + enterpriseCode + '\'' +
//                ", enrolledGroup='" + enrolledGroup + '\'' +
//                ", contractNo='" + contractNo + '\'' +
//                ", activityID='" + activityID + '\'' +
//                ", activityName='" + activityName + '\'' +
//                ", activityMode=" + activityMode +
//                ", customerRemark='" + customerRemark + '\'' +
//                ", remark1='" + remark1 + '\'' +
//                ", remark2='" + remark2 + '\'' +
//                ", remark3='" + remark3 + '\'' +
//                ", remark4='" + remark4 + '\'' +
//                ", createTime=" + createTime +
//                ", updateTime=" + updateTime +
//                ", version=" + version +
//                ", main=" + main +
//                ", isNeedToSend=" + isNeedToSend +
//                ", pactCode='" + pactCode + '\'' +
//                ", pactTakeEffectTime=" + pactTakeEffectTime +
//                ", pactSendID='" + pactSendID + '\'' +
//                ", pactUrl='" + pactUrl + '\'' +
//                ", companyName='" + companyName + '\'' +
//                ", customerOrderCodeSon='" + customerOrderCodeSon + '\'' +
//                ", customerOrderCode='" + customerOrderCode + '\'' +
//                ", submitOrderWay=" + submitOrderWay +
//                ", storeId=" + storeId +
//                '}';
//    }
}