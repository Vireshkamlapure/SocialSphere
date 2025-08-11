package com.adtu.dao;

import com.adtu.model.Post;

import java.util.List;

public interface PostDAO {
    public int createPost(Post post);
    public List<Post> view();
}
