/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cstuser
 */
@Entity
@Table(name = "TRANSPORTATION", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportation.findAll", query = "SELECT t FROM Transportation t"),
    @NamedQuery(name = "Transportation.findByTransportid", query = "SELECT t FROM Transportation t WHERE t.transportid = :transportid"),
    @NamedQuery(name = "Transportation.findByTransportdesc", query = "SELECT t FROM Transportation t WHERE t.transportdesc = :transportdesc"),
    @NamedQuery(name = "Transportation.findByMaxweight", query = "SELECT t FROM Transportation t WHERE t.maxweight = :maxweight"),
    @NamedQuery(name = "Transportation.findByMaxvolume", query = "SELECT t FROM Transportation t WHERE t.maxvolume = :maxvolume")})
public class Transportation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSPORTID")
    private Short transportid;
    @Size(max = 10)
    @Column(name = "TRANSPORTDESC")
    private String transportdesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MAXWEIGHT")
    private BigDecimal maxweight;
    @Column(name = "MAXVOLUME")
    private BigDecimal maxvolume;

    public Transportation() {
    }

    public Transportation(Short transportid) {
        this.transportid = transportid;
    }

    public Short getTransportid() {
        return transportid;
    }

    public void setTransportid(Short transportid) {
        this.transportid = transportid;
    }

    public String getTransportdesc() {
        return transportdesc;
    }

    public void setTransportdesc(String transportdesc) {
        this.transportdesc = transportdesc;
    }

    public BigDecimal getMaxweight() {
        return maxweight;
    }

    public void setMaxweight(BigDecimal maxweight) {
        this.maxweight = maxweight;
    }

    public BigDecimal getMaxvolume() {
        return maxvolume;
    }

    public void setMaxvolume(BigDecimal maxvolume) {
        this.maxvolume = maxvolume;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transportid != null ? transportid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportation)) {
            return false;
        }
        Transportation other = (Transportation) object;
        if ((this.transportid == null && other.transportid != null) || (this.transportid != null && !this.transportid.equals(other.transportid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.Transportation[ transportid=" + transportid + " ]";
    }
    
}
