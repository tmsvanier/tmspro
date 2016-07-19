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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cstuser
 */
@Entity
@Table(name = "KPILOG", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kpilog.findAll", query = "SELECT k FROM Kpilog k"),
    @NamedQuery(name = "Kpilog.findByOrderid", query = "SELECT k FROM Kpilog k WHERE k.kpilogPK.orderid = :orderid"),
    @NamedQuery(name = "Kpilog.findByKpiparid", query = "SELECT k FROM Kpilog k WHERE k.kpilogPK.kpiparid = :kpiparid"),
    @NamedQuery(name = "Kpilog.findByKpivalue", query = "SELECT k FROM Kpilog k WHERE k.kpivalue = :kpivalue"),
    @NamedQuery(name = "Kpilog.findByKpiweight", query = "SELECT k FROM Kpilog k WHERE k.kpiweight = :kpiweight"),
    @NamedQuery(name = "Kpilog.findByKpiparid1", query = "SELECT k FROM Kpilog k WHERE k.kpiparid1 = :kpiparid1")})
public class Kpilog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KpilogPK kpilogPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KPIVALUE")
    private BigDecimal kpivalue;
    @Column(name = "KPIWEIGHT")
    private Short kpiweight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPIPARID")
    private short kpiparid1;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;

    public Kpilog() {
    }

    public Kpilog(KpilogPK kpilogPK) {
        this.kpilogPK = kpilogPK;
    }

    public Kpilog(KpilogPK kpilogPK, short kpiparid1) {
        this.kpilogPK = kpilogPK;
        this.kpiparid1 = kpiparid1;
    }

    public Kpilog(long orderid, short kpiparid) {
        this.kpilogPK = new KpilogPK(orderid, kpiparid);
    }

    public KpilogPK getKpilogPK() {
        return kpilogPK;
    }

    public void setKpilogPK(KpilogPK kpilogPK) {
        this.kpilogPK = kpilogPK;
    }

    public BigDecimal getKpivalue() {
        return kpivalue;
    }

    public void setKpivalue(BigDecimal kpivalue) {
        this.kpivalue = kpivalue;
    }

    public Short getKpiweight() {
        return kpiweight;
    }

    public void setKpiweight(Short kpiweight) {
        this.kpiweight = kpiweight;
    }

    public short getKpiparid1() {
        return kpiparid1;
    }

    public void setKpiparid1(short kpiparid1) {
        this.kpiparid1 = kpiparid1;
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
        hash += (kpilogPK != null ? kpilogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kpilog)) {
            return false;
        }
        Kpilog other = (Kpilog) object;
        if ((this.kpilogPK == null && other.kpilogPK != null) || (this.kpilogPK != null && !this.kpilogPK.equals(other.kpilogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.Kpilog[ kpilogPK=" + kpilogPK + " ]";
    }
    
}
