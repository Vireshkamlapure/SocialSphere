package com.adtu.dao;

import com.adtu.model.User;

public interface UserDAO {
    int Register(User user);
    User login(User user);
}
