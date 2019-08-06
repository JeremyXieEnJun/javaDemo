package synchronizedDemo02;

/**
 * @author Jeremy
 * @create 2019/8/5-14:43
 */
public class Demo06 {
    private static int count = 10;

    public synchronized static  void m(){   //这里等同于synchronized (synchronizedDemo02.Demo06.class)
        count--;
        System.out.println(Thread.currentThread().getName()+ " count = " +count);
    }

    public static void mm(){
        synchronized (Demo06.class){ //因为是静态方法，不能创建实例，所以不能写 synchronized (this)
            count--;
            System.out.println(Thread.currentThread().getName()+ " count = " +count);
        }
    }

}

