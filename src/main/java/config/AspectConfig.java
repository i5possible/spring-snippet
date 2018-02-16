package config;

import aop.Audience;
import aop.AudiencePlus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"aop"})
public class AspectConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public AudiencePlus audiencePlus() {
        return new AudiencePlus();
    }
}
