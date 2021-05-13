package util;

import java.sql.*;

/*
        JDBC工具类
*/
public class DBUilt {
    String url = "jdbc:mysql://localhost:3306/yzx";//数据库url
    String uesr = "root";//数据库用户名
    String password = "root";//密码
    Connection con = null;
    PreparedStatement ps = null;
    //使用静态代码块，类加载。
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //  获取数据库连接对象，并返回。
    public  Connection getConnection() {
        try {
            con = DriverManager.getConnection(url,uesr,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (con != null){
            System.out.println("数据库操作成功");
        }else {
            System.out.println("数据库链接失败");
        }
        return con;
    }
    public PreparedStatement creatStatement(String sql) {
        try {
            ps = getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    //关闭资源。
    public  void close(){

        if (ps != null ){
            try {
                ps.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null ){
            try {
                con.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
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