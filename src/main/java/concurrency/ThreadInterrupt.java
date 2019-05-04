package concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * @author lianghong
 * @date 2019/5/4
 */

public class ThreadInterrupt implements Runnable {
    BlockingQueue<Runnable> queue;

    @Override
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {

            // 必须捕获不能继续抛，调用当前线程上的interrupt方法恢复中断状态
            Thread.currentThread().interrupt();
        }
    }

    /**
     * InterruptedException 不捕获，交给上层处理
     * @param take
     * @throws InterruptedException
     */
    private void processTask(Runnable take) throws InterruptedException{
        take.run();
        throw new InterruptedException();
    }
}
