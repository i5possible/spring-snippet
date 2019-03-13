package concurrency;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * Volatile
 * @author lianghong
 * @date 2019/3/12
 */

@NotThreadSafe
public class CountSheep {
//    private static boolean asleep = false;

    private volatile static boolean asleep = false;
    private static int count;

    static {
        Thread thread = new Thread(() -> {
            System.out.println("asleep:" + asleep);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CountSheep.asleep = true;
            System.out.println("asleep:" + asleep);
        });
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        while (!asleep) {
            count++;
            System.out.println("count:" + count);
        }

    }
}
