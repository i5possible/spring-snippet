package beans;

import beans.auto.user.impl.Manager;
import beans.auto.user.impl.Master;
import config.BasicConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BasicConfig.class})
public class BeanScopeTest {
    @Autowired
    ApplicationContext applicationContext;

    @Before
    public void contextType() {
        System.out.println(applicationContext.getClass().toGenericString());
    }

    @Test
    public void singleton_scope_test() {
        assertEquals(applicationContext.getBean(Master.class), applicationContext.getBean(Master.class));
    }

    @Test
    public void prototype_scope_test() {
        assertNotEquals(applicationContext.getBean(Manager.class), applicationContext.getBean(Manager.class));
    }
}
