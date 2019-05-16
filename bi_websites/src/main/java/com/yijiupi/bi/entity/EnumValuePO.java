package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangtao
 * @Title: himalaya-bi-microservice-orgsettings
 * @Package com.yijiupi.himalaya.bi.orgsettings.domain.po
 * @Description:
 * @date 2018/7/4  14:52
 */
@TableName("enum_value")
public class EnumValuePO implements Serializable {

    private Integer id;
    @TableField("category_id")
    private Integer categoryID;
    @TableField("category_name")
    private String categoryName;

    @TableField("enum_text")
    private String enumText;
    @TableField("enum_value")
    private String enumValue;
    /**
     * 是否系统菜单
     */
    @TableField("is_system")
    private Byte isSystem;
    @TableField("create_time")
    private Date createTime;
    @TableField("create_user")
    private String createUser;
    @TableField("last_update_time")
    private Date lastUpdateTime;
    @TableField("last_update_user")
    private String lastUpdateUser;
    /**
     * 是否删除 0未删除 1删除
     */
    @TableField("is_delete")
    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getEnumText() {
        return enumText;
    }

    public void setEnumText(String enumText) {
        this.enumText = enumText;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    public Byte getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Byte isSystem) {
        this.isSystem = isSystem;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
