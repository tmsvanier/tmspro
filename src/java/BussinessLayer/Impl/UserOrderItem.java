/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.OrderItem;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import tmsModelLayer.Item;
import tmsModelLayer.Itemcategory;
import tmsModelLayer.Oracle;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public class UserOrderItem implements OrderItem{
    Oracle order_Conn=null;
    Set<Orders> orderSet=null;
    ArrayList<Item>orderItems=null;
    ResultSet rslt,rslt1=null;
    String  query="";
    @Override
    public Set<Orders> getClientOrder(int cL_Id) {
        order_Conn=new Oracle();
        
        
//        query="SELECT o.orderid,ic.itemCategoryDesc,o.clientId,c.fullName"+
//               "from client c,orders o,item i, itemcategory ic"+
//               "where c.clientId=o.clientId and o.orderid=i.orderid and ic.itemCategoryId=i.itemCategoryId and c.clientId="+
//                cL_Id+
//                "and i.orderid in(select orderid from item )";
        order_Conn.connect("scott", "tiger");
        query="SELECT *FROM ORDERS WHERE CLIENTID="+cL_Id;
        rslt=order_Conn.getResult(query);
        orderSet=new HashSet();
        
        try {
            while(rslt.next()){
                Orders record=new Orders();               
                record.setOrderid(rslt.getLong("orderId"));record.setClientid(cL_Id);
                record.setProviderid(rslt.getShort("providerid"));
                record.setStatusid(rslt.getInt("statusId"));
                record.setArrival(rslt.getString("arrival"));
                record.setDeparture(rslt.getString("departure"));
                record.setOrderdate(rslt.getDate("orderdate"));
                record.setDriverid(rslt.getInt("driverid"));
                record.setDistance(rslt.getBigDecimal("distance"));
                query="Select i.*,ic.itemCategoryDesc " +
                        "from " +
                        "item i,itemcategory ic " +
                         "Where " +
                         "ic.itemCategoryId=i.itemCategoryId and i.orderid="+record.getOrderid();
                rslt1=order_Conn.getResult(query); 
                orderItems=new ArrayList();
                while(rslt1.next()){                    
                    Item element=new Item();
                    element.setOrderId(rslt1.getLong("orderid"));
                    element.setCategoryDetail(rslt1.getString("itemCategoryDesc"));
                    element.setItemprice(rslt1.getDouble("itemprice"));
                    element.setItemvolume(rslt1.getInt("itemvolume"));
                    element.setItemqty(rslt1.getInt("itemqty"));
                    element.setItemweight(rslt1.getDouble("itemweight"));
                    
                    orderItems.add(element);                    
                }
                record.setItemCollection(orderItems);
                orderSet.add(record);
                
             
            }//end of orderset pushing
            
           } 
        catch (SQLException ex) {
                Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
             }
        order_Conn.terminate();
       return  orderSet; 
    }

    @Override
    public List<Item> getOrderItem(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Orders> getCarrierOrder(int cR_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders getDriverOrder(int dR_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Orders>getProviderOrder(int pR_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Itemcategory> getCategory() {
        
        ArrayList<Itemcategory> catList=new ArrayList();
      query="select * from Itemcategory";
        order_Conn=new Oracle();
        order_Conn.connect("scott", "tiger");
        rslt=order_Conn.getResult(query);
        try {
            while(rslt.next()){
               Itemcategory element=new Itemcategory(); 
               element.setItemcategoryid(rslt.getInt("itemCategoryId"));
               element.setItemcategorydesc(rslt.getString("itemCategoryDesc"));
               catList.add(element);
            }
           order_Conn.terminate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catList;
    }
    
}
