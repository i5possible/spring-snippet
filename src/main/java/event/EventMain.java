package event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lianghong
 * @date 29/09/2018
 */

public class EventMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-event.xml");
        final CustomizePublisher customizePublisher = context.getBean(CustomizePublisher.class);
        customizePublisher.publish(new FirstEvent("first event"));
        customizePublisher.publish(new SecondEvent("second event"));
    }
}
