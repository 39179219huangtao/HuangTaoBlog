package com.yijiupi.bi.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yijiupi.bi.utils.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 21:28 2018/8/7
 * @Email: huangyuansheng@yijiupi.cn
 */
@Component
public class AllFrMenu {
    @Value("${yjp.fineBi.serverUrl}")
    private String serverUrl;

    private List<FrFolderMenu> allFrMenu;

    private List<Iconcls> allIconCls;

    public List<FrFolderMenu> getAllFrMenu() {
        return allFrMenu;
    }

    public synchronized void setAllFrMenu(List<FrFolderMenu> allFrMenu) {
        this.allFrMenu = allFrMenu;
    }

    /**
     * 获取一个克隆的列表
     *
     * @return
     */
    public List<FrFolderMenu> getAllCloneFrMenuList() {
        List<FrFolderMenu> returnList = new ArrayList<>();
        for (FrFolderMenu menu : allFrMenu) {
            returnList.add(menu.clone());
        }
        return returnList;
    }

    public List<Iconcls> getAllIconCls() {
        return allIconCls;
    }

    public void setAllIconCls(List<Iconcls> allIconCls) {
        this.allIconCls = allIconCls;
    }

    /**
     * 转换菜单url连接，将cpt和frm结尾的加上特殊的FineBI命令
     *
     * @param frFolderMenus 菜单 list
     * @return 转换后的菜单list
     */
    public List<FrFolderMenu> transUrl(List<FrFolderMenu> frFolderMenus) throws UnsupportedEncodingException {
        for (FrFolderMenu menu : frFolderMenus) {
            String menuUrl = menu.getUrl();
            if (!"".equals(menuUrl)) {
                String[] urlSplit = menuUrl.split("\\.");
                String suffix = urlSplit[urlSplit.length - 1];
                menu.setUrlStr(menuUrl);
                if ("cpt".equals(suffix)) {
                    menuUrl = URLEncoder.encode(menuUrl, "UTF-8");
                    menu.setUrl(this.serverUrl + "?reportlet=" + menuUrl);
                }
                if ("frm".equals(suffix)) {
                    menuUrl = URLEncoder.encode(menuUrl, "UTF-8");
                    menu.setUrl(this.serverUrl + "?formlet=" + menuUrl);
                }
            }
            if (null != menu.getUpdateTime()) {
                menu.setUpdateTimeStr(DateUtils.transDateToString(menu.getUpdateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS));
            }

            if (null != menu.getParameters() && !"".equals(menu.getParameters()) && !"[]".equals(menu.getParameters())) {
                JSONArray parameters = JSONObject.parseArray(menu.getParameters());
                JSONObject result;
                String url;
                for (int i = 0; i < parameters.size(); i++) {
                    result = parameters.getJSONObject(i);
                    url = menu.getUrl() + "&" + result.getString("name") + "=" + result.getString("value");
                    menu.setUrl(url);
                }
            }

            if (menu.getIsView().equals(1)) {
                menu.setUrl(menu.getUrl() + "&op=view");
            }
        }
        return frFolderMenus;
    }
}
