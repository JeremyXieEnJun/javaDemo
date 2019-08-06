package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-15:55
 * 模拟死锁
 *
 * 注意：写死锁的时候一定要写Thread.sleep()方法，否则无法发生资源的争夺
 */

public class DeadDemo implements Runnable {
    int flag;
    static String A = "A";
    static String B = "B";

    public void run(){
        System.out.println(flag);
        if(flag==0){
            synchronized(A){
                System.out.println("--thread_1 lock A----");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(B){

                    System.err.println("--thread_1 lock B----");
                }
            }

        }
        if(flag==1){
            synchronized(B){
                System.out.println("--thread_2 lock B----");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized(A){
                    System.err.println("--thread_2 lock A----");


                }
            }

        }

    }


     public static void main(String[] args){
        DeadDemo r1 = new DeadDemo();
        DeadDemo r2 = new DeadDemo();

        r1.flag=1;
        r2.flag=0;

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
      }
}

