package beans;

import aop.TrackCounter;
import aop.soundsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-aop.xml")
public class TrackCounterTest {
    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void aop_test() {
        compactDisc.playTrack(1);
        compactDisc.playTrack(1);
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(3);
        compactDisc.playTrack(3);

        assertEquals(3, trackCounter.getTrackCount(1));
        assertEquals(1, trackCounter.getTrackCount(2));
        assertEquals(2, trackCounter.getTrackCount(3));
    }
}
