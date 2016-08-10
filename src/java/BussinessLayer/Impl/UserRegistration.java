/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.RegisterUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tmsModelLayer.Oracle;
import tmsModelLayer.Carrier;
import tmsModelLayer.Client;
import tmsModelLayer.Drivers;
import tmsModelLayer.Provider;

/**
 *
 * @author omid
 */
public class UserRegistration implements RegisterUser {
    Oracle regOracle=null;
      ResultSet rslt=null;
      String query;
    @Override
    public void sendToDB(Client user) {
        regOracle = new Oracle();
       
       // regOracle.connect("system", "tiger");
         regOracle.connect("scott", "tiger");
        
        query="INSERT into client values(clientId_seq.nextval,'"+user.getFullName() + "','" + user.getAddress() + "','" 
                + user.getEmail()+"','" + user.getPhone()+ "','" + user.getUsername()+ "','" + user.getPassword()+ "')";
        regOracle.setQuery(query);
        regOracle.terminate();
    }
     @Override
     public Client getClient(String Tusername){
          regOracle = new Oracle();
          // regOracle.connect("system", "tiger");
          regOracle.connect("scott", "tiger");
          query="Select * from client where userName='"+Tusername+"'";
          rslt=regOracle.getResult(query);
          Client retUser=new Client();
          try{
              while(rslt.next())
               { 
             
                 retUser.setClientId(rslt.getInt("clientId"));
                 retUser.setFullName(rslt.getString("fullName"));
                 retUser.setAddress(rslt.getString("address"));
                 retUser.setPhone(rslt.getString("phoneNumber"));
                 retUser.setEmail(rslt.getString("email"));
                 retUser.setUsername(rslt.getString("userName")); 
                 retUser.setPassword(rslt.getString("password"));
                  }//end of rslt while
              }
            catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }
          regOracle.terminate();
           
         return retUser;
     }
  
    @Override
    public void sendToDB(Provider user) {
        regOracle = new Oracle();
       
       // regOracle.connect("system", "tiger");
         regOracle.connect("scott", "tiger");
        
        query="INSERT into provider values(providerId_seq.nextval,'"+user.getFullName() + "','" + user.getAddress() + "','" 
                + user.getEmail()+"','" + user.getPhone()+ "','" + user.getUsername()+ "','" + user.getPassword()+ "')";
        regOracle.setQuery(query);
        regOracle.terminate();
    }

    @Override
    public Provider getProvider(String Tusername) {
         regOracle = new Oracle();
          // regOracle.connect("system", "tiger");
          regOracle.connect("scott", "tiger");
          query="Select * from provider where userName='"+Tusername+"'";
          rslt=regOracle.getResult(query);
          Provider retUser=new Provider();
          try{
               while(rslt.next())
                {
          
                 retUser.setProviderId(rslt.getInt("providerId"));
                 retUser.setFullName(rslt.getString("fullName"));
                 retUser.setAddress(rslt.getString("address"));
                 retUser.setPhone(rslt.getString("phoneNumber"));
                 retUser.setEmail(rslt.getString("email"));
                 retUser.setUsername(rslt.getString("userName")); 
                 retUser.setPassword(rslt.getString("password"));
                 }//end of rslt while
             }
         catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
              
          regOracle.terminate();
         return retUser;
    }

    @Override
    public void sendToDB(Carrier user) {
       regOracle = new Oracle();
       
       // regOracle.connect("system", "tiger");
         regOracle.connect("scott", "tiger");
        
        query="INSERT into carrier values(carrierId_seq.nextval,"+6+",'"+user.getFullName()+ "','" + user.getAddress() + "','" 
                + user.getEmail()+"','" + user.getPhone()+ "','" + user.getUsername()+ "','" + user.getPassword()+ "',"+100+")";
        regOracle.setQuery(query);
        regOracle.terminate();
    }

    @Override
    public Carrier getCarrier(String Tusername) {
         regOracle = new Oracle();
          // regOracle.connect("system", "tiger");
          regOracle.connect("scott", "tiger");
          query="Select * from carrier where userName='"+Tusername+"'";
          rslt=regOracle.getResult(query);
          Carrier retUser=new Carrier();
          
             try {
          while(rslt.next())
          {
                 retUser.setCarrierId(rslt.getInt("carrierId"));
                 retUser.setTransportId(rslt.getInt("transportId"));
                 retUser.setFullName(rslt.getString("fullName"));
                 retUser.setAddress(rslt.getString("address"));
                 retUser.setPhone(rslt.getString("phoneNumber"));
                 retUser.setEmail(rslt.getString("email"));
                 retUser.setUsername(rslt.getString("userName")); 
                 retUser.setPassword(rslt.getString("password"));
                  }//end of rslt while
             }  
          catch (SQLException ex)
                  {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
            
          regOracle.terminate();
         return retUser;
    }

    @Override
    public void sendToDB(Drivers user) {
      regOracle = new Oracle();
       
       // regOracle.connect("system", "tiger");
         regOracle.connect("scott", "tiger");
        
        query="INSERT into driver values(driverId_seq.nextval,"+8+",'"+user.getFullName() + "','" + user.getAddress() + "','" 
                + user.getEmail()+"','" + user.getPhone()+ "','" + user.getUsername()+ "','" + user.getPassword()+ "')";
        regOracle.setQuery(query);
        regOracle.terminate();
    }

    @Override
    public Drivers getDriver(String Tusername) {
         regOracle = new Oracle();
          // regOracle.connect("system", "tiger");
          regOracle.connect("scott", "tiger");
          query="Select * from driver where userName='"+Tusername+"'";
          rslt=regOracle.getResult(query);
          Drivers retUser=new Drivers();
         try {
             while(rslt.next())
              {
            
                 retUser.setDriverId(rslt.getInt("driverId"));
                 retUser.setCarreirId(rslt.getInt("carrierId"));
                 retUser.setFullName(rslt.getString("fullName"));
                 retUser.setAddress(rslt.getString("address"));
                 retUser.setPhone(rslt.getString("phoneNumber"));
                 retUser.setEmail(rslt.getString("email"));
                 retUser.setUsername(rslt.getString("userName")); 
                 retUser.setPassword(rslt.getString("password"));
                 } 
         }
         catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
          regOracle.terminate();
         return retUser;
    }

  
   }
