/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.Actions;
import tmsModelLayer.Oracle;

/**
 *
 * @author cstuser
 */
public class ProviderAction implements Actions {

   Oracle con;
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
    
}
