package dao;

import entity.Users;
import util.DBUilt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private DBUilt uilt = new DBUilt();
    public int add(Users users){
        String sql = "insert into users(userName,password,sex,email)" +
                "values(?,?,?,?)";
        int result = 0;
        PreparedStatement ps = uilt.creatStatement(sql);
        try {
            ps.setString(1, users.getUserName());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getSex());
            ps.setString(4, users.getEmail());
            result =  ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            uilt.close();
        }
        return result;
    }
    public java.util.List<Users> findAll(){
        String sql = "select * from users";
        PreparedStatement ps = uilt.creatStatement(sql);
        ResultSet res = null;
        ArrayList<Users> userlist = new ArrayList();
        try {
            res = ps.executeQuery();
            while (res.next()){
                Integer userId = res.getInt("userId");
                String userName = res.getString("userName");
                String password = res.getString("password");
                String sex = res.getString("sex");
                String email = res.getString("email");
                Users users = new Users(userId,userName,password,sex,email);
                userlist.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            uilt.close(res);
        }
        return userlist;
    }
    public int delete(String userId){
        String sql = "delete from users where userId=?";
        PreparedStatement ps = uilt.creatStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            uilt.close();
        }
       return result;
    }
    public int login(String userName,String password){
        int result = 0;
        String sql = "select count(*) from users where userName=? and password=?";
        PreparedStatement ps = uilt.creatStatement(sql);
        ResultSet res=null;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            res = ps.executeQuery();
            while (res.next()){
               result =  res.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            uilt.close();
        }
        return result;
    }
}
