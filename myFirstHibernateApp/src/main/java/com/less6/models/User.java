package com.less6.models;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")

public class User {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts;

    public User() {
    }

    public User(String name) {
        this.id = id;
        this.name = name;
        carts = new ArrayList<>();
    }

    public void addCart(Cart cart) {
        cart.setUser(this);
        carts.add(cart);
    }

    public void removeCart(Cart cart) {
        carts.remove(cart);
    }

    public int getId() {
        return id;
    }

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarts (List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "models.User{" + "id = " + id + ", name = " + name +'}';
    }
}
