package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 */
public class Demo04 {
    private int count = 10;

    public void m(){         //this是当前对象， synchronized (this)锁定的是当前对象（谁调用苏定谁）
        synchronized (this){//任何线程要执行下面的代码，必须先拿到this这个对象的锁。这里是锁定了调用这个方法的this对象

            count--;
            System.out.println(Thread.currentThread().getName()+ " count = " +count);
        }

    }

}