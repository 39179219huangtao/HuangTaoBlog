package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.EnumValuePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnumValuePOMapper extends BaseMapper<EnumValuePO> {


    int insertSelective(@Param("record") EnumValuePO enumValuePO);

    int insertList(@Param("records") List<EnumValuePO> enumValuePOs);

}
