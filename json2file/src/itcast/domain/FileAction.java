package itcast.domain;

import java.io.*;

 /**
 * @author Jeremy
 * @create 2019/6/22-17:46
  * 文件的读出和写入
  *
 */
public class FileAction {

        //读出模板文件的内容到字符串
     public String fileOut(String modelUrl) {

         File file = new File(modelUrl);
         FileInputStream fis = null; //创建文件输入流
         try {
             fis = new FileInputStream(file);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         // InputStreamReader  in = new InputStreamReader(fis,"UTF-8");
         byte[] buffer = new byte[1024]; //创建文件输入缓冲区
         ByteArrayOutputStream bos = new ByteArrayOutputStream(); //创建内存输出流
         int len = 0;

         while (true) {
             try {
                 if (!((len = fis.read(buffer)) != -1)) break;
             } catch (IOException e) {
                 e.printStackTrace();
             } //当整个循环结束后，文件中的内容就全部写入了缓冲区
             bos.write(buffer, 0, len);
         }

         byte[] result = bos.toByteArray(); //通过内存输出流把读到的内容放进字节数组
         String content = new String(result); //通过字符型的数据存放结果，也就把文件中的内容赋值给了content变量
         return content;
     }


          //将字符串重新写入文件
     public void fileIn(String con,String url) {

         File writeName = new File(url); // 相对路径，如果没有则要建立一个新的file.txt文件
         try {
             writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
         } catch (IOException e) {
             e.printStackTrace();
         }
         try (FileWriter writer = new FileWriter(writeName);
              BufferedWriter out = new BufferedWriter(writer)
         ) {
             out.write(con);

             out.flush(); // 把缓存区内容压入文件
         } catch (IOException e) {
             e.printStackTrace();
         }
   }
}





