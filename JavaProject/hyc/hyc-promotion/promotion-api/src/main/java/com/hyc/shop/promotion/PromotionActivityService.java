package com.hyc.shop.promotion;


import com.hyc.shop.promotion.bo.PromotionActivityBO;
import com.hyc.shop.promotion.bo.PromotionActivityPageBO;
import com.hyc.shop.promotion.dto.PromotionActivityPageDTO;

import java.util.Collection;
import java.util.List;

public interface PromotionActivityService {

    List<PromotionActivityBO> getPromotionActivityListBySpuId(Integer spuId,
                                                              Collection<Integer> activityStatuses);

    List<PromotionActivityBO> getPromotionActivityListBySpuIds(Collection<Integer> spuIds,
                                                               Collection<Integer> activityStatuses);

    PromotionActivityPageBO getPromotionActivityPage(PromotionActivityPageDTO promotionActivityPageDTO);

}
