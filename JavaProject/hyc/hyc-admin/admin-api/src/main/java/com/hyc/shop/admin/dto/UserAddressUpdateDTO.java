package com.hyc.shop.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户地址 更新
 *
 * @author Sin
 * @time 2019-04-06 13:28
 */
@Data
@Accessors(chain = true)
public class UserAddressUpdateDTO implements Serializable {

    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 收件区域编号
     */
    private String areaNo;
    /**
     * 收件人名称
     */
    private String name;
    /**
     * 收件手机号
     */
    private String mobile;
    /**
     * 收件详细地址
     */
    private String address;
    /**
     * 是否默认地址
     */
    private Integer hasDefault;
}
