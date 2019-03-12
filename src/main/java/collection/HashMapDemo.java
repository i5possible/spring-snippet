package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lianghong
 * @date 2019/3/8
 */

public class HashMapDemo {

    public static void main(String[] args) {
        basicDemo();
    }

    public static void basicDemo() {
        Map<String, String> map = generateMapA();
        String a = map.get("a");
        String put = map.put("f", "f");
        boolean e = map.containsKey("e");
        Set<String> strings = map.keySet();
        Collection<String> values = map.values();
        map.forEach((k, v) -> System.out.println(v));
        String s = map.putIfAbsent("g", "g");
        String orDefault = map.getOrDefault("h", "hh");
        boolean h = map.containsValue("h");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        boolean empty = map.isEmpty();
        map.replace("a", "aa");
        map.merge("b", "222", (va, vb) -> va + vb);
        map.computeIfPresent("c", (k, ov) -> ov + ov + ov);
        map.put("null", null);
        map.put("null2", null);
        map.put(null, "null");
        map.put(null, "null2");
        System.out.println(map);
    }

    public static void mergeDemo() {
        Map<String, String> mapA = generateMapA();
        Map<String, String> mapB = generateMapB();

    }

    public static Map<String, String> generateMapA() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.put("e", "e");
        return map;
    }

    public static Map<String, String> generateMapB() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        map.put("e", "5");
        return map;
    }
}
