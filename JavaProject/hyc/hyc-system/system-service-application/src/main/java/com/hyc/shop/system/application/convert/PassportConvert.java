package com.hyc.shop.system.application.convert;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.application.vo.PassportLoginVO;
import com.hyc.shop.system.bo.oauth2.OAuth2AccessTokenBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportConvert {

    PassportConvert INSTANCE = Mappers.getMapper(PassportConvert.class);

    @Mappings({})
    PassportLoginVO convert(OAuth2AccessTokenBO oauth2AccessTokenBO);

    @Mappings({})
    CommonResult<PassportLoginVO> convert(CommonResult<OAuth2AccessTokenBO> oauth2AccessTokenBO);

}
