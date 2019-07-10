package com.hyc.shop.system.application.convert;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.application.vo.admin.AdminMenuTreeNodeVO;
import com.hyc.shop.system.application.vo.resource.ResourceTreeNodeVO;
import com.hyc.shop.system.application.vo.resource.ResourceVO;
import com.hyc.shop.system.application.vo.role.RoleResourceTreeNodeVO;
import com.hyc.shop.system.bo.resource.ResourceBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceConvert {

    ResourceConvert INSTANCE = Mappers.getMapper(ResourceConvert.class);

    @Mappings({})
    AdminMenuTreeNodeVO convert(ResourceBO resourceBO);

    @Mappings({})
    ResourceTreeNodeVO convert2(ResourceBO resourceBO);

    @Mappings({})
    RoleResourceTreeNodeVO convert4(ResourceBO resourceBO);

    @Mappings({})
    ResourceVO convert3(ResourceBO resourceBO);

    @Mappings({})
    CommonResult<ResourceVO> convert3(CommonResult<ResourceBO> resourceBO);

}
