package concurrency.container;

import java.util.concurrent.BlockingQueue;

/**
 * @author lianghong
 * @date 2019/3/25
 */

public class DemoProducer implements Runnable{

    private final BlockingQueue<DemoMessage> blockingQueue;

    public DemoProducer(BlockingQueue<DemoMessage> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            DemoMessage msg = new DemoMessage("" + i);
            try {
                blockingQueue.put(msg);
                System.out.println("Produced:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Produce Interrupted");
            }
        }
        DemoMessage exit = new DemoMessage("exit");
        try {
            blockingQueue.put(exit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
