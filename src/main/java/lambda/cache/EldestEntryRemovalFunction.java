package lambda.cache;

import java.util.Map;

/**
 * @author lianghong
 * @date 2019/5/1
 */

public interface EldestEntryRemovalFunction<K, V> {
    boolean remove(Map<K, V> map, int maxSize);
}
