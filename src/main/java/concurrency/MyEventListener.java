package concurrency;

import java.util.EventListener;

/**
 * @author lianghong
 * @date 2019/3/12
 */

public class MyEventListener implements EventListener{
    public void onEvent(Object object) {
        System.out.println(object);
    }
}
