/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import BussinessLayer.Interface.Person;

/**
 *
 * @author cstuser
 */
public class Carrier extends Person{
    private int carrierId;
    private int transportId;
    private double KPIvalue;

    
    public Carrier() {
        super();
        this.carrierId = 0;
        
    }
   
    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public double getKPIvalue() {
        return KPIvalue;
    }

    public void setKPIvalue(double KPIvalue) {
        this.KPIvalue = KPIvalue;
    }
    
    public void makeCopy( Carrier tmp){
      carrierId=tmp.getCarrierId();
      transportId=tmp.getTransportId();
      KPIvalue=tmp.getKPIvalue();
      super.setFullName(tmp.getFullName());
      super.setAddress(tmp.getAddress());
      super.setEmail(tmp.getEmail());
      super.setUsername(tmp.getUsername());
      super.setPassword(tmp.getPassword());
      super.setPhone(tmp.getPhone());
    }
    @Override
    public String toString() {
        return super.getFullName()+"// transportid: "+transportId;
    }
}
