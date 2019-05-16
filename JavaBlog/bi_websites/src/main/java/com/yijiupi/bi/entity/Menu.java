package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


public class Menu extends Model<Menu> {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@TableId(type = IdType.UUID)
	private String id;
	
	/**
	 * 菜单文本
	 */
	@TableField("text")
	private String text;
	
	/**
	 * 菜单css
	 */
	@TableField("iconCls")
	private String iconCls;
	
	/**
	 * 菜单地址
	 */
	@TableField("url")
	private String url;
	
	/**
	 * 父菜单主键（外键到菜单表主键）
	 */
	@TableField("parentId")
	private String parentId;
	
	/**
	 * 菜单位置，用于进行菜单排序
	 */
	@TableField("position")
	private Integer position;
	
	@TableField("urlType")
	private Integer urlType;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getIconCls() {
		return iconCls;
	}
	
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Integer getUrlType() {
		return urlType;
	}
	
	public void setUrlType(Integer urlType) {
		this.urlType = urlType;
	}
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Menu{" +
				"id='" + id + '\'' +
				", text='" + text + '\'' +
				", iconCls='" + iconCls + '\'' +
				", url='" + url + '\'' +
				", parentId='" + parentId + '\'' +
				", position=" + position +
				", urlType=" + urlType +
				'}';
	}
}
