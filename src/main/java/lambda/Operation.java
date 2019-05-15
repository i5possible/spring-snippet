package lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghong
 * @date 2019/5/1
 */

public enum Operation implements Comparable<Operation>{
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    }

    ;
    private final String symbol;
    private static final Map<String, Operation> stringToEnumMap
        = new HashMap<>();

    Operation(String symbol) {
        this.symbol = symbol;
    }


    static {
        for (Operation operation : Operation.values()) {
            stringToEnumMap.put(operation.toString(), operation);
        }
    }

    @Override
    public String toString() {
        return symbol;
    }

    public Operation fromString(String symbol) {
        return stringToEnumMap.get(toString());
    }

    public abstract double apply(double x, double y);
}
