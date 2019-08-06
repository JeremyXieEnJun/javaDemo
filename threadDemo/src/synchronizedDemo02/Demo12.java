package synchronizedDemo02;

import java.util.concurrent.TimeUnit;

/**
 * @author Jeremy
 * @create 2019/8/5-18:44
 * 程序在执行的过程中，如果出现异常，默认情况    锁会被释放掉(如果不想被释放，就加一个try/catch抛出异常)
 * 所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况
 * 比如：在一个web处理过程中，多个servlet线程共同访问同一个资源，这时，如果异常处理不恰当的话，在第一个线程中抛出异常，
 * 其他线程就会进入同步代码区，有可能会访问到异常产生时生成的数据
 *
 * 因此要非常小心地处理同步业务逻辑中的异常
 */
public class Demo12 {
    int count = 0;
    synchronized void m() {

        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (count == 5) {
                    int i = 1 / 0;//此处会抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续
                }
            } catch (Exception e) {
                return;
            }

        }
    }

    public static void main(String[] args){
        Demo12 t = new Demo12();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };

        new Thread(r,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"t2").start();
    }

}




