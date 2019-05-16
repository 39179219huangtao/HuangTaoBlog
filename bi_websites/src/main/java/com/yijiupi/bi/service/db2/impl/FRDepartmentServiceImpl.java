package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import com.yijiupi.bi.dto.JiupiCity;
import com.yijiupi.bi.entity.FrCustomRoleUser;
import com.yijiupi.bi.entity.FrDepartment;
import com.yijiupi.bi.mapper.FrCustomRoleUserMapper;
import com.yijiupi.bi.mapper.FrDepartmentMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FRCustomRoleUserService;
import com.yijiupi.bi.service.db2.FRDepartmentService;
import com.yijiupi.bi.utils.HttpUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2.impl
 * @Description:
 * @date 2018/7/25  18:49
 */
@Service
public class FRDepartmentServiceImpl extends BaseServiceImpl<FrDepartmentMapper, FrDepartment> implements FRDepartmentService {

    private static Logger log = LoggerFactory.getLogger(FRUserServiceImpl.class);

    @Value("${yjp.fineBi.serverUrl}")
    private String serverUrl;
    @Value("${yjp.fineBi.adminPassword}")
    private String adminPassword;

    @Override
    public int syncUserDepartment(List<JiupiCity> jiupiCities) {
        List<FrDepartment> frDepartments = Lists.newArrayList();
        for (JiupiCity jiupiCity : jiupiCities) {
            EntityWrapper<FrDepartment> departmentwrapper = new EntityWrapper<>();
            departmentwrapper.eq("name", String.valueOf(jiupiCity.getId()));
            Integer num = selectCount(departmentwrapper);
            if (0 == num) {
                FrDepartment frDepartment = new FrDepartment();
                frDepartment.setPid(-1L);
                frDepartment.setName(String.valueOf(jiupiCity.getId()));
                frDepartment.setDescription(jiupiCity.getName());
                frDepartments.add(frDepartment);
            }
        }
        // 同步部门
        if (CollectionUtils.isNotEmpty(frDepartments)) {
            insertBatch(frDepartments);
            HttpUtils.resetCache(serverUrl,adminPassword);
        }
        return frDepartments.size();
    }
}
