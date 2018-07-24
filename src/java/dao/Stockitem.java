/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_stockitem"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockitem.findAll", query = "SELECT s FROM Stockitem s")
    , @NamedQuery(name = "Stockitem.findByIdStockitem", query = "SELECT s FROM Stockitem s WHERE s.idStockitem = :idStockitem")
    , @NamedQuery(name = "Stockitem.findByStockNum", query = "SELECT s FROM Stockitem s WHERE s.stockNum = :stockNum")
    , @NamedQuery(name = "Stockitem.findByUnit", query = "SELECT s FROM Stockitem s WHERE s.unit = :unit")
    , @NamedQuery(name = "Stockitem.findByQuantity", query = "SELECT s FROM Stockitem s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "Stockitem.findByUnitCost", query = "SELECT s FROM Stockitem s WHERE s.unitCost = :unitCost")
    , @NamedQuery(name = "Stockitem.findByAmount", query = "SELECT s FROM Stockitem s WHERE s.amount = :amount")})
public class Stockitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stockitem", nullable = false)
    private Integer idStockitem;
    @Size(max = 45)
    @Column(name = "stock_num", length = 45)
    private String stockNum;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unit_cost", precision = 12)
    private Float unitCost;
    @Column(precision = 12)
    private Float amount;

    public Stockitem() {
    }

    public Stockitem(Integer idStockitem) {
        this.idStockitem = idStockitem;
    }

    public Integer getIdStockitem() {
        return idStockitem;
    }

    public void setIdStockitem(Integer idStockitem) {
        this.idStockitem = idStockitem;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStockitem != null ? idStockitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockitem)) {
            return false;
        }
        Stockitem other = (Stockitem) object;
        if ((this.idStockitem == null && other.idStockitem != null) || (this.idStockitem != null && !this.idStockitem.equals(other.idStockitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Stockitem[ idStockitem=" + idStockitem + " ]";
    }
    
}
