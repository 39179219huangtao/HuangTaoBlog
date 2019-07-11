package com.hyc.shop.system.application.po.sms;


import com.hyc.shop.common.validator.InEnum;
import com.hyc.shop.system.constant.SmsPlatformEnum;
import com.hyc.shop.system.constant.SmsTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 短信模板 add
 *
 * @author Sin
 * @time 2019/5/26 12:37 PM
 */
@ApiModel("短信模板-添加")
@Data
@Accessors(chain = true)
public class SmsTemplateUpdatePO implements Serializable {

    @ApiModelProperty("短信模板id")
    @NotNull(message = "短信模板不能为空!")
    private Integer id;

    @ApiModelProperty("短信签名id")
    @NotNull(message = "短信短信签名id不能为空!")
    private Integer smsSignId;

    @ApiModelProperty("短信模板code")
    @NotNull
    @Size(min = 3, max = 50, message = "短信code在 3-50 之间")
    private String templateCode;

    @ApiModelProperty("短信模板")
    @NotNull
    @Size(min = 3, max = 255, message = "短信在 3-255 之间")
    private String template;

    @ApiModelProperty("短信模板-平台")
    @NotNull
    @InEnum(value = SmsPlatformEnum.class)
    private Integer platform;

    @ApiModelProperty("短信模板-平台")
    @NotNull
    @InEnum(value = SmsTypeEnum.class)
    private Integer smsType;
}
