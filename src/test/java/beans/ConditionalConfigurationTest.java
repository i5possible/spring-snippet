package beans;

import beans.other.AhaBean;
import config.ConditionConfig;
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
@ContextConfiguration(classes = ConditionConfig.class)
public class ConditionalConfigurationTest {
    @Autowired
    private AhaBean ahaBean;

    @Test
    public void java_bean_configuration() {
        assertNotNull(ahaBean);
    }
}
