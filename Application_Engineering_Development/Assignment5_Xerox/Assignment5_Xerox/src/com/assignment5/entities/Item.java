/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

/**
 *
 * @author shailly
 */
public class Item {
    int itemId;
    int productId;
    int salesPrice;
    int quantity;
    int diffTargetAndSales;//Added by Tasleem

    public Item(int itemId,int productId, int salesPrice, int quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getDiffTargetAndSales() {
        return diffTargetAndSales;
    }

    public void setDiffTargetAndSales(int diffTargetAndSales) {
        this.diffTargetAndSales = diffTargetAndSales;
    }
    
    
        @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", productId=" + productId + ", salesPrice=" + salesPrice + ", quantity="
                + quantity + "]\n";
    }
    
    
    
}
