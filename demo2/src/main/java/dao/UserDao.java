package dao;

import entity.User;
import util.DBUilt;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private DBUilt uilt = new DBUilt();
    public int add(User user){
        String sql = "insert into users(userName,password,sex,email)" +
                "values()";
        int result = 0;
        PreparedStatement ps = uilt.creatStatement(sql);
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4,user.getEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            uilt.close();
        }
        return result;
    }
}
