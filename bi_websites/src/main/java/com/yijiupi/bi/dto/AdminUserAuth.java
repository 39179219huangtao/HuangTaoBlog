package com.yijiupi.bi.dto;


import java.io.Serializable;
import java.util.Date;

/*********************************************
 * ClassName: AdminUserAuth
 * @Description: 酒批运营用户授权 1.添加授权时，如果选择的角色时是：“管理员”、“系统用户”，那么该角色不属于某城市； 如果选择的是：“城市管理员”，那么添加角色时，需要选择城市；
 *               如果选择的是：“销售人员”、“财务出纳”、“配送人员”，则该角色的所在城市，就等于他所在的城市。
 *               如果选择的是：“仓库管理员”，则该仓库所在的城市，就必须等于该用户所在的城市。 2.用户的角色不能被修改，只能移除角色，或者新增角色。
 * @author 王新 Date 2016年2月3日
 *********************************************/
public class AdminUserAuth implements Comparable<AdminUserAuth>, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2918545283345866846L;
	private Integer id;
	/**
	 * 用户Id
	 */
	private Integer user_Id;
	/**
	 * 角色对应的组织机构
	 */
	private BaseOrg org;
	/**
	 * 用户角色
	 */
	private AdminUserRoleType role;
	/**
	 * 角色对应的主管业务类型
	 */
	private Integer businessType;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建者Id
	 */
	private Integer createUserId;
	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;
	/**
	 * 修改人Id
	 */
	private Integer lastUpdateUserId;

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public AdminUserRoleType getRole() {
		return role;
	}

	public void setRole(AdminUserRoleType role) {
		this.role = role;
	}

	@Override
	public int compareTo(AdminUserAuth o) {
		return this.getCompareValue() < o.getCompareValue() ? -1 : (this.getCompareValue() == o.getCompareValue() ? 0 : 1);
	}

	private int getCompareValue() {
		return this.role.ordinal() + (this.role.isCanLoginOp() ? 0 : 100);
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 创建者Id
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return 最后更新时间
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return 修改人Id
	 */
	public Integer getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	/**
	 */
	public void setLastUpdateUserId(Integer lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	/**  
	 * 获取org  
	 * @return org org  
	 */  
	public BaseOrg getOrg() {
		return org;
	}

	/**  
	 * 设置org  
	 * @param org org  
	 */
	public void setOrg(BaseOrg org) {
		this.org = org;
	}
}
