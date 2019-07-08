package com.hyc.shop.system.service;



import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.deptment.DeptmentBO;
import com.hyc.shop.system.dto.depetment.DeptmentAddDTO;
import com.hyc.shop.system.dto.depetment.DeptmentPageDTO;
import com.hyc.shop.system.dto.depetment.DeptmentUpdateDTO;

import java.util.List;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-14
 * @time: 19:35
 */
public interface DeptmentService {

    DeptmentBO addDeptment(Integer adminId, DeptmentAddDTO deptmentAddDTO);

    Boolean deleteDeptment(Integer adminId, Integer deptmentId);

    Boolean updateDeptment(Integer adminId, DeptmentUpdateDTO deptmentUpdateDTO);

    PageResult<DeptmentBO> getPageRootDeptment(DeptmentPageDTO deptmentPageDTO);

    List<DeptmentBO> getAllDeptments();

    List<DeptmentBO> getAllNotRootDeptment();
}
