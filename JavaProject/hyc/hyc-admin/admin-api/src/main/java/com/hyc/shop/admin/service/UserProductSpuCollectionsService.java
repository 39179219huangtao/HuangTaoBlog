package com.hyc.shop.admin.service;


import com.hyc.shop.admin.bo.UserProductSpuCollectionsBO;
import com.hyc.shop.admin.dto.UserProductSpuCollectionsAddDTO;
import com.hyc.shop.admin.dto.UserProductSpuCollectionsUpdateDTO;

/**
 * UserProductSpuCollectionsService
 * @author xiaofeng
 * @date 2019/07/01 20:27
 * @version 1.0
 */
public interface UserProductSpuCollectionsService {

    /**
     * 添加商品收藏
     * @return
     */
    int addUserSkuCollections(UserProductSpuCollectionsAddDTO userProductSpuCollectionsAddDTO);

    /**
     * 获取用户商品收藏
     * @param userId 用户ID
     * @param spuId 商品ID
     * @return
     */
    UserProductSpuCollectionsBO getUserSpuCollectionsByUserIdAndSpuId(Integer userId, Integer spuId);

    /**
     * 取消商品收藏
     * @param userProductSpuCollectionsUpdateDTO
     * @return
     */
    int updateUserProductSpuCollections(UserProductSpuCollectionsUpdateDTO userProductSpuCollectionsUpdateDTO);

}
