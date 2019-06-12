package com.hyc.shop.lock;

//import com.hyc.shop.lock.config.MicroLockConfig;
//import com.hyc.shop.lock.core.BusinessKeyProvider;
//import com.hyc.shop.lock.core.LockInfoProvider;
//import com.hyc.shop.lock.core.MicroLockAspectHandler;
//import com.hyc.shop.lock.lock.LockFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
///**
// * @description:适用于内部低版本spring mvc项目配置,redisson外化配置
// * @author: huangtao
// * @date: 2019/6/12
// */
//@Configuration
//@Import({MicroLockAspectHandler.class})
//public class MicroLockConfiguration {
//    @Bean
//    public LockInfoProvider lockInfoProvider(){
//        return new LockInfoProvider();
//    }
//
//    @Bean
//    public BusinessKeyProvider businessKeyProvider(){
//        return new BusinessKeyProvider();
//    }
//
//    @Bean
//    public LockFactory lockFactory(){
//        return new LockFactory();
//    }
//    @Bean
//    public MicroLockConfig microLockConfig(){
//        return new MicroLockConfig();
//    }
//}
