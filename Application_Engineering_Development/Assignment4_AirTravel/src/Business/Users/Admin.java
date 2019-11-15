/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import Business.AirlinerDirectory;
import Business.CustomerDirectory;
import Business.FlightDirectory;

/**
 *
 * @author Eshanee Thakur
 */
public class Admin extends User {

    public AirlinerDirectory airlinerDirectory;
    public CustomerDirectory customerDirectory;
    public FlightDirectory flightDirectory;

    public Admin() {
        super("Admin","Admin", "Admin");

        this.airlinerDirectory = new AirlinerDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.flightDirectory = new FlightDirectory();

    }

    @Override
    public boolean verifyPassword(String password) {
        return password.equals(getPassword());
    }

    public AirlinerDirectory getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(AirlinerDirectory airlinerDirectory) {
        this.airlinerDirectory = airlinerDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public FlightDirectory getFlightDirectory() {
        return flightDirectory;
    }

    public void setFlightDirectory(FlightDirectory flightDirectory) {
        this.flightDirectory = flightDirectory;
    }



}
