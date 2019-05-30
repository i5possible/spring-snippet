package concurrency.container;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * @author lianghong
 * @date 2019/3/25
 */

public class ContainerDemo {
    private final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    {
        concurrentHashMap.put("", "");
        concurrentHashMap.computeIfAbsent("", (key) -> "name:" + key);
        concurrentHashMap.computeIfPresent("", (key, value) -> "name:" + key + value);
        concurrentHashMap.getOrDefault("", "default");
    }
    private final CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    private final ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    private final PriorityQueue<String> priorityQueue = new PriorityQueue<>();
    private final DelayQueue<Delayed> delayeds = new DelayQueue<>();

    private final ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);
    private final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>();
    private final PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
    private final LinkedBlockingDeque<Object> linkedBlockingDeque = new LinkedBlockingDeque<>();

    public static void main(String[] args) {

    }
}
