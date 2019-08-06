package synchronizedDemo02;

import java.util.concurrent.TimeUnit;

/**
 * @author Jeremy
 * @create 2019/8/5-20:39
 * volatile  关键字，使一个变量在多线程间可见，每次改变都会去提醒每个线程。（无锁同步）
 * A B线程都用到了一个变量，java默认是A线程中保留一份copy，这样，如果B线程修改了该变量，则A线程未必会知道
 * 使用Volatile关键字之后，会让所有线程都会读到变量的修改值
 *
 * 使用Volatile，将会强制所有的线程都去堆内存中读取running的值。
 *
 * 参考（Java内存模型）：https://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 *
 * Volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说，Volatile并不能代替synchronized
 * 能用Volatile就不要用synchronized
 */
public class VolatileDemo {
                                            //《深入理解Java虚拟机》
       /*volatile*/ boolean running = true; //对比一下有无volatile的情况下，整个程序运行结果的区别
         void m() {

            System.out.println( "m start" );
            while (running) {

            }
             System.out.println("m end");
        }

        public static void main(String[] args){
            VolatileDemo v = new VolatileDemo();


            new Thread(v::m,"t1").start();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.running = false;
        }

    }




