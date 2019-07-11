package com.hyc.shop.system.domain.convert;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.role.RoleBO;
import com.hyc.shop.system.domain.dataobject.RoleDO;
import com.hyc.shop.system.dto.role.RoleAddDTO;
import com.hyc.shop.system.dto.role.RoleUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleConvert {

    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);

    @Mappings({})
    RoleDO convert(RoleAddDTO roleAddDTO);

    @Mappings({})
    RoleDO convert(RoleUpdateDTO roleUpdateDTO);

    @Mappings({})
    RoleBO convert(RoleDO roleDO);

    @Mappings({})
    List<RoleBO> convert(List<RoleDO> roleDOs);

    @Mappings({
            @Mapping(source = "records", target = "list"),
    })
    PageResult<RoleBO> convert(IPage<RoleDO> page);

}
