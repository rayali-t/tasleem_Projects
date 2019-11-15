/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Users.Customer;

/**
 *
 * @author Eshanee Thakur
 */
public class Booking {

    protected Customer customer;
    protected Flight flight;
    protected String bookingDate;

    Booking(Customer customer, Flight flight, String bookingDate) {
        this.customer = customer;
        this.flight = flight;
        this.bookingDate = bookingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return this.getFlight().getAirliner().getAirLinerName();
    }
}
