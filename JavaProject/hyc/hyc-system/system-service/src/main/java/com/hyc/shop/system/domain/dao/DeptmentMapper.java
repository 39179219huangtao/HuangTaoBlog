package com.hyc.shop.system.domain.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyc.shop.common.mybatis.QueryWrapperX;
import com.hyc.shop.system.domain.dataobject.DeptmentDO;
import com.hyc.shop.system.dto.depetment.DeptmentPageDTO;

import java.util.List;

/**
 * Description:
 *
 * @author: zhenxianyimeng
 * @date: 2019-06-14
 * @time: 19:26
 */
public interface DeptmentMapper extends BaseMapper<DeptmentDO> {

    default DeptmentDO findDeptByNameAndPid(String name, Integer pid){
        return selectOne(new QueryWrapper<DeptmentDO>()
                .eq("name", name)
                .eq("pid", pid)
                .eq("deleted", false)
        );
    }

    default IPage<DeptmentDO> selectDeptPage(DeptmentPageDTO deptmentPageDTO, Integer pid){
        return selectPage(new Page<>(deptmentPageDTO.getPageNo(), deptmentPageDTO.getPageSize()),
                new QueryWrapperX<DeptmentDO>()
                        .likeIfPresent("name", deptmentPageDTO.getName())
                        .eqIfPresent("pid", pid)
                        .eq("deleted", false));

    }

    default List<DeptmentDO> getDeptByPid(Integer pid){
        return selectList(new QueryWrapperX<DeptmentDO>()
                .eqIfPresent("pid", pid)
                .eq("deleted", false));
    }

    default List<DeptmentDO> getDeptExcudePid(Integer pid){
        return selectList(new QueryWrapper<DeptmentDO>()
            .ne("pid",pid)
            .eq("deleted",false));
    }
}
