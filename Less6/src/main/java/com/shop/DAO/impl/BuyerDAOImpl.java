package com.shop.DAO.impl;

import com.shop.DAO.BuyerDAO;
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
public class BuyerDAOImpl implements BuyerDAO {

    @Autowired
    private SessionFactory sessionFactory;
        protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void saveBuyer(Buyer buyer) {
        getSession().saveOrUpdate(buyer);
    }

    @Override
    public List<Buyer> getAllBuyersByShopId(Shop shop) {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        criteria.add(Restrictions.eq("shop", shop));
        return criteria.list();
    }
}
