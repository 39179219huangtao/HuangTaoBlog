package com.hyc.shop.admin.application.convert;


import com.hyc.shop.admin.application.vo.admins.AdminsUserPageVO;
import com.hyc.shop.admin.application.vo.users.UsersUserVO;
import com.hyc.shop.admin.bo.UserBO;
import com.hyc.shop.admin.bo.UserPageBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mappings({})
    AdminsUserPageVO convert(UserPageBO result);

    @Mappings({})
    UsersUserVO convert2(UserBO result);

}
