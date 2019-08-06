package synchronizedDemo;

import java.util.Date;

/**
 * @author Jeremy
 * @create 2019/8/2-16:13
 * sleep()和interrupt()方法的Demo
 */
public class TestSleep {
     public static void main(String[] args){

         Runner r = new  Runner();
         Thread t = new Thread(r);

         t.start();

         try {
             Thread.sleep(5000);  //注意：在哪个线程里调用了sleep()方法，就让哪个线程睡眠。   这里是让主线程main方法睡眠
         } catch (InterruptedException e) {
         }
         System.out.println("停下");//主线程睡眠结束，执行这句代码之后，执行下面的   t.interrupt();  中断睡眠的语句
        // t.interrupt();  //这种方法太粗暴了,而且会报错
         r.shutDown();

      }

}



class  Runner  implements Runnable {
    Boolean flag = true;  //用flag来控制跳出run方法，让子线程结束。
    public void run(){
        while(flag){
            System.out.println("===="+new Date()+"---------");
            try {
                //sleep()方法，是Thread类的静态方法，使得当前线程休眠（暂时停止执行多少毫秒）
               Thread.sleep(1000);  //注意：在哪个线程里调用了sleep()方法，就让哪个线程睡眠。
            } catch (InterruptedException e) {
              //  System.exit(0);    // 上面的t.interrupt();  中断睡眠的语句被执行之后，程序直接跳出，结束
                return;   // 上面的t.interrupt();  中断睡眠的语句被执行之后，程序直接跳出，结束
            }
        }
    }

    public void shutDown(){
        flag = false;
    }
}