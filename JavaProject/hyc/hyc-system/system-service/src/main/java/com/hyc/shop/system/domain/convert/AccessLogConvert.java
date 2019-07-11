package com.hyc.shop.system.domain.convert;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.systemlog.AccessLogBO;
import com.hyc.shop.system.domain.dataobject.AccessLogDO;
import com.hyc.shop.system.domain.dataobject.ExceptionLogDO;
import com.hyc.shop.system.dto.systemlog.AccessLogAddDTO;
import com.hyc.shop.system.dto.systemlog.ExceptionLogAddDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccessLogConvert {

    AccessLogConvert INSTANCE = Mappers.getMapper(AccessLogConvert.class);

    @Mappings({})
    AccessLogDO convert(AccessLogAddDTO accessLogAddDTO);

    @Mappings({})
    ExceptionLogDO convert(ExceptionLogAddDTO exceptionLogAddDTO);

    @Mappings({
            @Mapping(source = "records", target = "list"),
    })
    PageResult<AccessLogBO> convert(IPage<AccessLogDO> page);

}
