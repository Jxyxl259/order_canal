package com.lenovo.m2.oc.canal.domain.ordercenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;
import com.lenovo.m2.arch.tool.util.StringUtils;
import com.lenovo.m2.oc.canal.common.utils.OrderConstant;
import com.lenovo.m2.oc.canal.domain.reverse.Reverse;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Main implements Serializable {

    public static final long NONE_ID = Long.MIN_VALUE;


    /**
     * 支付类型-在线支付
     */
    public static final int PAY_STATUS_ONLINE = 0;

    /**
     * 支付类型-货到付款
     */
    public static final int PAY_STATUS_REVIVE  = 1;

    /**
     * 支付类型-线下打款
     */
    public static final int PAY_STATUS_LINE  = 2;


    /**
     * 销售订单类型-普通
     */
    public static final int ADD_TYPE_NORMAL = 0;
    /**
     * 销售订单类型-闪购
     */
    public static final int ADD_TYPE_SEC_KILL = 1;
    /**
     * 销售订单类型-预售
     */
    public static final int ADD_TYPE_PRE_SELL = 2;
    /**
     * 销售订单类型-先试后买
     */
    public static final int ADD_TYPE_SALES_TRIAL = 3;
    /**
     * 销售订单类型-K码商品
     */
    public static final int ADD_TYPE_K_CODE = 4;
    /**
     * 销售订单类型-定制
     */
    public static final int ADD_TYPE_DESIGN = 5;
    /**
     * 销售订单类型-以旧换新
     */
    public static final int ADD_TYPE_OLD_CHANGE_NEW = 6;
    /**
     * 销售订单类型-c2c
     */
    public static final int ADD_TYPE_C2C = 7;
    /**
     * 销售订单类型-大侠码
     */
    public static final int ADD_TYPE_XCODE = 8;
    /**
     * 销售订单类型-CTO
     */
    public static final int ADD_TYPE_CTO = 9;
    /**
     * 销售订单类型-OTO
     */
    public static final int ADD_TYPE_OTO = 10;
    /**
     * 销售订单类型-乐豆兑换
     */
    public static final int ADD_TYPE_LEBEAN = 15;
    /**
     * 销售订单类型-消费点兑换
     */
    public static final int ADD_TYPE_CONSUMER_SCORE = 16;
    /**
     * 销售订单类型-众筹
     */
    public static final int ADD_TYPE_RAISE = 11;
    /**
     * 销售类型-普通
     */
    public static final int SALES_TYPE_NORMAL = 0;
    /**
     * 销售类型-闪购
     */
    public static final int SALES_TYPE_SEC_KILL = 1;
    /**
     * 销售类型-预售
     */
    public static final int SALES_TYPE_PRE_SELL = 2;
    /**
     * 销售类型-先试后买
     */
    public static final int SALES_TYPE_SALES_TRIAL = 3;
    /**
     * 销售类型-K码商品
     */
    public static final int SALES_TYPE_K_CODE = 4;
    /**
     * 销售类型-定制
     */
    public static final int SALES_TYPE_DESIGN = 5;
    /**
     * 销售类型-CTO
     */
    public static final int SALES_TYPE_CTO = 96;
    /**
     * 销售类型-众筹
     */
    public static final int SALES_TYPE_RAISE = 97;
    /**
     * 销售类型-O2O
     */
    public static final int SALES_TYPE_O2O = 98;
    /**
     * 订单状态-未发货
     */
    public static final int STATUS_UN_SHIPPED = 0;
    /**
     * 订单状态-已发货
     */
    public static final int STATUS_SHIPPED = 1;
    /**
     * 订单状态-已签收
     */
    public static final int STATUS_SIGNED = 2;
    /**
     * 订单状态-已取消
     */
    public static final int STATUS_CANCELLED = 3;
    /**
     * 订单状态-已退货
     */
    public static final int STATUS_RETURNED = 4;
    /**
     * 订单状态-撤单中
     */
    public static final int STATUS_REVOKING = 5;
    /**
     * 订单状态-换货中
     */
    public static final int STATUS_EXCHANGING = 6;
    /**
     * 订单状态-退货中
     */
    public static final int STATUS_RETURNING = 7;

    /**
     * 订单状态-已拒签
     */
    public static final int STATUS_REFUSE = 8;

    /**
     * 订单状态-订单终止
     */
    public static final int STATUS_END = 9;
     /**
     * 支付状态-0:未支付
     */
    public static final int PAY_STATUS_UN = 0;
    /**
     * 支付状态-1:已支付
     */
    public static final int PAY_STATUS_COMP = 1;
    /**
     * 支付状态-2:退款中
     */
    public static final int PAY_STATUS_REFUND = 2;
    /**
     * 支付状态- 3:已退款
     */
    public static final int PAY_STATUS_REFUND_COMP = 3;




    /**
     * FA类型-直营
     */
    public static final int FA_TYPE_DIRECT = 0;
    /**
     * FA类型-直营
     */
    public static final int FA_TYPE_FA_DIRECT = 12;
    /**
     * FA类型-手机直营
     */
    public static final int FA_TYPE_MBG_DIRECT = 100001;
    /**
     * FA类型-代理
     */
    public static final int FA_TYPE_RESELLERS = 1;

    /**
     * FA类型-Think直营
     */
    public static final int FA_TYPE_THINK_DIRECT = 3;

    /**
     * FA类型-懂的通信
     */
    public static final int FA_TYPE_DONGDE = 5;

    /**
     * FA类型-懂的充值
     */
    public static final int FA_TYPE_DONGDE_RECHARGE = 6;

    /**
     * FA类型-17TV
     */
    public static final int FA_TYPE_17TV = 9;
    /**
     * FA类型-联想TV
     */
    public static final int FA_TYPE_LENOVOTV = 10;

    /**
     * 商户号-联想商城
     */
    public static final int SHOP_ID_LENOVO = 1;
    /**
     * 商户号-epp
     */
    public static final int SHOP_ID_EPP = 3;
    /**
     * 商户号-moto
     */
    public static final int SHOP_ID_MOTO = 5;
    /**
     * 商户号-moto
     */
    public static final int SHOP_ID_PCSD = 11;
    /**
     * 商户号-慧商
     */
    public static final int SHOP_ID_HUISHANG = 14;
    /**
     * 商户号-moto
     */
    public static final int SHOP_ID_INDIA_MOTO = 16;
    /**
     * 乐豆换算比率
     */
    public static final double MONEY_CONVERT_RATE = 0.01;

    private Long id = NONE_ID;

    private Long parentId;

    private String outId;

    private String customerId;

    private String memberCode;

    private String lenovoId;

    private Money totalCost;

    private Money totalPay;

    private Money discountTotal;

    private Money cashVoucher;

    private Money cashGiftCard;

    private String voucherRemark;

    private String source;

    private Integer type;

    private Integer status;

    private Integer salesType;

    private Integer paymentType;

    private Integer payStatus;

    private Integer payment;

    private String bankTraceNo;

    private String payVoucherNo;

    private String payTraceNo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date paidTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date shipTime;

    private Integer shopId;

    private Integer terminalId;

    private String customerManagerCode;

    private Integer bu;

    private String faId;

    private Integer faType;

    private String faName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expectDate;

    private Boolean isTax;

    private Boolean isSameDelivery;

    private String systemRemark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signTime;

    private Integer version;

    private  String  buyerCode;

    private MainBelonging belonging;

    private MainDiscount discount;

    private Invoice invoice;

    private DeliveryAddress deliveryAddress;

    private Reverse reverse;

    private List<Item> items;

    private Item ctoItem;

    private Boolean locked;

    private Tenant tenant;

    private Integer otoConfirmStatus;



    private Money changePriceDiscount;

    //虚拟币增加字段

    private Money freight;//运费

    private Money virtualCoin;//虚拟币数量

    private String virtualCoinTradeNo;//虚拟币流水号

    private Integer virtualCoinType;//虚拟币类型1 消费点 2 乐豆

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Integer getVirtualCoinType() {
        return virtualCoinType;
    }

    public void setVirtualCoinType(Integer virtualCoinType) {
        this.virtualCoinType = virtualCoinType;
    }

    public String getVirtualCoinTradeNo() {
        return virtualCoinTradeNo;
    }

    public void setVirtualCoinTradeNo(String virtualCoinTradeNo) {
        this.virtualCoinTradeNo = virtualCoinTradeNo;
    }

    public Money getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Money virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public Money getFreight() {
        return freight;
    }

    public void setFreight(Money freight) {
        this.freight = freight;
    }

    public Integer getOtoConfirmStatus() {
        return otoConfirmStatus;
    }

    public void setOtoConfirmStatus(Integer otoConfirmStatus) {
        this.otoConfirmStatus = otoConfirmStatus;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

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
        this.outId = outId == null ? null : outId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode == null ? null : memberCode.trim();
    }

    public String getLenovoId() {
        return lenovoId;
    }

    public void setLenovoId(String lenovoId) {
        this.lenovoId = lenovoId == null ? null : lenovoId.trim();
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


    public Money getDiscountTotal() {
        return discountTotal;
    }


    public Money getCashVoucher() {
        return cashVoucher;
    }


    public Money getCashGiftCard() {
        return cashGiftCard;
    }


    public String getVoucherRemark() {
        return voucherRemark;
    }

    public void setVoucherRemark(String voucherRemark) {
        this.voucherRemark = voucherRemark == null ? null : voucherRemark.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
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
        this.bankTraceNo = bankTraceNo == null ? null : bankTraceNo.trim();
    }

    public String getPayVoucherNo() {
        return payVoucherNo;
    }

    public void setPayVoucherNo(String payVoucherNo) {
        this.payVoucherNo = payVoucherNo == null ? null : payVoucherNo.trim();
    }

    public String getPayTraceNo() {
        return payTraceNo;
    }

    public void setPayTraceNo(String payTraceNo) {
        this.payTraceNo = payTraceNo == null ? null : payTraceNo.trim();
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public String getCustomerManagerCode() {
        return customerManagerCode;
    }

    public void setCustomerManagerCode(String customerManagerCode) {
        this.customerManagerCode = customerManagerCode == null ? null : customerManagerCode.trim();
    }

    public Integer getBu() {
        return bu;
    }

    public void setBu(Integer bu) {
        this.bu = bu;
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

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public Boolean getIsTax() {
        return isTax;
    }

    public void setIsTax(Boolean isTax) {
        this.isTax = isTax;
    }

    public Boolean getIsSameDelivery() {
        return isSameDelivery;
    }

    public void setIsSameDelivery(Boolean isSameDelivery) {
        this.isSameDelivery = isSameDelivery;
    }

    public String getSystemRemark() {
        return systemRemark;
    }

    public void setSystemRemark(String systemRemark) {
        this.systemRemark = systemRemark == null ? null : systemRemark.trim();
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
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public MainBelonging getBelonging() {
        return belonging;
    }

    public void setBelonging(MainBelonging belonging) {
        this.belonging = belonging;
    }

    public MainDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(MainDiscount discount) {
        this.discount = discount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Reverse getReverse() {
        return reverse;
    }

    public void setReverse(Reverse reverse) {
        this.reverse = reverse;
    }

    public Item getCtoItem() {
        return ctoItem;
    }

    public void setCtoItem(Item ctoItem) {
        this.ctoItem = ctoItem;
    }

    public String getOutCustomerCode(){
        // todo
        return "I";
    }

    public void setTotalPay(Money totalPay) {
        this.totalPay = totalPay;
    }

    public void setDiscountTotal(Money discountTotal) {
        this.discountTotal = discountTotal;
    }

    public void setCashVoucher(Money cashVoucher) {
        this.cashVoucher = cashVoucher;
    }

    public void setCashGiftCard(Money cashGiftCard) {
        this.cashGiftCard = cashGiftCard;
    }


    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
    public Money getChangePriceDiscount() {
        return changePriceDiscount;
    }

    public void setChangePriceDiscount(Money changePriceDiscount) {
        this.changePriceDiscount = changePriceDiscount;
    }
    @Override
    public String toString() {
        return "Main{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", outId='" + outId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", totalCost=" + totalCost +
                ", totalPay=" + totalPay +
                ", source='" + source + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", salesType=" + salesType +
                ", paymentType=" + paymentType +
                ", payStatus=" + payStatus +
                ", payment=" + payment +
                ", bankTraceNo='" + bankTraceNo + '\'' +
                ", payVoucherNo='" + payVoucherNo + '\'' +
                ", payTraceNo='" + payTraceNo + '\'' +
                ", paidTime=" + paidTime +
                ", faType=" + faType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", items=" + items +
                ", locked=" + locked +
                '}';
    }



    /**
     * 判断FA是否为直营
     * @return
     */
    public boolean isFaDirect(){
        if(this.faType != null){
            if (this.faType == Main.FA_TYPE_DIRECT || this.faType == Main.FA_TYPE_THINK_DIRECT)
                return true;
            else
                return false;
        }
       return  false;
    }
    //新增抛单状态
    private int throwStatus;

    public int getThrowStatus() {
        if(StringUtils.isEmpty(this.outId)){
            return 0;
        }
        return 1;
    }

    public void setThrowStatus(int throwStatus) {
        this.throwStatus = throwStatus;
    }


    public boolean allowShipping() {
        boolean allowable = false;
        if (this.faType == Main.FA_TYPE_RESELLERS) {
            allowable = true;
        } else if (StringUtils.isNotEmpty(this.outId)) {
            allowable = true;
        }
        return allowable;
    }

    public Boolean signed() {
        return this.status == OrderConstant.STATUS_SIGNED;
    }

    /**
     * oto 货到付款
     *
     * @return
     */
    public  boolean otoPayOnDelivery() {
        return getType() == OrderConstant.ADD_TYPE_OTO && PAY_STATUS_REVIVE == getPaymentType();
    }

    public boolean shiped() {
        return this.status == OrderConstant.STATUS_SHIPPED;
    }
}