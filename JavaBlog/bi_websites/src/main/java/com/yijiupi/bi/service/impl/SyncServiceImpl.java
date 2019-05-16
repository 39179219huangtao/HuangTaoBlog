package com.yijiupi.bi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yijiupi.bi.dto.AdminUser;
import com.yijiupi.bi.dto.JiupiCity;
import com.yijiupi.bi.entity.FrPost;
import com.yijiupi.bi.service.SyncService;
import com.yijiupi.bi.service.db2.FRDepartmentService;
import com.yijiupi.bi.service.db2.FRPostService;
import com.yijiupi.bi.service.db2.FRUserService;
import com.yijiupi.bi.utils.HttpClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SyncServiceImpl implements SyncService {

    private static Logger log = LoggerFactory.getLogger(SyncServiceImpl.class);

    @Value("${opUrl}")
    private String opUrl;
    @Autowired
    FRUserService frUserService;

    @Autowired
    FRDepartmentService frDepartmentService;

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private FRPostService frPostService;

    @Override
    public void syncAllUser() {
        String url = opUrl + "/adminUser/list";
        Map<String, Object> params = Maps.newHashMap();
        params.put("pageSize", 1);
        params.put("currentPage", 1);
        String adminUser = httpClientService.doPost(url, params, String.class);
        JSONObject result = JSON.parseObject(adminUser);
        JSONObject data = result.getJSONObject("data");
        JSONObject pager = data.getJSONObject("pager");
        //每页显示的记录数
        int pageSize = 100;
        //总记录数
        int rows = pager.getIntValue("recordCount");
        if (rows > 0) {
            //页数
            int pageSum = (rows - 1) / pageSize + 1;
            // 分页获取用户
            for (int i = 1; i <= pageSum; i++) {
                syncEachPageUser(pageSize, i);
            }
        }
    }

    /**
     * 同步用户，当页出错不影响其他页继续处理
     * @param pageSize
     * @param currentPage
     */
    private void syncEachPageUser(int pageSize, int currentPage) {
        try {
            String url = opUrl + "/adminUser/list";
            Map<String, Object> params = Maps.newHashMap();
            params.put("pageSize", pageSize);
            params.put("currentPage", currentPage);
            String adminUser = httpClientService.doPost(url, params, String.class);
            JSONObject result = JSON.parseObject(adminUser);
            JSONObject data = result.getJSONObject("data");
            JSONArray dataList = data.getJSONArray("dataList");
            List<AdminUser> adminUserList = Lists.newArrayList();
            dataList.forEach(e -> {
                AdminUser adminUser1 = JSONObject.parseObject(JSON.toJSONString(e), AdminUser.class);
                adminUserList.add(adminUser1);
            });
            int sysUserCount = frUserService.syncUser(adminUserList);
            log.debug("共新增或者删除了{}个用户",sysUserCount);
            int sysUserDepartmentCount = frUserService.syncUserDepartmentPos(adminUserList);
            log.debug("共同步了{}个岗位",sysUserDepartmentCount);
        }
        catch (Exception ex){
            log.error("在处理第{}页{}条数用户信息时出错",currentPage,pageSize, ex);
        }
    }

    @Override
    public void syncAllDepartment() {
        String url = opUrl + "/adminUser/allJiupiCity/list";
        String jiupiCityStr = httpClientService.doGet(url, String.class);

        JSONObject result = JSON.parseObject(jiupiCityStr);
        JSONArray dataList = result.getJSONArray("data");

        List<JiupiCity> jiupiCityList = Lists.newArrayList();
        //0号时特殊城市，自动添加0号城市
        JiupiCity zeroCity = new JiupiCity();
        zeroCity.setId(0);
        zeroCity.setName("总部城市");
        jiupiCityList.add(zeroCity);

        dataList.forEach(e -> {
            JiupiCity jiupiCity = JSONObject.parseObject(JSON.toJSONString(e), JiupiCity.class);
            jiupiCityList.add(jiupiCity);
        });
        log.debug("准备同步城市:{}", JSON.toJSONString(jiupiCityList));
        int successCount = frDepartmentService.syncUserDepartment(jiupiCityList);
        log.debug("成功过同步了{}个城市", successCount);
    }

    @Override
    public void syncAllPost() {
        String url = opUrl + "/adminUser/userRole/list";
        String result = httpClientService.doGet(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Map<String, String> data = JSONObject.parseObject(jsonObject.get("data").toString(), Map.class);
        List<FrPost> frPosts = new ArrayList<>();
        data.entrySet().forEach(x -> {
            FrPost frPost = new FrPost();
            frPost.setPostname(x.getValue());
            frPost.setDescription(x.getKey());
            frPosts.add(frPost);
        });
        log.info("准备同步城市角色:{}", JSON.toJSONString(frPosts));
        int successCount = frPostService.syncFineBiPost(frPosts);
        log.debug("成功过同步了{}个城市", successCount);
    }
}
