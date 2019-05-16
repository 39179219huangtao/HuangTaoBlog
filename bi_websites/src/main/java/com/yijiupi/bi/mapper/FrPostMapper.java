package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrDepartmentPostUser;
import com.yijiupi.bi.entity.FrPost;

public interface FrPostMapper extends BaseMapper<FrPost> {
    int deleteByPrimaryKey(Long id);


    int insertSelective(FrPost record);

    FrPost selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrPost record);

    int updateByPrimaryKey(FrPost record);
}