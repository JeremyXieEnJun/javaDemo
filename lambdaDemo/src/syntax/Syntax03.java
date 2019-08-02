package syntax;

import interfaces.LambdaSingleReturnSingleParameter;

/**
 * @author Jeremy
 * @create 2019/7/31-10:50
 */
public class Syntax03 {
     public static void main(String[] args){
         //方法引用：
         //可以快速地将一个Lambda表达式的实现指向一个已经实现的方法。
         //语法：方法的隶属者::方法名
         //      静态方法的隶属者是类
         //      普通方法的隶属者是对象

         //注意：
         //     1、参数数量和类型一定要和接口中定义的方法一致
         //     2、返回值的类型一定要和接口中定义的方法一致

         LambdaSingleReturnSingleParameter lambda1  = a -> change(a);

         LambdaSingleReturnSingleParameter lambda2  = Syntax03::change;


      }

      private  static  int change (int a){
         return 2*a;
      }
}
