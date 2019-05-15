package enumcollection.extend;

/**
 * @author lianghong
 * @date 2019/5/15
 */

public class OperationUtils {

    public static <T extends Enum<T> & Operation> void apply(Class<T> tClass) {
        double x = Math.random() * 10;
        double y = Math.random() * 10;

        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println(tClass.getSimpleName());
        for (Operation operation : tClass.getEnumConstants()) {
            double res = operation.apply(x, y);
            System.out.println("" + res);
        }
    }

    public static void main(String[] args) {
        apply(BaseOperation.class);
        apply(ExtendedOperation.class);
    }
}
