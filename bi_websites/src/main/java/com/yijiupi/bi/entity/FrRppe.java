package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("fr_rppe")
public class FrRppe implements Serializable {
    private static final long serialVersionUID = -4964762320247022267L;
    private Integer id;
    @TableField("parent")
    private Integer parent;
    @TableField("processtype")
    private Integer processtype;
    @TableField("name")
    private String name;
    @TableField("description")
    private String description;
    @TableField("sortindex")
    private Long sortindex;
    @TableField("mobilecoverid")
    private String mobilecoverid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getProcesstype() {
        return processtype;
    }

    public void setProcesstype(Integer processtype) {
        this.processtype = processtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMobilecoverid() {
        return mobilecoverid;
    }

    public void setMobilecoverid(String mobilecoverid) {
        this.mobilecoverid = mobilecoverid;
    }

}