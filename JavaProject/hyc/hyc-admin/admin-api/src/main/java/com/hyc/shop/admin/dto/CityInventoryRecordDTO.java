package com.hyc.shop.admin.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 城市下对应仓库库存变更记录
 * Created by huangtao on 2017-09-30
 */
public class CityInventoryRecordDTO implements Serializable {

	/**
	 * 仓库ID
	 */
	private Integer warehouseId;
	/**
	 * 城市id
	 */
	private Integer cityId;

	/**
	 * 事件类型
	 */
	private Integer jiupiEventType;
	/**
	 * 事件类型
	 */
	private Integer erpEventType;
	/**
	 * 单据类型
	 */
	private Integer orderType;

	/**
	 * 记录id
	 */
	private String orderId;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 明细描述
	 */
	private String des;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 变更数量（小单位）
	 */
	private Integer changeCount;

	/**
	 * 原数量（小单位）
	 */
	private Integer sourceCount;

	/**
	 * 新数量（小单位）
	 */
	private Integer newCount;
	/**
	 * 大单位名称
	 */
	private String packageName;
	/**
	 * 小单位名称
	 */
	private String unitName;
	/**
	 * 转换系数
	 */
	private Integer quantity;

	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 仓库类型 InventoryChangeTypes
	 */
	private Integer storeType;

	/**
	 * 库存渠道（0：酒批，1：大宗产品）
	 */
	private String channel;

	public String getOrderId() {
		return orderId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * 获取 仓库ID
	 *
	 * @return warehouseId 仓库ID
	 */
	public Integer getWarehouseId() {
		return this.warehouseId;
	}

	/**
	 * 设置 仓库ID
	 *
	 * @param warehouseId 仓库ID
	 */
	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * 获取 城市id
	 *
	 * @return cityId 城市id
	 */
	public Integer getCityId() {
		return this.cityId;
	}

	/**
	 * 设置 城市id
	 *
	 * @param cityId 城市id
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * 获取 事件类型
	 *
	 * @return jiupiEventType 事件类型
	 */
	public Integer getJiupiEventType() {
		return this.jiupiEventType;
	}

	/**
	 * 设置 事件类型
	 *
	 * @param jiupiEventType 事件类型
	 */
	public void setJiupiEventType(Integer jiupiEventType) {
		this.jiupiEventType = jiupiEventType;
	}

	/**
	 * 获取 事件类型
	 *
	 * @return erpEventType 事件类型
	 */
	public Integer getErpEventType() {
		return this.erpEventType;
	}

	/**
	 * 设置 事件类型
	 *
	 * @param erpEventType 事件类型
	 */
	public void setErpEventType(Integer erpEventType) {
		this.erpEventType = erpEventType;
	}

	/**
	 * 获取 单据类型
	 *
	 * @return orderType 单据类型
	 */
	public Integer getOrderType() {
		return this.orderType;
	}

	/**
	 * 设置 单据类型
	 *
	 * @param orderType 单据类型
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	/**
	 * 设置 订单 id
	 *
	 * @param orderId 订单
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取 订单号
	 *
	 * @return orderNo 订单号
	 */
	public String getOrderNo() {
		return this.orderNo;
	}

	/**
	 * 设置 订单号
	 *
	 * @param orderNo 订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * 获取 明细描述
	 *
	 * @return des 明细描述
	 */
	public String getDes() {
		return this.des;
	}

	/**
	 * 设置 明细描述
	 *
	 * @param des 明细描述
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * 获取 创建时间
	 *
	 * @return createTime 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 设置 创建时间
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取 变更数量（小单位）
	 *
	 * @return changeCount 变更数量（小单位）
	 */
	public Integer getChangeCount() {
		return this.changeCount;
	}

	/**
	 * 设置 变更数量（小单位）
	 *
	 * @param changeCount 变更数量（小单位）
	 */
	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}

	/**
	 * 获取 原数量（小单位）
	 *
	 * @return sourceCount 原数量（小单位）
	 */
	public Integer getSourceCount() {
		return this.sourceCount;
	}

	/**
	 * 设置 原数量（小单位）
	 *
	 * @param sourceCount 原数量（小单位）
	 */
	public void setSourceCount(Integer sourceCount) {
		this.sourceCount = sourceCount;
	}

	/**
	 * 获取 新数量（小单位）
	 *
	 * @return newCount 新数量（小单位）
	 */
	public Integer getNewCount() {
		return this.newCount;
	}

	/**
	 * 设置 新数量（小单位）
	 *
	 * @param newCount 新数量（小单位）
	 */
	public void setNewCount(Integer newCount) {
		this.newCount = newCount;
	}

	/**
	 * 获取 大单位名称
	 *
	 * @return packageName 大单位名称
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 设置 大单位名称
	 *
	 * @param packageName 大单位名称
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * 获取 小单位名称
	 *
	 * @return unitName 小单位名称
	 */
	public String getUnitName() {
		return this.unitName;
	}

	/**
	 * 设置 小单位名称
	 *
	 * @param unitName 小单位名称
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * 获取 转换系数
	 *
	 * @return quantity 转换系数
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * 设置 转换系数
	 *
	 * @param quantity 转换系数
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获取 创建人
	 *
	 * @return createUser 创建人
	 */
	public String getCreateUser() {
		return this.createUser;
	}

	/**
	 * 设置 创建人
	 *
	 * @param createUser 创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取 仓库类型 InventoryChangeTypes
	 *
	 * @return storeType 仓库类型 InventoryChangeTypes
	 */
	public Integer getStoreType() {
		return this.storeType;
	}

	/**
	 * 设置 仓库类型 InventoryChangeTypes
	 *
	 * @param storeType 仓库类型 InventoryChangeTypes
	 */
	public void setStoreType(Integer storeType) {
		this.storeType = storeType;
	}
}
