package com.lenovo.m2.oc.canal.domain.reverse;

import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;
import com.lenovo.m2.arch.tool.util.StringUtils;
import com.lenovo.m2.oc.canal.common.utils.JsonUtilForMongoBean;
import com.lenovo.m2.oc.canal.domain.ordercenter.Cv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzhen10 on 2016-07-26 10:52:38
 */
public class ReverseItem implements Serializable {

    private long id;   //自增id

    private long reverseId;  //反向单号

    private String goodsCode;  //商品编号

    private Money goodsPrice;   //商品价格

    private int num;    //数量

    private String goodsName;   //商品名称

    private String goodsDesc;   //商品描述

    private String goodsSpec;   //商品规格

    private String goodsPhoto;   //商品图片

    private Money discountImmediacy;    //下单立减

    private Money discountFirst;    //首单立减

    private Money discountCoupons;   //优惠券折扣

    private Money discountCouponCode;  //优惠码折扣

    private Money cashVoucher;     //代金券

    private Money cashGiftCard;   //礼品卡

    private Money discountFullReduce;  //满减

    private Money refundManual;  //满减

    private Money discountInnerBuyMoney;  //内购额度

    private Money discountLeDou;  //使用乐豆

    private Money amount;  //小计

    private Money internalUpLine;  //内购上线

    private boolean needSn;   //是否需要SN

    private boolean optional;   //是否选件

    private boolean physical;   //是否实物

    private int serviceType;    //是否服务

    private boolean aGift;      //是否赠品

    private String materialCode;   //物料编号

    private String unit;   //单位

    private String packageId;   //商品组

    private String machineSN; //主机编号,购买服务时，绑定的SN号

    private String snCode;

    private String deatLike;   //产品组

    private String ctoRemark;  //定制信息

    private String ctoToken;

    private String faid;

    private String faType;

    private String faName;

    private int bu;

    private String reservationId;    //库存软预留号  moto

    private Date promiseDate;    //预计送达时间

    private Date scheduledShipDate;   //预计发货时间

    private Money upsellPrice;   //升级价 moto

    private Money basePrice;    //基础价 moto

    private int itemAsc;  //行项目

    private String createTime;   //创建时间

    private String updateTime;  //修改时间

    private int version;    //版本号

    private int reverseNum;    //退/换货数量

    private String reverseSnCode;  //退/换货SN

    private List<Cv> cvItemList;

    private String skuExtend; //定制详情

    private String materialType;//物料类型 ZMAT,ZREV,LG18,LG19 为主机物料类型，其他为非主机物料类型

    private boolean mainSku;//是否主品

    private String imei1;//Moto-i1
    private String imei2;//Moto-i2
    private Money lineTax;//反向商品税额
    private String billingNo; //billing 号 （moto 专用）
    private Integer uniqueKey; //1 imei  2 pn

    private String imeiRemark; //imei号集合 的json串

    private Money totalDiscount;    //总优惠   商品单价*数量  - 小计

    //************ moto税 ***********
    private String taxDetail;//moto税明细

    private String cgstTaxRate;
    private Money cgsttaxAmount;

    private String sgstTaxRate;
    private Money sgsttaxAmount;

    private String igstTaxRate;
    private Money igsttaxAmount;
    private Integer rewardBean;//奖励乐豆

    private Money personalizationAmount;//私定金额

    //预售优惠
    private Money discountPresell;

    public Money getDiscountPresell() {
        return discountPresell;
    }

    public void setDiscountPresell(Money discountPresell) {
        this.discountPresell = discountPresell;
    }

    public Money getPersonalizationAmount() {
        return personalizationAmount;
    }

    public void setPersonalizationAmount(Money personalizationAmount) {
        this.personalizationAmount = personalizationAmount;
    }

    public Integer getRewardBean() {
        return rewardBean;
    }

    public void setRewardBean(Integer rewardBean) {
        this.rewardBean = rewardBean;
    }
    public String getCgstTaxRate() {
        return cgstTaxRate;
    }

    public void setCgstTaxRate(String cgstTaxRate) {
        this.cgstTaxRate = cgstTaxRate;
    }

    public Money getCgsttaxAmount() {
        return cgsttaxAmount;
    }

    public void setCgsttaxAmount(Money cgsttaxAmount) {
        this.cgsttaxAmount = cgsttaxAmount;
    }

    public String getSgstTaxRate() {
        return sgstTaxRate;
    }

    public void setSgstTaxRate(String sgstTaxRate) {
        this.sgstTaxRate = sgstTaxRate;
    }

    public Money getSgsttaxAmount() {
        return sgsttaxAmount;
    }

    public void setSgsttaxAmount(Money sgsttaxAmount) {
        this.sgsttaxAmount = sgsttaxAmount;
    }

    public String getIgstTaxRate() {
        return igstTaxRate;
    }

    public void setIgstTaxRate(String igstTaxRate) {
        this.igstTaxRate = igstTaxRate;
    }

    public Money getIgsttaxAmount() {
        return igsttaxAmount;
    }

    public void setIgsttaxAmount(Money igsttaxAmount) {
        this.igsttaxAmount = igsttaxAmount;
    }

    public String getTaxDetail() {
        return taxDetail;
    }

    public void setTaxDetail(String taxDetail) {
        this.taxDetail = taxDetail;
    }

    public Money getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Money totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getImeiRemark() {
        return imeiRemark;
    }

    public void setImeiRemark(String imeiRemark) {
        this.imeiRemark = imeiRemark;
    }
    //虚拟币增加字段

    private Money virtualCoin;//虚拟币数量

    private Integer virtualCoinType;//虚拟币类型1 消费点 2 乐豆

    public Integer getVirtualCoinType() {
        return virtualCoinType;
    }

    public void setVirtualCoinType(Integer virtualCoinType) {
        this.virtualCoinType = virtualCoinType;
    }

    public Money getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Money virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public Integer getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(Integer uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getBillingNo() {
        return billingNo;
    }

    public void setBillingNo(String billingNo) {
        this.billingNo = billingNo;
    }

    public Money getLineTax() {
        return lineTax;
    }

    public void setLineTax(Money lineTax) {
        this.lineTax = lineTax;
    }

    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    public String getImei2() {
        return imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    private Reverse reverse;

    private Tenant tenant;

    public Money getRefundManual() {
        return refundManual;
    }

    public void setRefundManual(Money refundManual) {
        this.refundManual = refundManual;
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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Money getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Money goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
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

    public Money getCashVoucher() {
        return cashVoucher;
    }

    public void setCashVoucher(Money cashVoucher) {
        this.cashVoucher = cashVoucher;
    }

    public Money getCashGiftCard() {
        return cashGiftCard;
    }

    public void setCashGiftCard(Money cashGiftCard) {
        this.cashGiftCard = cashGiftCard;
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

    public Money getDiscountLeDou() {
        return discountLeDou;
    }

    public void setDiscountLeDou(Money discountLeDou) {
        this.discountLeDou = discountLeDou;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Money getInternalUpLine() {
        return internalUpLine;
    }

    public void setInternalUpLine(Money internalUpLine) {
        this.internalUpLine = internalUpLine;
    }

    public boolean isNeedSn() {
        return needSn;
    }

    public void setNeedSn(boolean needSn) {
        this.needSn = needSn;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public boolean isPhysical() {
        return physical;
    }

    public void setPhysical(boolean physical) {
        this.physical = physical;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isaGift() {
        return aGift;
    }

    public void setaGift(boolean aGift) {
        this.aGift = aGift;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getMachineSN() {
        return machineSN;
    }

    public void setMachineSN(String machineSN) {
        this.machineSN = machineSN;
    }

    public String getSnCode() {
        return snCode;
    }

    public void setSnCode(String snCode) {
        this.snCode = snCode;
    }

    public String getDeatLike() {
        return deatLike;
    }

    public void setDeatLike(String deatLike) {
        this.deatLike = deatLike;
    }

    public String getCtoRemark() {
        return ctoRemark;
    }

    public void setCtoRemark(String ctoRemark) {
        this.ctoRemark = ctoRemark;
    }

    public String getCtoToken() {
        return ctoToken;
    }

    public void setCtoToken(String ctoToken) {
        this.ctoToken = ctoToken;
    }

    public String getFaid() {
        return faid;
    }

    public void setFaid(String faid) {
        this.faid = faid;
    }

    public String getFaType() {
        return faType;
    }

    public void setFaType(String faType) {
        this.faType = faType;
    }

    public String getFaName() {
        return faName;
    }

    public void setFaName(String faName) {
        this.faName = faName;
    }

    public int getBu() {
        return bu;
    }

    public void setBu(int bu) {
        this.bu = bu;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getPromiseDate() {
        return promiseDate;
    }

    public void setPromiseDate(Date promiseDate) {
        this.promiseDate = promiseDate;
    }

    public Date getScheduledShipDate() {
        return scheduledShipDate;
    }

    public void setScheduledShipDate(Date scheduledShipDate) {
        this.scheduledShipDate = scheduledShipDate;
    }

    public Money getUpsellPrice() {
        return upsellPrice;
    }

    public void setUpsellPrice(Money upsellPrice) {
        this.upsellPrice = upsellPrice;
    }

    public Money getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Money basePrice) {
        this.basePrice = basePrice;
    }

    public int getItemAsc() {
        return itemAsc;
    }

    public void setItemAsc(int itemAsc) {
        this.itemAsc = itemAsc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getReverseNum() {
        return reverseNum;
    }

    public void setReverseNum(int reverseNum) {
        this.reverseNum = reverseNum;
    }

    public String getReverseSnCode() {
        return reverseSnCode;
    }

    public void setReverseSnCode(String reverseSnCode) {
        this.reverseSnCode = reverseSnCode;
    }

    public List<Cv> getCvItemList() {
        return cvItemList;
    }

    public void setCvItemList(List<Cv> cvItemList) {
        this.cvItemList = cvItemList;
    }

    public String getSkuExtend() {
        return skuExtend;
    }

    public void setSkuExtend(String skuExtend) {
        this.skuExtend = skuExtend;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public boolean isMainSku() {
        return mainSku;
    }

    public void setMainSku(boolean mainSku) {
        this.mainSku = mainSku;
    }

    public Reverse getReverse() {
        return reverse;
    }

    public void setReverse(Reverse reverse) {
        this.reverse = reverse;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public List<Cv> genCvItemList() {
        if(StringUtils.isNotEmpty(this.skuExtend)){
            cvItemList = JsonUtilForMongoBean.fromJson(this.getSkuExtend(),this.getClass()).getCvItemList();
        }else{
            cvItemList = new ArrayList<Cv>();
        }
        return cvItemList;
    }
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", num=" + num +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsSpec='" + goodsSpec + '\'' +
                ", discountLeDou=" + discountLeDou +
                ", amount=" + amount +
                ", service=" + serviceType +
                ", aGift=" + aGift +
                ", materialCode='" + materialCode + '\'' +
                ", packageId='" + packageId + '\'' +
                ", machineSN='" + machineSN + '\'' +
                ", snCode='" + snCode + '\'' +
                ", ctoRemark='" + ctoRemark + '\'' +
                ", ctoToken='" + ctoToken + '\'' +
                ", faType='" + faType + '\'' +
                ", reverseNum=" + reverseNum +
                ", cvItemList=" + cvItemList +
                '}';
    }
}
