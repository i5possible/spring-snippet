package concurrency;

/**
 * @author lianghong
 * @date 2019/3/12
 */

public class MutableInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
