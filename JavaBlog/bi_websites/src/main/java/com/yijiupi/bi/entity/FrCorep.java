package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("fr_t_corep")
public class FrCorep implements Serializable {
    private static final long serialVersionUID = 6560940845440391127L;
    private Long id;
    @TableField("roleid")
    private Long roleid;
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

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
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
        return "FrCorep{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", type=" + type +
                ", entryid=" + entryid +
                ", view=" + view +
                ", authorized=" + authorized +
                ", edit=" + edit +
                ", export=" + export +
                '}';
    }
}