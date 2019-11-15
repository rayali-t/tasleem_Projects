/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Eshanee Thakur
 */
public class Airliner {
    private String airLinerName;
    private int noOfFlights;
    
    public String getAirLinerName() {
        return airLinerName;
    }

    public void setAirLinerName(String airLinerName) {
        this.airLinerName = airLinerName;
    }

    public int getNoOfFlights() {
        return noOfFlights;
    }

    public void setNoOfFlights(int noOfFlights) {
        this.noOfFlights = noOfFlights;
    }
    
    @Override
    public String toString(){
    return this.airLinerName;
    
    }
    
    
}
