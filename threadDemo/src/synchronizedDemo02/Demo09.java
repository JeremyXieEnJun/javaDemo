package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 * 同步方法和非同步方法是否可以同时调用
 */
public class Demo09 {

    public synchronized  void m1(){
        System.out.println(Thread.currentThread().getName()+ " m1 start " );
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " m1 end " );
    }

    public  void m2(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " m2 " );
    }

    public static void main(String[] args){
        Demo09 r = new Demo09();
        new Thread(()->r.m1(),"r1").start();
        new Thread(()->r.m2(),"r2").start();//执行m2不需要在意对象有没有被锁住

       /* new Thread(r::m1,"r3").start();
        new Thread(r::m1,"r4").start();*/

    }

}