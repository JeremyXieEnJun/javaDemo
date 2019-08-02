package itcast.test;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Jeremy
 * @create 2019/6/22-11:05
 * 测试将json字符串写入到json文件中
 */
public class GsonTest2 {

    public static  void main (String [] args) throws IOException {


        String json = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthday\":\"2018-07-07\"}";
        //将json字符串写入到json文件中
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(System.getProperty("user.dir") +"\\resources\\jsonfile\\create.json"));
            System.out.println(System.getProperty("user.dir"));
           // System.out.println(System.getResource());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.flush();
        bw.close();
    }


}