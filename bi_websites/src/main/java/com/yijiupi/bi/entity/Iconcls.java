package com.yijiupi.bi.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("iconcls")
public class Iconcls {

    private Long id;

    @TableField("clsid")
    private String clsid;

    @TableField("descripe")
    private String descripe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClsid() {
        return clsid;
    }

    public void setClsid(String clsid) {
        this.clsid = clsid;
    }

    public String getDescripe() {
        return descripe;
    }

    public void setDescripe(String descripe) {
        this.descripe = descripe;
    }
}