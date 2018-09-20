package com.shop.DAO.impl;

import com.shop.DAO.ShopDAO;
import com.shop.models.Buyer;
import com.shop.models.Shop;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void saveShop(Shop shop) {
        getSession().saveOrUpdate(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        getSession().saveOrUpdate(shop);
    }

    @Override
    public Shop getShopById(int id) {
        return (Shop) getSession().get(Shop.class, id);
    }


/*    @Override
    public void deleteShop(Shop shop) {

    }

    @Override
    public List<Shop> findAll() {
        return null;
    }

    @Override
    public Buyer findBuyerById(int id) {
        return null;
    }*/
}
