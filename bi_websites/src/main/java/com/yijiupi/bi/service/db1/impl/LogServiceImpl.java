package com.yijiupi.bi.service.db1.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yijiupi.bi.entity.Log;
import com.yijiupi.bi.mapper.LogDao;
import com.yijiupi.bi.service.db1.LogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志文件 服务实现类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogDao, Log> implements LogService {

}
