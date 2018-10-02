package event;

import org.springframework.context.ApplicationEvent;

/**
 * @author lianghong
 * @date 29/09/2018
 */


public class FirstEvent extends ApplicationEvent {
    public FirstEvent(Object source) {
        super(source);
    }
}
