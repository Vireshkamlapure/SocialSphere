package com.adtu.dao;

import com.adtu.model.User;
import com.adtu.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO{
    @Override
    public int Register(User user) {

        int res = 1;
        try {
            String sql = "insert into user(UID,password,email) values(?,?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUid());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            return 0;
        }

    }

    @Override
    public User login(User user) {

        User user1 = new User();
        int res  =0;
        try {
            String uname , pass;
            Statement statement = DBUtil.getConnection().createStatement();
            String sql = "select * from user";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                uname = resultSet.getString(1);
                pass = resultSet.getString(2);
                if (uname.equals(user.getUid()) && pass.equals(user.getPassword())) {
                    user1.setUid(resultSet.getString(1));
                    user1.setPassword(resultSet.getString(2));
                    return user1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user1;
    }

}
