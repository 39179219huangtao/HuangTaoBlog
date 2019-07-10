package com.hyc.shop.admin.domain.convert;


import com.hyc.shop.admin.bo.UserAddressBO;
import com.hyc.shop.admin.domain.dataobject.UserAddressDO;
import com.hyc.shop.admin.dto.UserAddressAddDTO;
import com.hyc.shop.admin.dto.UserAddressUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户地址 convert
 *
 * @author Sin
 * @time 2019-04-06 13:38
 */
@Mapper
public interface UserAddressConvert {

    UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);

    @Mappings({})
    UserAddressDO convert(UserAddressAddDTO userAddressAddDTO);

    @Mappings({})
    UserAddressDO convert(UserAddressUpdateDTO userAddressUpdateDTO);

    @Mappings({})
    UserAddressBO convert(UserAddressDO userAddressDO);

    @Mappings({})
    List<UserAddressBO> convertUserAddressBOList(List<UserAddressDO> userAddressDOList);
}
