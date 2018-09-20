package com.shop.services.impl;

import com.shop.models.Buyer;
import com.shop.models.Shop;
import com.shop.services.BuyerService;
import com.shop.services.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app.xml"})

public class ShopServiceTest {
    @Autowired
    ShopService shopService;

    @Autowired
    BuyerService buyerService;

    @Test
    public void test() {
        List<Buyer> allBuyersMagnit = new ArrayList<Buyer>();

        Shop shop1 = new Shop("Dixie");
        Shop shop2 = new Shop("Magnit");
        shopService.saveShop(shop1);
        shopService.saveShop(shop2);
        int id1 = shop1.getId();
        int id2 = shop2.getId();

        Buyer buyer1 = new Buyer("George", 45);
        Buyer buyer2 = new Buyer("Michael", 31);
        Buyer buyer3 = new Buyer("Oksana", 23);
        buyerService.saveBuyer(buyer1, id1);
        buyerService.saveBuyer(buyer2, id2);
        buyerService.saveBuyer(buyer3, id1);

        allBuyersMagnit = shopService.getAllBuyersByShopId(id1);
        Assert.assertEquals(2, allBuyersMagnit.size());
    }

}
