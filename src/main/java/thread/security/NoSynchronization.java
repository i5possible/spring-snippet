package thread.security;

/**
 * @author lianghong
 * @date 03/10/2018
 */

// ThreadLocalt
public class NoSynchronization {
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        NoSynchronization noSynchronization = new NoSynchronization();
        for (int i = 0; i < 3; i++) {
            TestClient testClient = new TestClient(noSynchronization);
            testClient.start();
        }
    }

    private static class TestClient extends Thread {
        private NoSynchronization noSynchronization;

        public TestClient(NoSynchronization noSynchronization) {
            this.noSynchronization = noSynchronization;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] seqNum[" + noSynchronization.getNextNum() + "]");
            }
        }
    }
}
