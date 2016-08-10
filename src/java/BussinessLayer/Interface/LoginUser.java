/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

import java.util.ArrayList;
import tmsModelLayer.Client;
import tmsModelLayer.Drivers;
import tmsModelLayer.Provider;
import tmsModelLayer.Carrier;



/**
 *
 * @author omid
 */
public interface LoginUser {
    public int check_Username(int role,String Tusername,String pass);
    public boolean checkPass(int role,String Tusername, String pass);
    public Client getClient (String Tusername);
    public Provider getProvider(String Tusername);
    public Carrier getCarrier(String Tusername);
    public Drivers getDriver(String Tusername);
    public ArrayList<Client> clientList();
    public ArrayList<Carrier> carrierList();
    public ArrayList<Drivers> getCarrierDriver(int id);
    
}
