package test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownHostException;

/**
 * @author Jeremy
 * @create 2019/6/19-11:17
 * 测试：用HttpClient来爬取页面
 * 接下来的工作就是从简单到复杂，不断扩充爬虫的能力和功能了，包括页面信息提取等。
 */
public class HttpClientTest4 {
    private void Get() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String HostName = "http://www.baidu.com";
            HttpGet httpget = new HttpGet(HostName);
            System.out.println(httpget.getURI());
            //HttpGet httpget = new HttpGet("http://www.lietu.com");
            CloseableHttpResponse response = httpclient.execute(httpget);
            System.out.println("Successful!");
            System.out.println(response.getProtocolVersion());  //Protocol Version
            System.out.println(response.getStatusLine().getStatusCode());   //Status Code
            System.out.println(response.getStatusLine().getReasonPhrase());
            System.out.println(response.getStatusLine().toString());

            //get entity
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream input = entity.getContent();
                String filename = HostName.substring(HostName.lastIndexOf('/')+1);
                System.out.println("The filename is: " + filename);
                OutputStream output = new FileOutputStream(filename);

                int tempByte=-1;
                while ((tempByte=input.read())>0) {
                    output.write(tempByte);
                }

                if (input != null) {
                    input.close();
                }

                if (output != null) {
                    output.close();
                }
            }
        } catch(UnknownHostException e) {
            System.out.println("No such a host!");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpClientTest4 h = new HttpClientTest4();
        h.Get();
        System.out.println("This is a test");
    }
}