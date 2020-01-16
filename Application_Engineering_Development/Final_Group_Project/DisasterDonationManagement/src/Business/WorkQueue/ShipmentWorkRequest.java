/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Eshanee Thakur
 */
public class ShipmentWorkRequest extends WorkRequest {

    private String shipmentAck;

    public String getShipmentAck() {
        return shipmentAck;
    }

    public void setShipmentAck(String shipmentAck) {
        this.shipmentAck = shipmentAck;
    }
}
