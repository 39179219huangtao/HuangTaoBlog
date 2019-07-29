package com.hyc.shop.promotion;



import com.hyc.shop.common.constant.CommonStatusEnum;
import com.hyc.shop.common.validator.InEnum;
import com.hyc.shop.promotion.bo.BannerBO;
import com.hyc.shop.promotion.bo.BannerPageBO;
import com.hyc.shop.promotion.dto.BannerAddDTO;
import com.hyc.shop.promotion.dto.BannerPageDTO;
import com.hyc.shop.promotion.dto.BannerUpdateDTO;

import java.util.List;

public interface BannerService {

    List<BannerBO> getBannerListByStatus(Integer status);

    BannerPageBO getBannerPage(BannerPageDTO bannerPageDTO);

    BannerBO addBanner(Integer adminId, BannerAddDTO bannerAddDTO);

    Boolean updateBanner(Integer adminId, BannerUpdateDTO bannerUpdateDTO);

    Boolean updateBannerStatus(Integer adminId, Integer bannerId,
                               @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}") Integer status);

    Boolean deleteBanner(Integer adminId, Integer bannerId);

}
