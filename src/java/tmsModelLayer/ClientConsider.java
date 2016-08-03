/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

/**
 *
 * @author omid
 */
public class ClientConsider {
    private int considerId;
    private int transportId;
     private long orderId;
     private String cosiderDesc;

    public ClientConsider() {
    }

    public ClientConsider(int considerId, int transportId, long orderId, String cosiderDesc) {
        this.considerId = considerId;
        this.transportId = transportId;
        this.orderId = orderId;
        this.cosiderDesc = cosiderDesc;
    }

    public int getConsiderId() {
        return considerId;
    }

    public void setConsiderId(int considerId) {
        this.considerId = considerId;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCosiderDesc() {
        return cosiderDesc;
    }

    public void setCosiderDesc(String cosiderDesc) {
        this.cosiderDesc = cosiderDesc;
    }
     
     
    
    
}
