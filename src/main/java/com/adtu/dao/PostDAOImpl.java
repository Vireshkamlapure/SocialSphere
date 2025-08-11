package com.adtu.dao;

import com.adtu.model.Post;
import com.adtu.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO{
    @Override
    public int createPost(Post post) {

        try {
            String sql ="insert into post(title,content,uid) values(?,?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3,post.getUid());
            int res ;
            res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Post> view(){

        List<Post> postList = new ArrayList();
        try {
            String sql = "SELECT p.PID, p.title, p.timestamp, p.content, p.UID, u.uid FROM Post p JOIN User u ON p.UID = u.UID ORDER BY p.PID DESC";
            Statement statement = DBUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                postList.add(new Post(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
}
