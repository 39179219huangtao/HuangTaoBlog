package com.yijiupi.bi.dto;



import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 * 大区
 */
public class Region extends BaseEntity<Integer> {
    /**
     *
     */
    private static final long serialVersionUID = -303980948709993027L;
    /**
     * 城市Id集合
     */
    List<Integer> cityIdList;
    /**
     * 大区名字
     */
    private String name;
    /**
     * 部门Id
     */
    private Integer departmentId;

    /**
     * 备注
     */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getCityIdList() {
        return cityIdList;
    }

    public void setCityIdList(List<Integer> cityIdList) {
        this.cityIdList = cityIdList;
    }

    /**
     * 获取 部门Id
     *
     * @return departmentId 部门Id
     */
    public Integer getDepartmentId() {
        return this.departmentId;
    }

    /**
     * 设置 部门Id
     *
     * @param departmentId 部门Id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
