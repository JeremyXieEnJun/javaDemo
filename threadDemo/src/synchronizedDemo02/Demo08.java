package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 * 同步方法和非同步方法是否可以同时调用
 */
public class Demo08 implements  Runnable{
    private int count = 10;

    public synchronized  void run(){//这个方法是synchronized代码块，具有原子的特性，功能上不可分
        count--;
        System.out.println(Thread.currentThread().getName()+ " count = " +count);
    }

    public static void main(String[] args){
        Demo07 r = new Demo07();
        for(int i=0; i<10;i++){
            new Thread(r,"Thread"+i).start();
        }

    }

}