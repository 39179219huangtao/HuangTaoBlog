package com.hyc.shop.system.application.convert;

import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.application.vo.deptment.DeptmentVO;
import com.hyc.shop.system.bo.deptment.DeptmentBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-22
 * @time: 00:23
 */
@Mapper
public interface DeptmentConvert {

    DeptmentConvert INSTANCE = Mappers.getMapper(DeptmentConvert.class);

    @Mappings({@Mapping(source = "list", target = "list")})
    PageResult<DeptmentVO> convert(PageResult<DeptmentBO> pageResult);

    @Mappings({})
    List<DeptmentVO> convert(List<DeptmentBO> list);
}
