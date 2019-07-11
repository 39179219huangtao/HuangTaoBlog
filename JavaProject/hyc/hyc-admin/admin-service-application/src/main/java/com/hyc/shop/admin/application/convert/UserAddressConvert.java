package com.hyc.shop.admin.application.convert;


import com.hyc.shop.admin.application.po.UserAddressAddPO;
import com.hyc.shop.admin.application.po.UserAddressUpdatePO;
import com.hyc.shop.admin.dto.UserAddressAddDTO;
import com.hyc.shop.admin.dto.UserAddressUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Sin
 * @time 2019-04-06 14:19
 */
@Mapper
public interface UserAddressConvert {

    UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);

    @Mappings({})
    UserAddressAddDTO convert(UserAddressAddPO userAddressAddPO);

    @Mappings({})
    UserAddressUpdateDTO convert(UserAddressUpdatePO userAddressUpdatePO);
}
