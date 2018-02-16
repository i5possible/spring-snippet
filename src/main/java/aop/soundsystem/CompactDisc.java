package aop.soundsystem;

import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Component
public class CompactDisc {
    public void playTrack(int trackNumber) {
        System.out.println("play:" + trackNumber);
    }
}
