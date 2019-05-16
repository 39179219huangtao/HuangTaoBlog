package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrUser;

public interface FrUserMapper extends BaseMapper<FrUser> {
    int deleteByPrimaryKey(Long id);


    int insertSelective(FrUser record);

    FrUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrUser record);

    int updateByPrimaryKey(FrUser record);
}