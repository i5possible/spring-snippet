package beans;

import config.EnvironmentConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EnvironmentConfig.class})
public class EnvironmentTest {
    @Autowired
    private Environment environment;

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;
    @Test
    public void environment_test() {
        configurableEnvironment.notify();
        assertEquals(1, environment.getActiveProfiles().length);
        assertEquals("main", environment.getProperty("name"));

    }
}
