package syntax;

import interfaces.LambdaNoneReturnMutipleParamter;
import interfaces.LambdaNoneReturnSingleParameter;
import interfaces.LambdaSingleReturnMutipleParameter;
import interfaces.LambdaSingleReturnNoneParameter;
import sun.security.krb5.internal.LocalSeqNumber;

/**
 * @author Jeremy
 * @create 2019/7/31-10:09
 */
public class Syntax02 {
     public static void main(String[] args){
         //语法的精简：
         //1.参数类型：
         //由于在接口的抽象方法中，已经定义了参数的数量和类型。所以在Lambda表达式中，参数的类型可以省略。
         //备注：如果需要省略类型，则每一个参数的类型都要省略。千万不要出现省略一个参数类型，不省略一个参数类型的情况
         LambdaNoneReturnMutipleParamter lambda1 = (a,b) ->{
             System.out.println("hello world");
         };

         //2.参数小括号：
         //如果参数列表中，参数的数量只有一个。此时小括号可以省略
         LambdaNoneReturnSingleParameter lambda2 = a ->{
             System.out.println("hello world");
         };

         //3.方法的大括号：
         //如果方法体中只有一条语句，此刻大括号可以省略
         LambdaNoneReturnSingleParameter lambda3 = a -> System.out.println("hello world");

         //4.省略return
         //如果方法体中唯一的一条语句是返回语句，则在省略掉大括号的同时，也必须省略掉return
         LambdaSingleReturnNoneParameter lambda4 =() -> 10;

         LambdaSingleReturnMutipleParameter lambda5 =(a,b) ->a+b;

      
      }
    
}
