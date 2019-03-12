package basic;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author lianghong
 * @date 2019/3/8
 */

public class ObjectDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("k", "v");
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("k", "v");
        boolean b = Objects.deepEquals(map, map1);
        System.out.println("deepEquals:" + b);
    }
}
