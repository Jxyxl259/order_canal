package com.lenovo.m2.oc.canal.domain.esdoc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2019-08-27 13:57
 */
public class MainES implements Serializable {

    /**
     * 订单号
     * `main`主键
     */
    private Long id;

    /**
     * 主订单号
     * `main`.`ParentId`
     */
    private Long parentId;

    /**
     * 第三方订单号(BTCP 订单号)
     */
    private String outId;

    /**
     * 历史订单编号,其他系统迁移 id
     * Epack订单号
     */
    private String customerId;

    /**
     * 用户lenovoId
     */
    private String lenovoId;

    /**
     * 用户账号(手机号/邮箱)
     */
    private String memberCode;

    /**
     * 基本信息(货币类型)
     */
    private Tenant tenant;

    /**
     * 订单总金额
     * 支付金额 + 总折扣 + 代金券 + 礼品卡
     */
    private Money totalCost;

    /**
     * 支付金额
     */
    private Money totalPay;

    /**
        订单类型
            0    普通
            1    闪购
            2    预售
            3    先试后买
            4    L码商品
            5    定制
            6    以旧换新
            7    C2C
            8    大侠码
            9    CTO
            10   OTO
            11   众筹
            12   拼团
            13   懂得充值
            14   私人订制
            15   乐豆兑换
            16   消费点兑换

    */
    private Integer type;

    /**
        订单状态
            0    未发货
            1    已发货
            2    已签收
            3    已取消
            4    已退货
            5    撤单中
            6    换货中
            7    退货中
            8    已拒签
            9    订单终止
     */
    private Integer status;

    /**
        订单销售类型
            0    普通
            1    闪购
            2    预售
            3    先试后买
            4    L码商品
            5    定制
            96   CTO
            97   众筹
            98   O2O
     */
    private Integer salesType;

    /**
        支付类型
            0    在线支付
            1    货到付款
            2    线下打款
     */
    private Integer paymentType;

    /**
        支付状态
            0    未支付
            1    已支付
            2    退款中
            3    已退款
     */
    private Integer payStatus;

    /**
        支付方式
            0    招行
            1    支付宝
            7    银联
            16   微信
            17   农行
     */
    private Integer payment;

    /**
     * 第三方交易号(支付宝流水号/银行流水号)
     */
    private String bankTraceNo;

    /**
     * 支付凭证号(收银台推送第三方支付平台)
     */
    private String payVoucherNo;

    /**
     * 支付平台流水号(代收代付流水号)
     */
    private String payTraceNo;

    /**
     * 商户
     */
    private Integer shopId;

    /**
     * 收货人姓名
     * `deliveryaddress`.`name`
     */
    private String  consigneeName;

    /**
     * 收货人手机号
     * `deliveryaddress`.`mobile`
     */
    private String  consigneeMobile;

    /**
     * 客服代码(客户经理)
     */
    private String customerManagerCode;

    /**
     * 代理商信息
     */
    private String faId;
    private Integer faType;// 0直营 1代理 2MBG 3THINK 4THINKFA 5懂的
    private String faName;

    /**
        BTCP是否冻结
            0    否
            1    是
     */
    private Boolean locked;


    /**
     * C2C分享人lenovoId
     * `main_belonging`.`C1LenovoId`
     */
    private String c1LenovoId;

    /**
     * 抛单失败原因
     * `main_belonging`.`ThrowedFailureReason`
     */
    private String throwedFailureReason;

    /**
     * 发票抬头
     * `invoice`.`Title`
     */
    private String invoiceTitle;

    /**
     * 包含订单关联的商品查询条件
     *      商品名称
     *      产品组
     *      物料编码
     */
    private List<ItemES> items;

    /**
     * 抛单状态
     */
    private Boolean throwStatus;

    /**
     * 所属企业(EPP企业名称)
     * `main_belonging`.`Enterprise`
     */
    private String enterprise;

    /**
     * 所属组(EPP企业所在组)
     * `main_belonging`.`EnrolledGroup`
     */
    private String enrolledGroup;

    // TODO (oc-web common.js)现在有不少门店ID 找不到对应的 门店名称
    /**
     * 门店ID
     * `main_belonging`.`StoreId`
     */
    private Long storeId;

    /**
     * 推广类型
     * `main_belonging`.`SpreadType`
     */
    private  String  spreadType;

    /**
     * 推广渠道
     * `main_belonging`.`SpreadChannel`
     */
    private  String  spreadChannel;

    /**
     * 推广ID
     * `main_belonging`.`SpreadId`
     */
    private  String  spreadId;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date paidTime;

    /**
     * 发货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date shipTime;

    /**
     * 预计到货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expectDate;

    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 签收时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    private String updateBy;

    /**
     * 只有非系统变更会更新 (version +=1)
     */
    private Integer version;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLenovoId() {
        return lenovoId;
    }

    public void setLenovoId(String lenovoId) {
        this.lenovoId = lenovoId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Money totalCost) {
        this.totalCost = totalCost;
    }

    public Money getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Money totalPay) {
        this.totalPay = totalPay;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getBankTraceNo() {
        return bankTraceNo;
    }

    public void setBankTraceNo(String bankTraceNo) {
        this.bankTraceNo = bankTraceNo;
    }

    public String getPayVoucherNo() {
        return payVoucherNo;
    }

    public void setPayVoucherNo(String payVoucherNo) {
        this.payVoucherNo = payVoucherNo;
    }

    public String getPayTraceNo() {
        return payTraceNo;
    }

    public void setPayTraceNo(String payTraceNo) {
        this.payTraceNo = payTraceNo;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeMobile() {
        return consigneeMobile;
    }

    public void setConsigneeMobile(String consigneeMobile) {
        this.consigneeMobile = consigneeMobile;
    }

    public String getCustomerManagerCode() {
        return customerManagerCode;
    }

    public void setCustomerManagerCode(String customerManagerCode) {
        this.customerManagerCode = customerManagerCode;
    }

    public String getFaId() {
        return faId;
    }

    public void setFaId(String faId) {
        this.faId = faId;
    }

    public Integer getFaType() {
        return faType;
    }

    public void setFaType(Integer faType) {
        this.faType = faType;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getC1LenovoId() {
        return c1LenovoId;
    }

    public void setC1LenovoId(String c1LenovoId) {
        this.c1LenovoId = c1LenovoId;
    }

    public String getThrowedFailureReason() {
        return throwedFailureReason;
    }

    public void setThrowedFailureReason(String throwedFailureReason) {
        this.throwedFailureReason = throwedFailureReason;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public List<ItemES> getItems() {
        return items;
    }

    public void setItems(List<ItemES> items) {
        this.items = items;
    }

    public Boolean getThrowStatus() {
        return throwStatus;
    }

    public void setThrowStatus(Boolean throwStatus) {
        this.throwStatus = throwStatus;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getEnrolledGroup() {
        return enrolledGroup;
    }

    public void setEnrolledGroup(String enrolledGroup) {
        this.enrolledGroup = enrolledGroup;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getSpreadId() {
        return spreadId;
    }

    public void setSpreadId(String spreadId) {
        this.spreadId = spreadId;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return "MainES{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", outId='" + outId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", lenovoId='" + lenovoId + '\'' +
                ", memberCode='" + memberCode + '\'' +
                ", tenant=" + tenant +
                ", totalCost=" + totalCost +
                ", totalPay=" + totalPay +
                ", type=" + type +
                ", status=" + status +
                ", salesType=" + salesType +
                ", paymentType=" + paymentType +
                ", payStatus=" + payStatus +
                ", payment=" + payment +
                ", bankTraceNo='" + bankTraceNo + '\'' +
                ", payVoucherNo='" + payVoucherNo + '\'' +
                ", payTraceNo='" + payTraceNo + '\'' +
                ", shopId=" + shopId +
                ", consigneeName='" + consigneeName + '\'' +
                ", consigneeMobile='" + consigneeMobile + '\'' +
                ", customerManagerCode='" + customerManagerCode + '\'' +
                ", faId='" + faId + '\'' +
                ", faType=" + faType +
                ", faName='" + faName + '\'' +
                ", locked=" + locked +
                ", c1LenovoId='" + c1LenovoId + '\'' +
                ", throwedFailureReason='" + throwedFailureReason + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", items=" + items +
                ", throwStatus=" + throwStatus +
                ", enterprise='" + enterprise + '\'' +
                ", enrolledGroup='" + enrolledGroup + '\'' +
                ", storeId=" + storeId +
                ", spreadType='" + spreadType + '\'' +
                ", spreadChannel='" + spreadChannel + '\'' +
                ", spreadId='" + spreadId + '\'' +
                ", paidTime=" + paidTime +
                ", shipTime=" + shipTime +
                ", expectDate=" + expectDate +
                ", createTime=" + createTime +
                ", signTime=" + signTime +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", version=" + version +
                '}';
    }

    public static void main(String[] args) {
        MainES mainES = new MainES();
        List<ItemES> items = new ArrayList<>();
        items.add(new ItemES("笔记本","A产品组","MAL093"));
        items.add(new ItemES("笔记本","B产品组","MAL093"));
        items.add(new ItemES("台式机","C产品组","MAL083"));
        mainES.setItems(items);
        System.out.println(mainES);
    }
}

