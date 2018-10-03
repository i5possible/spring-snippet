package thread.security;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lianghong
 * @date 03/10/2018
 */

public class UnblockSynchronization {
    /**
     *
     * Retry Strategy
     *
     * Test and Set
     * Fetch and Increment
     * Swap
     * Compare and Swap, Abbr:CAS
     * Load Linked, Store-conditional, Abbr: LL,SC
     */

    /**
     * 对于可见性，Java提供了volatile关键字来保证可见性。
     * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
     * 而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，此时内存中可能还是原来的旧值，因此无法保证可见性。
     */
    private volatile int count = 0;
    private AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
    }

    public synchronized void increment() {
        this.count++;
    }

    public void atomicIncrement() {
        this.atomicCount.getAndIncrement();
    }
}
