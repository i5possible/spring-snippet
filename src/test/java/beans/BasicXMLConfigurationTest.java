package beans;

import beans.always.BasicBean;
import beans.auto.MagicBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-basic.xml")
public class BasicXMLConfigurationTest {
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
