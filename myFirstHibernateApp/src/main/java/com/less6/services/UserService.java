package com.less6.services;

import com.less6.models.User;

import java.io.Serializable;

public interface UserService {

    Serializable save(User user);
}
