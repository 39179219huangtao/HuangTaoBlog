package com.yijiupi.bi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 11:06 2018/7/31 0031
 * @Email: huangyuansheng@yijiupi.cn
 **/
public class FrFolderMenu implements Serializable, Comparator<FrFolderMenu>, Cloneable {

    private static final long serialVersionUID = 8457782188247969033L;

    @JsonProperty("reallyId")
    private Integer id;

    @JsonProperty("id")
    private String treeId;

    private Integer parentId;

    private String text;

    private String url;

    private Integer type;

    private Long sortIndex;

    private List<FrFolderMenu> children;

    private String iconCls;

    private String updateUser;

    @JsonIgnore
    private Date updateTime;

    private String updateTimeStr;

    /**
     * 未Encode的url，用于菜单管理显示
     */
    private String urlStr;

    @JsonIgnore
    private String parameters;

    /**
     * 1.分析报表，2.预览报表
     */
    @JsonIgnore
    private Integer isView;

    public FrFolderMenu() {
        this.children = new ArrayList<>();
    }

    public FrFolderMenu(Integer id, Integer type) {
        this.id = id;
        this.type = type;
        this.children = new ArrayList<>();
    }

    public void setTreeFieldId() {
        this.treeId = String.valueOf(id) + String.valueOf(Math.abs(parentId)) + String.valueOf(type);
    }

    public List<FrFolderMenu> getChildren() {
        return children;
    }

    public void setChildren(List<FrFolderMenu> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Long sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
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

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getUrlStr() {
        return urlStr;
    }

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    @Override
    public int compare(FrFolderMenu menu1, FrFolderMenu menu2) {
        if (menu1.getSortIndex() > menu2.getSortIndex()) {
            return 1;
        }
        if (menu1.getSortIndex() < menu2.getSortIndex()) {
            return -1;
        }

        if (menu1.getSortIndex().equals(menu2.getSortIndex())) {
            if (menu1.getId() > menu2.getId()) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public static FrFolderMenu getRootFolder() {
        return new FrFolderMenu(-1, 0);
    }

    public boolean isFolder() {
        return new Integer(0).equals(type);
    }

    public static void sort(List<FrFolderMenu> menus) {
        menus.sort(new FrFolderMenu());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrFolderMenu that = (FrFolderMenu) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, type);
    }

    @Override
    public FrFolderMenu clone() {
        FrFolderMenu newOb = new FrFolderMenu();
        newOb.id = this.id;
        newOb.parentId = this.parentId;
        newOb.text = this.text;
        newOb.url = this.url;
        newOb.type = this.type;
        newOb.sortIndex = this.sortIndex;
        newOb.iconCls = this.iconCls;
        newOb.updateUser = this.updateUser;
        newOb.updateTime = this.updateTime;
        newOb.updateTimeStr = this.updateTimeStr;
        newOb.urlStr = this.urlStr;
        newOb.parameters = this.parameters;
        newOb.isView = this.isView;
        return newOb;
    }
}
