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
public class CollectionWorkRequest extends WorkRequest {

    private String collectionAck;

    public String getCollectionAck() {
        return collectionAck;
    }

    public void setCollectionAck(String collectionAck) {
        this.collectionAck = collectionAck;
    }
}
