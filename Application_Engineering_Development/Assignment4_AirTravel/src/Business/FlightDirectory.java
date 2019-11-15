/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author shailly
 */
public class FlightDirectory {
    
    private ArrayList<Flight> flightdirectory;

    public FlightDirectory() {
        flightdirectory = new ArrayList<Flight>();
    }

    public ArrayList<Flight> getFlightdirectory() {
        return flightdirectory;
    }

    public void setFlightdirectory(ArrayList<Flight> flightdirectory) {
        this.flightdirectory = flightdirectory;
    }

    
    
       public void addflight(Flight f){
   flightdirectory.add(f);
    }
    
    public void deleteflight(Flight flight)
    {
        flightdirectory.remove(flight);
    }
    
    
}