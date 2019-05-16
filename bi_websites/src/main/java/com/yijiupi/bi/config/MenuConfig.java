package com.yijiupi.bi.config;

import com.yijiupi.bi.entity.AllFrMenu;
import com.yijiupi.bi.service.db2.FrFolderentryService;
import com.yijiupi.bi.service.db2.IconClsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 13:51 2018/8/8
 * @Email: huangyuansheng@yijiupi.cn
 */
@Configuration
public class MenuConfig {
    @Autowired
    private FrFolderentryService folderentryService;

    @Autowired
    private IconClsService iconClsService;

    @Autowired
    private AllFrMenu allFrMenu;

    @Bean
    public AllFrMenu initAllFrMenu() throws UnsupportedEncodingException {
        allFrMenu.setAllFrMenu(allFrMenu.transUrl(folderentryService.loadAllMenu()));
        allFrMenu.setAllIconCls(iconClsService.getAllIconCls());
        return allFrMenu;
    }
}
