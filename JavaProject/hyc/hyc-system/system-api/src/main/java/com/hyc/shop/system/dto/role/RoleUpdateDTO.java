package com.hyc.shop.system.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("角色添加 DTO")
@Data
@Accessors(chain = true)
public class RoleUpdateDTO implements Serializable {

    @ApiModelProperty(value = "角色编号", required = true, example = "1")
    @NotNull(message = "角色编号不能为空")
    private Integer id;

    @ApiModelProperty(value = "角色名", required = true, example = "系统管理员")
    @NotEmpty(message = "角色名字不能为空")
    private String name;

}
