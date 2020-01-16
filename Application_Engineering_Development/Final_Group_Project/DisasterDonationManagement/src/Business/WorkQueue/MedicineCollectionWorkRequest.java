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
public class MedicineCollectionWorkRequest extends WorkRequest {

    private String MedicineAck;
    private boolean isClaimed =false;

    public boolean isIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

    public String getMedicineAck() {
        return MedicineAck;
    }

    public void setMedicineAck(String MedicineAck) {
        this.MedicineAck = MedicineAck;
    }

 


}
