package concurrency.latch;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lianghong
 * @date 2019/5/4
 */

public class CDLatch {
    private static int count;
    private final CountDownLatch startGate;
    private final CountDownLatch endGate;

    public CDLatch(CountDownLatch startGate, CountDownLatch latch) {
        this.startGate = startGate;
        this.endGate = latch;
    }

    public void await() {
        try {
            startGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countDown() {
        monitor();
        endGate.countDown();
    }

    private void monitor() {
        if (endGate.getCount() == 5) {
            System.out.println("There is only 5 remain.");
        }
        if (endGate.getCount() <= 5) {
            System.out.println(endGate.getCount() + "...");
        }
    }

    public static void main(String[] args) {
        count = 10;
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(count);
        CDLatch cdLatch = new CDLatch(startGate, endGate);
        ThreadPoolExecutor cdPools = new ThreadPoolExecutor(5, count, 6000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new BasicThreadFactory.Builder().build());
        for (int i = 0; i < count; i++) {
            cdPools.submit(new CDThread(cdLatch));
        }

        long start = System.nanoTime();
        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("Time used:" + (end - start)/(1000 * 1000 * 1000) + "s");
    }
}
