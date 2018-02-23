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
    @NamedQuery(name = "Ppelc.findAll", query = "SELECT p FROM Ppelc p")
    , @NamedQuery(name = "Ppelc.findByIdPPELC", query = "SELECT p FROM Ppelc p WHERE p.idPPELC = :idPPELC")
    , @NamedQuery(name = "Ppelc.findByIdFundCluster", query = "SELECT p FROM Ppelc p WHERE p.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Ppelc.findByPropPlantEquip", query = "SELECT p FROM Ppelc p WHERE p.propPlantEquip = :propPlantEquip")
    , @NamedQuery(name = "Ppelc.findByDescription", query = "SELECT p FROM Ppelc p WHERE p.description = :description")
    , @NamedQuery(name = "Ppelc.findByObjAmtCode", query = "SELECT p FROM Ppelc p WHERE p.objAmtCode = :objAmtCode")
    , @NamedQuery(name = "Ppelc.findByEstimateUseLife", query = "SELECT p FROM Ppelc p WHERE p.estimateUseLife = :estimateUseLife")
    , @NamedQuery(name = "Ppelc.findByRateOfDepreciation", query = "SELECT p FROM Ppelc p WHERE p.rateOfDepreciation = :rateOfDepreciation")
    , @NamedQuery(name = "Ppelc.findByDate", query = "SELECT p FROM Ppelc p WHERE p.date = :date")
    , @NamedQuery(name = "Ppelc.findByReference", query = "SELECT p FROM Ppelc p WHERE p.reference = :reference")
    , @NamedQuery(name = "Ppelc.findByRecQty", query = "SELECT p FROM Ppelc p WHERE p.recQty = :recQty")
    , @NamedQuery(name = "Ppelc.findByRecUnitcost", query = "SELECT p FROM Ppelc p WHERE p.recUnitcost = :recUnitcost")
    , @NamedQuery(name = "Ppelc.findByRecTotalcost", query = "SELECT p FROM Ppelc p WHERE p.recTotalcost = :recTotalcost")
    , @NamedQuery(name = "Ppelc.findByAccumulatedDep", query = "SELECT p FROM Ppelc p WHERE p.accumulatedDep = :accumulatedDep")
    , @NamedQuery(name = "Ppelc.findByAccumulatedImpairLoss", query = "SELECT p FROM Ppelc p WHERE p.accumulatedImpairLoss = :accumulatedImpairLoss")
    , @NamedQuery(name = "Ppelc.findByIssuesTransfersAdjustments", query = "SELECT p FROM Ppelc p WHERE p.issuesTransfersAdjustments = :issuesTransfersAdjustments")
    , @NamedQuery(name = "Ppelc.findByAdjustedCost", query = "SELECT p FROM Ppelc p WHERE p.adjustedCost = :adjustedCost")
    , @NamedQuery(name = "Ppelc.findByRhNatureRepair", query = "SELECT p FROM Ppelc p WHERE p.rhNatureRepair = :rhNatureRepair")
    , @NamedQuery(name = "Ppelc.findByRhAmount", query = "SELECT p FROM Ppelc p WHERE p.rhAmount = :rhAmount")
    , @NamedQuery(name = "Ppelc.findByUpAsset", query = "SELECT p FROM Ppelc p WHERE p.upAsset = :upAsset")})
public class Ppelc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_PPELC")
    private Integer idPPELC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prop_plant_equip")
    private String propPlantEquip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String description;
    @Size(max = 45)
    @Column(name = "obj_amt_code")
    private String objAmtCode;
    @Size(max = 45)
    @Column(name = "estimate_use_life")
    private String estimateUseLife;
    @Size(max = 45)
    @Column(name = "rate_of_depreciation")
    private String rateOfDepreciation;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    private String reference;
    @Size(max = 45)
    @Column(name = "rec_qty")
    private String recQty;
    @Size(max = 45)
    @Column(name = "rec_unitcost")
    private String recUnitcost;
    @Size(max = 45)
    @Column(name = "rec_totalcost")
    private String recTotalcost;
    @Size(max = 45)
    @Column(name = "accumulated_dep")
    private String accumulatedDep;
    @Size(max = 45)
    @Column(name = "accumulated_impair_loss")
    private String accumulatedImpairLoss;
    @Size(max = 45)
    @Column(name = "issues_transfers_adjustments")
    private String issuesTransfersAdjustments;
    @Size(max = 45)
    @Column(name = "adjusted_cost")
    private String adjustedCost;
    @Size(max = 45)
    @Column(name = "rh_nature_repair")
    private String rhNatureRepair;
    @Size(max = 45)
    @Column(name = "rh_amount")
    private String rhAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset3")
    private List<Generalinventory> generalinventoryList;

    public Ppelc() {
    }

    public Ppelc(Integer idPPELC) {
        this.idPPELC = idPPELC;
    }

    public Ppelc(Integer idPPELC, int idFundCluster, String propPlantEquip, String description, int upAsset) {
        this.idPPELC = idPPELC;
        this.idFundCluster = idFundCluster;
        this.propPlantEquip = propPlantEquip;
        this.description = description;
        this.upAsset = upAsset;
    }

    public Integer getIdPPELC() {
        return idPPELC;
    }

    public void setIdPPELC(Integer idPPELC) {
        this.idPPELC = idPPELC;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public String getPropPlantEquip() {
        return propPlantEquip;
    }

    public void setPropPlantEquip(String propPlantEquip) {
        this.propPlantEquip = propPlantEquip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjAmtCode() {
        return objAmtCode;
    }

    public void setObjAmtCode(String objAmtCode) {
        this.objAmtCode = objAmtCode;
    }

    public String getEstimateUseLife() {
        return estimateUseLife;
    }

    public void setEstimateUseLife(String estimateUseLife) {
        this.estimateUseLife = estimateUseLife;
    }

    public String getRateOfDepreciation() {
        return rateOfDepreciation;
    }

    public void setRateOfDepreciation(String rateOfDepreciation) {
        this.rateOfDepreciation = rateOfDepreciation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRecQty() {
        return recQty;
    }

    public void setRecQty(String recQty) {
        this.recQty = recQty;
    }

    public String getRecUnitcost() {
        return recUnitcost;
    }

    public void setRecUnitcost(String recUnitcost) {
        this.recUnitcost = recUnitcost;
    }

    public String getRecTotalcost() {
        return recTotalcost;
    }

    public void setRecTotalcost(String recTotalcost) {
        this.recTotalcost = recTotalcost;
    }

    public String getAccumulatedDep() {
        return accumulatedDep;
    }

    public void setAccumulatedDep(String accumulatedDep) {
        this.accumulatedDep = accumulatedDep;
    }

    public String getAccumulatedImpairLoss() {
        return accumulatedImpairLoss;
    }

    public void setAccumulatedImpairLoss(String accumulatedImpairLoss) {
        this.accumulatedImpairLoss = accumulatedImpairLoss;
    }

    public String getIssuesTransfersAdjustments() {
        return issuesTransfersAdjustments;
    }

    public void setIssuesTransfersAdjustments(String issuesTransfersAdjustments) {
        this.issuesTransfersAdjustments = issuesTransfersAdjustments;
    }

    public String getAdjustedCost() {
        return adjustedCost;
    }

    public void setAdjustedCost(String adjustedCost) {
        this.adjustedCost = adjustedCost;
    }

    public String getRhNatureRepair() {
        return rhNatureRepair;
    }

    public void setRhNatureRepair(String rhNatureRepair) {
        this.rhNatureRepair = rhNatureRepair;
    }

    public String getRhAmount() {
        return rhAmount;
    }

    public void setRhAmount(String rhAmount) {
        this.rhAmount = rhAmount;
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
        hash += (idPPELC != null ? idPPELC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ppelc)) {
            return false;
        }
        Ppelc other = (Ppelc) object;
        if ((this.idPPELC == null && other.idPPELC != null) || (this.idPPELC != null && !this.idPPELC.equals(other.idPPELC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ppelc[ idPPELC=" + idPPELC + " ]";
    }
    
}
