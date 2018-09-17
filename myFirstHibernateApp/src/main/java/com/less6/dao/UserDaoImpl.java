package com.less6.dao;

import com.less6.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable saveUser(User user) {
        return getSession().save(user);
    }
}
