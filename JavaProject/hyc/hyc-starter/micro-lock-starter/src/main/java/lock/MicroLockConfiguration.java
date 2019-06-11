package lock;

import lock.config.MicroLockConfig;
import lock.core.BusinessKeyProvider;
import lock.core.LockInfoProvider;
import lock.core.MicroLockAspectHandler;
import lock.lock.LockFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by kl on 2017/12/29.
 * Content :适用于内部低版本spring mvc项目配置,redisson外化配置
 */
@Configuration
@Import({MicroLockAspectHandler.class})
public class MicroLockConfiguration {
    @Bean
    public LockInfoProvider lockInfoProvider(){
        return new LockInfoProvider();
    }

    @Bean
    public BusinessKeyProvider businessKeyProvider(){
        return new BusinessKeyProvider();
    }

    @Bean
    public LockFactory lockFactory(){
        return new LockFactory();
    }
    @Bean
    public MicroLockConfig klockConfig(){
        return new MicroLockConfig();
    }
}
