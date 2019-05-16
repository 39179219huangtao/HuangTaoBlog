package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.IconclsMenu;
import com.yijiupi.bi.service.db1.BaseService;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 11:16 2018/8/16
 * @Email: huangyuansheng@yijiupi.cn
 */
public interface IconClsMenuService extends BaseService<IconclsMenu> {

    IconclsMenu getByEntryId(Long entryId);

    boolean upsertIconByEntryId(IconclsMenu iconclsMenu);
}
