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
 * @date 2018/7/4  14:47
 */
@TableName("enum_category")
public class EnumCategoryPO implements Serializable {


    private Integer id;
    @TableField("category_name")
    private String categoryName;
    @TableField("category_code")
    private String categoryCode;
    /**
     * 是够启用
     */
    @TableField("enum_category_enable")
    private Byte enumCategoryEnable;
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
    @TableField("dblink")
    private String DBlink;
    @TableField("enum_category_sql")
    private String enumCategorySql;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Byte getEnumCategoryEnable() {
        return enumCategoryEnable;
    }

    public void setEnumCategoryEnable(Byte enumCategoryEnable) {
        this.enumCategoryEnable = enumCategoryEnable;
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

    public String getDBlink() {
        return DBlink;
    }

    public void setDBlink(String DBlink) {
        this.DBlink = DBlink;
    }

    public String getEnumCategorySql() {
        return enumCategorySql;
    }

    public void setEnumCategorySql(String enumCategorySql) {
        this.enumCategorySql = enumCategorySql;
    }
}
