package com.lenovo.m2.oc.canal.common.utils;

/**
 * Created by jh on 2017/1/16.
 */
public class OrderConstant {

    public final static String RESULT_COD_SUCCESS = "1000";
    public final static String RESULT_MSG_SUCCESS = "操作成功";

    public final static String RESULT_COD_FAIL = "1001";
    public final static String RESULT_MSG_FAIL = "操作失败";

    public final static String PARAM_COD_ERROR = "1002";
    public final static String PARAM_MSG_ERROR = "传入参数错误";

    public final static String RESULT_COD_TEMP = "1003";
    public final static String RESULT_MSG_TEMP = "未查询到数据！";

    public final static String BTCP_CODE_ERROR = "1004";
    public final static String BTCP_MSG_ERROR = "调用BTCP接口异常";

    public final static String SHOP_CODE_ERROR = "100401";
    public final static String SHOP_MSG_ERROR = "调用中间件接口异常";

    public final static String PARAM_SYS_COD_ERROR = "1005";
    public final static String PARAM_SYS_MSG_ERROR = "系统参数错误";

    public final static String PARAM_AUTH_COD_ERROR = "1006";
    public final static String PARAM_AUTH_MSG_ERROR = "权限参数错误";

    public final static String JSON_MAP_COD_EXCEPTION = "1007";//json转map异常
    public final static String JSON_MAP_MSG_EXCEPTION = "json转map异常";


    public final static String ORDER_COD_EXCEPTION = "1008";//订单异常
    public final static String ORDER_MSG_EXCEPTION = "订单异常";//

    public final static String PARAM_TENANT_COD_ERROR = "1009";
    public final static String PARAM_TENANT_MSG_ERROR = "租户参数错误";


    public static final String ORDER_TYPE_NORMAL = "ZOR";
    public static final int ORDER_DELIVER_SHIPPED = 1;

    // Main -支付类型
    public static final int PAY_STATUS_ONLINE = 0;//在线支付
    public static final int PAY_STATUS_REVIVE = 1;//货到付款
    public static final int PAY_STATUS_LINE = 2;//线下打款

    //Main -销售订单类型
    public static final int ADD_TYPE_NORMAL = 0;//普通
    public static final int ADD_TYPE_SEC_KILL = 1;//闪购

    public static final int ADD_TYPE_PRE_SELL = 2;//销售订单类型-预售

    public static final int ADD_TYPE_SALES_TRIAL = 3;//销售订单类型-先试后买

    public static final int ADD_TYPE_K_CODE = 4;//销售订单类型-K码商品

    public static final int ADD_TYPE_DESIGN = 5;//销售订单类型-定制

    public static final int ADD_TYPE_OLD_CHANGE_NEW = 6;//销售订单类型-以旧换新

    public static final int ADD_TYPE_C2C = 7;//销售订单类型-c2c

    public static final int ADD_TYPE_XCODE = 8;//销售订单类型-大侠码

    public static final int ADD_TYPE_CTO = 9;//销售订单类型-CTO

    public static final int ADD_TYPE_OTO = 10;//销售订单类型-OTO

    public static final int ADD_TYPE_RAISE = 11;//销售订单类型-众筹

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
    public static final int FA_TYPE_FA_DIRECT = 12;
    /**
     * FA类型-直营
     */
    public static final int FA_TYPE_DIRECT = 0;
    /**
     * FA类型-代理
     */
    public static final int FA_TYPE_RESELLERS = 1;
    /**
     * FA类型-MBG
     */
    public static final int FA_TYPE_MBG = 2;
    /**
     * FA类型-Think直营
     */
    public static final int FA_TYPE_THINK_DIRECT = 3;
    /**
     * FA类型-ThinkFA
     */
    public static final int FA_TYPE_THINK_RESELLERS = 4;
    /**
     * FA类型-懂的通信
     */
    public static final int FA_TYPE_DONGDE = 5;

    /**
     * FA类型-懂的充值
     */
    public static final int FA_TYPE_DONGDE_RECHARGE = 6;
    /**
     * 商户号-moto
     */
    public static final int SHOP_ID_MOTO = 5;
    /**
     * 商户号-moto
     */
    public static final int SHOP_ID_PCSD = 11;
    /**
     * 乐豆换算比率
     */
    public static final double MONEY_CONVERT_RATE = 0.01;

    //审核通过
    public static final int AUDIT_PASS = 1;
    //审核拒绝
    public static final int AUDIT_NOPASS = 2;

    /**
     * 已签收
     */
    public static final String MONGO_ORDER_DELIVER_SIGNED = "7";

    /**
     * 订单取消状态
     */
    public static final String MONGO_Order_STATUS_IS_CANCEL = "1";

    /**
     * 订单来源
     */
    public static final String ORDER_COME_FROM_C2C = "2";

}
