package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Description:
 * Author: lichanghong
 * Date: 2018-07-25
 */
@TableName("fr_t_customrole")
public class FrRole implements Serializable {
    private static final long serialVersionUID = -813134834196618691L;
    private Long id;
    @TableField("rolename")
    private String rolename;
    @TableField("description")
    private String description;
    @TableField("sortindex")
    private Long sortindex;
    @TableField("isSync")
    private Integer isSync;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSortindex() {
        return sortindex;
    }

    public void setSortindex(Long sortindex) {
        this.sortindex = sortindex;
    }

    public Integer getIsSync() {
        return isSync;
    }

    public void setIsSync(Integer isSync) {
        this.isSync = isSync;
    }
}
