package event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 29/09/2018
 */

@Component
public class GlobalListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>event:" + event);
    }

}
