/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author tashu
 */
public class DonationWorkRequest extends WorkRequest {

    private String donationAck;

    public String getDonationAck() {
        return donationAck;
    }

    public void setDonationAck(String donationAck) {
        this.donationAck = donationAck;
    }
}
