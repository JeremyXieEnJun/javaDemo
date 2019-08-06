package synchronizedDemo02;


import java.util.concurrent.TimeUnit;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 * 一个同步方法可以调用另一个同步方法，一个线程  已经拥有某个对象的锁，再次申请的时候仍会得到该对象的锁，
 * 也就是说synchronized获得的锁是可重入的
 * 前提：同一个线程，可一个多次申请同一个对象的锁
 */
public class Demo10 {

     synchronized  void m1(){
        System.out.println( " m1 " );

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();
    }

    synchronized  void m2(){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" m2 ");
    }
}