package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.dto.JiupiCity;
import com.yijiupi.bi.entity.FrCustomRoleUser;
import com.yijiupi.bi.entity.FrDepartment;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2
 * @Description:
 * @date 2018/7/25  18:46
 */
public interface FRDepartmentService extends BaseService<FrDepartment> {

    int syncUserDepartment(List<JiupiCity> jiupiCities);
}
