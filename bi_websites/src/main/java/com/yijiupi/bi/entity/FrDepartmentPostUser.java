package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Objects;

@TableName("fr_t_department_post_user")
public class FrDepartmentPostUser implements Serializable {
    private static final long serialVersionUID = 6455076328479188824L;
    private Long id;
    @TableField("userid")
    private Long userid;
    @TableField("departmentid")
    private Long departmentid;
    @TableField("postid")
    private Long postid;

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

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrDepartmentPostUser that = (FrDepartmentPostUser) o;
        if(((FrDepartmentPostUser) o).id != null && this.id != null){
            return Objects.equals(id, that.id);
        }else{
            return Objects.equals(userid, that.userid) &&
                    Objects.equals(departmentid, that.departmentid) &&
                    Objects.equals(postid, that.postid);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, departmentid, postid);
    }
}