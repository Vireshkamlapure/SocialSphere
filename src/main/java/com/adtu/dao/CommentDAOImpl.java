package com.adtu.dao;

import com.adtu.model.Comment;
import com.adtu.model.Post;
import com.adtu.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{
    @Override
    public int createComment(Comment comment) {

        try {
            String sql = "insert into comment(uid , pid , content) values(?,?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,comment.getuID());
            preparedStatement.setInt(2, comment.getpID());
            preparedStatement.setString(3, comment.getContent());
            int res ;
            res = preparedStatement.executeUpdate();
            return  res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Comment> view() {

        List<Comment> commentList = new ArrayList<>();

        try {
            String sql = "select * from comment";
            Statement statement = DBUtil.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                commentList.add(new Comment(
                        resultSet.getInt(1),
                        resultSet.getInt(3),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate()

                ));
            }
            return commentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }
}
