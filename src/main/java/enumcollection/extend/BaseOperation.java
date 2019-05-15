package enumcollection.extend;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghong
 * @date 2019/5/15
 */

public enum  BaseOperation implements Operation{
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

    BaseOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
