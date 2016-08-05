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
import tmsModelLayer.Carrier;
import tmsModelLayer.ClientConsider;
import tmsModelLayer.Item;
import tmsModelLayer.Itemcategory;
import tmsModelLayer.Oracle;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public class UserOrderItem implements OrderItem{
    Oracle Client_Conn=null;
     Oracle Provider_Conn=null;
     Oracle bestCarry=null;
     
    Set<Orders> orderSet=null;
    ArrayList<Item>orderItems=null;
    ResultSet rslt,rslt1=null;
    String  query="";
    @Override
    public Set<Orders> getClientOrder(int cL_Id) {
        Client_Conn=new Oracle();
        
        
//        query="SELECT o.orderid,ic.itemCategoryDesc,o.clientId,c.fullName"+
//               "from client c,orders o,item i, itemcategory ic"+
//               "where c.clientId=o.clientId and o.orderid=i.orderid and ic.itemCategoryId=i.itemCategoryId and c.clientId="+
//                cL_Id+
//                "and i.orderid in(select orderid from item )";
        Client_Conn.connect("scott", "tiger");
        query="SELECT *FROM ORDERS WHERE CLIENTID="+cL_Id;
        rslt=Client_Conn.getResult(query);
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
                rslt1=Client_Conn.getResult(query); 
                orderItems=new ArrayList();
                while(rslt1.next()){                    
                    Item element=new Item();
                    element.setOrderId(rslt1.getLong("orderid"));
                    element.setCategoryDetail(rslt1.getString("itemCategoryDesc"));
                    element.setItemprice(rslt1.getDouble("itemprice"));
                    element.setItemvolume(rslt1.getInt("itemvolume"));
                    element.setItemqty(rslt1.getInt("itemqty"));
                    element.setItemweight(rslt1.getDouble("itemweight"));
                    element.setItemDesc(rslt1.getString("itemdesc"));
                    
                    orderItems.add(element);                    
                }
                record.setItemCollection(orderItems);
                orderSet.add(record);
                
             
            }//end of orderset pushing
            
           } 
        catch (SQLException ex) {
                Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
             }
        Client_Conn.terminate();
       return  orderSet; 
    }
     @Override
        public Set<Orders> getProviderOrder(int cL_Id) {
        Provider_Conn=new Oracle();
        
        
//        query="SELECT o.orderid,ic.itemCategoryDesc,o.clientId,c.fullName"+
//               "from client c,orders o,item i, itemcategory ic"+
//               "where c.clientId=o.clientId and o.orderid=i.orderid and ic.itemCategoryId=i.itemCategoryId and c.clientId="+
//                cL_Id+
//                "and i.orderid in(select orderid from item )";
        Provider_Conn.connect("scott", "tiger");
        query="SELECT *FROM ORDERS";
        rslt=Provider_Conn.getResult(query);
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
                record.setCarrierid(rslt.getInt("carrierid"));
                record.setDriverid(rslt.getInt("driverid"));
                record.setDistance(rslt.getBigDecimal("distance"));
                query="Select i.*,ic.itemCategoryDesc " +
                        "from " +
                        "item i,itemcategory ic " +
                         "Where " +
                         "ic.itemCategoryId=i.itemCategoryId and i.orderid="+record.getOrderid();
                rslt1=Provider_Conn.getResult(query); 
                orderItems=new ArrayList();
                while(rslt1.next()){                    
                    Item element=new Item();
                    element.setOrderId(rslt1.getLong("orderid"));
                    element.setCategoryDetail(rslt1.getString("itemCategoryDesc"));
                    element.setItemprice(rslt1.getDouble("itemprice"));
                    element.setItemvolume(rslt1.getInt("itemvolume"));
                    element.setItemqty(rslt1.getInt("itemqty"));
                    element.setItemweight(rslt1.getDouble("itemweight"));
                    element.setItemDesc(rslt1.getString("itemdesc"));
                    
                    orderItems.add(element);                    
                }
                record.setItemCollection(orderItems);
                orderSet.add(record);
                
             
            }//end of orderset pushing
            
           } 
        catch (SQLException ex) {
                Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
             }
        Provider_Conn.terminate();
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
    public int getPosition(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Itemcategory> getCategory() {
        
        ArrayList<Itemcategory> catList=new ArrayList();
      query="select * from Itemcategory";
        Client_Conn=new Oracle();
        Client_Conn.connect("scott","tiger");
        rslt=Client_Conn.getResult(query);
        try {
            while(rslt.next()){
               Itemcategory element=new Itemcategory(); 
               element.setItemcategoryid(rslt.getInt("itemCategoryId"));
               element.setItemcategorydesc(rslt.getString("itemCategoryDesc"));
               catList.add(element);
            }
           Client_Conn.terminate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catList;
    }

    @Override
    public void setClientOrder(int clientid,int providerid,int driverid,String depart,String arrival,ArrayList<Item> items,int cosiderid,int clinetTransid) {
        Client_Conn=new Oracle();
        Client_Conn.connect("scott", "tiger");
        query="INSERT INTO orders (orderId,clientId,providerid,driverid,departure,arrival,statusId) VALUES(orderId_seq.nextval,"+
              clientid+","+providerid+","+driverid+",'"+depart+"','"+arrival+"',2)";     
        Client_Conn.setQuery(query);
        query="select max(orderid)from orders";
           int NewOrderId=-1;
       rslt= Client_Conn.getResult(query);
        try {
            rslt.next() ;  NewOrderId = rslt.getInt(1) ;
        } catch (SQLException ex) {
            Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //set a recoord for clientConsider Table
        
        query="Insert into clientConsider Values("+cosiderid+",'NULL',"+clinetTransid+","+NewOrderId+")";
        Client_Conn.setQuery(query);
        //set orderId for selected item
        for(int i=0;i<2;i++){//i must be changed to 5
            query="insert into item values("+NewOrderId+","+items.get(i).getItemcategory()+","+
                    +items.get(i).getItemweight()+","+items.get(i).getItemvolume()+
                    ","+items.get(i).getItemprice()+","+items.get(i).getItemqty()+
                    ",'"+items.get(i).getItemDesc()+"')";
             Client_Conn.setQuery(query);
        }
        NewOrderId-=1;
        //query="insert into item (orderid,itemcategoryid) values("+NewOrderId+",5)";;
       
        Client_Conn.terminate();
        
        
          
    }

    @Override
    public Item setOrderItem(long orderId, int catNo, double Weight, int Volume, double Price, int Qnty) {
        Item element=new Item();
        element.setOrderId(orderId);element.setItemcategory(catNo);element.setItemweight(Weight);
        element.setItemprice(Price);element.setItemvolume(Volume);element.setItemqty(Qnty);
        return element;
    }

    @Override
    public ArrayList<Carrier> getBestCarriers(int transportid) {
       ArrayList<Carrier> bestCarrier=new ArrayList();
       Carrier record=new Carrier();
       ClientConsider consider=new ClientConsider();
        bestCarry=new Oracle();
        bestCarry.connect("scott", "tiger");
        query="CREATE TABLE TMSKPI as " +
              "SELECT c.transportId\"T1\",outer.carrierid\"C1\",outer.orderid\"O1\", " +
                "COALESCE((select sum(KpiValue*(KpiWeight)) from kpilog where orderid=outer.orderid ),0)\"C2\" " +
              "from orders outer,carrier c where outer.carrierid=c.carrierid and c.transportId In (2,3,4,5,6) and outer.statusId=5 " +
              "order by 4 desc";
        
       return bestCarrier;
    }
    
}
