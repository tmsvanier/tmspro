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
public class KpilogPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private long orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KPIPARID")
    private short kpiparid;

    public KpilogPK() {
    }

    public KpilogPK(long orderid, short kpiparid) {
        this.orderid = orderid;
        this.kpiparid = kpiparid;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public short getKpiparid() {
        return kpiparid;
    }

    public void setKpiparid(short kpiparid) {
        this.kpiparid = kpiparid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderid;
        hash += (int) kpiparid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KpilogPK)) {
            return false;
        }
        KpilogPK other = (KpilogPK) object;
        if (this.orderid != other.orderid) {
            return false;
        }
        if (this.kpiparid != other.kpiparid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tmsModelLayer.KpilogPK[ orderid=" + orderid + ", kpiparid=" + kpiparid + " ]";
    }
    
}
