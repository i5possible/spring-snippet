package concurrency.container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lianghong
 * @date 2019/3/25
 */

public class DemoManagerServices {
    static {
        ArrayBlockingQueue<DemoMessage> blockingQueue = new ArrayBlockingQueue<>(10);
        DemoProducer demoProducer = new DemoProducer(blockingQueue);
        DemoConsumer demoConsumer = new DemoConsumer(blockingQueue);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                6000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

        executor.submit(demoConsumer);
        executor.submit(demoProducer);
    }

    public static void main(String[] args) {

    }
}
