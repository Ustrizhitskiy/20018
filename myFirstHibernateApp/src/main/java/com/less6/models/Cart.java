package com.less6.models;

import javax.persistence.*;

@Entity
@Table(name = "carts")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String product_name;
    private int cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")

    private User user;

    public Cart() {
    }

    public Cart(String product_name, int cost) {
        this.product_name = product_name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        String costToString = String.valueOf(cost);
        return product_name + " " + costToString;
    }
}
