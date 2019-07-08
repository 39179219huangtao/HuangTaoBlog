package com.hyc.shop.system.dto.role;

import com.hyc.shop.common.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("角色分页 DTO")
@Data
@Accessors(chain = true)
public class RolePageDTO extends PageParam {

    @ApiModelProperty( value = "角色名，模糊匹配", example = "系统管理员")
    private String name;

}
