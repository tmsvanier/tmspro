/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

import java.util.ArrayList;
import tmsModelLayer.Gps;
import tmsModelLayer.Kpilog;

/**
 *
 * @author cstuser
 */
public interface Actions {
    public void confirmOrder(int orderid,int Carrierid);
    public void cancelOrder(int orderid);
    public void shipOrder(int orderid,int driverid);
    public void noDriver(int orderid);
    public void sendEmail();
    public void modifyUsers();
    public void orderFeedBack(ArrayList<Kpilog> feedbackList);
    public void SetPositoin(long orderid, double x,double y);
    public ArrayList<Gps> getPosition(int orderid);
    public void deliverOrder(long orderid);
    
}
