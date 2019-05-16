package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("fr_t_customrole_user")
public class FrCustomRoleUser implements Serializable {
    private static final long serialVersionUID = -324481396887280944L;
    private Long id;
    @TableField("userid")
    private Long userid;
    @TableField("customroleid")
    private Long customroleid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCustomroleid() {
        return customroleid;
    }

    public void setCustomroleid(Long customroleid) {
        this.customroleid = customroleid;
    }
}