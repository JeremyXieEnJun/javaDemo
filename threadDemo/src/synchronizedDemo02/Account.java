package synchronizedDemo02;

import java.util.concurrent.TimeUnit;

/**
 * @author Jeremy
 * @create 2019/8/5-15:55
 * 对业务写方法(set)加锁
 * 对业务读方法(get)不加锁
 * 就会产生脏读问题(dirtyRead)
 */
public class Account {
    String name;
    double balance;

    public synchronized void set(String name,double balance){
        this.name = name;
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {  //如果没有这个sleep()方法，就无法体现问题，就是在这两段代码之间有别的代码执行
            e.printStackTrace();            //如果没有这个sleep()方法，结果永远都是两个100
        }   */                             //当使用sleep()方法后，这个问题就体现出来了，会出现第一次读的是0，第二次读的是100
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name){
        return this.balance;
    }
     public static void main(String[] args){
        Account a = new Account();

        new Thread(()->a.set("zhangsan",100.00)).start();

         try {
             TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         System.out.println(a.getBalance("zhangsan"));

         try {
             TimeUnit.SECONDS.sleep(2);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         System.out.println(a.getBalance("zhangsan"));
     }

}
