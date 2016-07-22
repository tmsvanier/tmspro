/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer.Interface;

import java.util.List;
import java.util.Set;
import tmsModelLayer.Item;
import tmsModelLayer.Orders;

/**
 *
 * @author cstuser
 */
public interface OrderItem {
    public Set<Orders> getClientOrder(int cL_Id);
    public List<Item> getOrderItem(long orderId);
    public Set<Orders> getCarrierOrder(int cR_Id);
    public Orders getDriverOrder(int dR_Id);
    public Set<Orders> getProviderOrder(int pR_Id);
    public int getPosition(long orderId);
}
