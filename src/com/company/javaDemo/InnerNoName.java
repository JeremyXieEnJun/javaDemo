package com.company.javaDemo;

/**
 * @author Jeremy
 * @create 2019/6/13-13:45
 * 匿名内部类:
 *     就是一个没有名字的方法内部类，因此特点和方法与方法内部类完全一致，除此之外，还有自己的特点：
 * 1.匿名内部类必须继承一个抽象类或者实现一个接口。
 * 2.匿名内部类没有类名，因此没有构造方法。
 */

    //匿名内部类
    //声明一个接口
    interface MyInterface {
        //接口中方法没有方法体
        void test();
    }

public class InnerNoName {

        private int num = 5;
        public void dispaly(int temp) {
            //匿名内部类，匿名的实现了MyInterface接口
            //隐藏的class声明

            new MyInterface() {
                public void test()
                {
                    System.out.println("匿名实现MyInterface接口");
                    System.out.println(temp);
                }
            }.test();
        }



        public static void main(String[] args) {
            InnerNoName inn = new InnerNoName();
            inn.dispaly(3);
        }
    }



