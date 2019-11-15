/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Users.Customer;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Eshanee Thakur
 */
public class CustomerDirectory {

    private ArrayList<Customer> customerDirectory;

    public CustomerDirectory() {
        customerDirectory = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(ArrayList<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
   

    public void addCustomer(Customer customer) {
        customerDirectory.add(customer);
    }
}
