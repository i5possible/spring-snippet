package enumcollection.extend;

/**
 * @author lianghong
 * @date 2019/5/15
 */

public enum ExtendedOperation implements Operation{
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
