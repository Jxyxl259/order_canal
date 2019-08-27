package com.lenovo.m2.oc.canal.domain.esdoc;

import java.io.Serializable;

/**
 * @description: 订单关联的商品信息(简 : 只包含订单报表列表中的查询条件)
 * @author: jiangxy9
 * @create: 2019-08-27 19:59
 */
public class ItemES implements Serializable {

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 产品组
     */
    private String deatLike;

    /**
     * 物料编码
     */
    private String materialCode;

    public ItemES() {
    }

    public ItemES(String goodsName, String deatLike, String materialCode) {
        this.goodsName = goodsName;
        this.deatLike = deatLike;
        this.materialCode = materialCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getDeatLike() {
        return deatLike;
    }

    public void setDeatLike(String deatLike) {
        this.deatLike = deatLike;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    @Override
    public String toString() {
        return "ItemES{" +
                "goodsName='" + goodsName + '\'' +
                ", deatLike='" + deatLike + '\'' +
                ", materialCode='" + materialCode + '\'' +
                '}';
    }
}
