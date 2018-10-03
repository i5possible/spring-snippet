package thread.priority;

/**
 * @author lianghong
 * @date 03/10/2018
 */

public class PriorityThreadTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            RunningThread runningThread = new RunningThread();
            runningThread.setPriority(i);
            runningThread.start();
        }
    }
}
