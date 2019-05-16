package com.yijiupi.bi.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.yijiupi.bi.entity.Role;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.vo.RoleVo;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
public interface RoleService extends IService<Role> {

	public EasyUiPage<RoleVo> pageByUserId(String userId, EasyUiPage<RoleVo> page);
	
}
