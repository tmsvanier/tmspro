/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

import tmsModelLayer.Item;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public interface OrderItem {
    public Orders getClientOrder(int cL_Id);
    public Item getOrderItem(int orderId);
    public Orders getCarrierOrder(int cR_Id);
    public Orders getDriverOrder(int dR_Id);
    public Orders getProviderOrder(int pR_Id);
    public int getPosition(int orderId);
}
