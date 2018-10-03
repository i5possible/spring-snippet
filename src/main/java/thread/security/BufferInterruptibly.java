package thread.security;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lianghong
 * @date 03/10/2018
 */

// Bocking Synchronization, Pessimistic lock
public class BufferInterruptibly {
    private ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();
        try {
            long l = System.currentTimeMillis();
            System.out.println("write in buff");

            for (; ; ) {
                if (System.currentTimeMillis() - l > Integer.MAX_VALUE) {
                    break;
                }
            }
            System.out.println("write over");
        } finally {
            lock.unlock();
        }
    }

    public void tryLock() throws InterruptedException {
        long timeout = 60000;
        if (lock.tryLock(timeout, TimeUnit.MILLISECONDS)) {
            System.out.println("do something");
            lock.unlock();
        } else {
            System.out.println("tryLock can't get lock");
        }
    }

    public void read() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("write from buffer");
        } finally {
            lock.unlock();
        }
    }
}
