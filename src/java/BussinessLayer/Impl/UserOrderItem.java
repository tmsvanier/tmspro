/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.OrderItem;
import tmsModelLayer.Item;
import tmsModelLayer.Oracle;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public class UserOrderItem implements OrderItem{
    Oracle order;
    String  query;
    @Override
    public Orders getClientOrder(int cL_Id) {
        Orders n=null;
       return  null; 
    }

    @Override
    public Item getOrderItem(int orderId) {
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
    public int getPosition(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
