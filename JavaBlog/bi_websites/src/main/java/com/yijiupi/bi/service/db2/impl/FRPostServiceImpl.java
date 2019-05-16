package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import com.yijiupi.bi.entity.FrCustomRoleUser;
import com.yijiupi.bi.entity.FrDepartmentPostUser;
import com.yijiupi.bi.entity.FrPost;
import com.yijiupi.bi.entity.FrRole;
import com.yijiupi.bi.mapper.FrCustomRoleUserMapper;
import com.yijiupi.bi.mapper.FrDepartmentPostUserMapper;
import com.yijiupi.bi.mapper.FrPostMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FRCustomRoleUserService;
import com.yijiupi.bi.service.db2.FRDepartmentPostUserService;
import com.yijiupi.bi.service.db2.FRPostService;
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
public class FRPostServiceImpl extends BaseServiceImpl<FrPostMapper, FrPost> implements FRPostService {

    @Override
    public int syncFineBiPost(List<FrPost> frPosts) {
        List<FrPost> needInsterPostList = Lists.newArrayList();
        for (FrPost frPost : frPosts) {
            EntityWrapper<FrPost> wrapper = new EntityWrapper<>();
            wrapper.eq("postname",frPost.getPostname());
            Integer num = baseMapper.selectCount(wrapper);
            System.out.println(num);
            if(0==num){
                needInsterPostList.add(frPost);
            }
        }
        insertBatch(needInsterPostList);
        return needInsterPostList.size();
    }
}
