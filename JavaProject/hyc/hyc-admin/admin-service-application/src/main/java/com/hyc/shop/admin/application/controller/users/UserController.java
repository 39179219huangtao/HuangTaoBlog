package com.hyc.shop.admin.application.controller.users;


import com.hyc.shop.admin.application.convert.UserConvert;
import com.hyc.shop.admin.application.vo.users.UsersUserVO;
import com.hyc.shop.admin.bo.UserBO;
import com.hyc.shop.admin.dto.UserUpdateDTO;
import com.hyc.shop.admin.sdk.annotation.RequiresLogin;
import com.hyc.shop.admin.sdk.context.UserSecurityContextHolder;
import com.hyc.shop.admin.service.UserService;
import com.hyc.shop.common.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("/users/user")
@Api("用户模块")
public class UserController {

    @Reference(validation = "true", version = "${dubbo.provider.UserService.version}")
    private UserService userService;

    @GetMapping("/info")
    @RequiresLogin
    @ApiOperation(value = "用户信息")
    public CommonResult<UsersUserVO> info() {
        UserBO userResult = userService.getUser(UserSecurityContextHolder.getContext().getUserId());
        return success(UserConvert.INSTANCE.convert2(userResult));
    }

    @PostMapping("/update_avatar")
    @RequiresLogin
    @ApiOperation(value = "更新头像")
    public CommonResult<Boolean> updateAvatar(@RequestParam("avatar") String avatar) {
        // 创建
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO().setId(UserSecurityContextHolder.getContext().getUserId())
                .setAvatar(avatar);
        // 更新头像
        return success(userService.updateUser(userUpdateDTO));
    }

    @PostMapping("/update_nickname")
    @RequiresLogin
    @ApiOperation(value = "更新昵称")
    public CommonResult<Boolean> updateNickname(@RequestParam("nickname") String nickname) {
        // 创建
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO().setId(UserSecurityContextHolder.getContext().getUserId())
                .setNickname(nickname);
        // 更新头像
        return success(userService.updateUser(userUpdateDTO));
    }

}
