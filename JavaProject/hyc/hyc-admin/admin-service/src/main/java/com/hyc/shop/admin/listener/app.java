package com.hyc.shop.admin.listener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program hyc
 * @description:
 * @author: huangtao
 * @create: 2019/05/16 17:22
 */

public class app {
    public static void main(String[] args) {
        final ArrayList<String> strings = new ArrayList<>();
        final HashMap<String, String> stringStringHashMap = new HashMap<>();
        strings.stream().forEach(e->{
            stringStringHashMap.put(e,e);
        });
    }
}
