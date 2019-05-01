package lambda.cache;

/**
 * @author lianghong
 * @date 2019/5/1
 */

public class StrategyPattern {

    public static void selfDefineFunction() {
        int maxSize = 10;
        Cache<Object, Object> cache =
                new Cache<>(maxSize, (map, size) -> map.size() > size);
    }

    public static void standardFunction() {
//        UnaryOperator;
//        BinaryOperator;
//        Predicate;
//        Function;
//        Supplier;
//        Consumer;
    }
}
