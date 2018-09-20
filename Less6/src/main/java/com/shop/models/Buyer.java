package com.shop.models;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Buyer() {
    }

    public Buyer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
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

    public int getage() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nbuyer_id: " + id + ", name: " + name + ", age: " + age ;
    }
}
