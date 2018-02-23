/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
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
    @NamedQuery(name = "Ics.findAll", query = "SELECT i FROM Ics i")
    , @NamedQuery(name = "Ics.findByIdICS", query = "SELECT i FROM Ics i WHERE i.idICS = :idICS")
    , @NamedQuery(name = "Ics.findByIdFundCluster", query = "SELECT i FROM Ics i WHERE i.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Ics.findByIcsNum", query = "SELECT i FROM Ics i WHERE i.icsNum = :icsNum")
    , @NamedQuery(name = "Ics.findByQuantity", query = "SELECT i FROM Ics i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "Ics.findByUnti", query = "SELECT i FROM Ics i WHERE i.unti = :unti")
    , @NamedQuery(name = "Ics.findByAmountUnitCost", query = "SELECT i FROM Ics i WHERE i.amountUnitCost = :amountUnitCost")
    , @NamedQuery(name = "Ics.findByAmountTotalCost", query = "SELECT i FROM Ics i WHERE i.amountTotalCost = :amountTotalCost")
    , @NamedQuery(name = "Ics.findByDescription", query = "SELECT i FROM Ics i WHERE i.description = :description")
    , @NamedQuery(name = "Ics.findByInventoryItemNum", query = "SELECT i FROM Ics i WHERE i.inventoryItemNum = :inventoryItemNum")
    , @NamedQuery(name = "Ics.findByEstimtedUsefulLife", query = "SELECT i FROM Ics i WHERE i.estimtedUsefulLife = :estimtedUsefulLife")
    , @NamedQuery(name = "Ics.findByReceivedFrom", query = "SELECT i FROM Ics i WHERE i.receivedFrom = :receivedFrom")
    , @NamedQuery(name = "Ics.findByReceivedBy", query = "SELECT i FROM Ics i WHERE i.receivedBy = :receivedBy")
    , @NamedQuery(name = "Ics.findByUpAsset", query = "SELECT i FROM Ics i WHERE i.upAsset = :upAsset")})
public class Ics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ICS")
    private Integer idICS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ics_num")
    private int icsNum;
    private Integer quantity;
    private Integer unti;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount_unit_cost")
    private Float amountUnitCost;
    @Column(name = "amount_total_cost")
    private Float amountTotalCost;
    @Size(max = 100)
    private String description;
    @Column(name = "inventory_item_num")
    private Integer inventoryItemNum;
    @Size(max = 45)
    @Column(name = "estimted_useful_life")
    private String estimtedUsefulLife;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "received_from")
    private String receivedFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "received_by")
    private String receivedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset1")
    private List<Generalinventory> generalinventoryList;

    public Ics() {
    }

    public Ics(Integer idICS) {
        this.idICS = idICS;
    }

    public Ics(Integer idICS, int idFundCluster, int icsNum, String receivedFrom, String receivedBy, int upAsset) {
        this.idICS = idICS;
        this.idFundCluster = idFundCluster;
        this.icsNum = icsNum;
        this.receivedFrom = receivedFrom;
        this.receivedBy = receivedBy;
        this.upAsset = upAsset;
    }

    public Integer getIdICS() {
        return idICS;
    }

    public void setIdICS(Integer idICS) {
        this.idICS = idICS;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public int getIcsNum() {
        return icsNum;
    }

    public void setIcsNum(int icsNum) {
        this.icsNum = icsNum;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnti() {
        return unti;
    }

    public void setUnti(Integer unti) {
        this.unti = unti;
    }

    public Float getAmountUnitCost() {
        return amountUnitCost;
    }

    public void setAmountUnitCost(Float amountUnitCost) {
        this.amountUnitCost = amountUnitCost;
    }

    public Float getAmountTotalCost() {
        return amountTotalCost;
    }

    public void setAmountTotalCost(Float amountTotalCost) {
        this.amountTotalCost = amountTotalCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInventoryItemNum() {
        return inventoryItemNum;
    }

    public void setInventoryItemNum(Integer inventoryItemNum) {
        this.inventoryItemNum = inventoryItemNum;
    }

    public String getEstimtedUsefulLife() {
        return estimtedUsefulLife;
    }

    public void setEstimtedUsefulLife(String estimtedUsefulLife) {
        this.estimtedUsefulLife = estimtedUsefulLife;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
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
        hash += (idICS != null ? idICS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ics)) {
            return false;
        }
        Ics other = (Ics) object;
        if ((this.idICS == null && other.idICS != null) || (this.idICS != null && !this.idICS.equals(other.idICS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ics[ idICS=" + idICS + " ]";
    }
    
}
