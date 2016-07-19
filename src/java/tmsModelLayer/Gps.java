/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cstuser
 */
@Entity
@Table(name = "GPS", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gps.findAll", query = "SELECT g FROM Gps g"),
    @NamedQuery(name = "Gps.findByGpsorderid", query = "SELECT g FROM Gps g WHERE g.gpsorderid = :gpsorderid"),
    @NamedQuery(name = "Gps.findByGpsx", query = "SELECT g FROM Gps g WHERE g.gpsx = :gpsx"),
    @NamedQuery(name = "Gps.findByGpsy", query = "SELECT g FROM Gps g WHERE g.gpsy = :gpsy"),
    @NamedQuery(name = "Gps.findByGpsdate", query = "SELECT g FROM Gps g WHERE g.gpsdate = :gpsdate")})
public class Gps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GPSORDERID")
    private Long gpsorderid;
    @Column(name = "GPSX")
    private Integer gpsx;
    @Column(name = "GPSY")
    private Integer gpsy;
    @Column(name = "GPSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gpsdate;
    @JoinColumn(name = "GPSORDERID", referencedColumnName = "ORDERID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orders orders;

    public Gps() {
    }

    public Gps(Long gpsorderid) {
        this.gpsorderid = gpsorderid;
    }

    public Long getGpsorderid() {
        return gpsorderid;
    }

    public void setGpsorderid(Long gpsorderid) {
        this.gpsorderid = gpsorderid;
    }

    public Integer getGpsx() {
        return gpsx;
    }

    public void setGpsx(Integer gpsx) {
        this.gpsx = gpsx;
    }

    public Integer getGpsy() {
        return gpsy;
    }

    public void setGpsy(Integer gpsy) {
        this.gpsy = gpsy;
    }

    public Date getGpsdate() {
        return gpsdate;
    }

    public void setGpsdate(Date gpsdate) {
        this.gpsdate = gpsdate;
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
        hash += (gpsorderid != null ? gpsorderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gps)) {
            return false;
        }
        Gps other = (Gps) object;
        if ((this.gpsorderid == null && other.gpsorderid != null) || (this.gpsorderid != null && !this.gpsorderid.equals(other.gpsorderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.Gps[ gpsorderid=" + gpsorderid + " ]";
    }
    
}
