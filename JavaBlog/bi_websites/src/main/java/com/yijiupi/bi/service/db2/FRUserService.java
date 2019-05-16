package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.dto.AdminUser;
import com.yijiupi.bi.dto.JiupiCity;
import com.yijiupi.bi.entity.FrUser;
import com.yijiupi.bi.entity.User;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.service.db1.BaseService;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
public interface FRUserService extends BaseService<FrUser> {

    int syncUser(List<AdminUser> adminUsers);

    int syncUserDepartmentPos(List<AdminUser> adminUsers);

    FrUser getFrUser(FrUser model, String... attrs);

    void updateFrUserById(FrUser frUser);

    void insertFrUserOrUpdate(FrUser frUser);

    EasyUiPage<FrUser> getFrUserList(EasyUiPage<FrUser> pageInfo, FrUser frUser, String... attrs);
}
