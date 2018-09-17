package com.less6.dao;

import com.less6.models.User;

import java.io.Serializable;

public interface UserDao {

    Serializable saveUser(User user);
}
