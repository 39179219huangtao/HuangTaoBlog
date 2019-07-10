package com.hyc.shop.admin.service;


import com.hyc.shop.admin.bo.UserProductSpuCollectionsBO;
import com.hyc.shop.admin.domain.convert.UserProductSpuCollectionsConvert;
import com.hyc.shop.admin.domain.dao.UserProductSpuCollectionsMapper;
import com.hyc.shop.admin.domain.dataobject.UserProductSpuCollectionsDO;
import com.hyc.shop.admin.dto.UserProductSpuCollectionsAddDTO;
import com.hyc.shop.admin.dto.UserProductSpuCollectionsUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserSkuCollectionsServiceImpl
 * @author xiaofeng
 * @date 2019/07/01 21:02
 * @version 1.0
 */
@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.UserProductSpuCollectionsService.version}")
public class UserProductSpuCollectionsServiceImpl implements UserProductSpuCollectionsService {


    @Autowired
    private UserProductSpuCollectionsMapper userProductSpuCollectionsMapper;


    @Override
    public int addUserSkuCollections(UserProductSpuCollectionsAddDTO userProductSpuCollectionsAddDTO) {
        return userProductSpuCollectionsMapper
                .insert(UserProductSpuCollectionsConvert.INSTANCE.convert(userProductSpuCollectionsAddDTO));
    }

    @Override
    public UserProductSpuCollectionsBO getUserSpuCollectionsByUserIdAndSpuId(Integer userId, Integer spuId) {
        UserProductSpuCollectionsDO userProductSpuCollectionsDO = userProductSpuCollectionsMapper
                .getUserSpuCollectionsByUserIdAndSpuId(userId, spuId);
        return UserProductSpuCollectionsConvert.INSTANCE.convert(userProductSpuCollectionsDO);
    }

    @Override
    public int updateUserProductSpuCollections(UserProductSpuCollectionsUpdateDTO userProductSpuCollectionsUpdateDTO) {
        return userProductSpuCollectionsMapper
                .updateById(UserProductSpuCollectionsConvert.INSTANCE.convert(userProductSpuCollectionsUpdateDTO));
    }


}
