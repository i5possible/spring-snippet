package beans;

import beans.always.BasicBean;
import beans.auto.MagicBean;
import config.BasicConfig;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicConfig.class)
public class BeanConfigurationTest {

    @BeforeClass
    public static void init(){

    }

    @AfterClass
    public static void clean(){

    }

    @Before
    public void runBeforeEachTest(){

    }

    @After
    public void runAfterEachTest(){

    }

    @Autowired
    private BasicBean basicBean;

    @Autowired
    private MagicBean magicBean;

    @Test
    public void java_bean_configuration() {
        assertNotNull(basicBean);
        assertNotNull(magicBean);
    }
}
