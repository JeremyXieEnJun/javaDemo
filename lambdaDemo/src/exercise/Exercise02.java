package exercise;

import data.Person;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Jeremy
 * @create 2019/7/31-15:18
 */
public class Exercise02 {
    //集合排序：
    //ArrayList< >
    public static void main(String[] args) {
        //需求：已知在一个ArrayList集合中有若干个Person对象。将这些对象按照年龄进行降序排序。

        TreeSet<Person> set = new  TreeSet<>((o1,o2) -> {
            if(o1.age>=o2.age) {//相等的时候，必须要归为-1或1，否则算为相等会重叠，set集合就不会对此做输出
                return -1;
            }
            else{
                return  1;
            }

        });

        set.add(new Person("xia", 10));
        set.add(new Person("xia1", 11));
        set.add(new Person("xia2", 11));
        set.add(new Person("xia3", 13));
        set.add(new Person("xia4", 14));


        System.out.println(set);
    }
}