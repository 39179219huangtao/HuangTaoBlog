package com.hyc.shop.system.application.convert;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.application.vo.admin.AdminInfoVO;
import com.hyc.shop.system.application.vo.admin.AdminRoleVO;
import com.hyc.shop.system.application.vo.admin.AdminVO;
import com.hyc.shop.system.bo.admin.AdminBO;
import com.hyc.shop.system.bo.role.RoleBO;
import com.hyc.shop.system.sdk.context.AdminSecurityContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AdminConvert {

    AdminConvert INSTANCE = Mappers.getMapper(AdminConvert.class);

    @Mappings({})
    AdminInfoVO convert(AdminSecurityContext adminSecurityContext);

    @Mappings({})
    AdminVO convert(AdminBO adminBO);

    @Mappings({})
    CommonResult<AdminVO> convert2(CommonResult<AdminBO> result);

    @Mappings({})
    List<AdminRoleVO> convert(List<RoleBO> roleList);

    @Mappings({})
    PageResult<AdminVO> convertAdminVOPage(PageResult<AdminBO> page);

    List<AdminVO.Role> convertAdminVORoleList(Collection<RoleBO> list);

}
