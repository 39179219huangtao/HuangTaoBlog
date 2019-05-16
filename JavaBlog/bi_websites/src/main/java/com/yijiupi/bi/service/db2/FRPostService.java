package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrPost;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2
 * @Description:
 * @date 2018/7/25  18:46
 */
public interface FRPostService extends BaseService<FrPost> {
    int syncFineBiPost(List<FrPost> frPosts);
}
