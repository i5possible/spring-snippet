package event;

import org.springframework.context.ApplicationEvent;

/**
 * @author lianghong
 * @date 29/09/2018
 */

public class SecondEvent extends ApplicationEvent {
    public SecondEvent(Object source) {
        super(source);
    }
}
