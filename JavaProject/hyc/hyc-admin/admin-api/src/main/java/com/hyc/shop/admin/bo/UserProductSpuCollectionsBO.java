package com.hyc.shop.admin.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户_商品_收藏记录表
 * @author xiaofeng
 * @date 2019-07-01 20:23:30
 */
@Data
@Accessors(chain = true)
public class UserProductSpuCollectionsBO implements Serializable {

    /**
     * id自增长
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 商品id
     */
    private Integer spuId;

    /**
     * 商品名字
     */
    private String spuName;

    /**
     * 图片名字
     */
    private String spuImage;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态
     */
    private Integer deleted;


}
