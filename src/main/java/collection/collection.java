package collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lianghong
 * @date 05/10/2018
 */

public class collection {
    public static void main(String[] args) {
//        new ArrayList<>();
//        new LinkedList<>();
//
//        new HashMap<String, String>();
//        new Hashtable<String, String>();
//        new TreeMap<>();
//        new LinkedHashMap<>();
//
//        new HashSet<>();
//        new TreeSet<>();
//        new LinkedHashSet<>();

        arrayList();
    }

    public static void arrayList() {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("123");
        strings.add(1, "222");
        String init = strings.set(0, "456");
        System.out.println(init);
        strings.remove(1);
        strings.remove(-1);
        // 对查询修改大于增删时
    }

    public static void linkList() {
        // not thread safe, need synchronized
        LinkedList<String> strings = new LinkedList<>();
        strings.add("123");
        strings.get(0);
        strings.remove(0);
        strings.add(1, "456");
        // 对增删的需求大于查询修改
    }

    public static void hashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.clear();
        Object clone = map.clone();
        map.put("a", "b");
        map.get("a");
    }

    public static void hashTable() {
        // not null value
        // thread safe

    }

    public static void treeMap() {
        // not null value
        // thread safe
        // nlog2n查询修改、删除
        TreeMap<String, String> map = new TreeMap<>();
        map.comparator();
        map.put("a","b");
        map.get("ab");
        NavigableMap<String, String> stringStringNavigableMap = map.descendingMap();
        // 空间利用率高
        // 性能稳定 HashMap 会有碰撞，会降低效率；会rehash，降低效率；TreeMap O(logn)
    }

    public static void linkedHashMap() {
        // HashMap 数组 + 列表
        // LinkedHashMap 数据 + 双向列表
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
    }

    public static void concurrentHashMap() {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.get("1");
        map.mappingCount();
        map.putIfAbsent("", "");
        map.containsKey("123");
        Enumeration<Object> elements = map.elements();
    }

    public static void summary() {
        // HashMap 适用于一般的键值映射需求
        // HashTable 适用于有多线程并发的场合 vs ConcurrentHashMap
        // TreeMap 适用于要按照键排序的迭代场合
        // LinkedHashMap 适用于特殊顺序的迭代场合（如LRU算法）
        // ConcurrentHashMap 是 HashTable 的替代品，但是底层实现不同
    }

    public static void hashSet() {
        // 使用了 HashMap，Set的集合为 Map 的 Key, 值为一个空的 final Object
        HashSet<Object> objects = new HashSet<>();
    }
}
