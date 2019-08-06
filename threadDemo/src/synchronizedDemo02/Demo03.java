package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 */
public class Demo03 {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        synchronized (o){//任何线程要执行下面的代码，必须先拿到 o 这个对象的锁。这里是锁定了o指向的那个对象
                         //要执行这个m()方法，必须先去申请 o 这个对象的锁
                         //运行完了之后再释放这个对象的锁，别的对象才能够申请锁定这个 o 对象，然后才能执行m()方法。
            count--;
            System.out.println(Thread.currentThread().getName()+ " count = " +count);
        }

    }

}