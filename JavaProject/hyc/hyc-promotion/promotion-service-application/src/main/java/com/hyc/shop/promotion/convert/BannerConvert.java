package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.BannerBO;
import com.hyc.shop.promotion.bo.BannerPageBO;
import com.hyc.shop.promotion.vo.admins.AdminsBannerPageVO;
import com.hyc.shop.promotion.vo.admins.AdminsBannerVO;
import com.hyc.shop.promotion.vo.users.UsersBannerVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface BannerConvert {

    Users USERS = Mappers.getMapper(Users.class);

    Admins ADMINS = Mappers.getMapper(Admins.class);

    @Mapper
    interface Admins {

        @Mappings({})
        AdminsBannerVO convert(BannerBO bannerBO);

        @Mappings({})
        AdminsBannerPageVO convert3(BannerPageBO bannerPageBO);

    }

    @Mapper
    interface Users {

        @Mappings({})
        List<UsersBannerVO> convertList(List<BannerBO> banners);

    }

}
