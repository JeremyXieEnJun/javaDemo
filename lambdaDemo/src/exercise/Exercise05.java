package exercise;

/**
 * @author Jeremy
 * @create 2019/7/31-16:05
 */
public class Exercise05 {
     public static void main(String[] args){
           //需求：开辟一条线程，做一个数字的输出
           //通过实现Runnale接口
         Thread t = new Thread(() -> {
             for(int i = 0 ;i<100;i++){
                 System.out.println(i);
                 try {
                     Thread.sleep(1);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         });

         t.start();
         for(int i = 0 ;i<100;i++){
             System.out.println("+++++++++++++"+i);
         }


      }
}
