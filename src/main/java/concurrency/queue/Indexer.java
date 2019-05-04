package concurrency.queue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @author lianghong
 * @date 2019/5/4
 */

public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                indexFile(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void indexFile(File file) {
    }
}
