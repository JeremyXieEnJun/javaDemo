package synchronizedDemo;

/**
 * @author Jeremy
 * @create 2019/8/5-13:49
 */
public class TestJoin {
     public static void main(String[] args){
           Thread1 t = new Thread1("abc");
           t.start();
         try {
             t.join(); //join方法相当于将这个线程重新变为一个方法调用。这个线程分支不再和主线程同步进行，而是先进行完这个分支，主线程再继续进行
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         for(int i=0;i<=5;i++){
             System.out.println("I am main Thread");
         }

     }
}

class  Thread1  extends Thread {
   Thread1(String s){
       super(s);
   }
    public void run(){
       for(int i=0;i<=5;i++){
           System.out.println("I am :"+getName());
       }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
