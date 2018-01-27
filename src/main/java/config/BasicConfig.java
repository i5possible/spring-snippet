package config;

import beans.always.BasicBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianghong
 * @date 27/01/2018
 */


@ComponentScans(value = {
        @ComponentScan(value = {"beans.auto"})
})
@Configuration
public class BasicConfig {
    @Bean
    public BasicBean basicBean(){
        return new BasicBean();
    }
}
