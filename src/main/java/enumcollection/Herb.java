package enumcollection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 使用 EnumMap 代替序数索引
 *
 * @author lianghong
 * @date 2019/5/15
 */

public class Herb {
    public enum Type {ANNUAL, PERENNIAL, BIENNIAL}

    private final String name;
    private final Type type;

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    private static final EnumMap<Type, Set<Herb>> map = new EnumMap<>(Herb.Type.class);

    static {
        for (Herb.Type t : Herb.Type.values()) {
            map.put(t, new HashSet<>());
        }
    }

    public static void main(String[] args) {
        List<Herb> herbs = IntStream.range(0, 50)
                .boxed()
                .map(i -> new Herb(UUID.randomUUID().toString(), Type.values()[i % 3]))
                .collect(Collectors.toList());

        for (Herb herb : herbs) {
            map.get(herb.type).add(herb);
        }

        map.forEach((k, v) -> {
            System.out.println("Type:" + k);
            v.forEach(System.out::println);
        });
    }
}


