/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cstuser
 */
@Embeddable
public class ItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private long orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMCATEGORYID")
    private short itemcategoryid;

    public ItemPK() {
    }

    public ItemPK(long orderid, short itemcategoryid) {
        this.orderid = orderid;
        this.itemcategoryid = itemcategoryid;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public short getItemcategoryid() {
        return itemcategoryid;
    }

    public void setItemcategoryid(short itemcategoryid) {
        this.itemcategoryid = itemcategoryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderid;
        hash += (int) itemcategoryid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPK)) {
            return false;
        }
        ItemPK other = (ItemPK) object;
        if (this.orderid != other.orderid) {
            return false;
        }
        if (this.itemcategoryid != other.itemcategoryid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.ItemPK[ orderid=" + orderid + ", itemcategoryid=" + itemcategoryid + " ]";
    }
    
}
