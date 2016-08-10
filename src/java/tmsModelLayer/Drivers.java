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
public class Drivers extends Person implements java.io.Serializable {
    private int driverId;
    private int carreirId;

    public Drivers() {
        super();
        this.driverId = 0;
        //this.carreirId = 0;
    }

    public int getCarreirId() {
        return carreirId;
    }

    public void setCarreirId(int carreirId) {
        this.carreirId = carreirId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    
     public void makeCopy( Drivers tmp){
      driverId=tmp.getDriverId();
      carreirId=tmp.getCarreirId();
      super.setFullName(tmp.getFullName());
      super.setAddress(tmp.getAddress());
      super.setEmail(tmp.getEmail());
      super.setUsername(tmp.getUsername());
      super.setPassword(tmp.getPassword());
      super.setPhone(tmp.getPhone());
    }
}
