package com.yijiupi.bi.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*********************************************
 * ClassName: AdminUser
 * @Description: 酒批运营用户
 * @author
 *********************************************/
public class AdminUser implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1132234046933466553L;
	/**
	 * 主键编号
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 姓名
	 */
	private String trueName;
	/**
	 * 人员基础薪水
	 */
	private BigDecimal baseSalary;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机号
	 */
	private String mobileNo;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 */
	private Integer enableState;
	/**
	 * 用户所属城市，可以为null
	 */
	private Integer cityId;
	/**
	 * 用户最后登陆时间
	 */
	private Date lastLoginTime;
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
	/**
	 * 用户授权列表
	 */
	private List<AdminUserAuth> authList;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 入职时间
	 */
	private Date hiredate;
	/**
	 * 离职时间
	 */
	private Date leaveDate;
	/**
	 * 最后更改密码的时间
	 */
	private Date lastChangePasswordTime;
	/**
	 * 联系电话
	 */
	private String contactNumber;


	private EnableState state;
	/**
	 * 身份证信息
	 */
	private String idCard;

	public Date getLastChangePasswordTime() {
		return lastChangePasswordTime;
	}

	public void setLastChangePasswordTime(Date lastChangePasswordTime) {
		this.lastChangePasswordTime = lastChangePasswordTime;
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
	/**
	 * 人员类型
	 */
	private Integer employeeType;

	public BigDecimal getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(BigDecimal baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public List<AdminUserAuth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AdminUserAuth> authList) {
		this.authList = authList;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(Integer employeeType) {
		this.employeeType = employeeType;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

		public String toDisplayString() {
		return "姓名：" + trueName + "，手机号：" + mobileNo;
	}

	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof AdminUser)) {
			return false;
		}
		AdminUser adminUser = (AdminUser) o;
		return getId().equals(adminUser.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	/**
	 * @return 主键编号
	 */
	public Integer getId() {
		return id;
	}

	/**
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
	 */
	public Integer getEnableState() {
		return enableState;
	}

	/**
	 * @param enableState 用户状态
	 */
	public void setEnableState(Integer enableState) {
		this.enableState = enableState;
	}

	/**
	 * 获取idCard
	 * @return idCard idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置idCard
	 * @param idCard idCard
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}
