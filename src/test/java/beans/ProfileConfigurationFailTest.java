package beans;

import beans.profile.DevBean;
import config.DevConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author lianghong
 * @date 27/01/2018
 */

/**
 * JVM params (add to method in configuration):
 *      -Dspring.profiles.active=dev
 *
 * or
 * @ActiveProfiles({"dev"}) on the Test class;
 *
 * or
 * Environment params:
 *
 * or
 * web.xml:
 * <init-param>
 * <param-name>spring.profiles.active</param-name>
 * <param-value>production</param-value>
 * </init-param>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DevConfig.class)
public class ProfileConfigurationFailTest {
    @Autowired(required = false)
    private DevBean devBean;

    @Test
    public void profile_test_without_params() {
        assertNull(devBean);
    }
}
