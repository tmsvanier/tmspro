/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cstuser
 */
@Entity
@Table(name = "ITEMCATEGORY", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemcategory.findAll", query = "SELECT i FROM Itemcategory i"),
    @NamedQuery(name = "Itemcategory.findByItemcategoryid", query = "SELECT i FROM Itemcategory i WHERE i.itemcategoryid = :itemcategoryid"),
    @NamedQuery(name = "Itemcategory.findByItemcategorydesc", query = "SELECT i FROM Itemcategory i WHERE i.itemcategorydesc = :itemcategorydesc")})
public class Itemcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMCATEGORYID")
    private int itemcategoryid;
    @Size(max = 10)
    @Column(name = "ITEMCATEGORYDESC")
    private String itemcategorydesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemcategory")
    private Collection<Item> itemCollection;

    public Itemcategory() {
    }

    public Itemcategory(Short itemcategoryid) {
        this.itemcategoryid = itemcategoryid;
    }

    public int getItemcategoryid() {
        return itemcategoryid;
    }

    public void setItemcategoryid(int itemcategoryid) {
        this.itemcategoryid = itemcategoryid;
    }

    public String getItemcategorydesc() {
        return itemcategorydesc;
    }

    public void setItemcategorydesc(String itemcategorydesc) {
        this.itemcategorydesc = itemcategorydesc;
    }
//
//    @XmlTransient
//    public Collection<Item> getItemCollection() {
//        return itemCollection;
//    }
//
////    public void setItemCollection(Collection<Item> itemCollection) {
//        this.itemCollection = itemCollection;
//    }
//
//    @Override
////    public int hashCode() {
//        int hash = 0;
//        hash += (itemcategoryid != 1 ? itemcategoryid.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Itemcategory)) {
//            return false;
//        }
//        Itemcategory other = (Itemcategory) object;
//        if ((this.itemcategoryid == null && other.itemcategoryid != null) || (this.itemcategoryid != null && !this.itemcategoryid.equals(other.itemcategoryid))) {
//            return false;
//        }
//        return true;
//    }

   
    public String toString() {
        return "tmsModelLayer.Itemcategory[ itemcategoryid=" + itemcategoryid + " ]";
    }
    
}
