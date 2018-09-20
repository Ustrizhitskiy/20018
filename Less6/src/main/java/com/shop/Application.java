package com.shop;

import com.shop.config.ApplicationConfig;

import com.shop.models.Buyer;
import com.shop.models.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.shop.services.impl.ShopServiceImpl;

import java.util.List;


@Component
public class Application {

    @Autowired
    ShopServiceImpl shopServiceImpl;

    public static void main(String args[]) {
//создаем контекст для взаимодействия , т.к. main не может общаться с методами run
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Application app = ctx.getBean(Application.class);
        app.run();
    }

    private void run() {

/*        Shop shop = new Shop("OBI");
        shopServiceImpl.saveShop(shop);
        Buyer buyer1 = new Buyer("Marina", 29);
        buyer1.setShop(shop);
        shop.addBuyer(buyer1);
        shopServiceImpl.update(shop);*/

        Shop shop = shopServiceImpl.getShop(10);
        shop.setName("Murlo");
        shopServiceImpl.update(shop);
        System.out.println(shop);
        List<Buyer> listById = shopServiceImpl.getAllBuyersByShopId(10);
        System.out.println(listById);
    }
}
