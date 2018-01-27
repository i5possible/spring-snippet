package config;

import beans.profile.DevBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Configuration
@Profile("dev")
public class DevConfig {
    @Bean
    public DevBean devBean(){
        return new DevBean();
    }
}
