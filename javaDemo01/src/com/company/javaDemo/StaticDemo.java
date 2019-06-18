package com.company.javaDemo;

/**
 * @author Jeremy
 * @create 2019/6/12-11:32
 * 测试类的继承，内部类的实现，static修饰的类（内部类）
 * java里面static一般用来修饰成员变量或函数。但有一种特殊用法是用static修饰内部类，普通类是不允许声明为静态的，只有内部类才可以。
 * 	被static修饰的内部类可以直接作为一个普通类来使用，而不需实例一个外部类。
 *
 */
public class StaticDemo extends StaticTest {
 private  String str = "外部类的属性";
    @Override
    public   int in(int i) {
        return i;
    }

    class Inner {
        private String inStr = "这是一个普通的内部类的内部属性";

        //定义一个普通方法
        public void print() {
            //调用外部类的str属性
            System.out.println(str);
            //调用内部类的inStr属性
            System.out.println(inStr);
        }
    }

    static class DemoStaticInner{
        private static  String inStr= "这是一个static修饰的内部类的内部属性";
        //定义一个普通方法
        public  void print(){
            //调用外部类的str属性
            // System.out.println(str);//在静态内部类中不能访问类的非静态成员变量和非静态成员方法
            //调用内部类的inStr属性
            System.out.println(inStr);
        }


    }

    public static  void main(String [] args){
        /* 在外部类外部 创建非静态内部类
           语法： 外部类.内部类 内部类对象 = new 外部类().new 内部类();
           举例： Outer.Inner in = new Outer().new Inner();
        */
        StaticTest s = new StaticDemo();
        System.out.println( s.in(5));
       // StaticDemo.Inner in = s.new Inner();  //注意，这样会发生错误，涉及到多态，内部类的创建不起效
        Inner in = new StaticDemo().new Inner();
        in.print();
        System.out.println("--------------");

      /*  在外部类外部 创建静态内部类
        语法： 外部类.内部类 内部类对象 = new 外部类.内部类();
        举例： Outer.Inner in = new Outer.Inner();
        */
      //被static修饰的内部类可以直接作为一个普通类来使用，而不需实例一个外部类。
        //同时，因为是在同一个类里所以  可以越过外部类直接创建static修饰的内部类
        DemoStaticInner sin = new DemoStaticInner();
          sin.print();
        DemoStaticInner sin1 = new DemoStaticInner();
          sin1.print();
    }
}

