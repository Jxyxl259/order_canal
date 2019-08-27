package com.lenovo.m2.oc.canal.domain.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.tool.util.StringUtils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jh on 16/08/23.
 * 订单报表
 */
public class OrdersReportVo implements Serializable {


    private String id; //订单编号
    private String itemId; //商品编号
    private String payTraceNo; //子支付流水号
    private String payVoucherNo; //主支付流水号
    private String bankTraceNo; //第三方支付流水号  支付订单号
    private String outId; //BTCP订单号
    private int shopId; // 商户名称
    private String faName; //FA名称
    private String customerPONo;
    private int status; //订单状态
    private String paymentType; //订单支付类型

    private int payStatus; //支付状态

    private int type; //订单类型
    private String name; //收货人姓名
    private Money totalCost; //订单总价
    private String lenovoId; //LenovoID
    private int terminalId;
    private String salesType;
    private String enterprise; //#所属企业
    private String enrolledGroup;//所属组
    private String customerManagerCode; //客户经理编码
    private Money cashVoucher; // 代金券总金额


    private String memberCode; //会员用户名
    private int discountLeDou; //使用乐豆
    private int rewardLeDouNum; //获赠乐豆
    private String address; //收货人地址
    private String zip; //邮编
    private String mobile;
    private String email; //邮箱
    private String province; //省名称
    private String city; //城市
    private String area; //城市
    private String county; //区县
    private Money totalPay; // 在线支付总金额
    private Money amount; // 在线支付总金额
    private String parentId; //主订单号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime; //单据生成时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp paidTime; //支付时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;//OutId 存在时，为抛单时间
    private int payment; //用户支付方式
    private Money skMoney; //收款金额  #收款金额 = 支付金额 + 代金券 + 礼品卡
    private String customerRemark;//订单附言
    private int taxType;//发票类型
    private String title;//发票抬头
    private String taxpayerIdentity;//纳税人识别号
    private int units;
    private String deatLike;//产品组
    private String goodsSpec;//商品规格
    private String materialCode;//联想物料编码
    private int gift;//商品类型
    private String goodsName;//商品名称
    private String goodsCode;//商品编号
    private int num;//商品数量
    private Money goodsPrice; //商品单价
    private Money favourableTotalMoney; // #折扣总金额 # 折扣总金额 = 商品数量 * 单品折扣
    private Money projectSJPrice; // #商品实际价格 #商品实际价格 = 商品原单价 - 单品折扣
    private Money favourablePay; // 折扣金额
    private Money discountInnerBuyMoney;//内购额度
    private String source;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp shipDate; //发货时间 sendDate
    private String logisticsCompanyName;//物流公司名称 logiName
    private String logisticsNo;//物流单号 logiNo
    private int shipStatus; //发货状态 shipStatus
    //抛单状态
    private int throwStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp throwTime;

    private String throwedFailureReason;

    /**
     * 是否冻结 0--否;1--是
     */
    private Boolean locked;

    private Long storeId;//门店id

    private String currencyCode;
    private int mainSku;//1：主品

    private String ctoRemark;
    private int itemAsc;
    private Money totalTax; //订单的总税款，目前moto印度有
    private String deliverGoodsType;//送货方式:L1空运，L2陆运，D7自取
    private Money lineTax;//送货方式:L1空运，L2陆运，D7自取
    private String proviceAbbreviation;//moto省份编码
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp expectDate;
    private String taxNo;
    private Money cashGiftCard;//礼品卡
    private Money discountFirst;//
    private Money discountCoupons;//
    private Money discountCouponCode;//
    private Money discountFullReduce;//
    private Money discountImmediacy;//
    private String snCode;
    private Money changePriceDiscount;//改价优惠
    //预售优惠
    private Money discountPresell;

    /**
     * 虚拟币增加字段
     */
    private Money freight;//运费
    private Money virtualCoin;//虚拟币数量
    private Integer virtualCoinType;//虚拟币类型
    private Money leDouNum;//乐豆数量

    public String getSnCode() {
        return snCode;
    }

    public void setSnCode(String snCode) {
        this.snCode = snCode;
    }

    public Money getLeDouNum() {
        return leDouNum;
    }

    public void setLeDouNum(Money leDouNum) {
        this.leDouNum = leDouNum;
    }

    public Money getFreight() {
        return freight;
    }

    public void setFreight(Money freight) {
        this.freight = freight;
    }

    public Money getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Money virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public Integer getVirtualCoinType() {
        return virtualCoinType;
    }

    public void setVirtualCoinType(Integer virtualCoinType) {
        this.virtualCoinType = virtualCoinType;
    }

    public Money getDiscountImmediacy() {
        return discountImmediacy;
    }

    public void setDiscountImmediacy(Money discountImmediacy) {
        this.discountImmediacy = discountImmediacy;
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

    public Money getDiscountFirst() {
        return discountFirst;
    }

    public void setDiscountFirst(Money discountFirst) {
        this.discountFirst = discountFirst;
    }

    public Money getCashGiftCard() {
        return cashGiftCard;
    }

    public void setCashGiftCard(Money cashGiftCard) {
        this.cashGiftCard = cashGiftCard;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public Timestamp getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Timestamp expectDate) {
        this.expectDate = expectDate;
    }

    public String getProviceAbbreviation() {
        return proviceAbbreviation;
    }

    public void setProviceAbbreviation(String proviceAbbreviation) {
        this.proviceAbbreviation = proviceAbbreviation;
    }

    public Money getLineTax() {
        return lineTax;
    }

    public void setLineTax(Money lineTax) {
        this.lineTax = lineTax;
    }

    public Money getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Money totalTax) {
        this.totalTax = totalTax;
    }

    public String getDeliverGoodsType() {
        return deliverGoodsType;
    }

    public void setDeliverGoodsType(String deliverGoodsType) {
        this.deliverGoodsType = deliverGoodsType;
    }

    public int getItemAsc() {
        return itemAsc;
    }

    public void setItemAsc(int itemAsc) {
        this.itemAsc = itemAsc;
    }

    public String getCtoRemark() {
        return ctoRemark;
    }

    public void setCtoRemark(String ctoRemark) {
        this.ctoRemark = ctoRemark;
    }

    public int getMainSku() {
        return mainSku;
    }

    public void setMainSku(int mainSku) {
        this.mainSku = mainSku;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getThrowedFailureReason() {
        return throwedFailureReason;
    }

    public void setThrowedFailureReason(String throwedFailureReason) {
        this.throwedFailureReason = throwedFailureReason;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public String getLogisticsCompanyName() {
        return logisticsCompanyName;
    }

    public void setLogisticsCompanyName(String logisticsCompanyName) {
        this.logisticsCompanyName = logisticsCompanyName;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public int getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(int shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Timestamp getThrowTime() {
        return throwTime;
    }

    public void setThrowTime(Timestamp throwTime) {
        this.throwTime = throwTime;
    }

    public int getThrowStatus() {
        if (StringUtils.isEmpty(this.outId)) {
            return 0;
        }
        return 1;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setThrowStatus(int throwStatus) {
        this.throwStatus = throwStatus;
    }

    public String getCustomerPONo() {
        return customerPONo;
    }

    public void setCustomerPONo(String customerPONo) {
        this.customerPONo = customerPONo;
    }

    public int getGift() {
        return gift;
    }

    public void setGift(int gift) {
        this.gift = gift;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayTraceNo() {
        return payTraceNo;
    }

    public void setPayTraceNo(String payTraceNo) {
        this.payTraceNo = payTraceNo;
    }

    public String getPayVoucherNo() {
        return payVoucherNo;
    }

    public void setPayVoucherNo(String payVoucherNo) {
        this.payVoucherNo = payVoucherNo;
    }

    public String getBankTraceNo() {
        return bankTraceNo;
    }

    public void setBankTraceNo(String bankTraceNo) {
        this.bankTraceNo = bankTraceNo;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLenovoId() {
        return lenovoId;
    }

    public void setLenovoId(String lenovoId) {
        this.lenovoId = lenovoId;
    }

    public int getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
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

    public String getCustomerManagerCode() {
        return customerManagerCode;
    }

    public void setCustomerManagerCode(String customerManagerCode) {
        this.customerManagerCode = customerManagerCode;
    }


    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public int getDiscountLeDou() {
        return discountLeDou;
    }

    public void setDiscountLeDou(int discountLeDou) {
        this.discountLeDou = discountLeDou;
    }

    public int getRewardLeDouNum() {
        return rewardLeDouNum;
    }

    public void setRewardLeDouNum(int rewardLeDouNum) {
        this.rewardLeDouNum = rewardLeDouNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Timestamp paidTime) {
        this.paidTime = paidTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }


    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public int getTaxType() {
        return taxType;
    }

    public void setTaxType(int taxType) {
        this.taxType = taxType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeatLike() {
        return deatLike;
    }

    public void setDeatLike(String deatLike) {
        this.deatLike = deatLike;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Money totalCost) {
        this.totalCost = totalCost;
    }

    public Money getCashVoucher() {
        return cashVoucher;
    }

    public void setCashVoucher(Money cashVoucher) {
        this.cashVoucher = cashVoucher;
    }

    public Money getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Money totalPay) {
        this.totalPay = totalPay;
    }

    public Money getSkMoney() {
        return skMoney;
    }

    public void setSkMoney(Money skMoney) {
        this.skMoney = skMoney;
    }

    public Money getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Money goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Money getFavourableTotalMoney() {
        return favourableTotalMoney;
    }

    public void setFavourableTotalMoney(Money favourableTotalMoney) {
        this.favourableTotalMoney = favourableTotalMoney;
    }

    public Money getProjectSJPrice() {
        return projectSJPrice;
    }

    public void setProjectSJPrice(Money projectSJPrice) {
        this.projectSJPrice = projectSJPrice;
    }

    public Money getFavourablePay() {
        return favourablePay;
    }

    public void setFavourablePay(Money favourablePay) {
        this.favourablePay = favourablePay;
    }

    public Money getDiscountInnerBuyMoney() {
        return discountInnerBuyMoney;
    }

    public void setDiscountInnerBuyMoney(Money discountInnerBuyMoney) {
        this.discountInnerBuyMoney = discountInnerBuyMoney;
    }

    public Money getChangePriceDiscount() {
        return changePriceDiscount;
    }

    public void setChangePriceDiscount(Money changePriceDiscount) {
        this.changePriceDiscount = changePriceDiscount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTaxpayerIdentity() {
        return taxpayerIdentity;
    }

    public void setTaxpayerIdentity(String taxpayerIdentity) {
        this.taxpayerIdentity = taxpayerIdentity;
    }

    public int getUnits() {
        return units;
    }

    public Money getDiscountPresell() {
        if(discountPresell == null){
            return new Money(0, "CNY");
        }
        return discountPresell;
    }

    public void setDiscountPresell(Money discountPresell) {
        this.discountPresell = discountPresell;
    }

    public void setUnits(int units) {
        this.units = units;
    }
    /*   public String toString() {
        return "OrdersReportVo{" +
                "id='" + id + '\'' +
                ", payTraceNo='" + payTraceNo + '\'' +
                ", payVoucherNo='" + payVoucherNo + '\'' +
                ", bankTraceNo='" + bankTraceNo + '\'' +
                ", outId='" + outId + '\'' +
                ", shopId=" + shopId +
                ", faName='" + faName + '\'' +
                ", customerPONo='" + customerPONo + '\'' +
                ", status=" + status +
                ", paymentType='" + paymentType + '\'' +
                ", payStatus=" + payStatus +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", totalCost=" + totalCost +
                ", lenovoId='" + lenovoId + '\'' +
                ", terminalId=" + terminalId +
                ", salesType='" + salesType + '\'' +
                ", enterprise='" + enterprise + '\'' +
                ", enrolledGroup='" + enrolledGroup + '\'' +
                ", customerManagerCode='" + customerManagerCode + '\'' +
                ", cashVoucher=" + cashVoucher +
                ", memberCode='" + memberCode + '\'' +
                ", discountLeDou=" + discountLeDou +
                ", rewardLeDouNum=" + rewardLeDouNum +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", totalPay=" + totalPay +
                ", parentId='" + parentId + '\'' +
                ", createTime=" + createTime +
                ", paidTime=" + paidTime +
                ", updateTime=" + updateTime +
                ", payment=" + payment +
                ", skMoney=" + skMoney +
                ", customerRemark='" + customerRemark + '\'' +
                ", taxType=" + taxType +
                ", title='" + title + '\'' +
                ", deatLike='" + deatLike + '\'' +
                ", goodsSpec='" + goodsSpec + '\'' +
                ", materialCode='" + materialCode + '\'' +
                ", gift=" + gift +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", num=" + num +
                ", goodsPrice=" + goodsPrice +
                ", favourableTotalMoney=" + favourableTotalMoney +
                ", projectSJPrice=" + projectSJPrice +
                ", favourablePay=" + favourablePay +
                ", discountInnerBuyMoney=" + discountInnerBuyMoney +
                ", source='" + source + '\'' +
                ", shipDate=" + shipDate +
                ", logisticsCompanyName='" + logisticsCompanyName + '\'' +
                ", logisticsNo='" + logisticsNo + '\'' +
                ", shipStatus=" + shipStatus +
                ", throwStatus=" + throwStatus +
                ", throwTime=" + throwTime +
                ", locked=" + locked +
                '}';
    }*/
}
