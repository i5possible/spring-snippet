package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Tickets {
    public int number = 0;
    public int size;
    boolean available = false;
    private int sellNumber = 0;

    public Tickets(int size) {
        this.size = size;
    }

    public synchronized void put() {
        System.out.println("Producer puts ticket" + (++number));
        available = true;
    }

    public synchronized void sell() {
        System.out.println("Consumer buy ticket" + (++sellNumber));
        if (sellNumber == number) {
            available = false;
        }
    }

    public void putTicket() {
        synchronized (this) {
            System.out.println("Producer puts ticket" + (++number));
            available = true;
        }
    }
}
