/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Impl;

import BussinessLayer.Interface.Actions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tmsModelLayer.Gps;
import tmsModelLayer.Kpilog;
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
       con=new Oracle();
       con.connect("scott","tiger");
       query="update Orders set statusid=2 where orderid="+orderid;
       con.setQuery(query);       
       con.terminate();
    }

    @Override
    public void orderFeedBack(ArrayList<Kpilog> feedbackList) {
   
       con=new Oracle();
       con.connect("scott","tiger");
       for(Kpilog element:feedbackList){
           query="insert into KPILOG Values("+element.getOrderid()+","+element.getKpiparid1()+","+element.getKpivalue()+
                   ","+element.getKpiweight()+")";
               
           con.setQuery(query);
      }
       con.terminate();
     
    }
    @Override
    public void SetPositoin(long orderid, double x, double y) {
       Oracle drCon=new Oracle();
      drCon.connect("scott", "tiger");      
      query="insert into gps values("+orderid+","+x+","+y+",(select sysdate from dual))";
      drCon.setQuery(query);
      drCon.terminate();
      
    }

    @Override
    public ArrayList<Gps> getPosition(int orderid) {
        ArrayList<Gps> positionList=new ArrayList();
        ResultSet rslpos;
         Oracle pos=new Oracle();
      pos.connect("scott", "tiger");      
      query="select* from gps where gpsorderid="+orderid;
      rslpos=pos.getResult(query);
      try {
          while(rslpos.next()){
              Gps record=new Gps();
              record.setGpsorderid(rslpos.getLong("gpsorderid"));
              record.setGpsx(rslpos.getDouble("gpsx"));
              record.setGpsy(rslpos.getDouble("gpsy"));
              record.setGpsdate(rslpos.getDate("gpsdate"));
              positionList.add(record);
              
          }
      } 
      catch (SQLException ex) {
          Logger.getLogger(UserActions.class.getName()).log(Level.SEVERE, null, ex);
      }
       
      pos.terminate();
      return positionList;
    }

    @Override
    public void deliverOrder(long orderid) {
         con=new Oracle();
       con.connect("scott","tiger");
       query="update Orders set statusid=5 where orderid="+orderid;
       con.setQuery(query);       
       con.terminate();
    }
    
}
