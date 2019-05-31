package mokito;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * @author lianghong
 * @date 2019/5/31
 */

@Component
public class DependedClass {

    public boolean doSomething() {
        System.out.println("Do something");
        return true;
    }

    public static String getSomething() {
        return UUID.randomUUID().toString();
    }
}
