
package synchronizedDemo02;


import java.util.concurrent.TimeUnit;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 * 一个同步方法可以调用另一个同步方法，一个线程  已经拥有某个对象的锁，再次申请的时候仍会得到该对象的锁，
 * 也就是说synchronized获得的锁是可重入的
 * 这里是在继承中有可能发生的情形，子类调用父类的同步方法，可行
 */
public class Demo11 {

    synchronized void m() {
        System.out.println(" m  start ");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" m  end ");
    }

     public static void main(String[] args){
             new T().m();
      }
}

    class  T extends Demo11{
        @Override
        synchronized  void m(){
            System.out.println("子类的 m start");
            super.m();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子类的 m end");
        }

    }
