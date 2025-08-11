package com.adtu.dao;

import com.adtu.model.Comment;

import java.util.List;

public interface CommentDAO {
    public int createComment(Comment comment);
    public List<Comment> view();
}
