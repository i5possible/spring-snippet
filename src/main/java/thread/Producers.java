package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Producers extends Thread {
    Tickets tickets;

    public Producers(Tickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (tickets.number < tickets.size) {
            tickets.put();
//            synchronized (tickets) {
//                System.out.println("Producer puts ticket" + (++tickets.number));
//                tickets.available = true;
//            }
//            try {
//                // if sleep, ticket is sold immediately once put
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
