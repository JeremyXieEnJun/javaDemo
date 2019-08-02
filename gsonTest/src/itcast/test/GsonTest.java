package itcast.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import itcast.domain.Person;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jeremy
 * @create 2019/6/21-16:53
 */
public class GsonTest {


    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person p  = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("女");
        p.setBirthday(new Date());

        //2.创建Gson的核心对象   gson
        Gson gson = new Gson();
        String s1 = gson.toJson(p);
        System.out.println("简单Bean转化为Json===" + s1);
        //3.转换

        //writeValue，将数据写到d://a.txt文件中
        //mapper.writeValue(new File("d://a.txt"),p);

        //writeValue.将数据关联到Writer中
        String s2 = gson.toJson(p);
        System.out.println(s2);
        gson.toJson(p,System.out);
    }


    @Test
    public void test2() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("李晶晶");
        p.setAge(25);
        p.setGender("女");
        p.setBirthday(new Date());
        //2.转换

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(p);
        System.out.println(json);

        //演示 JSON字符串转为Java对象
        String json1 = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthday\":1993-09-3}";
        Person p1 = gson.fromJson(json1,Person.class);
        System.out.println(p1);

        //得到的对象中的日期是一个Date类型，需要转化为字符串类型，好使用
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println( simpleDateFormat.format(p1.getBirthday()));
    }



    @Test
    public void test3() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());


        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);


        //2.转换
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(ps);
        System.out.println(json);

        //预测结果
        // [{},{},{}]
        //[{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"},{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"},{"name":"张三","age":23,"gender":"男","birthday":"2018-07-07"}]

    }

    @Test
    public void test4() throws Exception {
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        //2.转换
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String json = gson.toJson(map);
        System.out.println(json);

        //预测结果：
        //{"name":"张三","age":23,"gender":"男"}
       // System.out.println(json);//{"gender":"男","name":"张三","age":23}
    }

    @Test
    public void test5() throws Exception {

        //1.创建Person对象
        Person p  = new Person();
        p.setName("张");
        p.setAge(24);
        p.setGender("男");
        p.setBirthday(new Date());

        //2.创建Gson的核心对象   gson
        //这里使用了一个Gson自己写的一个适配器（用来规范反序列化时时间的格式）
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(p);
        System.out.println("简单Bean转化为Json===" + json);

        //3.转换

        //将数据写到文件中

        //将json字符串写入到json文件中
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(System.getProperty("user.dir") +"\\resorces\\jsonfile1\\create.json"));
            System.out.println(System.getProperty("user.dir"));
        } catch (IOException e) {
           e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.flush();
        bw.close();
    }
}
