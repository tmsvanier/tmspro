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
     Oracle Carrier_Conn=null;
     Oracle bestCarry=null;
     static ArrayList<Carrier> best;
    Set<Orders> orderSet=null;
    ArrayList<Item>orderItems=null;
    ResultSet rslt,rslt1=null;
    ResultSet rslt3,rslt4;
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
        Provider_Conn.connect("scott", "tiger");
        query="SELECT *FROM ORDERS";
        rslt=Provider_Conn.getResult(query);
        orderSet=new HashSet();
         ClientConsider consider=new ClientConsider();
        try {
            while(rslt.next()){
                Orders record=new Orders();               
                record.setOrderid(rslt.getLong("orderId"));record.setClientid(rslt.getInt("clientid"));
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
                
                //add items to its order                       
                    
                record.setItemCollection(orderItems);
                
                  //select clientconsider and best carrier     
                
                if(record.getStatusid()==2){
                         query="select * from clientconsider where orderid="+record.getOrderid();  
                         rslt1=Provider_Conn.getResult(query); 
                         while(rslt1.next()){
                         consider.setConsiderId(rslt1.getInt("considerId"));
                         consider.setCosiderDesc(rslt1.getString("cosiderDesc"));
                         consider.setOrderId(rslt1.getLong("orderid"));
                         consider.setTransportId(rslt1.getInt("transportid")); 
                     
                         record.set_CarrierOption(getBestCarriers(consider));
                         //record.setArrival(getBestCarriers(consider).get(0).getFullName());
                    }//end of select client consideraton
                    }//end if orderid=2 means statusid=2;
                else{
                    Carrier test=new Carrier();
                    test.setFullName("Confirmed Before.AttentionAslanBek");
                    ArrayList<Carrier> myArray=new ArrayList();
                    myArray.add(test);
                    test.setFullName("Attention AslanBek");
                    myArray.add(test);
                    record.set_CarrierOption(myArray);
                }  
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
        
         Carrier_Conn=new Oracle();   
          orderSet=new HashSet();
        Carrier_Conn.connect("scott", "tiger");
        query="SELECT *FROM ORDERS where statusid in(3,4) and carrierid="+cR_Id;
        rslt=Carrier_Conn.getResult(query);
         try {
            while(rslt.next()){
                Orders record=new Orders();               
                record.setOrderid(rslt.getLong("orderId"));record.setClientid(rslt.getInt("clientid"));
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
                rslt1=Carrier_Conn.getResult(query); 
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
                
                //add items to its order                       
                    
                record.setItemCollection(orderItems);
                
                orderSet.add(record);
          
            }//end of orderset pushing
         } 
        catch (SQLException ex) {
                Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
             }
        Carrier_Conn.terminate();
       return  orderSet; 
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
       public ArrayList<Carrier>  getBestCarriers(ClientConsider temp ){     
          best=new ArrayList();  
            bestCarry=new Oracle();
            bestCarry.connect("scott", "tiger");
            
            //select one of client consideraton based on clientconsider table 
       switch (temp.getConsiderId()){
           case 1:{//TMS Suggestion
              
                   String trans="";
                   int id=0;
                  
                 if(temp.getTransportId()!=6){
                    
                     if(temp.getTransportId()==2){
                         trans="TMSAirlPlane";id=2;
                     }                                                 
                     else if(temp.getTransportId()==3){
                          trans="TMSTrain";id=3;
                     }                         
                     else if(temp.getTransportId()==4){
                         trans="TMSTruck";id=4;                        
                     }                                           
                     else if(temp.getTransportId()==5){
                          trans="TMSMarine";id=5; 
                     }
                      System.out.println("\nBest options with TMS suggestion with transprot  "+trans);
                    // System.out.println(query);
                     query =SelectTabeQuery(trans,id,1);  
                     bestCarry.setQuery(query);                     
                     query=SelectKPIQuery(trans,1,id);
                     rslt3=bestCarry.getResult(query);
                       try {
                           while(rslt3.next()){
                               Carrier record =new Carrier();
                               record.setTransportId(id);
                               String CarrierInfo=rslt3.getString("N1");
                               CarrierInfo+=" KPI: "+rslt3.getDouble("AverageKPI");
                               CarrierInfo+=" //Number of Orders: "+rslt3.getInt("NumberOfOrder");
                               record.setCarrierId(rslt3.getInt("carrierid"));
                               record.setFullName(CarrierInfo);
                               best.add(record);
                           }   } catch (SQLException ex) {
                           Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
                       }
                 }//end if client  select select trnsportid
                 
                 else{//if client don't selecttrnsportid
                       query =SelectTabeQuery("AllCarrier",temp.getTransportId(),1);
                      bestCarry.setQuery(query);
                        for(int i=2;i<6;i++){
                        query=SelectKPIQuery("AllCarrier",1,i);
                       rslt3=bestCarry.getResult(query);
                           try {
                               while(rslt3.next()){
                                   int number=0;
                                   if(number<2){
                                       Carrier record =new Carrier();
                                       record.setTransportId(i);
                                       String CarrierInfo=rslt3.getString("N1");
                                       CarrierInfo+=" KPI: "+rslt3.getDouble("AverageKPI");
                                       CarrierInfo+=" //Number of Orders: "+rslt3.getInt("NumberOfOrder");
                                       record.setCarrierId(rslt3.getInt("carrierid"));
                                       record.setFullName(CarrierInfo);
                                       best.add(record);
                                   }
                                   number++;
                               }//end while
                           } catch (SQLException ex) {
                               Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
                           }
                      }//end for loop
                        break;
                 }//end of else TMS
           }//end of TMS Suggestion
           
           
          //cost
            case 2:{
               //select carrier with best cost
                System.out.println("2 Best carrier for cost!!");
                 query =SelectTabeQuery("ClientKPI",temp.getTransportId(),temp.getConsiderId());  
                 bestCarry.setQuery(query);
                 query=SelectKPIQuery("ClientKPI",2,temp.getTransportId());
                 rslt3=bestCarry.getResult(query);
                 int number=0;
              try {
                  while(rslt3.next()){
                      if(number<2){
                          Carrier record =new Carrier();
                          record.setTransportId(rslt3.getInt("T1"));
                          String CarrierInfo=rslt3.getString("N1");
                          CarrierInfo+=" KPI: "+rslt3.getDouble("cost");
                          CarrierInfo+=" //Number of Orders: "+rslt3.getInt("NumberOfOrder");
                          record.setCarrierId(rslt3.getInt("carrierid"));
                          record.setFullName(CarrierInfo);
                          best.add(record);
                      }
                      number++;
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
              }
               break;
           }
           case 3:{
               //select carrier with best time
                  System.out.println("2Best carrier for time!!");
                 query =SelectTabeQuery("ClientKPI",temp.getTransportId(),temp.getConsiderId());  
                 bestCarry.setQuery(query);
                 query=SelectKPIQuery("clientkpi",3,temp.getTransportId());
                 rslt3=bestCarry.getResult(query);
                 int number=0;
              try {
                  while(rslt3.next()){
                      if(number<2){
                          Carrier record =new Carrier();
                          record.setTransportId(rslt3.getInt("T1"));
                          String CarrierInfo=rslt3.getString("N1");
                          CarrierInfo+=" KPI: "+rslt3.getDouble("Time");
                          CarrierInfo+=" //Number of Orders: "+rslt3.getInt("NumberOfOrder");
                          record.setCarrierId(rslt3.getInt("carrierid"));
                          record.setFullName(CarrierInfo);
                          best.add(record);
                      }
                      number++;
           
                  }//end of adding 2 best Marine
              } catch (SQLException ex) {
                  Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
              }
    
               break;
           }//end of time selection
           case 4:{
               //select carrier with best reputation
                System.out.println("Best carrier for reputation!!");
                 query =SelectTabeQuery("ClientKPI",temp.getTransportId(),temp.getConsiderId());  
                 bestCarry.setQuery(query);
                 query=SelectKPIQuery("clientkpi",4,temp.getTransportId());
                 rslt3=bestCarry.getResult(query);
                 int number=0;
              try {
                  while(rslt3.next()){
                      if(number<2){
                          Carrier record =new Carrier();
                          record.setTransportId(rslt3.getInt("T1"));
                          String CarrierInfo=rslt3.getString("N1");
                          CarrierInfo+=" //Number of Orders: "+rslt3.getInt("NumberOfOrder");
                          record.setCarrierId(rslt3.getInt("carrierid"));
                          record.setFullName(CarrierInfo);
                          best.add(record);
                      }
                      number++;
                  }//end of best reputation
              } catch (SQLException ex) {
                  Logger.getLogger(UserOrderItem.class.getName()).log(Level.SEVERE, null, ex);
              }
               break;
           }
       }
         return best;
    }//end of bestcarrie
  
    public String SelectTabeQuery(String table, int transportid,int Case){
          DropTable(table);
        String id=transportid+"";
        if(Case==1){//TMS suggestion
            if(transportid==6)
                id="2,3,4,5";
        query ="CREATE TABLE "+table+" as " +
                  "SELECT c.transportId\"T1\",outer.carrierid\"C1\",outer.orderid\"O1\"," +
                  "COALESCE((select sum(KpiValue*(KpiWeight)) from kpilog where orderid=outer.orderid ),0)\"C2\" " +
                  "from orders outer,carrier c where outer.carrierid=c.carrierid and c.transportId in ("+id+") and outer.statusId=5" +
                  " order by 4 desc";
           System.out.println(query);
        }
        else{//Client Suggestion
           
            if(transportid==6)
                id="2,3,4,5";
           query ="create table ClientKPI as " +
               "SELECT c.fullName\"N1\", c.transportId\"T1\",o.carrierid\"C1\",o.orderid\"O1\"," +
                "COALESCE((select (KpiValue*KpiWeight) from kpilog where orderid=o.orderid and KpiParId=2),-1)\"C3\"," +
                "COALESCE((select (KpiValue*KpiWeight) from kpilog where orderid=o.orderid and KpiParId=3),-1)\"C4\"," +
                "COALESCE((select (KpiValue*KpiWeight) from kpilog where orderid=o.orderid and KpiParId=4),-1)\"C5\" " +
                "from orders o ,carrier c where o.carrierid=c.carrierid " +
                "and c.transportId in("+id+") and o.statusId=5 " +
               "order by 3 desc ";
            System.out.println(query);
        }
        
        return query;
    }//end of selectQuery 
    
    public String SelectKPIQuery(String table,int Case,int transid){
       
       String id=""+transid;
            if(transid==6)
                id="2,3,4,5";
        if(Case==1){
             query="select outer.fullname\"N1\",COALESCE((select avg(C2) from "+table+" where C1 = outer.carrierid),-1)\"AverageKPI\",outer.carrierid," +
           "COALESCE((select count(C1) from "+table+" where C1 = outer.carrierid ),0)\"NumberOfOrder\" " +
           "from carrier outer  where COALESCE((select avg(C2) from "+table+" where C1 = outer.carrierid),-1)>0 and outer.transportid="+id +
           "  order by COALESCE((select avg(C2) from "+table+" where C1 = outer.carrierid),-1) desc ";
           // System.out.println(query);
        }
        else if(Case==2){
             query="select T1, N1, avg(c3)\"Cost\",count(c1)\"numberoforder\", c1\"carrierid\",T1 from clientkpi where T1 in("+id+")  group by c1,N1,T1  order by 2 desc ";
            //  System.out.println("case 2\n"+query);
        }
         else if(Case==3){
            query="select N1, avg(c4)\"Time\",count(c1)\"numberoforder\", c1\"carrierid\",T1  from clientkpi where T1 in("+id+") group by c1,N1,T1  order by 2 desc ";
            //System.out.println("case 3\n"+query);
        }
         else if(Case==4){
            query="select N1,count(c1)\"numberoforder\", c1\"carrierid\",T1 from clientkpi where T1 in("+id+") group by c1,N1,T1  order by 2 desc ";
            //System.out.println("case 4 +"+id+"\n"+query);
        }
       
        return query;
    }//end of selectQuery 
    public void DropTable(String table){
     
        String query="Drop table "+ table;  
        bestCarry.setQuery(query);
                  
    }//end of drop table
    
}
