package com.hyc.shop.system.domain.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.admin.AdminAuthenticationBO;
import com.hyc.shop.system.bo.admin.AdminBO;
import com.hyc.shop.system.domain.dataobject.AdminDO;
import com.hyc.shop.system.dto.admin.AdminAddDTO;
import com.hyc.shop.system.dto.admin.AdminUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminConvert {

    AdminConvert INSTANCE = Mappers.getMapper(AdminConvert.class);

    @Mappings({})
    AdminBO convert(AdminDO adminDO);

    @Mappings({})
    AdminAuthenticationBO convert2(AdminDO admin);

    @Mappings({})
    AdminDO convert(AdminAddDTO adminAddDTO);

    @Mappings({})
    AdminDO convert(AdminUpdateDTO adminUpdateDTO);

    @Mappings({})
    List<AdminBO> convert(List<AdminDO> adminBOs);

    @Mappings({
            @Mapping(source = "records", target = "list"),
    })
    PageResult<AdminBO> convert(IPage<AdminDO> page);

}
