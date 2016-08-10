/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

import tmsModelLayer.Carrier;
import tmsModelLayer.Provider;
import tmsModelLayer.Drivers;
import tmsModelLayer.Client;



/**
 *
 * @author omid
 */
public interface RegisterUser {
     public void sendToDB(Client user);
     public Client getClient(String Tusername);
     public void sendToDB(Provider user);
     public Provider getProvider(String Tusername);
     public void sendToDB(Carrier user);
     public Carrier getCarrier(String Tusername);
     public void sendToDB(Drivers user);
     public Drivers getDriver(String Tusername);
     
    
    
}
