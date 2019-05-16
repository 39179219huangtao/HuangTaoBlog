package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("fr_t_uep")
public class FrTUep implements Serializable {

    private static final long serialVersionUID = -668653728229553015L;
    private Long id;
    @TableField("userid")
    private Long userid;
    @TableField("type")
    private Integer type;
    @TableField("entryid")
    private Long entryid;
    @TableField("view")
    private Long view;
    @TableField("authorized")
    private Long authorized;
    @TableField("edit")
    private Long edit;
    @TableField("export")
    private Long export;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }

    public Long getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Long authorized) {
        this.authorized = authorized;
    }

    public Long getEdit() {
        return edit;
    }

    public void setEdit(Long edit) {
        this.edit = edit;
    }

    public Long getExport() {
        return export;
    }

    public void setExport(Long export) {
        this.export = export;
    }

    @Override
    public String toString() {
        return "FrTUep{" +
                "id=" + id +
                ", userid=" + userid +
                ", type=" + type +
                ", entryid=" + entryid +
                ", view=" + view +
                ", authorized=" + authorized +
                ", edit=" + edit +
                ", export=" + export +
                '}';
    }
}