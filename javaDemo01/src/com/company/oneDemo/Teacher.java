package com.company.oneDemo;

/**
 * @author Jeremy
 * @create 2019/6/10-13:29
 */
//一个文件可以包含多个类，但是文件名必须和public类名相同，否则只能使用默认的包访问权限
abstract class Teacher{  														//abstract关键字表示为抽象类
    abstract void setname();   													//abstract抽象方法
    public String getname(){return name;}  										//使用public方法实现对private数据的控制，保证类内数据安全
    String name="teacher";  													//不加修饰符默认为报访问
}
