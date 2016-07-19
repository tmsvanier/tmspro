/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "ORDERSTATUS", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderstatus.findAll", query = "SELECT o FROM Orderstatus o"),
    @NamedQuery(name = "Orderstatus.findByStatusid", query = "SELECT o FROM Orderstatus o WHERE o.statusid = :statusid"),
    @NamedQuery(name = "Orderstatus.findByStatusdesc", query = "SELECT o FROM Orderstatus o WHERE o.statusdesc = :statusdesc")})
public class Orderstatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUSID")
    private Short statusid;
    @Size(max = 20)
    @Column(name = "STATUSDESC")
    private String statusdesc;
    @OneToMany(mappedBy = "statusid")
    private Collection<Orders> ordersCollection;

    public Orderstatus() {
    }

    public Orderstatus(Short statusid) {
        this.statusid = statusid;
    }

    public Short getStatusid() {
        return statusid;
    }

    public void setStatusid(Short statusid) {
        this.statusid = statusid;
    }

    public String getStatusdesc() {
        return statusdesc;
    }

    public void setStatusdesc(String statusdesc) {
        this.statusdesc = statusdesc;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusid != null ? statusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderstatus)) {
            return false;
        }
        Orderstatus other = (Orderstatus) object;
        if ((this.statusid == null && other.statusid != null) || (this.statusid != null && !this.statusid.equals(other.statusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.Orderstatus[ statusid=" + statusid + " ]";
    }
    
}
