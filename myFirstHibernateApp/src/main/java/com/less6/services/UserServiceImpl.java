package com.less6.services;

import com.less6.dao.UserDao;
import com.less6.dao.UserDaoImpl;
import com.less6.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Serializable save(User user) {
        return userDao.saveUser(user);
    }


}
