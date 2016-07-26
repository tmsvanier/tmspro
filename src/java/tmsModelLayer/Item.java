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
  //  protected ItemPK itemPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ITEMWEIGHT")
    private double itemweight;
    @Column(name = "ITEMVOLUME")
    private Integer itemvolume;
    @Column(name = "ITEMPRICE")
    private double itemprice;
    @Column(name = "ITEMQTY")
    private Integer itemqty;
    @JoinColumn(name = "ITEMCATEGORYID", referencedColumnName = "ITEMCATEGORYID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private int itemcategory;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private long orderId;
    private String categoryDetail;
    private String itemDesc;
    public Item() {
    }

    public String getItemDesc() {
        return itemDesc;
    }

//   // public Item(ItemPK itemPK) {
//        this.itemPK = itemPK;
//    }
//
//    public Item(long orderid, short itemcategoryid) {
//        this.itemPK = new ItemPK(orderid, itemcategoryid);
//    }
//
//    public ItemPK getItemPK() {
//        return itemPK;
//    }
//    public void setItemPK(ItemPK itemPK) {
//        this.itemPK = itemPK;
//    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getItemweight() {
        return itemweight;
    }

    public void setItemweight(double itemweight) {
        this.itemweight = itemweight;
    }

    public Integer getItemvolume() {
        return itemvolume;
    }

    public void setItemvolume(Integer itemvolume) {
        this.itemvolume = itemvolume;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public Integer getItemqty() {
        return itemqty;
    }

    public void setItemqty(Integer itemqty) {
        this.itemqty = itemqty;
    }

    public int getItemcategory() {
        return itemcategory;
    }

    public String getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(String categoryDetail) {
        this.categoryDetail = categoryDetail;
    }
   
    public void setItemcategory(int itemcategory) {
        this.itemcategory = itemcategory;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (itemPK != null ? itemPK.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Item)) {
//            return false;
//        }
//        Item other = (Item) object;
//        if ((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        String str="";
        str+="&nbsp;&nbsp;&nbsp;&nbsp;&nbspCategory&nbsp;&nbsp;&nbsp;&nbsp;&nbspWeight(kg)&nbsp;&nbsp;&nbsp;&nbsp;&nbspitemqty&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbspPrice&nbsp;&nbsp;&nbsp;&nbsp;&nbspitem Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</br>";
        str+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+
                categoryDetail+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"
                +itemweight+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"
                +itemqty+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+
                itemprice+"$&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+
                itemDesc+"</br>";
        str+="----------------------------------------------------------------------------------------</br>";
        
        return str;
    }
    
}
