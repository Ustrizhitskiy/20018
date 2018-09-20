package com.shop.DAO;

import com.shop.models.Buyer;
import com.shop.models.Shop;

import java.util.List;

public interface ShopDAO {

    void saveShop(Shop shop);

    void updateShop(Shop shop);

    Shop getShopById(int id);



/*    void deleteShop(Shop shop);

    List<Shop> findAll();

    Buyer findBuyerById(int id);*/
}
