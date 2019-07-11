package com.hyc.shop.system.application.convert;


import com.hyc.shop.system.application.vo.datadict.DataDictEnumVO;
import com.hyc.shop.system.bo.datadict.DataDictBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DataDictConvert {

    DataDictConvert INSTANCE = Mappers.getMapper(DataDictConvert.class);

    @Mappings({})
    List<DataDictEnumVO.Value> convert2(List<DataDictBO> dataDictBOs);

}
