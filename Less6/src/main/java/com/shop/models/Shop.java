/*
package com.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table (name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")  //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buyer> buyers;

    public Shop(String name) {
        this.name = name;
        this.buyers = new ArrayList<>();
    }
}
*/


package com.shop.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")  //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buyer> buyers;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
        this.buyers = new ArrayList<Buyer>();
    }

    public void addBuyer(Buyer buyer) {
        buyer.setShop(this);
        buyers.add(buyer);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public List<Buyer> getBuyers() {
        return buyers;
    }*/

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public void removeBuyer(Buyer buyer) {
        buyers.remove(buyer);
    }

    @Override
    public String toString() {
        return "shop_id: " + id + ", shop_name: " + name;
    }
}
