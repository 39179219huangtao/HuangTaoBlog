package com.yijiupi.bi.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.yijiupi.bi.entity.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
public interface UserRoleService extends IService<UserRole> {

	Integer deleteByUserId(@Param("userId") String userId);
	
}
