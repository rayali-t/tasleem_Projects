/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import java.util.Date;

/**
 *
 * @author Eshanee Thakur
 */
public class Customer extends User {

    String username;
    String travellerName;
    String phoneNo;
    String emailId;
    private Date date;

    public Customer(String username, String password) {
        super(username, password, "Customer");
        date = new Date();
    }

    public Customer(String username, String password, String travellerName, String phoneNo, String emailId) {
        super(username, password, "Customer");
        this.username = username;
        this.travellerName = travellerName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    //Check for this
    public int compareTo(Customer o) {
        return o.getUsername().compareTo(this.getUsername());
    }

    @Override
    public String toString() {
        return getUsername(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verifyPassword(String password) {
        return password.equals(getPassword());
    }

}
