package config;

import beans.other.AhaBean;
import condition.EnvCondition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Configuration
public class ConditionConfig {
    @Bean
    @Qualifier()
    @Conditional(EnvCondition.class)
    public AhaBean ahaBean() {
        return new AhaBean();
    }

}
