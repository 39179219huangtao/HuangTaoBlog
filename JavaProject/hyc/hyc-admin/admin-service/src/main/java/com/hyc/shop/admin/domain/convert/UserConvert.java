package com.hyc.shop.admin.domain.convert;


import com.hyc.shop.admin.bo.UserBO;
import com.hyc.shop.admin.bo.user.UserAuthenticationBO;
import com.hyc.shop.admin.domain.dataobject.UserDO;
import com.hyc.shop.admin.dto.UserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mappings({})
    UserBO convert(UserDO userDO);

    @Mappings({})
    UserAuthenticationBO convert2(UserDO userDO);

    @Mappings({})
    UserDO convert(UserUpdateDTO userUpdateDTO);

    @Mappings({})
    List<UserBO> convert(List<UserDO> userDOs);

}
