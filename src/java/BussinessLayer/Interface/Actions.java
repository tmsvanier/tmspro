/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

/**
 *
 * @author cstuser
 */
public interface Actions {
    public void confirmOrder(int orderid,int Carrierid);
    public void cancelOrder(int orderid);
    public void sendEmail();
    public void modifyUsers();
    
    
}
