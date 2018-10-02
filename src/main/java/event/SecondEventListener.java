package event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 29/09/2018
 */

@Component
public class SecondEventListener implements ApplicationListener<SecondEvent> {
    @Override
    public void onApplicationEvent(SecondEvent secondEvent) {
        System.out.println("SecondEvent");
    }
}
