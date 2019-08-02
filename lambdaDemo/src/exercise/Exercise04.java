package exercise;

import data.Person;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author Jeremy
 * @create 2019/7/31-15:51
 */
public class Exercise04 {
     public static void main(String[] args){
         //需求：删除集合中满足条件的元素

         ArrayList<Person> list = new ArrayList<>();

         list.add(new Person("xia",10));
         list.add(new Person("xia2",12));
         list.add(new Person("xia3",13));
         list.add(new Person("xia4",14));

         //删除集合中年龄>10岁的元素

         ListIterator<Person> it = list.listIterator();
         while(it.hasNext()){
             Person ele =it.next();
             if(ele.age > 13){
                 it.remove();
             }
         }
         System.out.println(list);

         //Lambda实现
         //removeIf的逻辑：将集合中的每个元素都带入到Predicate接口的test()方法当中，如果返回值为true，则删除该元素
         list.removeIf((p)->p.age>12);
         System.out.println(list);

      }
}
