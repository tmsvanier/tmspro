/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cstuser
 */
@Entity
@Table(name = "ORDERS", catalog = "", schema = "SCOTT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Orders o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Orders.findByDeparture", query = "SELECT o FROM Orders o WHERE o.departure = :departure"),
    @NamedQuery(name = "Orders.findByArrival", query = "SELECT o FROM Orders o WHERE o.arrival = :arrival"),
    @NamedQuery(name = "Orders.findByDistance", query = "SELECT o FROM Orders o WHERE o.distance = :distance"),
    @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Orders.findByClientid", query = "SELECT o FROM Orders o WHERE o.clientid = :clientid"),
    @NamedQuery(name = "Orders.findByDriverid", query = "SELECT o FROM Orders o WHERE o.driverid = :driverid"),
    @NamedQuery(name = "Orders.findByProviderid", query = "SELECT o FROM Orders o WHERE o.providerid = :providerid")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private Long orderid;
    @Size(max = 100)
    @Column(name = "DEPARTURE")
    private String departure;
    @Size(max = 100)
    @Column(name = "ARRIVAL")
    private String arrival;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISTANCE")
    private BigDecimal distance;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Column(name = "CLIENTID")
    private Integer clientid;
    @Column(name = "DRIVERID")
    private Integer driverid;
    @Column(name = "PROVIDERID")
    private int providerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private ArrayList<Item> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Collection<Kpilog> kpilogCollection;
    @JoinColumn(name = "STATUSID", referencedColumnName = "STATUSID")
    @ManyToOne
    private int statusid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
    private Gps gps;
    Carrier orderCarrier;
    Driver OrderDriver;
    Provider OrderProvidr;
    
    public Orders() {
        
    }

    public Orders(Long orderid) {
        this.orderid = orderid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getDriverid() {
        return driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    public int getProviderid() {
        return providerid;
    }

    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }

    @XmlTransient
    public ArrayList<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(ArrayList<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<Kpilog> getKpilogCollection() {
        return kpilogCollection;
    }

    public void setKpilogCollection(Collection<Kpilog> kpilogCollection) {
        this.kpilogCollection = kpilogCollection;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int states) {
        this.statusid = states;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ orderid+"//"+clientid+"//"+providerid+"//"+departure+"//"+arrival+"//"+driverid+"//"+statusid+"//";
    }
    public void makeCopy(Orders tOrder){
        
        orderid=tOrder.getOrderid();
    }
}
