package com.shop.services;

import com.shop.models.Buyer;
import com.shop.models.Shop;

import java.util.List;

public interface ShopService {

    void saveShop(Shop shop);

    void update(Shop shop);

    Shop getShop(int id);

    List<Buyer> getAllBuyersByShopId(int id);

/*    void delete(Shop shop);

    public List<Shop> findAll();

    public Buyer findBuyerById(int id);*/
}
