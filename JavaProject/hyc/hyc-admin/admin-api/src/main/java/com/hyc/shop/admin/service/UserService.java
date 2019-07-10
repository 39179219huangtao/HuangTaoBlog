package com.hyc.shop.admin.service;


import com.hyc.shop.admin.bo.UserBO;
import com.hyc.shop.admin.bo.UserPageBO;
import com.hyc.shop.admin.bo.user.UserAuthenticationBO;
import com.hyc.shop.admin.dto.UserPageDTO;
import com.hyc.shop.admin.dto.UserUpdateDTO;
import com.hyc.shop.admin.dto.user.UserAuthenticationByMobileCodeDTO;
import com.hyc.shop.common.constant.CommonStatusEnum;
import com.hyc.shop.common.validator.InEnum;

public interface UserService {

    UserAuthenticationBO authenticationByMobileCode(UserAuthenticationByMobileCodeDTO userAuthenticationByMobileCodeDTO);

    UserPageBO getUserPage(UserPageDTO userPageDTO);

    UserBO getUser(Integer userId);

    /**
     * 更新用户基本信息
     *
     * @param userUpdateDTO 更新 DTO
     * @return 更新结果
     */
    Boolean updateUser(UserUpdateDTO userUpdateDTO);

    /**
     * 更新用户状态
     *
     * @param userId 用户编号
     * @param status 状态
     * @return 更新结果
     */
    Boolean updateUserStatus(Integer userId,
                             @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}") Integer status);

    /**
     * 更新用户手机号
     *
     * @param userId 用户编号
     * @param mobile 手机号
     * @return 更新结果
     */
    Boolean updateUserMobile(Integer userId, String mobile);

}
