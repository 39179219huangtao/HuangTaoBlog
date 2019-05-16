package com.yijiupi.bi.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.yijiupi.bi.entity.Menu;
import com.yijiupi.bi.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
public interface MenuService extends IService<Menu> {
	public List<MenuVo> getAdminMenu(String userId);
	
	public List<MenuVo> getAllMenu();
	
	public List<MenuVo> getFirstDegree();
	
	public List<MenuVo> getByParentId(String parentId);
	
	public boolean hasChild(MenuVo menu);
	
	public List<MenuVo> renderRoleMenuTree(String roleId, String parentId);
	
	public boolean initRoleMenu(String roleId, String[] menuIds);
	
	@Override
	boolean insert(Menu menu);
	
	@Override
	boolean updateById(Menu menu);
}
