package com.shop.DAO;

import com.shop.models.Buyer;
import com.shop.models.Shop;

import java.util.List;

public interface BuyerDAO {

    void saveBuyer(Buyer buyer);

    List<Buyer> getAllBuyersByShopId(Shop shop);
}
