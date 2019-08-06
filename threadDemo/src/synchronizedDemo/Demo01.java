package synchronizedDemo;


/**
 * @author Jeremy
 * @create 2019/7/30-14:37
 */
public class Demo01 {
     public static void main(String[] args){
         Runner1 r1 = new  Runner1();

         Thread t = new Thread(r1);

         t.start();// start()方法的执行是线程创建和启动。执行Threa类的start()方法，会创建一个与主方法同步运行的线程分支。

         //r.run();//直接调用run()方法是方法的调用。直接调用run()方法，不存在多线程。

         Runner2 r2 = new Runner2();

         r2.start();

         for(int i = 0; i<100;i++){
             System.out.println(i);
             try {
                 Thread.sleep(300);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
      }
}

//通过实现Runnable接口来创建一个线程
class  Runner1  implements Runnable {
    public void run(){
        for(int i = 0; i<100;i++){
            System.out.println("Runner1  :"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//通过继承Thread类来创建一个线程，因为Thread类本身实现了Runnable接口

class Runner2 extends Thread{
    @Override
    public void run(){

            for(int i = 0; i<150;i++){
                System.out.println("Runner2  :"+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

