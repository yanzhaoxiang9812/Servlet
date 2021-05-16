package util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

/*
        JDBC工具类
*/
public class DBUilt {
    String url = "jdbc:mysql://localhost:3306/yzx";
    String uesr = "root";
    String password = "root";
    Connection con = null;
    PreparedStatement ps = null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
                         重载getConnection方法
     */
    public  Connection getConnection(HttpServletRequest request) {
        //  通过请求对象获取全局作用域对象
        ServletContext application =  request.getServletContext();
       //   通过全局作用域对象获取map
        Map consMap = (Map) application.getAttribute("cons");
        //  获取一个空闲con
        Iterator iterator = consMap.keySet().iterator();
        while (iterator.hasNext()){
            con = (Connection) iterator.next();
           boolean flag = (boolean) consMap.get(con);
            if (flag == true){
                consMap.put(con,false);
                    break;
            }
        }
        return con;
    }

    public  Connection getConnection() {
        try {
            con = DriverManager.getConnection(url,uesr,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    /*
                     重载creatStatement方法
    */
    public PreparedStatement creatStatement(String sql,HttpServletRequest request) {
        try {
            ps = getConnection(request).prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    public PreparedStatement creatStatement(String sql) {
        try {
            ps = getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    /*
                        重载close方法
       */
    public  void close(HttpServletRequest request){
        if (ps != null ){
            try {
                ps.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        ServletContext application =  request.getServletContext();
        Map consMap = (Map) application.getAttribute("cons");
        consMap.put(con,true);
    }
    public void close(ResultSet res) {
        if (res != null ){
            try {
                res.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
    }
}