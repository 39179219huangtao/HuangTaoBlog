package com.hyc.shop.system.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyc.shop.system.domain.dataobject.SmsSendLogDO;
import org.springframework.stereotype.Repository;

/**
 * 短信
 *
 * @author Sin
 * @time 2019/5/16 6:18 PM
 */
@Repository
public interface SmsSendMapper extends BaseMapper<SmsSendLogDO> {
}
