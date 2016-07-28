 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;
import BussinessLayer.Interface.LoginUser;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;

import tmsModelLayer.Oracle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tmsModelLayer.Carrier;
import tmsModelLayer.Client;
import tmsModelLayer.Driver;
import tmsModelLayer.Provider;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

/**
 *
 * @author omid
 */
public class UserLogin implements LoginUser {
      Oracle loginOrcl=null;
      ResultSet rslt=null;
      String query=""; 
      HttpSession mySession;
       ServletContext myapp;
    @Override
    public int check_Username(int role,String Tusername,String pass) {
       int exist=-1;      
        switch (role){
            case 1:{                
              Client test=new Client();
              test.makeCopy(getClient(Tusername));//copy from database
              if(test.getPassword().equals(pass))
                 exist=1;
              else if(test.getClientId()!=0){
                   if(checkPass(1,Tusername,test.getPassword()))
                       exist=0;
               }    
                break;
              }//end of clinet case
            case 2:{                
               Provider myUser=new Provider();
               myUser.makeCopy(getProvider(Tusername));//copy from database
               if(myUser.getPassword().equals(pass))
                 exist=1;
               else if(myUser.getProviderId()!=0){
                   if(checkPass(2,Tusername,myUser.getPassword()))
                       exist=0; 
               }                   
                break;
              }//end of provider case
            case 3:{
                Carrier myUser=new Carrier();
               myUser.makeCopy(getCarrier(Tusername));//copy from database
                if(myUser.getPassword().equals(pass))
                 exist=1;
               else if(myUser.getCarrierId()!=0){
                   if(checkPass(3,Tusername,myUser.getPassword()))
                       exist=0;
               }    
                break;
            }//end of carrier case
            case 4:{
               Driver myUser=new Driver();
               myUser.makeCopy(getDriver(Tusername));//copy from database
                if(myUser.getPassword().equals(pass))
                 exist=1;
               else if(myUser.getDriverId()!=0){
                   if(checkPass(4,Tusername,myUser.getPassword()))
                       exist=0;
               }    
                break;
            }//end of driver case
        }//end of role switch
        
       return exist;
    }

    @Override
    public boolean checkPass(int i,String name,String str) {
          loginOrcl.connect("scott", "tiger");
          boolean match=false;
          String pass="";
        switch(i){
            case 1:{                
                query="Select password from client where username='"+name+"'";                
               break;
            }//end of case clinet
            case 2:{                
                query="Select password from provider where username='"+name+"'";               
               break;
            }//end of case provider
            case 3:{                
                query="Select password from carrier where username='"+name+"'";                
               break;
            }//end of case carrier
            case 4:{                
                query="Select password from driver where username='"+name+"'";               
               break;
            }//end of case driver
        }//end of switch
        rslt=loginOrcl.getResult(query);
        try { 
            while(rslt.next()){
             
                  pass=rslt.getString("password");
              } 
            }
        catch (SQLException ex) {
                  Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
              }        
         loginOrcl.terminate();
        if(pass.trim().equals(str.trim()))
           match=true;
       return match;
    }//end of  pass check

   
    @Override
    public Client getClient(String Tusername) {
       loginOrcl = new Oracle();
       loginOrcl.connect("scott", "tiger");
       query="Select * from client where username='"+Tusername+"'";
       rslt=loginOrcl.getResult(query);
       Client tmp=new Client();           
       try {               
             while(rslt.next())
                {                              
                 tmp.setClientId(rslt.getInt("clientId"));
                 tmp.setFullName(rslt.getString("fullName"));
                 tmp.setAddress(rslt.getString("address"));
                 tmp.setEmail(rslt.getString("email"));
                 tmp.setPhone(rslt.getString("phoneNumber"));
                 tmp.setUsername(rslt.getString("userName"));
                 tmp.setPassword(rslt.getString("password"));
                }  //end of rslt while, choose Tools | Templates.
           }
             catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
         loginOrcl.terminate();
          return tmp;
    }

    @Override
    public Provider getProvider(String Tusername) {
       loginOrcl = new Oracle();
       loginOrcl.connect("scott", "tiger");
       query="Select * from Provider where username='"+Tusername+"'";
       rslt=loginOrcl.getResult(query);
       Provider tmp=new Provider();           
       try {              
             while(rslt.next())
                {                              
                 tmp.setProviderId(rslt.getInt("providerid"));
                 tmp.setFullName(rslt.getString("fullName"));
                 tmp.setAddress(rslt.getString("address"));
                 tmp.setEmail(rslt.getString("email"));
                 tmp.setPhone(rslt.getString("phoneNumber"));
                 tmp.setUsername(rslt.getString("userName"));
                 tmp.setPassword(rslt.getString("password"));
                }  //end of rslt while, choose Tools | Templates.
           }
             catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
         loginOrcl.terminate();
          return tmp;
    }

    @Override
    public Carrier getCarrier(String Tusername) {
        
       loginOrcl = new Oracle();
       loginOrcl.connect("scott", "tiger");
       query="Select * from Carrier where username='"+Tusername+"'";
       rslt=loginOrcl.getResult(query);
       Carrier tmp=new Carrier();           
       try {              
             while(rslt.next())
                {                              
                 tmp.setCarrierId(rslt.getInt("carrierid"));
                 tmp.setTransportId(rslt.getInt("transportId"));
                 tmp.setFullName(rslt.getString("fullName"));
                 tmp.setAddress(rslt.getString("address"));
                 tmp.setEmail(rslt.getString("email"));
                 tmp.setPhone(rslt.getString("phoneNumber"));
                 tmp.setUsername(rslt.getString("userName"));
                 tmp.setPassword(rslt.getString("password"));
                 tmp.setKPIvalue(rslt.getDouble("rslt.getInt"));
                }  //end of rslt while, choose Tools | Templates.
           }
             catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
         loginOrcl.terminate();
          return tmp;
    }

    @Override
    public Driver getDriver(String Tusername) {
         
       loginOrcl = new Oracle();
       loginOrcl.connect("scott", "tiger");
       query="Select * from Driver where username='"+Tusername+"'";
       rslt=loginOrcl.getResult(query);
       Driver tmp=new Driver();           
       try {              
             while(rslt.next())
                {                              
                 tmp.setDriverId(rslt.getInt("driverid"));
                 tmp.setCarreirId(rslt.getInt("carrierid"));
                 tmp.setFullName(rslt.getString("fullName"));
                 tmp.setAddress(rslt.getString("address"));
                 tmp.setEmail(rslt.getString("email"));
                 tmp.setPhone(rslt.getString("phoneNumber"));
                 tmp.setUsername(rslt.getString("userName"));
                 tmp.setPassword(rslt.getString("password"));
                }  //end of rslt while, choose Tools | Templates.
           }
             catch (SQLException ex) {
                 Logger.getLogger(UserRegistration.class.getName()).log(Level.SEVERE, null, ex);
             }              
         loginOrcl.terminate();
          return tmp;
    }

    @Override
    public ArrayList<Client> clientList() {
       ArrayList<Client> allClient=new ArrayList();
        Oracle provLog = new Oracle();
       provLog.connect("scott", "tiger");
       query="Select * from client";
       rslt=provLog.getResult(query);
          try {
              while(rslt.next()){
                  Client record=new Client();
                  record.setClientId(rslt.getInt("clientid"));record.setAddress(rslt.getString("address"));
                  record.setFullName(rslt.getString("fullname"));record.setEmail(rslt.getString("email"));
                  record.setPhone(rslt.getString("phonenumber"));record.setUsername(rslt.getString("username"));
                  record.setPassword(rslt.getString("password"));
                  allClient.add(record);
              }  } catch (SQLException ex) {
              Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
          }
          provLog.terminate();
       return allClient;
    }

    @Override
    public ArrayList<Carrier> carrierList() {
         ArrayList<Carrier> allCarrier=new ArrayList();              
        Oracle provLog = new Oracle();
       provLog.connect("scott", "tiger");
       query="Select * from carrier";
       rslt=provLog.getResult(query);
          try {
              while(rslt.next()){
                   Carrier record=new Carrier();                
                 record.setCarrierId(rslt.getInt("carrierid"));record.setAddress(rslt.getString("address"));
                  record.setFullName(rslt.getString("fullname"));record.setEmail(rslt.getString("email"));
                  record.setPhone(rslt.getString("phonenumber"));record.setUsername(rslt.getString("username"));
                  record.setPassword(rslt.getString("password")); record.setKPIvalue(rslt.getDouble("kpivalue"));
                  record.setTransportId(rslt.getInt("transportId"));
                  allCarrier.add(record);
              }  } catch (SQLException ex) {
              Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
          }
          provLog.terminate();
       return allCarrier;
    }

   
    
}
