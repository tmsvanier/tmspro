/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.OrderItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tmsModelLayer.Item;
import tmsModelLayer.Oracle;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public class UserOrderItem implements OrderItem{
    Oracle order_Conn=null;
    Orders ords=null;
    ResultSet rslt=null;
    String  query="";
    @Override
    public Orders getClientOrder(int cL_Id) {
        order_Conn=new Oracle();
        query="SELECT o.orderid,ic.itemCategoryDesc,o.clientId,c.fullName"+
               "from client c,orders o,item i, itemcategory ic"+
               "where c.clientId=o.clientId and o.orderid=i.orderid and ic.itemCategoryId=i.itemCategoryId and c.clientId="+
                cL_Id+
                "and i.orderid in(select orderid from item )";
        order_Conn.connect("scott", "tiger");
        rslt=order_Conn.getResult(query);
        ords=new Orders();
        try {
            while(rslt.next()){
                ords.setOrderid(rslt.getLong("orderId"));
                //ords.set
            }
           } 
        catch (SQLException ex) {
                Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
             }
        Orders n=null;
       return  null; 
    }

    @Override
    public Item getOrderItem(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders getCarrierOrder(int cR_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders getDriverOrder(int dR_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders getProviderOrder(int pR_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
