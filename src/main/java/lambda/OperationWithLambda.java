package lambda;

import java.util.function.DoubleBinaryOperator;

/**
 * @author lianghong
 * @date 2019/5/1
 */

public enum  OperationWithLambda {
    TIMES ("*", (x, y) -> x * y),
    DIVEDE ("/", (x, y) -> x /y)
    ;
    private final String symbol;
    private final DoubleBinaryOperator op;

    OperationWithLambda(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
