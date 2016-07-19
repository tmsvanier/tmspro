/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cstuser
 */
@Entity
@Table(name = "ITEM", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByOrderid", query = "SELECT i FROM Item i WHERE i.itemPK.orderid = :orderid"),
    @NamedQuery(name = "Item.findByItemcategoryid", query = "SELECT i FROM Item i WHERE i.itemPK.itemcategoryid = :itemcategoryid"),
    @NamedQuery(name = "Item.findByItemweight", query = "SELECT i FROM Item i WHERE i.itemweight = :itemweight"),
    @NamedQuery(name = "Item.findByItemvolume", query = "SELECT i FROM Item i WHERE i.itemvolume = :itemvolume"),
    @NamedQuery(name = "Item.findByItemprice", query = "SELECT i FROM Item i WHERE i.itemprice = :itemprice"),
    @NamedQuery(name = "Item.findByItemqty", query = "SELECT i FROM Item i WHERE i.itemqty = :itemqty")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPK itemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ITEMWEIGHT")
    private BigDecimal itemweight;
    @Column(name = "ITEMVOLUME")
    private Integer itemvolume;
    @Column(name = "ITEMPRICE")
    private BigDecimal itemprice;
    @Column(name = "ITEMQTY")
    private Integer itemqty;
    @JoinColumn(name = "ITEMCATEGORYID", referencedColumnName = "ITEMCATEGORYID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Itemcategory itemcategory;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    public Item() {
    }

    public Item(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Item(long orderid, short itemcategoryid) {
        this.itemPK = new ItemPK(orderid, itemcategoryid);
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public BigDecimal getItemweight() {
        return itemweight;
    }

    public void setItemweight(BigDecimal itemweight) {
        this.itemweight = itemweight;
    }

    public Integer getItemvolume() {
        return itemvolume;
    }

    public void setItemvolume(Integer itemvolume) {
        this.itemvolume = itemvolume;
    }

    public BigDecimal getItemprice() {
        return itemprice;
    }

    public void setItemprice(BigDecimal itemprice) {
        this.itemprice = itemprice;
    }

    public Integer getItemqty() {
        return itemqty;
    }

    public void setItemqty(Integer itemqty) {
        this.itemqty = itemqty;
    }

    public Itemcategory getItemcategory() {
        return itemcategory;
    }

    public void setItemcategory(Itemcategory itemcategory) {
        this.itemcategory = itemcategory;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPK != null ? itemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.Item[ itemPK=" + itemPK + " ]";
    }
    
}
