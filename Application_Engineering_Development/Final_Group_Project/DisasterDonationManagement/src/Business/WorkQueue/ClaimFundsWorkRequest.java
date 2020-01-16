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
public class ClaimFundsWorkRequest extends WorkRequest{
    private double amount;
    private String claimPurpose;
    private String companyName;
    private String companyAddress;
    private String lisenceNumber;
    private String termsChecked;
    private String claimAcknowledgement;
    private String comments;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getClaimPurpose() {
        return claimPurpose;
    }

    public void setClaimPurpose(String claimPurpose) {
        this.claimPurpose = claimPurpose;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getLisenceNumber() {
        return lisenceNumber;
    }

    public void setLisenceNumber(String lisenceNumber) {
        this.lisenceNumber = lisenceNumber;
    }

    public String getTermsChecked() {
        return termsChecked;
    }

    public void setTermsChecked(String termsChecked) {
        this.termsChecked = termsChecked;
    }

    public String getClaimAcknowledgement() {
        return claimAcknowledgement;
    }

    public void setClaimAcknowledgement(String claimAcknowledgement) {
        this.claimAcknowledgement = claimAcknowledgement;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    
    
}
