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
public class Client extends Person implements java.io.Serializable{
    private int clientId;

    public Client() {
        super();
        this.clientId = 0;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public void makeCopy( Client tmp){
      clientId=tmp.getClientId();
      super.setFullName(tmp.getFullName());
      super.setAddress(tmp.getAddress());
      super.setEmail(tmp.getEmail());
      super.setUsername(tmp.getUsername());
      super.setPassword(tmp.getPassword());
      super.setPhone(tmp.getPhone());
    } 

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + '}';
    }
    
}
