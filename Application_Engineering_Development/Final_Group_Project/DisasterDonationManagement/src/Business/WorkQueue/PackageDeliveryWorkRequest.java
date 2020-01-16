/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Eshanee Thakur
 */
public class PackageDeliveryWorkRequest extends WorkRequest {

    private String deliveryAck;
    private ArrayList<WorkRequest> shippedRequests;
    String carNumber;
    String driverName;
    String estimatedTime;
    String destination;
    String packageName;

    public PackageDeliveryWorkRequest(ArrayList<WorkRequest> shippedRequests) {
        this.shippedRequests = shippedRequests;
    }

    public ArrayList<WorkRequest> getShippedRequests() {
        return shippedRequests;
    }

    public String getDeliveryAck() {
        return deliveryAck;
    }

    public void setDeliveryAck(String deliveryAck) {
        this.deliveryAck = deliveryAck;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return destination;
    }
}
