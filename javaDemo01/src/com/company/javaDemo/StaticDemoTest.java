package com.company.javaDemo;

/**
 * @author Jeremy
 * @create 2019/6/12-11:32
 */
public class StaticDemoTest  {
    public static  void main(String [] args){
        /* 在外部类外部 创建非静态内部类
           语法： 外部类.内部类 内部类对象 = new 外部类().new 内部类();
           举例： Outer.Inner in = new Outer().new Inner();
        */
        StaticTest s = new StaticDemo();
        System.out.println( s.in(5));
       // StaticDemo.Inner in = s.new Inner();  //注意，这样会发生错误，涉及到多态，内部类的创建不起效
        StaticDemo.Inner in = new StaticDemo().new Inner();
        in.print();
        System.out.println("--------------");

      /*  在外部类外部 创建静态内部类
        语法： 外部类.内部类 内部类对象 = new 外部类.内部类();
        举例： Outer.Inner in = new Outer.Inner();
        */
      //被static修饰的内部类可以直接作为一个普通类来使用，而不需实例一个外部类。
        StaticDemo.DemoStaticInner sin = new StaticDemo.DemoStaticInner();
        sin.print();
    }
}

