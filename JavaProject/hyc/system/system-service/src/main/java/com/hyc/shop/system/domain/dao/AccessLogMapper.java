package com.hyc.shop.system.domain.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyc.shop.common.mybatis.QueryWrapperX;
import com.hyc.shop.system.domain.dataobject.AccessLogDO;
import com.hyc.shop.system.dto.systemlog.AccessLogPageDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLogMapper extends BaseMapper<AccessLogDO> {

    default IPage<AccessLogDO> selectPage(AccessLogPageDTO accessLogPageDTO) {
        return selectPage(new Page<>(accessLogPageDTO.getPageNo(), accessLogPageDTO.getPageSize()),
                new QueryWrapperX<AccessLogDO>().eqIfPresent("user_id", accessLogPageDTO.getUserId()));
    }

}
