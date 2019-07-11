package com.hyc.shop.admin.application.controller.users;


import com.hyc.shop.admin.application.convert.UserAddressConvert;
import com.hyc.shop.admin.application.po.UserAddressAddPO;
import com.hyc.shop.admin.application.po.UserAddressUpdatePO;
import com.hyc.shop.admin.bo.UserAddressBO;
import com.hyc.shop.admin.dto.UserAddressAddDTO;
import com.hyc.shop.admin.dto.UserAddressUpdateDTO;
import com.hyc.shop.admin.sdk.context.UserSecurityContextHolder;
import com.hyc.shop.admin.service.UserAddressService;
import com.hyc.shop.common.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户地址
 *
 * @author Sin
 * @time 2019-04-06 14:11
 */
@RestController
@RequestMapping("users/address")
@Api(value = "用户地址API")
public class UserAddressController {

    @Reference(validation = "true", version = "${dubbo.provider.UserAddressService.version}")
    private UserAddressService userAddressService;

    @PostMapping("add")
    @ApiOperation(value = "用户地址-添加")
    public CommonResult addAddress(@Validated UserAddressAddPO userAddressAddPO) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        UserAddressAddDTO userAddressAddDTO = UserAddressConvert.INSTANCE.convert(userAddressAddPO);
        userAddressAddDTO.setUserId(userId);
        return userAddressService.addAddress(userAddressAddDTO);
    }

    @PutMapping("update")
    @ApiOperation(value = "用户地址-更新")
    public CommonResult updateAddress(@Validated UserAddressUpdatePO userAddressUpdatePO) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        UserAddressUpdateDTO userAddressUpdateDTO = UserAddressConvert.INSTANCE.convert(userAddressUpdatePO);
        userAddressUpdateDTO.setUserId(userId);
        return userAddressService.updateAddress(userAddressUpdateDTO);
    }

    @DeleteMapping("remove")
    @ApiOperation(value = "用户地址-删除")
    public CommonResult removeAddress(@RequestParam("id") Integer id) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        return userAddressService.removeAddress(userId, id);
    }

    @GetMapping("list")
    @ApiOperation(value = "用户地址列表")
    public CommonResult<List<UserAddressBO>> addressList() {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        return userAddressService.addressList(userId);
    }

    @GetMapping("address")
    @ApiOperation(value = "获取地址")
    public CommonResult<UserAddressBO> getAddress(@RequestParam("id") Integer id) {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        return userAddressService.getAddress(userId, id);
    }

    @GetMapping("default_address")
    @ApiOperation(value = "获取默认地址")
    public CommonResult<UserAddressBO> getDefaultAddress() {
        Integer userId = UserSecurityContextHolder.getContext().getUserId();
        return userAddressService.getDefaultAddress(userId);
    }
}
