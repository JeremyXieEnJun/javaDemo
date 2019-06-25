package itcast.domain;

import com.besjon.pojo.JsonRootBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Jeremy
 * @create 2019/6/22-16:19
 * 实验的核心方法  用Json数据对模板文件进行注入
 */
public class JsonToChange {

        //将模板字符串的数据串，进行Json数据填充
     public  String  jsonChange(String json,String content){

        //解析Json数据，生成对象
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonRootBean jsonRootBean = gson.fromJson(json, JsonRootBean.class);

        //注入值
        String con =content;
        //todo 封装方法
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();


        //提取替换关键字

         //1、替换"zoneName"
        con = con.replace("zoneName",jsonRootBean.getZoneName());
         //2、替换"triggers"
        jsonRootBean.getTriggers().forEach((k,v) -> {
            for(int i = 0; v.size() > i; i++ ) {

                //判断是哪一个开关
                if (k.equals("inzonesensor_ON")) {

                    sb1.append("Item " + v.get(i) + " changed from OFF to ON or\n");
                }

                if (k.equals("inzonesensor_OFF")) {

                    sb1.append("Item " + v.get(i) + " changed from ON to OFF or\n");
                }
                if (k.equals("inzonesensor_ONOFF")) {

                    sb1.append("Item " + v.get(i) + " changed from OFF to ON or\n");
                    sb1.append("Item " + v.get(i) + " changed from ON to OFF or\n");
                }
                if (k.equals("outzonesensor_ON")) {

                    sb2.append("Item " + v.get(i) + " changed from OFF to ON or\n");

                }
                if (k.equals("outzonesensor_OFF")) {
                    sb2.append("Item " + v.get(i) + " changed from ON to OFF or\n");
                }
            }
        });

        //删除最后两个字符，"or"
        sb1.delete(sb1.length()-4,sb1.length());
        //通过替换的方式，注入值
        con = con.replace("inzonesensor",sb1.toString());

        sb2.delete(sb2.length()-4,sb2.length());
        con =  con.replace("outzonesensor",sb2.toString());

         //3、替换"actions"
          //根据不同的action做替换操作
         for(String action :jsonRootBean.getActions().keySet()) {
             StringBuffer sb = new StringBuffer();
             //首先判断集合中是否有值
             if (! jsonRootBean.getActions().get(action).isEmpty()) {
                     for (String device : jsonRootBean.getActions().get(action)) {

                           sb.append(device + ".sendcommand(ON)\n");
                     }
                     sb.delete(sb.length()-1,sb.length());
                     con = con.replace(action, sb.toString());

                 } else{
                 con = con.replace("\""+action+"\"", "");
             }
         }

         //4、替换"timers"
        for(String timer :jsonRootBean.getTimers().keySet()){
            //通过替换的方式，注入值
            con = con.replace(timer,jsonRootBean.getTimers().get(timer));
        }

        return con;
    }

}
