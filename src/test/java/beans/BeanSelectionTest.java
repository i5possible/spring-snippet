package beans;

import beans.always.BasicBean;
import beans.auto.MagicBean;
import beans.auto.office.MasterOffice;
import beans.auto.user.impl.Master;
import beans.auto.user.impl.Member;
import config.BasicConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicConfig.class)
public class BeanSelectionTest {
    @Autowired
    private MasterOffice masterOffice;

    @Test
    public void java_bean_configuration() {
        assertNotNull(masterOffice);
        assertEquals(masterOffice.getMaster().getClass(), Master.class);
        assertEquals(masterOffice.getMember().getClass(), Member.class);
    }
}
