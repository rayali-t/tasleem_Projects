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
public class Product {

    private int productId;
    private int minPrice;
    private int maxPrice;
    private int targetPrice;
    private List<Item> items;
    private int sumQuantityOfProductsAboveTarget;//Added by Tasleem
    private double averageSalesPrice; //By Eshanee
    private double modifiedTargetPrice; //By Eshanee
    private double differenceInPrice; //By Eshanee
    private double newDifferenceInPrice; //By Eshanee
    private double error; //By Eshanee

    public Product(int productId, int minPrice, int maxPrice, int targetPrice) {
        this.productId = productId;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.targetPrice = targetPrice;
        this.averageSalesPrice = 0; //By Eshanee
        this.modifiedTargetPrice = 0; //By Eshanee
        this.error = 0; //By Eshanee
        this.differenceInPrice = 0; //By Eshanee
        this.newDifferenceInPrice = 0; //By Eshanee
        this.items = new ArrayList<>();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getSumQuantityOfProductsAboveTarget() {
        return sumQuantityOfProductsAboveTarget;
    }

    public void setSumQuantityOfProductsAboveTarget(int sumQuantityOfProductsAboveTarget) {
        this.sumQuantityOfProductsAboveTarget = sumQuantityOfProductsAboveTarget;
    }

    public double getAverageSalesPrice() {
        return averageSalesPrice;
    }

    public void setAverageSalesPrice(double averageSalesPrice) {
        this.averageSalesPrice = averageSalesPrice;
    }

    public double getModifiedTargetPrice() {
        return modifiedTargetPrice;
    }

    public void setModifiedTargetPrice(double modifiedTargetPrice) {
        this.modifiedTargetPrice = modifiedTargetPrice;
    }

    public double getDifferenceInPrice() {
        return differenceInPrice;
    }

    public void setDifferenceInPrice(double differenceInPrice) {
        this.differenceInPrice = differenceInPrice;
    }

    public double getNewDifferenceInPrice() {
        return newDifferenceInPrice;
    }

    public void setNewDifferenceInPrice(double newDifferenceInPrice) {
        this.newDifferenceInPrice = newDifferenceInPrice;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
                + ", targetPrice=" + targetPrice + ", items=" + items.size() + "]\n";
    }

}
