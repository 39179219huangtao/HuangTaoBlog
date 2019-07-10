package com.hyc.shop.admin.service;



import com.hyc.shop.admin.bo.UserAddressBO;
import com.hyc.shop.admin.dto.UserAddressAddDTO;
import com.hyc.shop.admin.dto.UserAddressUpdateDTO;
import com.hyc.shop.common.vo.CommonResult;

import java.util.List;

/**
 * 用户地址
 *
 * @author Sin
 * @time 2019-04-06 13:24
 */
public interface UserAddressService {

    CommonResult addAddress(UserAddressAddDTO userAddressAddDTO);

    CommonResult updateAddress(UserAddressUpdateDTO userAddressAddDTO);

    CommonResult removeAddress(Integer userId, Integer addressId);

    CommonResult<List<UserAddressBO>> addressList(Integer userId);

    CommonResult<UserAddressBO> getAddress(Integer userId, Integer id);

    CommonResult<UserAddressBO> getDefaultAddress(Integer userId);
}
