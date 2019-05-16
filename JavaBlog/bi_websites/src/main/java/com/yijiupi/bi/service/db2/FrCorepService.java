package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrCorep;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 20:16 2018/8/7
 * @Email: huangyuansheng@yijiupi.cn
 */
public interface FrCorepService extends BaseService<FrCorep> {

    /**
     * 通过角色id查找所有的菜单以及权限
     *
     * @param roleId 角色id
     * @return 所有菜单权限
     */
    List<FrCorep> getAllCorepByRoleId(Long roleId);

    /**
     * 通过职位id，查询出该职位在所有部门中配置的权限
     *
     * @param postId 职位id
     * @return
     */
    List<FrCorep> getAllDepartmentPostCorepByPostId(Long postId);
}
