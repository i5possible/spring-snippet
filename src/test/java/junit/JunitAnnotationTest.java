package junit;

import beans.always.BasicBean;
import beans.auto.MagicBean;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author lianghong
 * @date 27/01/2018
 */

public class JunitAnnotationTest {

    @BeforeClass
    public static void init(){
        System.out.println("INIT TEST ENVIRONMENT!");
    }

    @AfterClass
    public static void clean(){
        System.out.println("CLEAN TEST ENVIRONMENT!");
    }

    @Before
    public void runBeforeEachTest(){
        System.out.println("Set test condition!");
    }

    @After
    public void runAfterEachTest(){
        System.out.println("Unset test condition!");
    }

    @Test
    public void first_test() {
        System.out.println("First test is running!");
    }

    @Test
    public void second_test() {
        System.out.println("Second test is running!");
    }
}
