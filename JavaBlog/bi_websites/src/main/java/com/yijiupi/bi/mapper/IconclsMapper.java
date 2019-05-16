package com.yijiupi.bi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.Iconcls;

public interface IconclsMapper extends BaseMapper<Iconcls> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Iconcls record);

    Iconcls selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Iconcls record);

    int updateByPrimaryKey(Iconcls record);
}