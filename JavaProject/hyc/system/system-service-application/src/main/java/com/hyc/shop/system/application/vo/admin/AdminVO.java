package com.hyc.shop.system.application.vo.admin;

import com.hyc.shop.system.bo.admin.AdminBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel("管理员 VO")
@Data
@Accessors(chain = true)
public class AdminVO extends AdminBO {

    private List<Role> roles;

    @ApiModel("管理员 VO - 角色")
    @Data
    @Accessors(chain = true)
    public static class Role {

        @ApiModelProperty(value = "角色编号", required = true, example = "1")
        private Integer id;

        @ApiModelProperty(value = "角色名", required = true, example = "码神")
        private String name;

    }

}
