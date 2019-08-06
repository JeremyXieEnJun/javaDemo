package synchronizedDemo;

/**
 * @author Jeremy
 * @create 2019/8/5-14:08
 */
public class TestYield {
     public static void main(String[] args){
            Thread2 t1 = new Thread2("t1");
            Thread2 t2 = new Thread2("t2");
            t1.start();
            t2.start();

      }
}

class  Thread2  extends Thread {
    Thread2(String s){
        super(s);
    }
    public void run(){
        for(int i=1;i<=100;i++){
            System.out.println(getName()+": "+i);
            if(i % 10==0){
               yield();    //使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。
                          //cpu会从众多的可执行态里选择，也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，
                          //并不是说一定会执行其他线程而该线程在下一次中不会执行到了。

                         //用了yield方法后，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
                try {
                    sleep(100);  //加上一个sleep()，方法之后，被yield的线程一定就抢不到CPU了，就昨自然会换一个线程执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}