package jdbc_demo;

import java.sql.*;
public class my {




//    public static void main(String args[]) {

//        String account = "123";
//        String password = "123456";
//        int state = 0;

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序
//            //Class.forName("org.gjt.mm.mysql.Driver");
//            System.out.println("Success loading Mysql Driver!");
//        }
//        catch (Exception e) {
//            System.out.print("Error loading Mysql Driver!");
//            e.printStackTrace();
//        }
//        try {
//            Connection connect = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/demo","root","Azrael19980123");
//            //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
//
//            System.out.println("Success connect Mysql server!");
//            Statement stmt = connect.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from user");
//            //user 为你表的名称
//            while (rs.next()) {
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("password"));
//                if(account.equals(rs.getString("name"))&&password.equals(rs.getString("password")))
//                    state = 1;
//            }
//            System.out.println(state);
//        }
//        catch (Exception e) {
//            System.out.print("get data error!");
//            e.printStackTrace();
//        }
//    }

    public static int  compare(String account,String password)
    {
        int state = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序
            //Class.forName("org.gjt.mm.mysql.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
        try {
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8","root","root");
            //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

            System.out.println("Success connect Mysql server!");
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            //user 为你表的名称
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                if(account.equals(rs.getString("name"))&&password.equals(rs.getString("password")))
                    state = 1;
            }
            System.out.println(state);
        }
        catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
        return state;
    }


}