package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Objects;

@TableName("fr_t_companyrole")
public class FrCompanyrole implements Serializable {
    private static final long serialVersionUID = 6526689987205775374L;
    private Long id;
    @TableField("postid")
    private Long postid;
    @TableField("departmentid")
    private Long departmentid;
    @TableField("description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrCompanyrole that = (FrCompanyrole) o;
        if(((FrCompanyrole) o).id != null && this.id != null){
            return Objects.equals(id, that.id);
        }else{
            return Objects.equals(postid, that.postid) &&
                    Objects.equals(departmentid, that.departmentid);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid, departmentid);
    }

    @Override
    public String toString() {
        return "FrCompanyrole{" +
                "roleId=" + id +
                ", postid=" + postid +
                ", departmentid=" + departmentid +
                ", description='" + description + '\'' +
                '}';
    }
}