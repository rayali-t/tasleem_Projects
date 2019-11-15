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
public class SalesPerson {
   private int salesPersonId;
   private List<Order> orders;
   int sumOfDiff;//Added by Tasleem
    int profitSumOfDiff;//Added by Tasleem

    public SalesPerson(int salesPersonId) {
        this.salesPersonId = salesPersonId;
        this.orders = new ArrayList<>();
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getSumOfDiff() {
        return sumOfDiff;
    }

    public void setSumOfDiff(int sumOfDiff) {
        this.sumOfDiff = sumOfDiff;
    }

    public int getProfitSumOfDiff() {
        return profitSumOfDiff;
    }

    public void setProfitSumOfDiff(int profitSumOfDiff) {
        this.profitSumOfDiff = profitSumOfDiff;
    }
    
    
   
   
}
