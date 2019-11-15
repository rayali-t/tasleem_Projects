/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analytics.AnalysisHelper;
import com.assignment5.analytics.DataStore;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author shailly
 */
public class GateWay {

    DataReader orderReader;
    DataReader productReader;
    AnalysisHelper helper;

    public GateWay() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        orderReader = new DataReader(generator.getOrderFilePath());
        productReader = new DataReader(generator.getProductCataloguePath());
        helper = new AnalysisHelper();
    }

    public static void main(String args[]) throws IOException {
        GateWay inst = new GateWay();
        inst.readData();
    }

    private void readData() throws IOException {
        String[] row;
        while ((row = productReader.getNextRow()) != null) {
            generateProduct(row);
        }
        while ((row = orderReader.getNextRow()) != null) {
            Item item = generateItem(row);
            generateOrder(row, item);
        }

        generateCustomer();//Added  by Tasleem
        generateSalesPerson();//Added by Tasleem

        run();
    }

    private void generateProduct(String[] row) {
        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Product p = new Product(productId, minPrice, maxPrice, targetPrice);
        DataStore.getInstance().getProducts().put(productId, p);

    }

    private Item generateItem(String[] row) {
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int salesPrice = Integer.parseInt(row[6]);
        int quantity = Integer.parseInt(row[3]);
        Item item = new Item(itemId, productId, salesPrice, quantity);
        DataStore.getInstance().getItems().put(itemId, item);
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        if (products.containsKey(productId)) {
            products.get(productId).getItems().add(item);

        }
        return item;

    }

    private void generateOrder(String[] row, Item item) {
        int orderId = Integer.parseInt(row[0]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        if (orders.containsKey(orderId)) {
            orders.get(orderId).getItems().add(item);
        } else {
            Order order = new Order(orderId, salesId, customerId, item);
            order.getItems().add(item);
            orders.put(orderId, order);
        }
    }

    //Start:Added by Tasleem
    private void generateCustomer() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Customer> customers = DataStore.getInstance().getCustomers();

        for (Order orderVar : orders.values()) {
            int customerId = orderVar.getCustomerId();
            if (customers.containsKey(customerId)) {
                customers.get(customerId).getOrders().add(orderVar);
            } else {
                Customer customer = new Customer(customerId);
                customer.getOrders().add(orderVar);
                customers.put(customerId, customer);
            }
        }
    }

    private void generateSalesPerson() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, SalesPerson> salesPersons = DataStore.getInstance().getSalesPersons();

        for (Order orderVar : orders.values()) {
            int salesId = orderVar.getSupplierId();
            if (salesPersons.containsKey(salesId)) {
                salesPersons.get(salesId).getOrders().add(orderVar);
            } else {
                SalesPerson salesPerson = new SalesPerson(salesId);
                salesPerson.getOrders().add(orderVar);
                salesPersons.put(salesId, salesPerson);
            }
        }
    }
//End: Added by Tasleem

    public void run() {
        //Question1:Top 3 negotiated Products
        helper.top3bestNegotiatedProducts();//Added by Tasleem

        helper.top3Customers();
        System.out.println();
        helper.top3salesperson();
        System.out.println();

        //Question 4: total revenue for the year that is above expected target
        helper.getTotalRevenue();//Added by Tasleem

        //Eshanee - Question 5 : Price Optimization
        helper.targetPriceOptimization();
    }

}
