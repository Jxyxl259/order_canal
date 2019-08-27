package com.lenovo.m2.oc.canal.domain.ordercenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jiazy on 2016/6/28.
 */
public class Item implements Serializable {

    /**
     * 非服务类型
     */
    public static  final  int SERVICE_TYPE_UN=0;
    /**
     * 普通服务类型
     */
    public static  final  int SERVICE_TYPE_ORDINARY=1;
    /**
     * 小新服务类型
     */
    public static  final  int SERVICE_TYPE_XIAOXIN=2;
    /**
     * 订单审核状态-已通过 审批通过
     */
    public static final int CTO_REVIEW_STATUS_PASSED = 1;
    /**
     * 订单审核状态-驳回
     */
    public static final int CTO_REVIEW_STATUS_REJECTED = 2;
    /**
     * 订单审核状态-未审批
     */
    public static final int CTO_REVIEW_STATUS_NOT_REVIEW = 3;

    /**
     * Imei校验
     */
    public static final int UNIQUE_KEY_IMEI = 1;   //需要校验Imei
    public static final int UNIQUE_KEY_PN = 2;


    private long id;   //自增id

    private long orderId;  //订单号

    private String goodsCode;  //商品编号

    private Money goodsPrice;   //商品价格

    private int num;    //数量

    private int reNum;    //反向数量

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

    private Money giftDiscount;//赠品分摊

    private Money discountFullReduce;  //满减

    private Money discountInnerBuyMoney;  //内购额度

    private Money discountLeDou;  //使用乐豆

    private Money amount;  //小计

    //预售优惠
    private Money discountPresell;

    private Money InternalUpLine;  //内购上线

    private boolean needSn;   //是否需要SN

    private boolean optional;   //是否选件

    private boolean physical;   //是否实物

    private int serviceType;    //服务类型

    private boolean aGift;      //是否赠品

    private  boolean aMainSku ; //是否是主品

    private String materialCode;   //物料编号

    private String unit;   //单位

    private String packageId;   //商品组

    private String machineSN; //主机编号,购买服务时，绑定的SN号

    private String snCode;

    private String deatLike;   //产品组


    private int ctoReviewStatus;  //定制审核状态

    private String ctoReviewReason;  //定制审核状态

    private String skuExtend; //定制详情

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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;   //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;  //修改时间

    private int version;    //版本号

    private String materialType;//物料类型 ZMAT,ZREV,LG18,LG19 为主机物料类型，其他为非主机物料类型

    private boolean mainSku;//是否主品

    private String faCode; //分销商code

    private String wareHouseId;  //库存地

    private int stockType;  //库存类型：1=SEC库存  2=自有库存

    private String skuType;  //'商品类型：0普通，10定制无字，11定制有字，20cto无需审核，21cto需要审核' ;

    private Money lineTax; //税额

    private int uniqueKey; //1 imei  2 pn

    private Main main;

    private List<Cv> cvItemList;

    private Tenant tenant;

    //虚拟币增加字段

    private Money virtualCoin;//虚拟币数量

    private Integer virtualCoinType;//虚拟币类型1 消费点 2 乐豆

    private String taxDetail;//moto税明细

    private Integer deductStock;//是否需要库存

    private Integer kcodeType;//K(L)和Z码类型

    private String kcode;// [K/L/Z]码

    //全网营销2.0
    private Money agentPrice;//代理价
    private Long originStoreId;//来源门店id
    private String originStoreCode;//来源门店编码
    private Long dispatchStoreId;//发货门店id
    private String dispatchStoreCode;//发货门店编码
    private String originFaId;//来源faid,faid是发货faid
    private Integer originFaType;//来源fa类型，fatype是发货fatype
    private String dispatchCode;//发货商品编码，code是来源商品编码

    private Integer rewardBean;//奖励乐豆

    public Money getDiscountPresell() {
        return discountPresell;
    }

    public void setDiscountPresell(Money discountPresell) {
        this.discountPresell = discountPresell;
    }

    public Integer getRewardBean() {
        return rewardBean;
    }

    public void setRewardBean(Integer rewardBean) {
        this.rewardBean = rewardBean;
    }

    public Money getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(Money agentPrice) {
        this.agentPrice = agentPrice;
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

    public Long getDispatchStoreId() {
        return dispatchStoreId;
    }

    public void setDispatchStoreId(Long dispatchStoreId) {
        this.dispatchStoreId = dispatchStoreId;
    }

    public String getDispatchStoreCode() {
        return dispatchStoreCode;
    }

    public void setDispatchStoreCode(String dispatchStoreCode) {
        this.dispatchStoreCode = dispatchStoreCode;
    }

    public String getOriginFaId() {
        return originFaId;
    }

    public void setOriginFaId(String originFaId) {
        this.originFaId = originFaId;
    }

    public Integer getOriginFaType() {
        return originFaType;
    }

    public void setOriginFaType(Integer originFaType) {
        this.originFaType = originFaType;
    }

    public String getDispatchCode() {
        return dispatchCode;
    }

    public void setDispatchCode(String dispatchCode) {
        this.dispatchCode = dispatchCode;
    }

    public Integer getDeductStock() {
        return deductStock;
    }

    public void setDeductStock(Integer deductStock) {
        this.deductStock = deductStock;
    }

    public Integer getKcodeType() {
        return kcodeType;
    }

    public void setKcodeType(Integer kcodeType) {
        this.kcodeType = kcodeType;
    }

    public String getKcode() {
        return kcode;
    }

    public void setKcode(String kcode) {
        this.kcode = kcode;
    }

    public String getTaxDetail() {
        return taxDetail;
    }

    public void setTaxDetail(String taxDetail) {
        this.taxDetail = taxDetail;
    }

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

    public boolean isaMainSku() {
        return aMainSku;
    }

    public void setaMainSku(boolean aMainSku) {
        this.aMainSku = aMainSku;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public String getFaCode() {
        return faCode;
    }

    public void setFaCode(String faCode) {
        this.faCode = faCode;
    }

    public String getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public int getStockType() {
        return stockType;
    }

    public void setStockType(int stockType) {
        this.stockType = stockType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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



    public Money getDiscountFirst() {
        return discountFirst;
    }


    public Money getDiscountCoupons() {
        return discountCoupons;
    }

    public void setGoodsPrice(Money goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setDiscountImmediacy(Money discountImmediacy) {
        this.discountImmediacy = discountImmediacy;
    }

    public void setDiscountFirst(Money discountFirst) {
        this.discountFirst = discountFirst;
    }

    public void setDiscountCoupons(Money discountCoupons) {
        this.discountCoupons = discountCoupons;
    }

    public void setDiscountCouponCode(Money discountCouponCode) {
        this.discountCouponCode = discountCouponCode;
    }

    public void setCashVoucher(Money cashVoucher) {
        this.cashVoucher = cashVoucher;
    }

    public void setCashGiftCard(Money cashGiftCard) {
        this.cashGiftCard = cashGiftCard;
    }

    public Money getGiftDiscount() {
        return giftDiscount;
    }

    public void setGiftDiscount(Money giftDiscount) {
        this.giftDiscount = giftDiscount;
    }

    public void setDiscountFullReduce(Money discountFullReduce) {
        this.discountFullReduce = discountFullReduce;
    }

    public void setDiscountInnerBuyMoney(Money discountInnerBuyMoney) {
        this.discountInnerBuyMoney = discountInnerBuyMoney;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public void setInternalUpLine(Money internalUpLine) {
        InternalUpLine = internalUpLine;
    }

    public void setUpsellPrice(Money upsellPrice) {
        this.upsellPrice = upsellPrice;
    }

    public void setBasePrice(Money basePrice) {
        this.basePrice = basePrice;
    }

    public Money getDiscountCouponCode() {
        return discountCouponCode;
    }



    public Money getCashVoucher() {
        return cashVoucher;
    }


    public Money getCashGiftCard() {
        return cashGiftCard;
    }


    public Money getDiscountFullReduce() {
        return discountFullReduce;
    }



    public Money getDiscountInnerBuyMoney() {
        return discountInnerBuyMoney;
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


    public Money getInternalUpLine() {
        return InternalUpLine;
    }

    public int getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(int uniqueKey) {
        this.uniqueKey = uniqueKey;
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

    public String getCtoReviewReason() {
        return ctoReviewReason;
    }

    public void setCtoReviewReason(String ctoReviewReason) {
        this.ctoReviewReason = ctoReviewReason;
    }

    public String getSkuExtend() {
        return skuExtend;
    }

    public void setSkuExtend(String skuExtend) {
        this.skuExtend = skuExtend;
    }

    public void setDeatLike(String deatLike) {
        this.deatLike = deatLike;
    }

    public int getCtoReviewStatus() {
        return ctoReviewStatus;
    }

    public void setCtoReviewStatus(int ctoReviewStatus) {
        this.ctoReviewStatus = ctoReviewStatus;
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


    public Money getBasePrice() {
        return basePrice;
    }

    public Money getLineTax() {
        return lineTax;
    }

    public void setLineTax(Money lineTax) {
        this.lineTax = lineTax;
    }
    public int getItemAsc() {
        return itemAsc;
    }

    public void setItemAsc(int itemAsc) {
        this.itemAsc = itemAsc;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public boolean isaGift() {
        return aGift;
    }

    public void setaGift(boolean aGift) {
        this.aGift = aGift;
    }

    public List<Cv> getCvItemList() {
        return cvItemList;
    }

    public void setCvItemList(List<Cv> cvItemList) {
        this.cvItemList =cvItemList;
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

    public int getReNum() {
        return reNum;
    }

    public void setReNum(int reNum) {
        this.reNum = reNum;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", num=" + num +
                ", reNum=" + reNum +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsSpec='" + goodsSpec + '\'' +
                ", discountLeDou=" + discountLeDou +
                ", amount=" + amount +
                ", service=" + serviceType +
                ", aGift=" + aGift +
                ", materialCode='" + materialCode + '\'' +
                ", packageId='" + packageId + '\'' +
                ", snCode='" + snCode + '\'' +
                ", ctoRemark='" + ctoRemark + '\'' +
                ", faType='" + faType + '\'' +
                '}';
    }

}
