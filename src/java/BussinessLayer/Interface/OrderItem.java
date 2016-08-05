/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tmsModelLayer.Carrier;
import tmsModelLayer.ClientConsider;
import tmsModelLayer.Item;
import tmsModelLayer.Itemcategory;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public interface OrderItem {
    public Set<Orders> getClientOrder(int cL_Id);
    public List<Item> getOrderItem(long orderId);
    public void setClientOrder(int clientid,int providerid,int driver_id,String deprt,String arrival,ArrayList<Item> ClItem,int cosiderid,int clinetTransid);
    public Item setOrderItem(long orderId,int catNo,double Weight,int Volume,double Price,int Qnty);
    public Set<Orders> getCarrierOrder(int cR_Id);
    public Orders getDriverOrder(int dR_Id);
    public Set<Orders> getProviderOrder(int pR_Id);
    public int getPosition(long orderId);
    public ArrayList<Itemcategory> getCategory();
    public ArrayList<Carrier> getBestCarriers(ClientConsider temp);
}