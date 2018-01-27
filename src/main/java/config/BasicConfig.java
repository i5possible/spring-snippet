package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianghong
 * @date 27/01/2018
 */


@ComponentScans(value = {
        @ComponentScan(basePackages = {"beans.always"}),
        @ComponentScan(value = {"beans.auto"})
})
@Configuration
public class BasicConfig {
}
