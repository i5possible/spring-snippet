package thread.deadlock;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class PlayersManager {
    private int playerNumbers;

    public PlayersManager(int playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public static void main(String[] args) throws InterruptedException {
        int gameScale = 3;
        PlayersManager playersManager = new PlayersManager(gameScale);
        BallsManager.init(gameScale);
        for (int playId = 0, total = playersManager.getPlayerNumbers(); playId < total; playId++) {
            new Thread(new Player(playId, playersManager)).start();
            Thread.sleep(1);
        }
    }

    public int getPlayerNumbers() {
        return playerNumbers;
    }
}
