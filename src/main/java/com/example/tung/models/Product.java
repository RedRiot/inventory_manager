package com.example.tung.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int price;
    private int quantity;
    private int itemBuying;

    public Product() {
    }

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.itemBuying = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemBuying() {
        return itemBuying;
    }

    public void setItemBuying(int itemBuying) {
        this.itemBuying = itemBuying;
    }

    public Integer decreaseQuantit(){
        return quantity = quantity - this.itemBuying;

    }

    public Integer totalPriceforOneKindOfProduct() {
        int totalPrice = itemBuying * price;
        return totalPrice;
    }


}
