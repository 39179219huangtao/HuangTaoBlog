package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("fr_urlentry")
public class FrUrlentry implements Serializable {
    private static final long serialVersionUID = -251260455109677604L;
    private Integer id;
    @TableField("parent")
    private Integer parent;
    @TableField("name")
    private String name;
    @TableField("url")
    private String url;
    @TableField("description")
    private String description;
    @TableField("sortindex")
    private Long sortindex;
    @TableField("mobiledeviceconfig")
    private Integer mobiledeviceconfig;
    @TableField("parentdeviceconfig")
    private Integer parentdeviceconfig;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getMobiledeviceconfig() {
        return mobiledeviceconfig;
    }

    public void setMobiledeviceconfig(Integer mobiledeviceconfig) {
        this.mobiledeviceconfig = mobiledeviceconfig;
    }

    public Integer getParentdeviceconfig() {
        return parentdeviceconfig;
    }

    public void setParentdeviceconfig(Integer parentdeviceconfig) {
        this.parentdeviceconfig = parentdeviceconfig;
    }

    public String getMobilecoverid() {
        return mobilecoverid;
    }

    public void setMobilecoverid(String mobilecoverid) {
        this.mobilecoverid = mobilecoverid;
    }
}