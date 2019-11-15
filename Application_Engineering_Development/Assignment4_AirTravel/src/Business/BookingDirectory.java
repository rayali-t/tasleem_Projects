/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Users.Customer;
import java.util.ArrayList;

/**
 *
 * @author Eshanee Thakur
 */
public class BookingDirectory {

    private ArrayList<Booking> bookingDirectory;
    private Booking booking;

    public BookingDirectory() {
        bookingDirectory = new ArrayList<>();

    }

    public ArrayList<Booking> getBookingDirectory() {
        return bookingDirectory;
    }

    public void setBookingDirectory(ArrayList<Booking> bookingDirectory) {
        this.bookingDirectory = bookingDirectory;
    }

    public void addBooking(Customer customer, Flight flight, String bookingDate) {
        Booking booking = new Booking(customer, flight, bookingDate);
        bookingDirectory.add(booking);
    }
    
    public boolean isFlightBooked(String seatNo)
    {
        for(Booking booking: this.bookingDirectory)
        {
            if(booking.flight.getAllocatedSeat().equalsIgnoreCase(seatNo))
            {
                return false;
            }
        }
        return true;
    }
}
