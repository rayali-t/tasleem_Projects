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
public class CashDonationWorkRequest extends WorkRequest {

    private String cashDonationAck;
    private String donorName;
    private String donorLocation;
    private String donorMessage;
    private double cashDonation;

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorLocation() {
        return donorLocation;
    }

    public void setDonorLocation(String donorLocation) {
        this.donorLocation = donorLocation;
    }

    public String getDonorMessage() {
        return donorMessage;
    }

    public void setDonorMessage(String donorMessage) {
        this.donorMessage = donorMessage;
    }

    public double getCashDonation() {
        return cashDonation;
    }

    public void setCashDonation(double cashDonation) {
        this.cashDonation = cashDonation;
    }

    public String getCashDonationAck() {
        return cashDonationAck;
    }

    public void setCashDonationAck(String cashDonationAck) {
        this.cashDonationAck = cashDonationAck;
    }
    
    @Override
    public String toString() {
        return donorName;
    }
}
