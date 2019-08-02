package functional;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Jeremy
 * @create 2019/8/1-11:01
 */
public class LambdaDemo {

        //测试自定义的Lambda函数式接口

         @Test
         public void test01(){
             String br = LambdaDemo.processFile(b -> b.readLine());
             System.out.println(br);
             br = LambdaDemo.processFile(b -> b.readLine() + b.readLine() + b.readLine());
             System.out.println(br);
         }

        /**
         * 将读取文件的动作封装成参数
         * @param b
         * @return
         */
         public static String processFile(BufferedReaderProcess b){   //这里的参数 b 是一个接口，需要实现
             //读取文件的一行
             try(BufferedReader br =  new BufferedReader( new FileReader("C:/Users/Administrator/Desktop/任务总结/2019-7-30.txt"))) {
                 return b.process(br);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return null;
         }
}


