package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("fr_t_user")
public class FrUser implements Serializable, Cloneable {
    private static final long serialVersionUID = 7487795251938280066L;
    private Long id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("realname")
    private String realname;
    @TableField("mobile")
    private String mobile;
    @TableField("email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrUser frUser = (FrUser) o;

        if (username != null ? !username.equals(frUser.username) : frUser.username != null) return false;
        if (password != null ? !password.equals(frUser.password) : frUser.password != null) return false;
        if (realname != null ? !realname.equals(frUser.realname) : frUser.realname != null) return false;
        if (mobile != null ? !mobile.equals(frUser.mobile) : frUser.mobile != null) return false;
        return email != null ? email.equals(frUser.email) : frUser.email == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (realname != null ? realname.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() {
        FrUser user = null;
        try
        {
            user = (FrUser)super.clone();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}