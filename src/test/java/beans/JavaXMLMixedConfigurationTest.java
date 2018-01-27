package beans;

import beans.always.BasicBean;
import beans.auto.MagicBean;
import beans.other.AwesomeBean;
import config.MixedConfig;
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
@ContextConfiguration(classes = MixedConfig.class)
public class JavaXMLMixedConfigurationTest {
    @Autowired
    private BasicBean basicBean;

    @Autowired
    private MagicBean magicBean;

    @Autowired
    private AwesomeBean awesomeBean;

    @Test
    public void java_bean_configuration() {
        assertNotNull(basicBean);
        assertNotNull(magicBean);
        assertNotNull(awesomeBean);
    }
}
