package syntax;

import data.Person;

/**
 * @author Jeremy
 * @create 2019/7/31-11:13
 */
public class Syntax04 {
     public static void main(String[] args){
           PersonCreater creater = () -> new Person();

           //构造方法的引用：
           PersonCreater creater1 = Person::new;
           Person a = creater1.getPerson();

           PersonCreater2 creater2 = Person::new;
           Person b = creater2.getPerson("恩军",10);

      }
}


//需求：
 interface PersonCreater{
    Person getPerson();
}

interface PersonCreater2{
    Person getPerson(String name,Integer age);
}