package com.hyc.shop.system.domain.convert;


import com.hyc.shop.system.bo.sms.PageSmsTemplateBO;
import com.hyc.shop.system.bo.sms.SmsTemplateBO;
import com.hyc.shop.system.domain.dataobject.SmsSignDO;
import com.hyc.shop.system.domain.dataobject.SmsTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信 template
 *
 * @author Sin
 * @time 2019/5/16 7:43 PM
 */
@Mapper
public interface SmsTemplateConvert {

    SmsTemplateConvert INSTANCE = Mappers.getMapper(SmsTemplateConvert.class);

    @Mappings({})
    SmsTemplateBO convert(SmsTemplateDO smsTemplateDO);

    @Mappings({})
    List<PageSmsTemplateBO.Template> convert(List<SmsTemplateDO> smsTemplateDOList);

    @Mappings({})
    List<PageSmsTemplateBO.Sign> convertTemplateSign(List<SmsSignDO> smsSignDOList);
}
