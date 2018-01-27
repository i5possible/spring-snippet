package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@PropertySource(value = "classpath:main.properties")
@Configuration
public class EnvironmentConfig {
}
