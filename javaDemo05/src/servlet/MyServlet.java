package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import jdbc_demo.my;


@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname+":"+pwd);
        if(my.compare(uname,pwd)==1)
        {
            System.out.println("Success");
            resp.getWriter().write("<script>alert('登录成功！');window.location='http://localhost:8080/javaDemo05/helloWorld.html';</script>");
        }
        else {
            System.out.println("filed");
            resp.getWriter().write("<script>alert('登录失败！');window.location='http://localhost:8080/javaDemo05/Main.html';</script>");
        }


    }
}
