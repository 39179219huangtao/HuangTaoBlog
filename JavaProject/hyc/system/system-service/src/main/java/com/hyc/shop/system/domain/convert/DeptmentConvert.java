package com.hyc.shop.system.domain.convert;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.deptment.DeptmentBO;
import com.hyc.shop.system.domain.dataobject.DeptmentDO;
import com.hyc.shop.system.dto.depetment.DeptmentAddDTO;
import com.hyc.shop.system.dto.depetment.DeptmentUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-14
 * @time: 20:06
 */
@Mapper
public interface DeptmentConvert {

    DeptmentConvert INSTANCE = Mappers.getMapper(DeptmentConvert.class);

    @Mappings({})
    DeptmentDO convert(DeptmentAddDTO deptmentAddDTO);

    @Mappings({})
    DeptmentBO convert(DeptmentDO deptmentDO);

    @Mappings({@Mapping(source = "records", target = "list")})
    PageResult<DeptmentBO> convert(IPage<DeptmentDO> list);

    @Mappings({})
    List<DeptmentBO> convert(List<DeptmentDO> list);

    @Mappings({})
    DeptmentDO convert(DeptmentUpdateDTO deptmentUpdateDTO);
}
