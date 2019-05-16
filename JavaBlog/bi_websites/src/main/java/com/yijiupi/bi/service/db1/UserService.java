package com.yijiupi.bi.service.db1;

import com.yijiupi.bi.entity.User;
import com.yijiupi.bi.kit.easyui.EasyUiPage;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
public interface UserService  extends BaseService<User> {

    public User selectUserByUsername(String username);

    public EasyUiPage<User> page(EasyUiPage<User> page, User user);
    
}
