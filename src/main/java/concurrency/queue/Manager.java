package concurrency.queue;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lianghong
 * @date 2019/5/4
 */

public class Manager {
    private static final int BOUND = 10;
    private static final int CONSUMERS = 5;

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(BOUND);
        FileFilter filter = pathname -> true;

        ThreadPoolExecutor producers = new ThreadPoolExecutor(BOUND / 2, BOUND, 600, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());
        for (File root : roots) {
            producers.submit(new FileCrawler(queue, filter, root));
        }

        ThreadPoolExecutor consumers = new ThreadPoolExecutor(BOUND / 2, BOUND, 600, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < CONSUMERS; i++) {
            consumers.submit(new Indexer(queue));
        }
    }
}

