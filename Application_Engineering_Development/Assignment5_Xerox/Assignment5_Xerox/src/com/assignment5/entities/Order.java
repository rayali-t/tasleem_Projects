/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shailly
 */
public class Order {
    
    int orderId;
    int supplierId;
    int customerId;
    private List<Item>items;
    Item item;

    public Order(int orderId, int supplierId, int customerId, Item item) {
        this.orderId = orderId;
        this.supplierId = supplierId;
        this.customerId = customerId;
        this.item = item;
        this.items=new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
    
    
    
        @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerId=" + customerId + ", SupplierId=" + supplierId + ", items=" + items
                + "]\n";
    }
    
}
