package concurrency.latch;

/**
 * @author lianghong
 * @date 2019/5/4
 */

public class CDThread implements Runnable{
    private final CDLatch latch;

    public CDThread(CDLatch endgate) {
        this.latch = endgate;
    }

    @Override
    public void run() {
        try {
            latch.await();
            Thread.sleep(Math.round(Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
