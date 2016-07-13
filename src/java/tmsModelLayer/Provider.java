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
public class Provider extends Person {
    private int providerId;

    public Provider() {
         super();
        this.providerId = 0;
       
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
     public void makeCopy( Provider tmp){
      tmp.setProviderId(providerId);
      tmp.setFullName(super.getFullName());
      tmp.setAddress(super.getAddress());
      tmp.setEmail(super.getEmail());
      tmp.setUsername(super.getUsername());
      tmp.setPassword(super.getPassword());
      tmp.setPhone(super.getPhone());
    } 
}
