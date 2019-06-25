package itcast.test;

import itcast.domain.FileAction;
import itcast.domain.JsonToChange;

import java.io.*;

/**
 * @author Jeremy
 * @create 2019/6/22-15:11
 * 基于一个json字符串输入和一个模板文件
 * 设计一个处理程序，该程序能将输入的json字符串中的信息提取出来，并基于模板文件，生成一个新的文件，这个新的文件内容是模板文件与json字符串中的
 * 关键信息的综合。
 */

public class JsonReToFile {

    public static void main(String[] args) throws IOException {

        //读出文件的内容到字符串
        String url ="E:/javaDemo/json2file/file.txt";
        FileAction fileAction = new FileAction();
        String content = fileAction.fileOut(url);

        //Json数据
        String json = "{\n" +
                "  \"zoneName\": \"卫生间10\",\n" +
                "  \"triggers\": {\n" +
                "        \"inzonesensor_ON\": [\"a1\",\"a13\",\"a14\"],\n" +
                "        \"inzonesensor_OFF\": [\"b11\",\"b14\",\"b15\"],\n" +
                "        \"inzonesensor_ONOFF\": [\"c12\",\"c113\",\"c14\"],\n" +
                "        \"outzonesensor_ON\": [\"d1\"],\n" +
                "        \"outzonesensor_OFF\": [\"e2\"]\n" +
                "  },\n" +
                "  \"actions\": {\n" +
                "    \"leaveDevice\": [],\n" +
                "    \"occupancyDevice\": [\"testsensor1\",\"testsensor2\"]\n" +
                "  },\n" +
                "  \"timers\": {\n" +
                "    \"occupTimeoutMinutes\": 10,\n" +
                "    \"leaveTimeoutMinutes\": 30\n" +
                "  }\n" +
                "}";

             //将模板字符串的数据串，进行Json数据填充
            JsonToChange jsonToChange = new JsonToChange();
            //填充之后返回一个字符串
            String con = jsonToChange.jsonChange(json,content);


            //重新将字符串写入文件
            fileAction = new FileAction();
            fileAction.fileIn(con,url);


    }
}