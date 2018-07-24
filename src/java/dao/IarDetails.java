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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "iar_details", catalog = "daramis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IarDetails.findAll", query = "SELECT i FROM IarDetails i")
    , @NamedQuery(name = "IarDetails.findByIdIarDetails", query = "SELECT i FROM IarDetails i WHERE i.idIarDetails = :idIarDetails")
    , @NamedQuery(name = "IarDetails.findByIarNo", query = "SELECT i FROM IarDetails i WHERE i.iarNo = :iarNo")
    , @NamedQuery(name = "IarDetails.findByStockNo", query = "SELECT i FROM IarDetails i WHERE i.stockNo = :stockNo")
    , @NamedQuery(name = "IarDetails.findByDescription", query = "SELECT i FROM IarDetails i WHERE i.description = :description")
    , @NamedQuery(name = "IarDetails.findByUnit", query = "SELECT i FROM IarDetails i WHERE i.unit = :unit")
    , @NamedQuery(name = "IarDetails.findByQuantity", query = "SELECT i FROM IarDetails i WHERE i.quantity = :quantity")})
public class IarDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_iar_details", nullable = false)
    private Integer idIarDetails;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iar_no", nullable = false)
    private int iarNo;
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    private Integer quantity;

    public IarDetails() {
    }

    public IarDetails(Integer idIarDetails) {
        this.idIarDetails = idIarDetails;
    }

    public IarDetails(Integer idIarDetails, int iarNo) {
        this.idIarDetails = idIarDetails;
        this.iarNo = iarNo;
    }

    public Integer getIdIarDetails() {
        return idIarDetails;
    }

    public void setIdIarDetails(Integer idIarDetails) {
        this.idIarDetails = idIarDetails;
    }

    public int getIarNo() {
        return iarNo;
    }

    public void setIarNo(int iarNo) {
        this.iarNo = iarNo;
    }

    public Integer getStockNo() {
        return stockNo;
    }

    public void setStockNo(Integer stockNo) {
        this.stockNo = stockNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIarDetails != null ? idIarDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IarDetails)) {
            return false;
        }
        IarDetails other = (IarDetails) object;
        if ((this.idIarDetails == null && other.idIarDetails != null) || (this.idIarDetails != null && !this.idIarDetails.equals(other.idIarDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.IarDetails[ idIarDetails=" + idIarDetails + " ]";
    }
    
}
