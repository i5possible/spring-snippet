package concurrency;

/**
 * @author lianghong
 * @date 2019/3/12
 */

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            System.out.println("ready:" + ready);
            System.out.println("number:" + number);
            while (!ready) {
                Thread.yield();
                System.out.println("number:" + number);
            }
        }
    }

    /**
     * Run many times, you will find the output is different
     * The number can be 42 or 0 when the ready is set to true
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1);
        number = 42;
        ready = true;
    }
}
