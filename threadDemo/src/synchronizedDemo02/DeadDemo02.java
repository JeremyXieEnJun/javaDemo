package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-17:06
 */
public class DeadDemo02 {

    private static String A = "A";
    private static String B = "B";
    public static void main(String args[]) {
        new DeadDemo02().deadLock();
    }
    private void deadLock() {
        // 线程thread_1
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.err.println("--thread_1 lock A----");
                    synchronized (B) {
                        System.err.println("--thread_1 lock B----");
                    }
                }
            }
        }
        );
        // 线程thread_2
        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    System.out.println("--thread_2 lock B----");

                    synchronized (A) {
                        System.out.println("--thread_2 lock A----");
                    }
                }
            }
        }
        );
        thread_1.start();
        thread_2.start();
    }
}
