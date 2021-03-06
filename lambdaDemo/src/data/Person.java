package data;

/**
 * @author Jeremy
 * @create 2019/7/31-11:04
 */
public class Person {
    public  String name;
    public  Integer age;

    public Person(){
        System.out.println("Person类的无参构造方法执行了");
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
        System.out.println("Person类的有参构造方法执行了");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
