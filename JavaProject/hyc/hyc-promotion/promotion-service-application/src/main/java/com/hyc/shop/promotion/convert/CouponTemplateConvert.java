package com.hyc.shop.promotion.convert;


import com.hyc.shop.promotion.bo.CouponTemplateBO;
import com.hyc.shop.promotion.bo.CouponTemplatePageBO;
import com.hyc.shop.promotion.vo.admins.AdminsCouponTemplatePageVO;
import com.hyc.shop.promotion.vo.admins.AdminsCouponTemplateVO;
import com.hyc.shop.promotion.vo.users.UsersCouponTemplateVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CouponTemplateConvert {

    Users USERS = Mappers.getMapper(Users.class);

    Admins ADMINS = Mappers.getMapper(Admins.class);

    @Mapper
    interface Admins {

        @Mappings({})
        AdminsCouponTemplateVO convert(CouponTemplateBO template);

        @Mappings({})
        AdminsCouponTemplatePageVO convertPage(CouponTemplatePageBO result);

        @Mappings({})
        List<AdminsCouponTemplateVO> convertList(List<CouponTemplateBO> templates);

    }

    @Mapper
    interface Users {

        @Mappings({})
        UsersCouponTemplateVO convert2(CouponTemplateBO template);

    }

}
