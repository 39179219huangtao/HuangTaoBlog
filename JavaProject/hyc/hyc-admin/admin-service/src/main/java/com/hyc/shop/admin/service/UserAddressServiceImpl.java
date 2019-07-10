package com.hyc.shop.admin.service;


import com.hyc.shop.admin.bo.UserAddressBO;
import com.hyc.shop.admin.constant.UserAddressHasDefaultEnum;
import com.hyc.shop.admin.constant.UserErrorCodeEnum;
import com.hyc.shop.admin.domain.convert.UserAddressConvert;
import com.hyc.shop.admin.domain.dao.UserAddressMapper;
import com.hyc.shop.admin.domain.dataobject.UserAddressDO;
import com.hyc.shop.admin.dto.UserAddressAddDTO;
import com.hyc.shop.admin.dto.UserAddressUpdateDTO;
import com.hyc.shop.common.constant.DeletedStatusEnum;
import com.hyc.shop.common.util.ServiceExceptionUtil;
import com.hyc.shop.common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户地址
 *
 * @author Sin
 * @time 2019-04-06 13:26
 */
@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.UserAddressService.version}")
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    @Transactional
    public CommonResult addAddress(UserAddressAddDTO userAddressAddDTO) {
        UserAddressDO userAddressDO = UserAddressConvert.INSTANCE.convert(userAddressAddDTO);
        userAddressDO.setCreateTime(new Date());
        userAddressDO.setDeleted(DeletedStatusEnum.DELETED_NO.getValue());

        // 检查是否设置为默认地址
        if (UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue() == userAddressAddDTO.getHasDefault()) {
            UserAddressDO defaultUserAddress = userAddressMapper.selectHasDefault(
                    DeletedStatusEnum.DELETED_NO.getValue(),
                    userAddressAddDTO.getUserId(), UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue());

            if (defaultUserAddress != null) {
                userAddressMapper.updateById(defaultUserAddress.getId(),
                        new UserAddressDO()
                                .setHasDefault(UserAddressHasDefaultEnum.DEFAULT_ADDRESS_NO.getValue())
                );
            }
        }

        int result = userAddressMapper.insert(userAddressDO);
        return CommonResult.success(result);
    }

    @Override
    @Transactional
    public CommonResult updateAddress(UserAddressUpdateDTO userAddressAddDTO) {
        UserAddressDO userAddress = userAddressMapper
                .selectByUserIdAndId(userAddressAddDTO.getUserId(), userAddressAddDTO.getId());

        if (DeletedStatusEnum.DELETED_YES.getValue().equals(userAddress.getDeleted())) {
            return ServiceExceptionUtil.error(UserErrorCodeEnum.USER_ADDRESS_IS_DELETED.getCode());
        }

        if (userAddress == null) {
            return ServiceExceptionUtil.error(UserErrorCodeEnum.USER_ADDRESS_NOT_EXISTENT.getCode());
        }

        // 检查是否设置为默认地址
        if (UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue() == userAddressAddDTO.getHasDefault()) {
            UserAddressDO defaultUserAddress = userAddressMapper.selectHasDefault(
                    DeletedStatusEnum.DELETED_NO.getValue(),
                    userAddressAddDTO.getUserId(), UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue());

            if (defaultUserAddress != null && !userAddressAddDTO.getId().equals(defaultUserAddress.getId())) {
                userAddressMapper.updateById(defaultUserAddress.getId(),
                        new UserAddressDO()
                                .setHasDefault(UserAddressHasDefaultEnum.DEFAULT_ADDRESS_NO.getValue())
                );
            }
        }

        UserAddressDO defaultUserAddress = userAddressMapper.selectHasDefault(
                DeletedStatusEnum.DELETED_NO.getValue(),
                userAddressAddDTO.getUserId(), UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue());

        if (defaultUserAddress != null && !userAddressAddDTO.getId().equals(defaultUserAddress.getId())) {
            userAddressMapper.updateById(defaultUserAddress.getId(),
                    new UserAddressDO()
                            .setHasDefault(UserAddressHasDefaultEnum.DEFAULT_ADDRESS_NO.getValue())
            );
        }

        UserAddressDO userAddressDO = UserAddressConvert.INSTANCE.convert(userAddressAddDTO);
        userAddressDO.setUpdateTime(new Date());
        userAddressMapper.updateById(userAddressDO.getId(), userAddressDO);
        return CommonResult.success(null);
    }

    @Override
    public CommonResult removeAddress(Integer userId, Integer addressId) {
        UserAddressDO userAddress = userAddressMapper.selectByUserIdAndId(userId, addressId);

        if (DeletedStatusEnum.DELETED_YES.getValue().equals(userAddress.getDeleted())) {
            // skip
            return CommonResult.success(null);
        }

        if (userAddress == null) {
            return ServiceExceptionUtil.error(UserErrorCodeEnum.USER_ADDRESS_NOT_EXISTENT.getCode());
        }

        userAddressMapper.updateById(
                addressId,
                (UserAddressDO) new UserAddressDO()
                        .setDeleted(DeletedStatusEnum.DELETED_YES.getValue())
        );
        return CommonResult.success(null);
    }

    @Override
    public CommonResult<List<UserAddressBO>> addressList(Integer userId) {

        List<UserAddressDO> userAddressDOList = userAddressMapper
                .selectByUserIdAndDeleted(DeletedStatusEnum.DELETED_NO.getValue(), userId);

        List<UserAddressBO> userAddressBOList = UserAddressConvert
                .INSTANCE.convertUserAddressBOList(userAddressDOList);

        return CommonResult.success(userAddressBOList);
    }

    @Override
    public CommonResult<UserAddressBO> getAddress(Integer userId, Integer id) {
        UserAddressDO userAddress = userAddressMapper.selectByUserIdAndId(userId, id);
        if (userAddress == null) {
            return ServiceExceptionUtil.error(UserErrorCodeEnum.USER_GET_ADDRESS_NOT_EXISTS.getCode());
        }

        if (DeletedStatusEnum.DELETED_YES.getValue().equals(userAddress.getDeleted())) {
            return ServiceExceptionUtil.error(UserErrorCodeEnum.USER_ADDRESS_IS_DELETED.getCode());
        }

        UserAddressBO userAddressBO = UserAddressConvert.INSTANCE.convert(userAddress);
        return CommonResult.success(userAddressBO);
    }

    @Override
    public CommonResult<UserAddressBO> getDefaultAddress(Integer userId) {

        UserAddressDO defaultUserAddress = userAddressMapper.selectHasDefault(
                DeletedStatusEnum.DELETED_NO.getValue(),
                userId,
                UserAddressHasDefaultEnum.DEFAULT_ADDRESS_YES.getValue());

        return CommonResult.success(UserAddressConvert.INSTANCE.convert(defaultUserAddress));
    }
}
