/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Par.findAll", query = "SELECT p FROM Par p")
    , @NamedQuery(name = "Par.findByIdPAR", query = "SELECT p FROM Par p WHERE p.idPAR = :idPAR")
    , @NamedQuery(name = "Par.findByIdFundCluster", query = "SELECT p FROM Par p WHERE p.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Par.findByParNum", query = "SELECT p FROM Par p WHERE p.parNum = :parNum")
    , @NamedQuery(name = "Par.findByQuantity", query = "SELECT p FROM Par p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Par.findByUnit", query = "SELECT p FROM Par p WHERE p.unit = :unit")
    , @NamedQuery(name = "Par.findByDescription", query = "SELECT p FROM Par p WHERE p.description = :description")
    , @NamedQuery(name = "Par.findByPropNumber", query = "SELECT p FROM Par p WHERE p.propNumber = :propNumber")
    , @NamedQuery(name = "Par.findByDateAcquired", query = "SELECT p FROM Par p WHERE p.dateAcquired = :dateAcquired")
    , @NamedQuery(name = "Par.findByAmount", query = "SELECT p FROM Par p WHERE p.amount = :amount")
    , @NamedQuery(name = "Par.findByUpAsset", query = "SELECT p FROM Par p WHERE p.upAsset = :upAsset")})
public class Par implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_PAR")
    private Integer idPAR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "par_num")
    private String parNum;
    @Basic(optional = false)
    @NotNull
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String unit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prop_number")
    private int propNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_acquired")
    @Temporal(TemporalType.DATE)
    private Date dateAcquired;
    @Basic(optional = false)
    @NotNull
    private float amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset2")
    private List<Generalinventory> generalinventoryList;

    public Par() {
    }

    public Par(Integer idPAR) {
        this.idPAR = idPAR;
    }

    public Par(Integer idPAR, int idFundCluster, String parNum, int quantity, String unit, String description, int propNumber, Date dateAcquired, float amount, int upAsset) {
        this.idPAR = idPAR;
        this.idFundCluster = idFundCluster;
        this.parNum = parNum;
        this.quantity = quantity;
        this.unit = unit;
        this.description = description;
        this.propNumber = propNumber;
        this.dateAcquired = dateAcquired;
        this.amount = amount;
        this.upAsset = upAsset;
    }

    public Integer getIdPAR() {
        return idPAR;
    }

    public void setIdPAR(Integer idPAR) {
        this.idPAR = idPAR;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public String getParNum() {
        return parNum;
    }

    public void setParNum(String parNum) {
        this.parNum = parNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getPropNumber() {
        return propNumber;
    }

    public void setPropNumber(int propNumber) {
        this.propNumber = propNumber;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getUpAsset() {
        return upAsset;
    }

    public void setUpAsset(int upAsset) {
        this.upAsset = upAsset;
    }

    @XmlTransient
    public List<Generalinventory> getGeneralinventoryList() {
        return generalinventoryList;
    }

    public void setGeneralinventoryList(List<Generalinventory> generalinventoryList) {
        this.generalinventoryList = generalinventoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPAR != null ? idPAR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Par)) {
            return false;
        }
        Par other = (Par) object;
        if ((this.idPAR == null && other.idPAR != null) || (this.idPAR != null && !this.idPAR.equals(other.idPAR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Par[ idPAR=" + idPAR + " ]";
    }
    
}
