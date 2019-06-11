package lock;

import io.netty.channel.nio.NioEventLoopGroup;
import lock.config.MicroLockConfig;
import lock.core.MicroLockAspectHandler;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import lock.core.BusinessKeyProvider;
import lock.core.LockInfoProvider;
import lock.lock.LockFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.ClassUtils;

/**
 * Created by kl on 2017/12/29.
 * Content :klock自动装配
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(MicroLockConfig.class)
@Import({MicroLockAspectHandler.class})
public class MicroLlockAutoConfiguration {

    @Autowired
    private MicroLockConfig microLockConfig;

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnMissingBean
    RedissonClient redisson() throws Exception {
        Config config = new Config();
        if (microLockConfig.getClusterServer() != null) {
            config.useClusterServers().setPassword(microLockConfig.getPassword())
                    .addNodeAddress(microLockConfig.getClusterServer().getNodeAddresses());
        } else {
            config.useSingleServer().setAddress(microLockConfig.getAddress())
                    .setDatabase(microLockConfig.getDatabase())
                    .setPassword(microLockConfig.getPassword());
        }
        Codec codec = (Codec) ClassUtils.forName(microLockConfig.getCodec(), ClassUtils.getDefaultClassLoader()).newInstance();
        config.setCodec(codec);
        config.setEventLoopGroup(new NioEventLoopGroup());
        return Redisson.create(config);
    }

    @Bean
    public LockInfoProvider lockInfoProvider() {
        return new LockInfoProvider();
    }

    @Bean
    public BusinessKeyProvider businessKeyProvider() {
        return new BusinessKeyProvider();
    }

    @Bean
    public LockFactory lockFactory() {
        return new LockFactory();
    }
}
