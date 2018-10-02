package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Consumers extends Thread {
    Tickets tickets;

    int number = 0;

    public Consumers(Tickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (tickets.sellNumber < tickets.size) {
            tickets.sell();
//            synchronized (tickets) {
//                if (tickets.available && number <= tickets.number) {
//                    System.out.println("Consumer buy ticket" + (++number));
//                }
//                if (number == tickets.number) {
//                    try {
//                        // if not synchronized
//                        // this sleep will lead to tickets.available be false forever.
//                        // then the while loop can't be end
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    tickets.available = false;
//                }
//            }
        }
    }
}
