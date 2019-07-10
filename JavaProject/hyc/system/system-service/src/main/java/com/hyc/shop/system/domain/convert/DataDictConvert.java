package com.hyc.shop.system.domain.convert;

import com.hyc.shop.system.bo.datadict.DataDictBO;
import com.hyc.shop.system.domain.dataobject.DataDictDO;
import com.hyc.shop.system.dto.datadict.DataDictAddDTO;
import com.hyc.shop.system.dto.datadict.DataDictUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DataDictConvert {

    DataDictConvert INSTANCE = Mappers.getMapper(DataDictConvert.class);

    DataDictDO convert(DataDictAddDTO dataDictAddDTO);

    DataDictDO convert(DataDictUpdateDTO dataDictUpdateDTO);

    DataDictBO convert(DataDictDO dataDictDO);

    List<DataDictBO> convert(List<DataDictDO> dataDictDOs);

}
