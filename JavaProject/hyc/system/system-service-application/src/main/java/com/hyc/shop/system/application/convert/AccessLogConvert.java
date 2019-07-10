package com.hyc.shop.system.application.convert;


import com.hyc.shop.system.application.vo.log.AccessLogPageVo;
import com.hyc.shop.system.application.vo.log.AccessLogVo;
import com.hyc.shop.system.bo.systemlog.AccessLogBO;
import com.hyc.shop.system.bo.systemlog.AccessLogPageBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author:ycjx
 * @descriptio
 * @create:2019-06-23 17:36
 */
@Mapper
public interface AccessLogConvert {


    AccessLogConvert INSTANCE = Mappers.getMapper(AccessLogConvert.class);

    @Mappings({})
    AccessLogPageVo convert(AccessLogPageBO result);

    @Mappings({})
    AccessLogVo convert(AccessLogBO result);



}
