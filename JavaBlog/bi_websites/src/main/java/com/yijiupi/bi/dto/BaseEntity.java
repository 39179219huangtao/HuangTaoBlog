package com.yijiupi.bi.dto;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.dto
 * @Description:
 * @date 2018/7/26  12:51
 */
import java.io.Serializable;
import java.util.Date;

/** @deprecated */
@Deprecated
public class BaseEntity<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date createTime;
    private Integer createUserId;
    private T id;
    private Date lastUpdateTime;
    private Integer lastUpdateUserId;

    public BaseEntity() {
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Integer getCreateUserId() {
        return this.createUserId;
    }

    public T getId() {
        return this.id;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public Integer getLastUpdateUserId() {
        return this.lastUpdateUserId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public void setId(T id) {
        this.id = id;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setLastUpdateUserId(Integer lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }
}
