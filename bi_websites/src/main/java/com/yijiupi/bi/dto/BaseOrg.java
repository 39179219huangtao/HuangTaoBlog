package com.yijiupi.bi.dto;


import java.io.Serializable;

/*********************************************
 * ClassName: BaseOrg
 * @Description: 组织机构的基类
 * @author 王新 Date 2016年2月3日
 *********************************************/
public class BaseOrg implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2602540515188342794L;
	private Integer id;
	/**
	 * 组织机构名称
	 */
	private String name;
	/**
	 * 组织机构类型=总部(1),城市(2),仓库(3),大区(4)
	 */
	private OrgType orgType;
	/**
	 * 启用状态
	 */
	private EnableState state;
	/**
	 * 酒批城市全名
	 */
	private String jiupiCityFullName;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县
	 * @deprecated removed
	 */
	@Deprecated
	private String county;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrgType getOrgType() {
		return orgType;
	}

	public void setOrgType(OrgType orgType) {
		this.orgType = orgType;
	}

	public EnableState getState() {
		return state;
	}

	public void setState(EnableState state) {
		this.state = state;
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
	 * @deprecated removed
	 */
	@Deprecated
	public String getCounty() {
		return county;
	}

	/**
	 * @deprecated removed
	 */
	@Deprecated
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the jiupiCityFullName
	 */
	public String getJiupiCityFullName() {
		return jiupiCityFullName;
	}

	/**
	 * @param jiupiCityFullName the jiupiCityFullName to set
	 */
	public void setJiupiCityFullName(String jiupiCityFullName) {
		this.jiupiCityFullName = jiupiCityFullName;
	}
}
