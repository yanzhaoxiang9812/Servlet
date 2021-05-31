package repostitory.impl;

import entity.User;
import repostitory.UserRepostitory;
import uitls.DBUilt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepostitoryImpl implements UserRepostitory {
    @Override
    public User Login(String username, String password) {
        String sql = "select * from s_student where name=? and password=?";
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        User user = null;
        try {
            Connection connection = DBUilt.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                    user = new User(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)
                    );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
