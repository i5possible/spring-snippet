package concurrency.escape;

import java.util.List;

/**
 * @author lianghong
 * @date 2019/3/12
 */

public class ListenerRunnable implements Runnable {

    private EventSource<MyEventListener> source;

    public ListenerRunnable(EventSource<MyEventListener> source) {
        this.source = source;
    }

    @Override
    public void run() {
        List<MyEventListener> listeners = null;

        try {
            listeners = this.source.retrieveListeners();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (MyEventListener listener : listeners) {
            listener.onEvent(new Object());
        }
    }
}
