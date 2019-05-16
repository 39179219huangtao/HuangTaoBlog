/**
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.bi.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 酒批城市模型
 * Create by 魏百川 on 2017/3/10
 */
public class JiupiCity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 酒批城市id（cityId）
     */
    private Integer id;

    /**
     * 酒批城市名称
     * 和city字段不一定一样
     */
    private String name;

    /**
     * 酒批城市所在行政区分的省
     * 现在酒批城市只有两级
     */
    private String province;

    /**
     * 酒批城市所在行政区分的市
     * 现在酒批城市只有两级
     */
    private String city;

    /**
     * 1.0还是2.0城市
     *
     * @deprecated removed
     */
    @Deprecated
    private CityType cityType;

    /**
     * 所属大区
     *
     * @See regionList
     */
    @Deprecated
    private Region region;

    /**
     * 所属大区
     */
    private List<Region> regionList;

    /**
     * 运营模式
     *
     * @deprecated replaced by cityModeValue
     */
    @Deprecated
    private CityMode cityMode;

    /**
     * 运营模式 {@link com.yijiupi.bi.dto.CityMode}
     */
    private Integer cityModeValue;

    /**
     * 城市级别 查字典CityLevel
     */
    private Integer cityLevelNum;

    /**
     * 组织机构类型
     */
    private OrgType orgType;

    /**
     * 启用状态
     *
     * @deprecated replaced by enableState
     */
    @Deprecated
    private EnableState state;

    /**
     * 启用状态 {@link com.yijiupi.bi.dto.EnableState}
     */
    private Integer enableState;

    /**
     * 城市设置(大字段)
     */
    private CitySetting citySetting;

    /**
     * 城市电话
     */
    private String telephone;

    /**
     * 运营公司名称
     */
    private String operatorName;

    /**
     * 是否支持自提业务
     */
    private Boolean selfPickup;

    /**
     * 酒批城市的全称（由province+Name组成）
     */
    private String jiupiCityFullName;
    /**
     * 是否开通兑奖申请
     */
    private Boolean openPrizeChangeApply;
    /**
     * 起送金额
     */
    private BigDecimal deliveryCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /**
     * @return
     * @deprecated removed
     */
    @Deprecated
    public CityType getCityType() {
        return cityType;
    }

    /**
     * @param cityType
     * @deprecated removed
     */
    @Deprecated
    public void setCityType(CityType cityType) {
        this.cityType = cityType;
    }

    @Deprecated
    public Region getRegion() {
        return region;
    }

    @Deprecated
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * @return
     * @deprecated replaced by cityModeValue
     */
    @Deprecated
    public CityMode getCityMode() {
        return cityMode;
    }

    /**
     * @param cityMode
     * @deprecated replaced by cityModeValue
     */
    @Deprecated
    public void setCityMode(CityMode cityMode) {
        this.cityMode = cityMode;
    }

    public OrgType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrgType orgType) {
        this.orgType = orgType;
    }

    /**
     * @return
     * @deprecated replaced by enableState
     */
    @Deprecated
    public EnableState getState() {
        return state;
    }

    /**
     * @param state
     * @deprecated replaced by enableState
     */
    @Deprecated
    public void setState(EnableState state) {
        this.state = state;
    }

    public CitySetting getCitySetting() {
        return citySetting;
    }

    public void setCitySetting(CitySetting citySetting) {
        this.citySetting = citySetting;
    }

    public Integer getCityLevelNum() {
        return cityLevelNum;
    }

    public void setCityLevelNum(Integer cityLevelNum) {
        this.cityLevelNum = cityLevelNum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Boolean getSelfPickup() {
        return selfPickup;
    }

    public void setSelfPickup(Boolean selfPickup) {
        this.selfPickup = selfPickup;
    }

    public String getJiupiCityFullName() {
        return jiupiCityFullName;
    }

    public void setJiupiCityFullName(String jiupiCityFullName) {
        this.jiupiCityFullName = jiupiCityFullName;
    }

    /**
     * @return 运营模式
     */
    public Integer getCityModeValue() {
        return cityModeValue;
    }

    /**
     * @param cityModeValue
     */
    public void setCityModeValue(Integer cityModeValue) {
        this.cityModeValue = cityModeValue;
    }

    /**
     * @return 启用状态
     */
    public Integer getEnableState() {
        return enableState;
    }

    /**
     * @param enableState 启用状态
     */
    public void setEnableState(Integer enableState) {
        this.enableState = enableState;
    }

    /**
     * 获取 是否开通兑奖申请
     *
     * @return openPrizeChangeApply 是否开通兑奖申请
     */
    public Boolean getOpenPrizeChangeApply() {
        return this.openPrizeChangeApply;
    }

    /**
     * 设置 是否开通兑奖申请
     *
     * @param openPrizeChangeApply 是否开通兑奖申请
     */
    public void setOpenPrizeChangeApply(Boolean openPrizeChangeApply) {
        this.openPrizeChangeApply = openPrizeChangeApply;
    }

    /**
     * 获取 所属大区
     *
     * @return regionList 所属大区
     */
    public List<Region> getRegionList() {
        return this.regionList;
    }

    /**
     * 设置 所属大区
     *
     * @param regionList 所属大区
     */
    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    /**
     * 获取 起送金额
     *
     * @return deliveryCost 起送金额
     */
    public BigDecimal getDeliveryCost() {
        return this.deliveryCost;
    }

    /**
     * 设置 起送金额
     *
     * @param deliveryCost 起送金额
     */
    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}
