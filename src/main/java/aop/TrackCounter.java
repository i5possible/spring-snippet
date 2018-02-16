package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Aspect
@Component
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    public int getTrackCount(int key) {
        return trackCounts.get(key);
    }

    @Pointcut(value = "execution(* aop.soundsystem.CompactDisc.playTrack(int)) " +
            "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {

    }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        trackCounts.put(trackNumber, getPlayCount(trackNumber) + 1);
    }

    private int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
