package lambda.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

/**
 * @author lianghong
 * @date 2019/5/1
 */

public class Cache<K, V> extends LinkedHashMap<K, V> {
    final int maxSize;
    protected EldestEntryRemovalFunction<K, V> removeEldestEntryFunction;
    protected BiPredicate<Map<K,V>, Integer> predicate;

    public Cache(int maxSize, EldestEntryRemovalFunction eldestEntryRemovalFunction) {
        this.maxSize = maxSize;
        this.removeEldestEntryFunction = eldestEntryRemovalFunction;
    }
}

