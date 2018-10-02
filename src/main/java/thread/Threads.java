package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Threads implements Runnable{

    private int count = 0;
    public static void main(String[] args) throws InterruptedException {
//        sleepTest();
        runnableTest();
    }

    public static void sleepTest() throws InterruptedException {
        new Threads().runNewThread();
        // thread manager will start the new thread before the main thread end because of the sleep.
        Thread.sleep(1);
        System.out.println("sleep");
    }

    public void runNewThread() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

    public void runThreadInPool() {
    }

    public static void runnableTest() {
        // thread created using runnable share the data
        Threads threads = new Threads();
        new Thread(threads).start();
        new Thread(threads).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(++count);
    }
}
