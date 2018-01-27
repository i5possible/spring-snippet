package beans;

import beans.auto.ComplicateBean;
import beans.auto.user.User;
import beans.auto.user.impl.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-complicate-bean.xml")
public class ComplicateBeanTest {
    @Autowired
    private ComplicateBean complicateBean;

    @Test
    public void value_injection_test() {
        assertEquals("FatBean", complicateBean.getName());
    }

    @Test
    public void auto_injection_test() {
        assertNotNull(complicateBean.getMaster());
    }

    @Test
    public void list_injection_test() {
        List<User> userList = complicateBean.getUserList();
        assertEquals(3, userList.size());
        assertEquals(Manager.class, userList.get(0).getClass());
        assertNotEquals(userList.get(0), userList.get(1));
    }

    @Test
    public void map_injection_test() {
        Map<String, User> userMap = complicateBean.getUserMap();
        assertEquals(3, userMap.size());
        assertEquals(Manager.class, userMap.get("m1").getClass());
        assertNotEquals(userMap.get("m1"), userMap.get("m2"));
    }

    @Test
    public void properties_injection_test() {
        Properties properties = complicateBean.getProperties();
        assertEquals(3, properties.size());
        assertEquals("dev", properties.getProperty("spring.profiles.active"));
        assertEquals("mysql", properties.getProperty("datasource.main"));
        assertEquals("main", properties.getProperty("name"));
    }
}
