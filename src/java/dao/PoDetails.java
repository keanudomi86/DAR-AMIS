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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "po_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_po_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoDetails.findAll", query = "SELECT p FROM PoDetails p")
    , @NamedQuery(name = "PoDetails.findByIdPoDetails", query = "SELECT p FROM PoDetails p WHERE p.idPoDetails = :idPoDetails")
    , @NamedQuery(name = "PoDetails.findByStockNo", query = "SELECT p FROM PoDetails p WHERE p.stockNo = :stockNo")
    , @NamedQuery(name = "PoDetails.findByUnit", query = "SELECT p FROM PoDetails p WHERE p.unit = :unit")
    , @NamedQuery(name = "PoDetails.findByDescription", query = "SELECT p FROM PoDetails p WHERE p.description = :description")
    , @NamedQuery(name = "PoDetails.findByQuantity", query = "SELECT p FROM PoDetails p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PoDetails.findByCost", query = "SELECT p FROM PoDetails p WHERE p.cost = :cost")
    , @NamedQuery(name = "PoDetails.findByAmount", query = "SELECT p FROM PoDetails p WHERE p.amount = :amount")})
public class PoDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_po_details", nullable = false)
    private Integer idPoDetails;
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float cost;
    @Column(precision = 12)
    private Float amount;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;

    public PoDetails() {
    }

    public PoDetails(Integer idPoDetails) {
        this.idPoDetails = idPoDetails;
    }

    public Integer getIdPoDetails() {
        return idPoDetails;
    }

    public void setIdPoDetails(Integer idPoDetails) {
        this.idPoDetails = idPoDetails;
    }

    public Integer getStockNo() {
        return stockNo;
    }

    public void setStockNo(Integer stockNo) {
        this.stockNo = stockNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoDetails != null ? idPoDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoDetails)) {
            return false;
        }
        PoDetails other = (PoDetails) object;
        if ((this.idPoDetails == null && other.idPoDetails != null) || (this.idPoDetails != null && !this.idPoDetails.equals(other.idPoDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.PoDetails[ idPoDetails=" + idPoDetails + " ]";
    }
    
}
