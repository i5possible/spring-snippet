package concurrency;

import net.jcip.annotations.GuardedBy;

/**
 * This class is synchronized compared with MutableInteger
 * @author lianghong
 * @date 2019/3/12
 */

public class SynchronizedInteger {

    @GuardedBy("this") private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
