package com.yijiupi.bi.dto;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.dto
 * @Description:
 * @date 2018/7/24  14:28
 */
public class UserQueryDTO implements Serializable {
    private Integer businessType;
    private String city;
    private Integer cityId;
    private String county;
    private Integer employeeType;
    private Date hiredate;
    private Integer id;
    private String mobileNo;
    private String nickname;
    private String province;
    private String roleType;
    private Integer state;
    private String trueName;
    private String userName;
    private Integer currentPage;
    private Integer pageSize;

    private Map<String, Object> translateMap;

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> translateToMap(){
        if(translateMap == null)
            translateMap = new HashMap<>();
        if(businessType != null)
            translateMap.put("businessType",businessType);
        if(city != null)
            translateMap.put("city",city);
        if(cityId != null)
            translateMap.put("cityId",cityId);
        if(county != null)
            translateMap.put("county",county);
        if(employeeType != null)
            translateMap.put("employeeType",employeeType);
        if(hiredate != null)
            translateMap.put("hiredate",hiredate);
        if(id != null)
            translateMap.put("id",id);
        if(mobileNo != null)
            translateMap.put("mobileNo",mobileNo);
        if(nickname != null)
            translateMap.put("nickname",nickname);
        if(province != null)
            translateMap.put("province",province);
        if(roleType != null)
            translateMap.put("roleType",roleType);
        if(state != null)
            translateMap.put("state",state);
        if(trueName != null)
            translateMap.put("trueName",trueName);
        if(userName != null)
            translateMap.put("userName",userName);
        if(currentPage != null)
            translateMap.put("currentPage",currentPage);
        if(pageSize != null)
            translateMap.put("pageSize",pageSize);
        return translateMap;
    }
}
