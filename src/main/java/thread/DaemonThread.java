package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {}
        });
        // if t.setDaemon(false), this program won't stop
        t.setDaemon(true);
        t.join();
        t.start();
    }
}
