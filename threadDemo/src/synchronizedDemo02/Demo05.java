package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 */
public class Demo05 {
    private int count = 10;

    public synchronized void m(){   //等同于在方法的代码执行时要 synchronized (this)
            count--;
            System.out.println(Thread.currentThread().getName()+ " count = " +count);
        }

    }

