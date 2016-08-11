/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.Actions;
import java.util.ArrayList;
import tmsModelLayer.Oracle;

/**
 *
 * @author cstuser
 */
public class UserActions implements Actions {

  static Oracle  con;
   String query;
   @Override
    public void confirmOrder(int orderid,int Carrierid) {
       con=new Oracle();
       con.connect("scott","tiger");
       query="update Orders set statusid=3,carrierid="+Carrierid+" where orderid="+orderid;
       con.setQuery(query);
       
       con.terminate();
    }

    @Override
    public void cancelOrder(int orderid) {
       con=new Oracle();
       con.connect("scott","tiger");
        query="update Orders set statusid=6 where orderid="+orderid;
       con.setQuery(query);
       
       con.terminate();
    }

    @Override
    public void sendEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifyUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shipOrder(int orderid, int driverid) {
        con=new Oracle();
       con.connect("scott","tiger");
        query="update Orders set statusid=4,driverid="+driverid+" where orderid="+orderid;
       con.setQuery(query);       
       con.terminate();
    }

    @Override
    public void noDriver(int orderid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void orderFeedBack(int orderid, ArrayList feedbackList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
