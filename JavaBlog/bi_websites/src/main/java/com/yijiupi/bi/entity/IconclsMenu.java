package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("iconcls_menu")
public class IconclsMenu {
    private Long id;

    @TableField("entryid")
    private Long entryid;

    @TableField("menuType")
    private Integer menuType;

    @TableField("iconclsid")
    private Long iconclsid;

    @TableField("updateUser")
    private String updateUser;

    @TableField("updateTime")
    private Date updateTime;

    public IconclsMenu(Long entryid, Integer menuType, Long iconclsid, String updateUser, Date updateTime) {
        this.entryid = entryid;
        this.iconclsid = iconclsid;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.menuType = menuType;
    }

    public IconclsMenu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
    }

    public Long getIconclsid() {
        return iconclsid;
    }

    public void setIconclsid(Long iconclsid) {
        this.iconclsid = iconclsid;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}