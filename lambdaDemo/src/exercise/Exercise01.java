package exercise;

import data.Person;

import java.util.ArrayList;

/**
 * @author Jeremy
 * @create 2019/7/31-11:37
 */
public class Exercise01 {
    //集合排序：
    //ArrayList< >
     public static void main(String[] args){
         //需求：已知在一个ArrayList集合中有若干个Person对象。将这些对象按照年龄进行降序排序。

         ArrayList<Person> list = new ArrayList<>();

         list.add(new Person("xian",10));
         list.add(new Person("xian1",11));
         list.add(new Person("xian2",12));
         list.add(new Person("xian3",13));
         list.add(new Person("xian4",14));

         //排序
         list.sort((o1,o2) -> o2.age-o1.age);
         System.out.println(list);



      }

}
