package com.hyc.shop.system.domain.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyc.shop.common.mybatis.QueryWrapperX;
import com.hyc.shop.system.domain.dataobject.RoleDO;
import com.hyc.shop.system.dto.role.RolePageDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<RoleDO> {

    default List<RoleDO> selectList() {
        return selectList(new QueryWrapper<>());
    }

    default IPage<RoleDO> selectPage(RolePageDTO rolePageDTO) {
        return selectPage(new Page<>(rolePageDTO.getPageNo(), rolePageDTO.getPageSize()),
                new QueryWrapperX<RoleDO>().likeIfPresent("name", rolePageDTO.getName()));
    }

}
