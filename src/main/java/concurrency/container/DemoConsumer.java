package concurrency.container;

import java.util.concurrent.BlockingQueue;

/**
 * @author lianghong
 * @date 2019/3/25
 */

public class DemoConsumer implements Runnable{
    private final BlockingQueue<DemoMessage> blockingQueue;

    public DemoConsumer(BlockingQueue<DemoMessage> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            DemoMessage message = blockingQueue.take();
            while ("exit" != message.name) {
                Thread.sleep(100);
                System.out.println("Consumed:" + message.name);
                message = blockingQueue.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
