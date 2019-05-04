package concurrency.deque;

import java.io.File;
import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * @author lianghong
 * @date 2019/5/4
 */

public class WorkStealingConsumer implements Runnable {
    private final BlockingDeque<File> deque;
    private final List<BlockingDeque<File>> friendDeque;


    public WorkStealingConsumer(BlockingDeque deque, List<BlockingDeque<File>> friendDeque) {
        this.deque = deque;
        this.friendDeque = friendDeque;
    }


    @Override
    public void run() {
        while(true) {
            doWork();
        }
    }

    private void doWork() {
        if (deque.isEmpty()) {
            stealWork();
        } else {
            selfWork();
        }
    }

    private void selfWork() {
        File file = null;
        try {
            file = deque.takeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        process(file);
    }

    private void process(File file) {

    }

    private void stealWork() {
        friendDeque.forEach( deque -> {
            boolean empty = deque.isEmpty();
            if (!empty) {
                File file = null;
                try {
                    file = deque.takeLast();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                process(file);
                return;
            }
        });
    }
}
