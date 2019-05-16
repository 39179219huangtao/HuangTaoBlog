package com.yijiupi.bi.config;

import com.yijiupi.bi.constant.DBTypeEnum;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.constant
 * @Description:
 * @date 2018/7/23  16:18
 */
@Component
@Aspect
@Order(-100) //这是为了保证AOP在事务注解之前生效,Order的值越小,优先级越高
public class DataSourceSwitchAspect {

    private Logger logger = LoggerFactory.getLogger(DataSourceSwitchAspect.class);

    @Pointcut("execution(* com.yijiupi.bi.service.db1..*(..))")
    private void db1Aspect() {
    }

    @Pointcut("execution(* com.yijiupi.bi.service.db2..*(..))")
    private void db2Aspect() {
    }

    @Before("db1Aspect()")
    public void db1() {
        logger.debug("切换到db1 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.db1);
    }

    @Before("db2Aspect()")
    public void debug() {
        logger.debug("切换到db2 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.db2);
    }

}





