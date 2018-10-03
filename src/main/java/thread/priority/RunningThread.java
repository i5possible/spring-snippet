package thread.priority;

/**
 * @author lianghong
 * @date 03/10/2018
 */

public class RunningThread extends Thread {
    private int tick = 0;
    private int total = 4000000;

    @Override
    public void run() {
        while (tick < total) {
            tick++;
            if (tick % 500000 == 0) {
                System.out.println(this.getName() + " is running, tick is " + tick + ", priority is " + getPriority());
                yield();
            }
        }
    }
}
