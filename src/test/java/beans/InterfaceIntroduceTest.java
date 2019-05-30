package beans;

import aop.Encoreable;
import aop.EncoreableIntroducer;
import aop.soundsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-aop.xml")
public class InterfaceIntroduceTest {
    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private EncoreableIntroducer encoreableIntroducer;
    @Test
    public void aop_test() {
        ((Encoreable) this.compactDisc).performEncore();
    }
}
