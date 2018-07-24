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
@Table(name = "ris_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ris_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RisDetails.findAll", query = "SELECT r FROM RisDetails r")
    , @NamedQuery(name = "RisDetails.findByIdRisDetails", query = "SELECT r FROM RisDetails r WHERE r.idRisDetails = :idRisDetails")
    , @NamedQuery(name = "RisDetails.findByStockNo", query = "SELECT r FROM RisDetails r WHERE r.stockNo = :stockNo")
    , @NamedQuery(name = "RisDetails.findByUnit", query = "SELECT r FROM RisDetails r WHERE r.unit = :unit")
    , @NamedQuery(name = "RisDetails.findByDescription", query = "SELECT r FROM RisDetails r WHERE r.description = :description")
    , @NamedQuery(name = "RisDetails.findByReqQuantity", query = "SELECT r FROM RisDetails r WHERE r.reqQuantity = :reqQuantity")
    , @NamedQuery(name = "RisDetails.findByStockAvail", query = "SELECT r FROM RisDetails r WHERE r.stockAvail = :stockAvail")
    , @NamedQuery(name = "RisDetails.findByIssuedQuantity", query = "SELECT r FROM RisDetails r WHERE r.issuedQuantity = :issuedQuantity")
    , @NamedQuery(name = "RisDetails.findByRemarks", query = "SELECT r FROM RisDetails r WHERE r.remarks = :remarks")})
public class RisDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ris_details", nullable = false)
    private Integer idRisDetails;
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Column(name = "req_quantity")
    private Integer reqQuantity;
    @Column(name = "stock_avail")
    private Integer stockAvail;
    @Column(name = "issued_quantity")
    private Integer issuedQuantity;
    @Size(max = 45)
    @Column(length = 45)
    private String remarks;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris", nullable = false)
    @ManyToOne(optional = false)
    private Ris idRis;

    public RisDetails() {
    }

    public RisDetails(Integer idRisDetails) {
        this.idRisDetails = idRisDetails;
    }

    public Integer getIdRisDetails() {
        return idRisDetails;
    }

    public void setIdRisDetails(Integer idRisDetails) {
        this.idRisDetails = idRisDetails;
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

    public Integer getReqQuantity() {
        return reqQuantity;
    }

    public void setReqQuantity(Integer reqQuantity) {
        this.reqQuantity = reqQuantity;
    }

    public Integer getStockAvail() {
        return stockAvail;
    }

    public void setStockAvail(Integer stockAvail) {
        this.stockAvail = stockAvail;
    }

    public Integer getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(Integer issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRisDetails != null ? idRisDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RisDetails)) {
            return false;
        }
        RisDetails other = (RisDetails) object;
        if ((this.idRisDetails == null && other.idRisDetails != null) || (this.idRisDetails != null && !this.idRisDetails.equals(other.idRisDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RisDetails[ idRisDetails=" + idRisDetails + " ]";
    }
    
}
