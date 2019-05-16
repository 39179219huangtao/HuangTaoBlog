package com.yijiupi.bi.mapper;

import com.yijiupi.bi.entity.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.vo.MenuVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface MenuDao extends BaseMapper<Menu> {

    List<MenuVo> getMenuByUserIdAndParentId(@Param("userId") String userId, @Param("parentId") String parentId);

    List<MenuVo> getMenuByParentId(@Param("parentId") String parentId);
    
    List<MenuVo> getFirstDegree();
    
    List<MenuVo> getByParentId(@Param("parentId")String parentId);
    
    List<MenuVo> getRoleMenuByParentId(@Param("roleId")String roleId, @Param("parentId")String parentId);    
}
