package repostitory.impl;

import entity.Admin;
import entity.User;
import repostitory.AdminRepostitory;
import uitls.DBUilt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepostitoryImpl implements AdminRepostitory {
    @Override
    public Admin Login(String username, String password) {
        String sql = "select * from s_admin where name=? and password=?";
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        Admin admin = null;
        try {
            Connection connection = DBUilt.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                admin = new Admin(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)

                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admin;
    }
}
