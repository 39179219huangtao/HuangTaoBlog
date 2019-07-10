package com.hyc.shop.system.domain.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyc.shop.common.mybatis.QueryWrapperX;
import com.hyc.shop.system.domain.dataobject.AdminDO;
import com.hyc.shop.system.dto.admin.AdminPageDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper extends BaseMapper<AdminDO> {

    default AdminDO selectByUsername(@Param("username") String username) {
        return selectOne(new QueryWrapper<AdminDO>().eq("username", username));
    }

    default IPage<AdminDO> selectPage(AdminPageDTO adminPageDTO) {
        return selectPage(new Page<>(adminPageDTO.getPageNo(), adminPageDTO.getPageSize()),
                new QueryWrapperX<AdminDO>().likeIfPresent("nickname", adminPageDTO.getNickname()));
    }

}
