package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Tickets {
    public int number = 0;
    public int size;
    boolean available = false;
    public int sellNumber = 0;

    public Tickets(int size) {
        this.size = size;
    }

    public synchronized void put() {
        if (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer puts ticket" + (++number));
        available = true;
        notify();
    }

    public synchronized void sell() {
        if (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer buy ticket" + (++sellNumber));
        if (sellNumber == number) {
            available = false;
        }
        notify();
        // 售完后互相等待，无法结束

    }

    public void putTicket() {
        synchronized (this) {
            System.out.println("Producer puts ticket" + (++number));
            available = true;
        }
    }
}
