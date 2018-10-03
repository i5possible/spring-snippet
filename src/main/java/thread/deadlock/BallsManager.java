package thread.deadlock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class BallsManager {
    public static final Map<Integer, Ball> ballMap = new HashMap<>();

    public static void init(int playNumbers) {
        for (int ballId = 0, total = playNumbers; ballId < total; ballId++) {
            ballMap.put(ballId, new Ball(ballId));
        }
    }

    public static boolean acquireBall(int id) {
        return ballMap.get(id).acquire();
    }

    public static void releaseBall(int id) {
        ballMap.get(id).release();
    }
}
