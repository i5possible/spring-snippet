package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Configuration
@Import({BasicConfig.class})
@ImportResource(value = {"classpath:application-other.xml"})
public class MixedConfig {
}
