package com.shop.services.impl;

import com.shop.DAO.BuyerDAO;
import com.shop.models.Buyer;
import com.shop.models.Shop;
import com.shop.services.BuyerService;
import com.shop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;

public class BuyerServiceImpl implements BuyerService {

    @Autowired
    ShopService shopService;

    @Autowired
    BuyerDAO buyerDAO;

    @Override
    public void saveBuyer(Buyer buyer, int id) {
        Shop shopById = shopService.getShop(id);
        buyer.setShop(shopById);
        buyerDAO.saveBuyer(buyer);
    }
}
