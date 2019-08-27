package com.lenovo.m2.oc.canal.domain.reverse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.arch.framework.domain.Tenant;
import com.lenovo.m2.oc.canal.domain.ordercenter.Main;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by zhangzhen on 16/7/8.
 */
public class Reverse implements Serializable {
    private static Logger LOGGER = LoggerFactory.getLogger(Reverse.class);

    private static Map<String, String> rApplyKPrefixMap = new HashMap<String, String>();

    static {
        rApplyKPrefixMap.put("0", "K");
        rApplyKPrefixMap.put("5", "T");
        rApplyKPrefixMap.put("6", "E");
        rApplyKPrefixMap.put("7", "G");
        rApplyKPrefixMap.put("8", "AP");
        rApplyKPrefixMap.put("9", "AG");
        rApplyKPrefixMap.put("10", "WS");
        rApplyKPrefixMap.put("11", "WG");
        rApplyKPrefixMap.put("12", "WA");
        rApplyKPrefixMap.put("13", "WP");
        rApplyKPrefixMap.put("16", "MBG");
        rApplyKPrefixMap.put("17", "T");
        rApplyKPrefixMap.put("18", "T");
        rApplyKPrefixMap.put("19", "T");
        rApplyKPrefixMap.put("56", "K");
        rApplyKPrefixMap.put("88", "AP");
    }

    /**
     * 反向类型 1--撤单
     */
    public final static int REVERSE_TYPE_REVOKE = 1;
    /**
     * 反向类型 2--退货
     */
    public final static int REVERSE_TYPE_RETURN = 2;
    /**
     * 反向类型 3--换货
     */
    public final static int REVERSE_TYPE_EXCHANGE = 3;
    /**
     * 审核状态 0--未审核
     */
    public final static int AUDIT_STATUS_UNAUDITED = 0;
    /**
     * 审核状态 1--受理
     */
    public final static int AUDIT_STATUS_ACCEPTED = 1;
    /**
     * 审核状态 2--驳回
     */
    public final static int AUDIT_STATUS_REJECTED = 2;
    /**
     * 审核状态 3--已作废
     */
    public final static int AUDIT_STATUS_CANCELL = 3;

    /**
     * 审核状态 4--已审核已抛废单
     */
    public final static int AUDIT_STATUS_ACC_ABOILSH = 4;
    /**
     * 审核状态 5--废单通过
     */
    public final static int AUDIT_STATUS_ABOLISH_SUC = 5;
    /**
     * 审核状态 6--废单驳回
     */
    public final static int AUDIT_STATUS_ABOLISH_DEF = 6;

    /**
     * 反向订单状态 0--已申请
     */
    public final static int RE_STATUS_UNAUDITED = 0;
    /**
     * 反向订单状态 1--审核通过
     */
    public final static int RE_STATUS_ACCEPTED = 1;
    /**
     * 反向订单状态 2--审核拒绝
     */
    public final static int RE_STATUS_REJECTED = 2;
    /**
     * 反向订单状态 3--退款中
     */
    public final static int RE_STATUS_REFUNDING = 3;
    /**
     * 反向订单状态 44--换货中
     */
    public final static int RE_STATUS_EXCHANGEING = 4;
    /**
     * 反向订单状态 5--完成
     */
    public final static int RE_STATUS_COMPLETE = 5;
    /**
     * 反向订单状态 6--关单
     */
    public final static int RE_STATUS_CLOSE = 6;

    /**
     * 反向订单状态 10--撤单已申请
     */
    public final static int RE_STATUS_REVAPPLY = 10;
    /**
     * 反向订单状态 11--撤单已审核
     */
    public final static int RE_STATUS_REVAUDIT = 11;
    /**
     * 反向订单状态 12--撤单已驳回
     */
    public final static int RE_STATUS_REVREFUSE = 12;


    /**
     * 反向订单状态 20--退货已申请
     */
    public final static int RE_STATUS_RETAPPLY = 20;
    /**
     * 反向订单状态 21--退货已审核
     */
    public final static int RE_STATUS_RETAUDIT = 21;
    /**
     * 反向订单状态 22--退货已驳回
     */
    public final static int RE_STATUS_RETREFUSE = 22;


    /**
     * 反向订单状态 30--换货已申请
     */
    public final static int RE_STATUS_EXCHAPPLY = 30;
    /**
     * 反向订单状态 31--换货已审核
     */
    public final static int RE_STATUS_EXCAUDIT = 31;
    /**
     * 反向订单状态 32--换货已驳回
     */
    public final static int RE_STATUS_EXCREFUSE = 32;


    /**
     * 反向支付状态-1:已支付
     */
    public static final int RE_PAY_STATUS_COMP = 1;
    /**
     * 反向支付状态-2:退款中
     */
    public static final int RE_PAY_STATUS_REFUND = 2;
    /**
     * 反向支付状态- 3:已退款
     */
    public static final int RE_PAY_STATUS_REFUND_COMP  = 3;

    /**
     * 反向订单关单 - 6 关单
     */
    public static final int AUDIT_STATUS_CLOSE = 6;

    /**
     * 反向、退款类型
     */
    public static final String TYPE_REVERSE = "reverse";
    public static final String TYPE_REFUND = "refund";
    public static final String TYPE_REAUDIT= "reAudit";

    /**
     * 反向退货方式
     */
    public static final int REVERSE_WAY_ALL = 0;
    public static final int REVERSE_WAY_PARY = 1;

    private long id;

    private long orderId;//订单号

    private String reason;//退换货原因

    private long stockReturnId;  //库存反向id

    private String category;//退换货分类 原因分类

    private String description;//退换货原因文字描述

    private Money amount;//退款小计

    private Money refundManual;//手工返款

    private Money personalizationAmount;//私人订制价格

    //客户换货原因
    private String csRedescription;


    private boolean complete;//包装是否齐全0:否 1:是

    private int type;//1--撤单,2--退货,3--换货

    private int auditStatus;//审批状态:0--待审批,1--审批通过,2--审批驳回,3--已作废,4废单申请，5 废单审核通过 6废单驳回

    private String goodsCodes;//商品编号多个以”,”分割

    private String goodsNames;//商品名称多个以”,”分割

    private String sns;//SN多个以”,”分割

    private String refuseReason;//驳回理由,审批驳回的时候必填

    private String rApplyK;//供应链K码, 仅btcp使用

    private String serviceMode;//服务方式,ZX16、ZX17 ””,仅btcp使用

    private boolean throwing;//是否抛单 0:否 1:是

    private String outId;//第三方订单号BtcpR号

    private String remark;//备注

    private int version;

    private String reLogisticsNo;

    private String reCompanyName;

    private String reCompanyCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

    private String updateBy;

    private String returnAddress;

    private boolean needReturnStock;

    private int outStatus;  //退货时btcp推送的工厂收货通知.0--符合退款;1--不符合;2--关单


    private Money transportFee;   //垫付金额

    private int preOrderStatus;//之前的订单状态

    private boolean needExpress;

    private int reStatus; //反向状态

    private int rePayStatus;//反向支付状态

    private Integer shopId;

    private Main main;

    private ReverseDeliveryAddress deliveryAddress;

    private List<ReverseItem> items;//退换货item列表

    private Refund refund;

    private Reverselogistics reverselogistics;

    private Tenant tenant; //租户对象

    private List<String> fileUrl;//文件地址路径

    private Money freight;//运费

    private Money virtualCoin;//虚拟币数量

    private String virtualCoinTradeNo;//虚拟币流水号

    private Integer virtualCoinType;//虚拟币类型1 消费点 2 乐豆

    private Integer reverseWay;//反向订单退货方式： 0：整单退  1：部分退

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime ;

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getReverseWay() {
        return reverseWay;
    }

    public void setReverseWay(Integer reverseWay) {
        this.reverseWay = reverseWay;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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

    public boolean isNeedExpress() {
        return needExpress;
    }

    public void setNeedExpress(boolean needExpress) {
        this.needExpress = needExpress;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getGoodsCodes() {
        return goodsCodes;
    }

    public void setGoodsCodes(String goodsCodes) {
        this.goodsCodes = goodsCodes;
    }

    public String getGoodsNames() {
        return goodsNames;
    }

    public void setGoodsNames(String goodsNames) {
        this.goodsNames = goodsNames;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getrApplyK() {
        return rApplyK;
    }

    public void setrApplyK(String rApplyK) {
        this.rApplyK = rApplyK;
    }

    public String getServiceMode() {
        return serviceMode;
    }

    public void setServiceMode(String serviceMode) {
        this.serviceMode = serviceMode;
    }

    public boolean isThrowing() {
        return throwing;
    }

    public void setThrowing(boolean throwing) {
        this.throwing = throwing;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(int outStatus) {
        this.outStatus = outStatus;
    }

    public Money getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(Money transportFee) {
        this.transportFee = transportFee;
    }

    public Main getMain() {
        if (main == null) {
            main = new Main();
        }
        return main;
    }

    public List<String> getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(List<String> fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getReLogisticsNo() {
        return reLogisticsNo;
    }

    public void setReLogisticsNo(String reLogisticsNo) {
        this.reLogisticsNo = reLogisticsNo;
    }

    public String getReCompanyName() {
        return reCompanyName;
    }

    public void setReCompanyName(String reCompanyName) {
        this.reCompanyName = reCompanyName;
    }

    public String getReCompanyCode() {
        return reCompanyCode;
    }

    public void setReCompanyCode(String reCompanyCode) {
        this.reCompanyCode = reCompanyCode;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ReverseDeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(ReverseDeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<ReverseItem> getItems() {
        return items;
    }

    public void setItems(List<ReverseItem> items) {
        this.items = items;
    }

    public Reverse(Main main) {
        this.main = main;
    }

    public Refund getRefund() {
        if (refund == null) {
            refund = new Refund();
        }
        return refund;
    }

    public void setRefund(Refund refund) {
        this.refund = refund;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public Reverse() {
    }

    public int getPreOrderStatus() {
        return preOrderStatus;
    }

    public void setPreOrderStatus(int preOrderStatus) {
        this.preOrderStatus = preOrderStatus;
    }

    public boolean isNeedReturnStock() {
        return needReturnStock;
    }

    public void setNeedReturnStock(boolean needReturnStock) {
        this.needReturnStock = needReturnStock;
    }


    public Reverselogistics getReverselogistics() {
        return reverselogistics;
    }

    public void setReverselogistics(Reverselogistics reverselogistics) {
        this.reverselogistics = reverselogistics;
    }

    public int getRePayStatus() {
        return rePayStatus;
    }

    public void setRePayStatus(int rePayStatus) {
        this.rePayStatus = rePayStatus;
    }

    public int getReStatus() {
        return reStatus;
    }

    public void setReStatus(int reStatus) {
        this.reStatus = reStatus;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void genRApplyK() {
        if (rApplyKPrefixMap.get(main.getSource()) != null) {
            this.rApplyK = rApplyKPrefixMap.get(main.getSource()) + main.getId() + new DateTime().toString("MMdd") + new Random(System.currentTimeMillis()).nextInt(9999);
        } else {
            LOGGER.info("没有获取到订单来源：" + main.getSource());
            rApplyK = "9999";
        }
    }

    /**
     * 判断该订单是否可以撤单
     */
//    public RemoteResult isApplyRevoke(RemoteResult remoteResult) {
//        if (Main.ADD_TYPE_OTO == type) {
//            remoteResult.setResultMsg("订单类型为OTO , 不允许做撤单");
//            remoteResult.setSuccess(false);
//            return remoteResult;
//        } else if (Main.FA_TYPE_RESELLERS == main.getFaType()) {
//            return remoteResult;
//        } else if ((Main.FA_TYPE_DIRECT == main.getFaType() || Main.FA_TYPE_DONGDE == main.getFaType() || Main.FA_TYPE_THINK_DIRECT == main.getFaType() || Main.FA_TYPE_MBG == main.getFaType() || Main.FA_TYPE_THINK_RESELLERS == main.getFaType()) && Main.STATUS_UN_SHIPPED == main.getStatus()) {
//            return remoteResult;
//        } else {//fa=1；fa(0,2,3,4)且未发货。这两种情况允许撤单
//            remoteResult.setResultMsg("FATYPE为1或者为(0,2,3,4)且未发货。这两种情况允许撤单");
//            remoteResult.setSuccess(false);
//            return remoteResult;
//        }
//    }



    /**
     * 校验退货申请入参
     *
     * @return
     */
    public RemoteResult validateApplyReturn() {
        RemoteResult remoteResult = new RemoteResult();
        if (StringUtils.isEmpty(this.reason)) {
            remoteResult.setResultCode("1007");
            remoteResult.setResultMsg("退货原因不能为空");
        } else if(StringUtils.isEmpty(this.category)){
            remoteResult.setResultCode("1008");
            remoteResult.setResultMsg("退货分类不能为空");
        }else {
            remoteResult.setSuccess(true);
            remoteResult.setResultCode("1000");
        }
        return remoteResult;
    }

    @Override
    public String toString() {
        return "Reverse{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", reason='" + reason + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", type=" + type +
                ", auditStatus=" + auditStatus +
                ", goodsCodes='" + goodsCodes + '\'' +
                ", goodsNames='" + goodsNames + '\'' +
                ", sns='" + sns + '\'' +
                ", refuseReason='" + refuseReason + '\'' +
                ", rApplyK='" + rApplyK + '\'' +
                ", serviceMode='" + serviceMode + '\'' +
                ", throwing=" + throwing +
                ", outId='" + outId + '\'' +
                ", remark='" + remark + '\'' +
                ", version=" + version +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                ", reStatus='" + reStatus + '\'' +
                ", rePayStatus='" + rePayStatus + '\'' +
                ", returnAddress='" + returnAddress + '\'' +
                ", transportFee='" + transportFee + '\'' +
                ", returnAddress='" + +'\'' +
                ", main=" + main +
                ", deliveryAddress=" + deliveryAddress +
                ", items=" + items +
                ", refund=" + refund +
                '}';
    }

    public long getStockReturnId() {
        return stockReturnId;
    }

    public void setStockReturnId(long stockReturnId) {
        this.stockReturnId = stockReturnId;
    }

    public String getCsRedescription() {
        return csRedescription;
    }

    public void setCsRedescription(String csRedescription) {
        this.csRedescription = csRedescription;
    }
}
