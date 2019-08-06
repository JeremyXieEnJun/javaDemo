package synchronizedDemo;

/**
 * @author Jeremy
 * @create 2019/8/5-14:27
 */
public class TestPriority {
    public static void main(String[] args){
        Thread3 t1 = new Thread3("t1");
        Thread3 t2 = new Thread3("t2===========");
        t2.setPriority(Thread.NORM_PRIORITY+2);//提高t2线程的优先级
        t1.start();
        t2.start();

    }
}

class  Thread3  extends Thread {
    Thread3(String s){
        super(s);
    }
    public void run(){
        for(int i=1;i<=1000;i++){
            System.out.println(getName()+":  "+i);
        }
    }
}