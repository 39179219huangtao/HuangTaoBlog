package com.hyc.shop.product.impl;


import com.hyc.shop.common.util.ServiceExceptionUtil;
import com.hyc.shop.product.constants.ProductErrorCodeEnum;
import com.hyc.shop.product.domain.dao.ProductSpuMapper;
import com.hyc.shop.product.domain.dataobject.ProductSpuDO;
import com.hyc.shop.product.message.ProductSpuCollectionMessage;
import com.hyc.shop.product.service.ProductSpuCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ProductSpuCollectionServiceImpl
 * @author xiaofeng
 * @date 2019/07/01 23:14
 * @version 1.0
 */
@Service // 实际上不用添加。添加的原因是，必须 Spring 报错提示
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.ProductSpuCollectionService.version}")
public class ProductSpuCollectionServiceImpl implements ProductSpuCollectionService {

    @Autowired
    private ProductSpuMapper productSpuMapper;

//    @Resource
//    private RocketMQTemplate rocketMQTemplate;


    @Override
    public boolean productSpuCollection(Integer spuId, Integer hasCollectionType, Integer userId) {
        ProductSpuDO productSpuDO = this.productSpuMapper.selectById(spuId);
        // 校验 Spu 是否存在
        if (productSpuDO == null) {
            throw ServiceExceptionUtil.exception(ProductErrorCodeEnum.PRODUCT_SPU_NOT_EXISTS.getCode());
        }
        this.sendProductSpuCollectionMessage(productSpuDO, hasCollectionType, userId);
        return Boolean.TRUE;
    }

    /**
     * 发送商品收藏或取消消息
     * @param productSpuDO
     * @param hasCollectionType
     */
    private void sendProductSpuCollectionMessage(final ProductSpuDO productSpuDO, final Integer hasCollectionType,
            final Integer userId) {
        ProductSpuCollectionMessage productSpuCollectionMessage = new ProductSpuCollectionMessage()
                .setSpuId(productSpuDO.getId()).setSpuName(productSpuDO.getName())
                .setSpuImage(productSpuDO.getPicUrls()).setHasCollectionType(hasCollectionType)
                .setUserId(userId);
        //rocketMQTemplate.convertAndSend(ProductSpuCollectionMessage.TOPIC, productSpuCollectionMessage);
    }
}
