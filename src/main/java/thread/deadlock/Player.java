package thread.deadlock;


/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Player implements Runnable {

    private int playerId;
    private int max;
    private int leftBallId;
    private int rightBallId;

    public Player(int playerId, int max) {
        this.playerId = playerId;
        this.max = max;
        leftBallId = getLeftBallId();
        rightBallId = getRightBallId();
    }

    public void play() {
        while (true) {
            getLeftBall();
            getRightBall();
            releaseBalls();
            rest(playerId);
        }
    }

    private void rest() {
        rest(1);
    }

    private void rest(int factor) {
        try {
            long millis = (long) (Math.random() * 5 * factor);
            System.out.println(String.format("Player %d rest %d millis.", playerId, millis));
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getLeftBall() {
        boolean getBall = false;
        while (!getBall) {
            getBall = BallsManager.acquireBall(leftBallId);
        }
        System.out.println(String.format("Player %d get ball %d!", playerId, leftBallId));
    }

    private int getLeftBallId() {
        int leftBallId = playerId - 1;
        if (leftBallId < 0) {
            leftBallId += max;
        }
        return leftBallId;
    }

    public void getRightBall() {
        boolean getBall = false;
        while (!getBall) {
            getBall = BallsManager.acquireBall(rightBallId);
        }
        System.out.println(String.format("Player %d get ball %d!", playerId, rightBallId));
    }

    private int getRightBallId() {
        int rightBallId = playerId + 1;
        if (rightBallId >= max) {
            rightBallId -= max;
        }
        return rightBallId;
    }

    public void releaseBalls() {
        BallsManager.releaseBall(getLeftBallId());
        System.out.println(String.format("Player %d release ball %d!", playerId, leftBallId));
        BallsManager.releaseBall(getRightBallId());
        System.out.println(String.format("Player %d release ball %d!", playerId, rightBallId));
    }

    @Override
    public void run() {
        System.out.println(String.format("Player %d join the game!", playerId));
        rest();
        play();
    }
}
