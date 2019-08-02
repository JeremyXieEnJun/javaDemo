package test;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;


/**
 * @author Jeremy
 * @create 2019/6/18-12:08
 * 测试：HttpClient 的get请求
 */

public class HttpClientTest1 {

    public static void main(String args[]) throws Exception {

             //1、请求地址
            String  url = "http://localhost:8080/javaDemo05/Main.html";

             //2、请求方法
            HttpGet get = new HttpGet(url);

            // 3、准备一个发包客户端，创建一个默认的HttpClient
            CloseableHttpClient httpClient =  HttpClients.createDefault();

            //4、通过客户端发包  --》 获取响应
            CloseableHttpResponse  response = httpClient.execute(get);  //响应报文 --》 响应对象

            //5、对响应内容进行分析

            // 1)状态行
            System.out.println(response.getStatusLine());
            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getReasonPhrase());
            System.out.println(response.getStatusLine().getProtocolVersion());


            // 2)响应头 ：cookie
            Header [] headers = response.getAllHeaders();
             for (Header header: headers){
                 System.out.println(header.getName()+":"+header.getValue());
             }
            // 3)响应体
            HttpEntity entity = response.getEntity();
             //把响应体转换为字符串
            String entityString = EntityUtils.toString(entity);
            System.out.println( entityString);

            //6、拿到响应信息 --》去和测试用例编写的期望结果作对比 --》 判断测试用例是否执行 --》断言


    }
}