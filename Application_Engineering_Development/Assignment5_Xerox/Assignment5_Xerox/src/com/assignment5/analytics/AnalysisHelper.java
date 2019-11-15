/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import com.assignment5.xerox.DataGenerator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tashu
 */
public class AnalysisHelper {

    // Question 2: Our 3 best customers 
    public void top3Customers() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        List<Integer> CustomerPersonList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        Map<Integer, Integer> CustomerPersonMap = new HashMap<>();

        for (Order order : orders.values()) {
            if (!CustomerPersonList.contains(order.getCustomerId())) {
                CustomerPersonList.add(order.getCustomerId());
            }
        }
        for (Integer id : CustomerPersonList) {
            int sum = 0;
            for (Order order : orders.values()) {
                for (Product product : products.values()) {
                    if (order.getCustomerId() == id) {
                        int salesPrice = order.getItem().getSalesPrice();
                        int quantity = order.getItem().getQuantity();
                        if (order.getItem().getProductId() == product.getProductId()) {
                            int targetPrice = product.getTargetPrice();
                            //if(salesPrice>targetPrice){
                            sum += (salesPrice - targetPrice) * quantity;
                            //}
                        }
                    }
                }
            }
            sumList.add(sum);
            CustomerPersonMap.put(id, sum);
        }
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(CustomerPersonMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, comparator.reversed());
        System.out.println("Top 3 Best Customer:");
        System.out.println("-------------------------");
        System.out.printf("%10s %10s", "Customer ID", "Profit");
        System.out.println();
        System.out.println("-------------------------");

        int counter = 3, previousTotalProfit = 0, currentTotalProfit;
        for (int i = 0; i < list.size() && counter != 0; i++) {
            if (counter == 0) {
                break;
            }
            currentTotalProfit = list.get(i).getValue();
            if (previousTotalProfit != currentTotalProfit) {
                counter--;
            }
            System.out.format("%10s %10s", list.get(i).getKey(), list.get(i).getValue());
            System.out.println();
            previousTotalProfit = currentTotalProfit;
        }
        System.out.println("-------------------------");
    }

    // Question 3: sales people who have the most profit
    public void top3salesperson() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        List<Integer> salesPersonList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        Map<Integer, Integer> SalesPersonMap = new HashMap<>();
        for (Order order : orders.values()) {
            if (!salesPersonList.contains(order.getSupplierId())) {
                salesPersonList.add(order.getSupplierId());
            }
        }
        for (Integer id : salesPersonList) {
            int sum = 0;
            for (Order order : orders.values()) {
                for (Product product : products.values()) {
                    if (order.getSupplierId() == id) {
                        int salesPrice = order.getItem().getSalesPrice();
                        int quantity = order.getItem().getQuantity();
                        if (order.getItem().getProductId() == product.getProductId()) {
                            int targetPrice = product.getTargetPrice();
                            //if(salesPrice>targetPrice){
                            sum += (salesPrice - targetPrice) * quantity;
                            //}
                        }
                    }
                }
            }
            sumList.add(sum);
            SalesPersonMap.put(id, sum);
        }
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(SalesPersonMap.entrySet());
        Comparator<Map.Entry<Integer, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, comparator.reversed());
        System.out.println("Top 3 Best Sales Person:");
        System.out.println("-------------------------");
        System.out.printf("%10s %10s", "Supplier ID", "Profit");
        System.out.println();
        System.out.println("-------------------------");

        int counter = 3, previousTotalProfit = 0, currentTotalProfit;
        for (int i = 0; i < list.size() && counter != 0; i++) {
            if (counter == 0) {
                break;
            }
            currentTotalProfit = list.get(i).getValue();
            if (previousTotalProfit != currentTotalProfit) {
                counter--;
            }
            System.out.format("%10s %10s", list.get(i).getKey(), list.get(i).getValue());
            System.out.println();
            previousTotalProfit = currentTotalProfit;
        }
        System.out.println("-------------------------");
    }

    //Start:Added by Tasleem
    //Question1 :Top 3 best negotiated products
    public void top3bestNegotiatedProducts() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Item> items = DataStore.getInstance().getItems();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        List<Product> productList = new ArrayList<>(products.values());

        Map<Integer, Item> itemSoldAboveTarget = new HashMap<Integer, Item>();
        int sumQuantityOfProductsAboveTarget = 0;

        for (Item item : items.values()) {
            for (Product product : products.values()) {
                if ((product.getProductId() == item.getProductId()) && (item.getSalesPrice() > product.getTargetPrice())) {
                    itemSoldAboveTarget.put(item.getItemId(), item);
                }
            }
        }

        for (Product product : products.values()) {
            sumQuantityOfProductsAboveTarget = 0;
            for (Item item : itemSoldAboveTarget.values()) {
                if (item.getProductId() == product.getProductId()) {
                    sumQuantityOfProductsAboveTarget += item.getQuantity();
                }
            }
            product.setSumQuantityOfProductsAboveTarget(sumQuantityOfProductsAboveTarget);
        }

        Collections.sort(productList, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getSumQuantityOfProductsAboveTarget(), p1.getSumQuantityOfProductsAboveTarget());
            }
        });

        System.out.println("\nTop 3 best negotiated products: ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Product Id    Quantity of Product sold above Target Price");
        System.out.println("---------------------------------------------------------");

        int counter = 3, previousSum = -1, currentSum;
        for (int i = 0; i < productList.size() && counter != 0; i++) {
            if (counter == 0) {
                break;
            }
            currentSum = productList.get(i).getSumQuantityOfProductsAboveTarget();
            if (previousSum != currentSum) {
                counter--;
            }
            System.out.println("\t" + productList.get(i).getProductId() + "\t \t" + productList.get(i).getSumQuantityOfProductsAboveTarget());
            previousSum = currentSum;
        }

        System.out.println();
    }

//Question:4 Total revenue of the year that is above expected arget
    public void getTotalRevenue() {
        Map<Integer, SalesPerson> salesPersons = DataStore.getInstance().getSalesPersons();
        List<SalesPerson> salesPersonList = new ArrayList<>(salesPersons.values());
        Map<Integer, Item> items = DataStore.getInstance().getItems();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        int revenue = 0;
        int diff;

        for (Item item : items.values()) {
            diff = 0;
            for (Product product : products.values()) {
                if ((product.getProductId() == item.getProductId())) {
                    diff = (item.getSalesPrice() * item.getQuantity()) - (product.getTargetPrice() * item.getQuantity());
                }
            }
            item.setDiffTargetAndSales(diff);
        }

        int profitSumOfDiff;
        for (SalesPerson salesPerson : salesPersons.values()) {
            profitSumOfDiff = 0;
            for (Order order : salesPerson.getOrders()) {
                if (salesPerson.getSalesPersonId() == order.getSupplierId()) {
                    for (Item item : order.getItems()) {
                        if (item.getDiffTargetAndSales() > 0) {
                            profitSumOfDiff += item.getDiffTargetAndSales();//find sum of diff between sals and target for a particular order
                        }
                    }
                }
            }
            salesPerson.setProfitSumOfDiff(profitSumOfDiff);
        }

        System.out.println("Total revenue for the year that is above expected target:\n");
        for (SalesPerson salesperson : salesPersons.values()) {
            int profit = salesperson.getProfitSumOfDiff();
            System.out.println("Profit by Sales Person " + salesperson.getSalesPersonId() + " profit= " + profit);
            revenue += profit;
        }
        System.out.println("\n Total revenue of the year= " + revenue + "\n");
    }
    //End:Added by Tasleem 

    //Eshanee - Question 5.
    public void targetPriceOptimization() {
        calculateAverageSalesPrice();

        Map<Integer, Product> products = DataStore.getInstance().getProducts();

        try {
            modifyExistingData(products);
        } catch (Exception e) {
            System.out.println("Error during modifying the file." + e);
        }

        //Order by using ascending of the difference - for original table
        List<Product> productList = new ArrayList<>(products.values());

        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product c1, Product c2) {
                return Double.compare(c2.getDifferenceInPrice(), c1.getDifferenceInPrice());
            }
        });

        System.out.println("\n\nOriginal Data : AvgSalesPrice >= TargetSalesPrice");
        System.out.println("-----------------------------------------------------------");
        System.out.println("ProductId\tAvg Sales Price\tTarget Price\tDifference\t");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < products.size(); i++) {
            Product p = productList.get(i);
            if (p.getDifferenceInPrice() >= 0) {
                System.out.println(p.getProductId() + "\t\t" + p.getAverageSalesPrice() + "\t\t" + p.getTargetPrice() + "\t\t" + p.getDifferenceInPrice());
            }
        }

        System.out.println("\n\nOriginal Data : AvgSalesPrice < TargetSalesPrice");
        System.out.println("-----------------------------------------------------------");
        System.out.println("ProductId\tAvg Sales Price\tTarget Price\tDifference\t");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < products.size(); i++) {
            Product p = productList.get(i);
            if (p.getDifferenceInPrice() < 0) {
                System.out.println(p.getProductId() + "\t\t" + p.getAverageSalesPrice() + "\t\t" + p.getTargetPrice() + "\t\t" + p.getDifferenceInPrice());
            }
        }

        //Order by using ascending of the difference - for original table
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product c1, Product c2) {
                return Double.compare(c2.getNewDifferenceInPrice(), c1.getNewDifferenceInPrice());
            }
        });

        System.out.println("\n\nModified Data : AvgSalesPrice >= ModifiedTargetSalesPrice");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("ProductId\tAvg Sales Price\tModified Target Price\tDifference\tError");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (int i = 0; i < products.size(); i++) {
            Product p = productList.get(i);
            if (p.getDifferenceInPrice() >= 0) {
                System.out.println(p.getProductId() + "\t\t" + p.getAverageSalesPrice() + "\t\t" + p.getModifiedTargetPrice() + "\t\t\t"
                        + p.getNewDifferenceInPrice() + "\t\t" + p.getError());
            }
        }

        System.out.println("\n\nModified Data : AvgSalesPrice < ModifiedTargetSalesPrice");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("ProductId\tAvg Sales Price\tModified Target Price\tDifference\tError");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (int i = 0; i < products.size(); i++) {
            Product p = productList.get(i);
            if (p.getDifferenceInPrice() < 0) {
                System.out.println(p.getProductId() + "\t\t" + p.getAverageSalesPrice() + "\t\t" + p.getModifiedTargetPrice() + "\t\t\t"
                        + p.getNewDifferenceInPrice() + "\t\t" + p.getError());
            }
        }
    }

    //Eshanee
    public void modifyExistingData(Map<Integer, Product> products) throws IOException {
        DataGenerator instance = DataGenerator.getInstance();
        instance.generateProductsFile("Product-Id,Min-Price,Max-Price,Target-Price,Average-Sales-Price,DifferenceInPrice,Modified-Target-Price,Error", products);
    }

    //Eshanee
    public void calculateAverageSalesPrice() {
        Map<Integer, Item> items = DataStore.getInstance().getItems();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();

        for (Product p : products.values()) {
            int quantity = 0;
            int totalSales = 0;
            for (Item i : items.values()) {
                if (p.getProductId() == i.getProductId()) {
                    quantity += i.getQuantity();
                    totalSales += i.getSalesPrice() * i.getQuantity();
                }
            }
            p.setAverageSalesPrice(totalSales / quantity);
        }
    }

}
