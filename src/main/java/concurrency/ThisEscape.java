package concurrency;

/**
 * The order of the code is not work as expected.
 * The name is used inside the inner class.
 * @author lianghong
 * @date 2019/3/12
 */

public class ThisEscape {
    public final int id;
    public final String name;

    public ThisEscape(EventSource<MyEventListener> source) {
        id = 1;
        source.registerListener(new MyEventListener() {
            @Override
            public void onEvent(Object obj) {
                System.out.println("id: " + ThisEscape.this.id);
                System.out.println("name: " + ThisEscape.this.name);
            }
        });
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "flysqrlboy";
    }

    public static void main(String[] args) {
        EventSource<MyEventListener> source = new EventSource<>();
        ListenerRunnable listRun = new ListenerRunnable(source);
        Thread thread = new Thread(listRun);
        thread.start();
        ThisEscape escape1 = new ThisEscape(source);
    }
}
