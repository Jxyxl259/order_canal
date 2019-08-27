package com.lenovo.m2.oc.canal.domain.ordercenter;

import com.lenovo.m2.arch.framework.domain.Money;
import com.lenovo.m2.arch.framework.domain.Tenant;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class DeliveryAddress implements Serializable {

    public static final int TYPE_GOODS = 0;
    public static final int TYPE_INVOICE = 1;
    public static final int TYPE_BILL = 3;

    private Long orderId;

    private Main main;

    private String deliverNo;

    private String name;

    private String address;

    private String zip;

    private String mobile;

    private String phone;

    private String email;

    private String province;

    private String city;

    private String county;

    private String area;

    private String provinceId;

    private String cityId;

    private String countyId;

    private String areaId;

    private Money freightCharge;

    private Money insuranceFee;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private String updateBy;

    private Integer version;

    private String proviceAbbreviation;//moto省份编码
    private String taxNo;//moto税号

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getProviceAbbreviation() {
        return proviceAbbreviation;
    }

    public void setProviceAbbreviation(String proviceAbbreviation) {
        this.proviceAbbreviation = proviceAbbreviation;
    }

    private Tenant tenant;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getDeliverNo() {
        return deliverNo;
    }

    public void setDeliverNo(String deliverNo) {
        this.deliverNo = deliverNo == null ? null : deliverNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getMobile() {
        return StringUtils.isNotBlank(this.mobile)?this.mobile:this.phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhone() {
        return StringUtils.isNotBlank(this.phone)?this.phone:this.mobile;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId == null ? null : countyId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public Money getFreightCharge() {
        return freightCharge;
    }


    public Money getInsuranceFee() {
        return insuranceFee;
    }

    public void setFreightCharge(Money freightCharge) {
        this.freightCharge = freightCharge;
    }

    public void setInsuranceFee(Money insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", area='" + area + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", type=" + type +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}