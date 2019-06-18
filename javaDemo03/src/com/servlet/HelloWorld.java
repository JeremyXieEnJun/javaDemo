package com.servlet;

/**
 * @author Jeremy
 * @create 2019/6/17-23:45
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

 public class HelloWorld extends HttpServlet {
 private static final long serialVersionUID = 4601029764222607869L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置编码格式
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // 2. 往返回体中写返回数据

        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.print("Hello world! 你好，世界！！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        // 1. 获取请求的参数
         String userName = req.getParameter("username");
         String password = req.getParameter("password");

         // 2. 往返回体写返回数据
         PrintWriter writer = null;
         try {
             writer = resp.getWriter();
             writer.print("your username is:" + userName + "\nyour password is:" + password);
         } catch (Exception e) {
                          e.printStackTrace();
         } finally {
                          writer.close();
         }
    }

 }