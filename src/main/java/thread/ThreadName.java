package thread;

/**
 * @author lianghong
 * @date 02/10/2018
 */
public class ThreadName extends Thread {

    public ThreadName() {
        System.out.println("Thread.currentThread().getname()=" + Thread.currentThread().getName());
        System.out.println("This.getName=" + this.getName());
    }
    @Override
    public void run() {
        System.out.println("Thread.currentThread().getname()=" + Thread.currentThread().getName());
        // run 方法调用 target.run() 方法
        System.out.println("This.getName=" + this.getName());
    }

    public static void main(String[] args) {
        ThreadName t0 = new ThreadName();
        Thread t1 = new Thread(t0);
        t1.setName("A");
        t1.start();
    }

}
