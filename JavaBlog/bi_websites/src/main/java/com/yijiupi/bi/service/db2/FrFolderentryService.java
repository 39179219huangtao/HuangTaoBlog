package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrFolderMenu;
import com.yijiupi.bi.entity.FrFolderentry;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:56 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
public interface FrFolderentryService extends BaseService<FrFolderentry> {

    FrFolderentry getFolderentryById(Integer id);

    /**
     * 初始化所有菜单
     *
     * @return 菜单
     */
    List<FrFolderMenu> loadAllMenu();
}
