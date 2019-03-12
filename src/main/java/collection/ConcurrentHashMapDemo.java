package collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lianghong
 * @date 2019/3/8
 */

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        basicDemo();
    }

    public static void basicDemo () {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put(null, "null");
//        map.put("null", null);
    }
}
