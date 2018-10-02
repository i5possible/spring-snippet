package thread.deadlock;

/**
 * @author lianghong
 * @date 02/10/2018
 */

public class Ball {
    private int id;
    private boolean isAvaliable = true;
    public int getId() {
        return id;
    }

    public Ball(int id) {
        this.id = id;
    }

    public synchronized boolean acquire() {
        if(isAvaliable) {
            isAvaliable = false;
            return true;
        }
        return false;
    }

    public synchronized void release() {
        isAvaliable = true;
    }
}
