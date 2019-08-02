package exercise;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jeremy
 * @create 2019/7/31-15:40
 */
public class Exercise03 {
     public static void main(String[] args){
             //集合的遍历
         ArrayList<Integer> list =new ArrayList<>();
         Collections.addAll(list,1,2,3,4,5,0,8,7);
         //将集合中的每一个元素都带入到方法accept中
         list.forEach(System.out::println);
         System.out.println("===============");
         //输出集合中所有的偶数
         list.forEach(ele ->{
             if(ele%2==0){
                 System.out.println(ele);
             }
         });

      }
}
