package com.hyc.shop.system.service;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.bo.datadict.DataDictBO;
import com.hyc.shop.system.dto.datadict.DataDictAddDTO;
import com.hyc.shop.system.dto.datadict.DataDictUpdateDTO;

import java.util.Collection;
import java.util.List;

public interface DataDictService {

    List<DataDictBO> selectDataDictList();

    DataDictBO addDataDict(Integer adminId, DataDictAddDTO dataDictAddDTO);

    Boolean updateDataDict(Integer adminId, DataDictUpdateDTO dataDictUpdateDTO);

    Boolean deleteDataDict(Integer adminId, Integer dataDictId);

    /**
     * 获取字典值 - 单个
     *
     *  注意: dictValue:Object 为了方便调用，会自动转换为 dictValue:String
     *
     * @param dictKey
     * @param dictValue
     * @return
     */
    CommonResult<DataDictBO> getDataDict(String dictKey, Object dictValue);

    CommonResult<List<DataDictBO>> getDataDict(String dictKey);

    /**
     * 获取字典值 - 多个
     *
     *  注意：dictValueList:? 为了方便调用，会自动转换为 Set:String
     *
     * @param dictKey
     * @param dictValueList
     * @return
     */
    CommonResult<List<DataDictBO>> getDataDictList(String dictKey, Collection<?> dictValueList);
}
