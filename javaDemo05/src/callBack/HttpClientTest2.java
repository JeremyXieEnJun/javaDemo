package callBack;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Jeremy
 * @create 2019/6/18-12:08
 * 测试：HttpClient 的post请求
 */

public class HttpClientTest2 {

    public static void main(String args[]) throws Exception {

        //1、请求地址
        String  url = "http://localhost:8080/javaDemo05/Main.html";

        //2、请求方法
        HttpPost post = new HttpPost(url);
        //3-0-1 添加请求头
        // post.setHeader("Accept","application/json");

        //3-0-2 准备参数  Post请求将参数放在 请求体中
        List<NameValuePair> paramerts = new ArrayList<>();
            paramerts.add(new BasicNameValuePair("uname","Jeremy"));
            paramerts.add(new BasicNameValuePair("pwd","123"));
        // 将参数设置到entity对象中
        HttpEntity requestEntity = new UrlEncodedFormEntity(paramerts,"UTF-8");
        post.setEntity(requestEntity);

        // 3、准备一个发包客户端，创建一个默认的HttpClient
        CloseableHttpClient httpClient =  HttpClients.createDefault();

        //4、通过客户端发包  --》 获取响应
        CloseableHttpResponse  response = httpClient.execute(post);  //响应报文 --》 响应对象

        //5、获取响应中间信息、对响应内容进行分析

        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());
        String entityString = EntityUtils.toString(entity);
        System.out.println(entityString);


        //6、拿到响应信息 --》去和测试用例编写的期望结果作对比 --》 判断测试用例是否执行 --》断言


    }
}