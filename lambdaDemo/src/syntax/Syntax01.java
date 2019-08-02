package syntax;

import interfaces.*;

/**
 * @author Jeremy
 * @create 2019/7/30-17:47
 */
public class Syntax01 {
     public static void main(String[] args){
         //1.Lambda表达式的基础语法
         //Lambda是一个匿名函数
         //需要关注：参数列表  方法体
         //不需要关注：参数类型（因为会有  类型推断）
         //           返回值类型（不用显式说明）
         //           方法名（匿名函数）

         //  ()  :用来描述参数列表
         //  {}  :用来描述方法体   （注意分号）
         //  ->  :Lambda运算符，读作 ：goes to

         //无参数无返回值
         LambdaNoneReturnNoneParameter lambda1 = () -> {
             System.out.println("hello world");
         };
         lambda1.test();

         //单个参数无返回值
         LambdaNoneReturnSingleParameter lambda2 =(int n) -> {
             System.out.println(n);
         };
         lambda2.test(10);

         //多个参数无返回值
         LambdaNoneReturnMutipleParamter lambda3 =(int n,int m) -> {
             System.out.println(n+m);
         };
         lambda3.test(10,20);

         //无参数有返回值
         LambdaSingleReturnNoneParameter lambda4 = () -> {
             System.out.println("无参数有返回值");
             return  100;
         };
         System.out.println(lambda4.test());

         //单个参数有返回值
         LambdaSingleReturnSingleParameter lambda5 =(int n) -> {
            // System.out.println();
             return  n*2;
         };
         System.out.println(lambda5.test(10));

         //多个参数有返回值
         LambdaSingleReturnMutipleParameter lambda6 =(int n,int m) -> n+m ;



         System.out.println(lambda6.test(10,20));

     }
}
