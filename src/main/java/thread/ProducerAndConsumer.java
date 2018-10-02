package thread;


import java.util.function.Consumer;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Tickets t = new Tickets(10);
        new Consumers(t).start();
        new Producers(t).start();
    }
}
