package beans;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lianghong
 * @date 02/03/2018
 */


public class FooBarTest {
    @Test
    public void fail_given_number_under_zero() {
        int input = -1;
        FooBar fooBar = new FooBar();
        String actual = fooBar.test(input);

        String expected = "Under Zero!";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void return_foo_given_3() {
        int input = 3;
        FooBar fooBar = new FooBar();
        String actual = fooBar.test(input);

        String expected = "Foo";

        Assert.assertEquals(expected, actual);
    }

}
