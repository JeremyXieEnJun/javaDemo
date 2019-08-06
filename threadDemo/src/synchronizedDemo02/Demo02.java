package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 */
public class Demo02 {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        synchronized (o){//任何线程要执行下面的代码，必须先拿到o的这个变量指向的对象这个锁。这里是锁定了o指向的那个对象
            count--;
            System.out.println(Thread.currentThread().getName()+ " count = " +count);
        }

    }

}