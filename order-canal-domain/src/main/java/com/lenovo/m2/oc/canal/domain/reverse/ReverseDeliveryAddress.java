package com.lenovo.m2.oc.canal.domain.reverse;

import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;
import com.lenovo.m2.oc.canal.domain.ordercenter.DeliveryAddress;

import java.io.Serializable;
import java.util.Date;

public class ReverseDeliveryAddress implements Serializable {

    private long reverseId;
    private String deliverNo;
    private String pickName;//取货方姓名
    private String pickAddress;//取货方详细地址
    private String pickZip;//取货方邮编
    private String pickMobile;//取货方手机号
    private String pickPhone;//取货方固定电话
    private String pickEmail;//取货方邮箱
    private String pickProvince;//取货方省名称
    private String pickCity;//取货方市名称
    private String pickCounty;//取货方区/县名称
    private String pickArea;//取货方乡镇/街道名称
    private String pickProvinceId;
    private String pickCityId;
    private String pickCountyId;
    private String pickAreaId;
    private String shipName;
    private String shipAddress;
    private String shipZip;
    private String shipMobile;
    private String shipPhone;
    private String shipEmail;
    private String shipProvince;
    private String shipCity;
    private String shipCounty;
    private String shipArea;
    private String shipProvinceId;
    private String shipCityId;
    private String shipCountyId;
    private String shipAreaId;
    private Money freightCharge;
    private Money insuranceFee;
    private Date createTime;
    private Date updateTime;
    private String updateBy;
    private int version;
    private Tenant tenant; //租户对象

    public long getReverseId() {
        return reverseId;
    }

    public void setReverseId(long reverseId) {
        this.reverseId = reverseId;
    }

    public String getDeliverNo() {
        return deliverNo;
    }

    public void setDeliverNo(String deliverNo) {
        this.deliverNo = deliverNo;
    }

    public String getPickName() {
        return pickName;
    }

    public void setPickName(String pickName) {
        this.pickName = pickName;
    }

    public String getPickAddress() {
        return pickAddress;
    }

    public void setPickAddress(String pickAddress) {
        this.pickAddress = pickAddress;
    }

    public String getPickZip() {
        return pickZip;
    }

    public void setPickZip(String pickZip) {
        this.pickZip = pickZip;
    }

    public String getPickMobile() {
        return pickMobile;
    }

    public void setPickMobile(String pickMobile) {
        this.pickMobile = pickMobile;
    }

    public String getPickPhone() {
        return pickPhone;
    }

    public void setPickPhone(String pickPhone) {
        this.pickPhone = pickPhone;
    }

    public String getPickEmail() {
        return pickEmail;
    }

    public void setPickEmail(String pickEmail) {
        this.pickEmail = pickEmail;
    }

    public String getPickProvince() {
        return pickProvince;
    }

    public void setPickProvince(String pickProvince) {
        this.pickProvince = pickProvince;
    }

    public String getPickCity() {
        return pickCity;
    }

    public void setPickCity(String pickCity) {
        this.pickCity = pickCity;
    }

    public String getPickCounty() {
        return pickCounty;
    }

    public void setPickCounty(String pickCounty) {
        this.pickCounty = pickCounty;
    }

    public String getPickArea() {
        return pickArea;
    }

    public void setPickArea(String pickArea) {
        this.pickArea = pickArea;
    }

    public String getPickProvinceId() {
        return pickProvinceId;
    }

    public void setPickProvinceId(String pickProvinceId) {
        this.pickProvinceId = pickProvinceId;
    }

    public String getPickCityId() {
        return pickCityId;
    }

    public void setPickCityId(String pickCityId) {
        this.pickCityId = pickCityId;
    }

    public String getPickCountyId() {
        return pickCountyId;
    }

    public void setPickCountyId(String pickCountyId) {
        this.pickCountyId = pickCountyId;
    }

    public String getPickAreaId() {
        return pickAreaId;
    }

    public void setPickAreaId(String pickAreaId) {
        this.pickAreaId = pickAreaId;
    }

    public Money getFreightCharge() {
        return freightCharge;
    }

    public void setFreightCharge(Money freightCharge) {
        this.freightCharge = freightCharge;
    }

    public Money getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Money insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }


    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipMobile() {
        return shipMobile;
    }

    public void setShipMobile(String shipMobile) {
        this.shipMobile = shipMobile;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public String getShipProvince() {
        return shipProvince;
    }

    public void setShipProvince(String shipProvince) {
        this.shipProvince = shipProvince;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipCounty() {
        return shipCounty;
    }

    public void setShipCounty(String shipCounty) {
        this.shipCounty = shipCounty;
    }

    public String getShipArea() {
        return shipArea;
    }

    public void setShipArea(String shipArea) {
        this.shipArea = shipArea;
    }

    public String getShipProvinceId() {
        return shipProvinceId;
    }

    public void setShipProvinceId(String shipProvinceId) {
        this.shipProvinceId = shipProvinceId;
    }

    public String getShipCityId() {
        return shipCityId;
    }

    public void setShipCityId(String shipCityId) {
        this.shipCityId = shipCityId;
    }

    public String getShipCountyId() {
        return shipCountyId;
    }

    public void setShipCountyId(String shipCountyId) {
        this.shipCountyId = shipCountyId;
    }

    public String getShipAreaId() {
        return shipAreaId;
    }

    public void setShipAreaId(String shipAreaId) {
        this.shipAreaId = shipAreaId;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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



    public DeliveryAddress genDeliveryAddress() {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setName(this.shipName);
        deliveryAddress.setMobile(this.shipMobile);
        deliveryAddress.setAddress(this.shipAddress);
        deliveryAddress.setProvinceId(this.shipProvinceId);
        deliveryAddress.setCity(this.shipCity);
        deliveryAddress.setCounty(this.shipCounty);
        deliveryAddress.setType(DeliveryAddress.TYPE_GOODS);
        deliveryAddress.setProvince(this.shipProvince);
        deliveryAddress.setArea(this.shipArea);
        return deliveryAddress;
    }
}