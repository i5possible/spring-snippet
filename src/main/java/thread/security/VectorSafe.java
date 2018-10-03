package thread.security;

import java.util.Vector;

/**
 * @author lianghong
 * @date 03/10/2018
 */

public class VectorSafe {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
//                        System.out.println(vector.size());
                        // if not synchronized(vector)
                        //Exception in thread "Thread-445606" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 16
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(() -> {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 20) {
                ;
            }
        }
    }
}
