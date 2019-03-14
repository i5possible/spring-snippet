package concurrency.extend;

import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for list.
 * @author lianghong
 * @date 2019/3/14
 */

@ThreadSafe
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    /**
     * Not Thread Safe
     * synchronized (ListHelper) not the list
     * @param x
     * @return
     */
    public synchronized boolean putIfAbsentWrong(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }

    /**
     * Thread Safe
     * @param x
     * @return
     */
    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }

}
