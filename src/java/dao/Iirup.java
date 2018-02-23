/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iirup.findAll", query = "SELECT i FROM Iirup i")
    , @NamedQuery(name = "Iirup.findByIdIIRUP", query = "SELECT i FROM Iirup i WHERE i.idIIRUP = :idIIRUP")
    , @NamedQuery(name = "Iirup.findByAsAt", query = "SELECT i FROM Iirup i WHERE i.asAt = :asAt")
    , @NamedQuery(name = "Iirup.findByIdFundCluster", query = "SELECT i FROM Iirup i WHERE i.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Iirup.findByIvDateAcquired", query = "SELECT i FROM Iirup i WHERE i.ivDateAcquired = :ivDateAcquired")
    , @NamedQuery(name = "Iirup.findByIvParticularsArticles", query = "SELECT i FROM Iirup i WHERE i.ivParticularsArticles = :ivParticularsArticles")
    , @NamedQuery(name = "Iirup.findByIvPropertyNo", query = "SELECT i FROM Iirup i WHERE i.ivPropertyNo = :ivPropertyNo")
    , @NamedQuery(name = "Iirup.findByIvQuantity", query = "SELECT i FROM Iirup i WHERE i.ivQuantity = :ivQuantity")
    , @NamedQuery(name = "Iirup.findByIvUnitCost", query = "SELECT i FROM Iirup i WHERE i.ivUnitCost = :ivUnitCost")
    , @NamedQuery(name = "Iirup.findByIvTotalCost", query = "SELECT i FROM Iirup i WHERE i.ivTotalCost = :ivTotalCost")
    , @NamedQuery(name = "Iirup.findByIvAccumuDepreciation", query = "SELECT i FROM Iirup i WHERE i.ivAccumuDepreciation = :ivAccumuDepreciation")
    , @NamedQuery(name = "Iirup.findByIvAccumuImpairmentLoss", query = "SELECT i FROM Iirup i WHERE i.ivAccumuImpairmentLoss = :ivAccumuImpairmentLoss")
    , @NamedQuery(name = "Iirup.findByIvCarryAmount", query = "SELECT i FROM Iirup i WHERE i.ivCarryAmount = :ivCarryAmount")
    , @NamedQuery(name = "Iirup.findByRemarks", query = "SELECT i FROM Iirup i WHERE i.remarks = :remarks")
    , @NamedQuery(name = "Iirup.findByIadSale", query = "SELECT i FROM Iirup i WHERE i.iadSale = :iadSale")
    , @NamedQuery(name = "Iirup.findByIadTransfer", query = "SELECT i FROM Iirup i WHERE i.iadTransfer = :iadTransfer")
    , @NamedQuery(name = "Iirup.findByIadDestruction", query = "SELECT i FROM Iirup i WHERE i.iadDestruction = :iadDestruction")
    , @NamedQuery(name = "Iirup.findByIadOthers", query = "SELECT i FROM Iirup i WHERE i.iadOthers = :iadOthers")
    , @NamedQuery(name = "Iirup.findByIadTotal", query = "SELECT i FROM Iirup i WHERE i.iadTotal = :iadTotal")
    , @NamedQuery(name = "Iirup.findByIadAppraisedValue", query = "SELECT i FROM Iirup i WHERE i.iadAppraisedValue = :iadAppraisedValue")
    , @NamedQuery(name = "Iirup.findByIadRecordOrNumber", query = "SELECT i FROM Iirup i WHERE i.iadRecordOrNumber = :iadRecordOrNumber")
    , @NamedQuery(name = "Iirup.findByIadRecordAmount", query = "SELECT i FROM Iirup i WHERE i.iadRecordAmount = :iadRecordAmount")
    , @NamedQuery(name = "Iirup.findByRequestedBy", query = "SELECT i FROM Iirup i WHERE i.requestedBy = :requestedBy")
    , @NamedQuery(name = "Iirup.findByApprovedBy", query = "SELECT i FROM Iirup i WHERE i.approvedBy = :approvedBy")
    , @NamedQuery(name = "Iirup.findByInspectionOfficer", query = "SELECT i FROM Iirup i WHERE i.inspectionOfficer = :inspectionOfficer")
    , @NamedQuery(name = "Iirup.findByWitness", query = "SELECT i FROM Iirup i WHERE i.witness = :witness")})
public class Iirup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_IIRUP")
    private Integer idIIRUP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "as_at")
    private String asAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Column(name = "iv_date_acquired")
    @Temporal(TemporalType.DATE)
    private Date ivDateAcquired;
    @Size(max = 45)
    @Column(name = "iv_particulars_articles")
    private String ivParticularsArticles;
    @Size(max = 45)
    @Column(name = "iv_property_no")
    private String ivPropertyNo;
    @Column(name = "iv_quantity")
    private Integer ivQuantity;
    @Size(max = 45)
    @Column(name = "iv_unit_cost")
    private String ivUnitCost;
    @Size(max = 45)
    @Column(name = "iv_total_cost")
    private String ivTotalCost;
    @Size(max = 45)
    @Column(name = "iv_accumu_depreciation")
    private String ivAccumuDepreciation;
    @Size(max = 45)
    @Column(name = "iv_accumu_impairment_loss")
    private String ivAccumuImpairmentLoss;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iv_carry_amount")
    private Float ivCarryAmount;
    @Size(max = 100)
    private String remarks;
    @Size(max = 45)
    @Column(name = "iad_sale")
    private String iadSale;
    @Size(max = 45)
    @Column(name = "iad_transfer")
    private String iadTransfer;
    @Size(max = 45)
    @Column(name = "iad_destruction")
    private String iadDestruction;
    @Size(max = 45)
    @Column(name = "iad_others")
    private String iadOthers;
    @Size(max = 45)
    @Column(name = "iad_total")
    private String iadTotal;
    @Size(max = 45)
    @Column(name = "iad_appraised_value")
    private String iadAppraisedValue;
    @Size(max = 45)
    @Column(name = "iad_record_or_number")
    private String iadRecordOrNumber;
    @Column(name = "iad_record_amount")
    private Float iadRecordAmount;
    @Size(max = 45)
    @Column(name = "requested_by")
    private String requestedBy;
    @Size(max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @Size(max = 45)
    @Column(name = "inspection_officer")
    private String inspectionOfficer;
    @Size(max = 45)
    private String witness;
    @JoinColumn(name = "id_item", referencedColumnName = "id_GeneralInventory")
    @ManyToOne(optional = false)
    private Generalinventory idItem;

    public Iirup() {
    }

    public Iirup(Integer idIIRUP) {
        this.idIIRUP = idIIRUP;
    }

    public Iirup(Integer idIIRUP, String asAt, int idFundCluster) {
        this.idIIRUP = idIIRUP;
        this.asAt = asAt;
        this.idFundCluster = idFundCluster;
    }

    public Integer getIdIIRUP() {
        return idIIRUP;
    }

    public void setIdIIRUP(Integer idIIRUP) {
        this.idIIRUP = idIIRUP;
    }

    public String getAsAt() {
        return asAt;
    }

    public void setAsAt(String asAt) {
        this.asAt = asAt;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public Date getIvDateAcquired() {
        return ivDateAcquired;
    }

    public void setIvDateAcquired(Date ivDateAcquired) {
        this.ivDateAcquired = ivDateAcquired;
    }

    public String getIvParticularsArticles() {
        return ivParticularsArticles;
    }

    public void setIvParticularsArticles(String ivParticularsArticles) {
        this.ivParticularsArticles = ivParticularsArticles;
    }

    public String getIvPropertyNo() {
        return ivPropertyNo;
    }

    public void setIvPropertyNo(String ivPropertyNo) {
        this.ivPropertyNo = ivPropertyNo;
    }

    public Integer getIvQuantity() {
        return ivQuantity;
    }

    public void setIvQuantity(Integer ivQuantity) {
        this.ivQuantity = ivQuantity;
    }

    public String getIvUnitCost() {
        return ivUnitCost;
    }

    public void setIvUnitCost(String ivUnitCost) {
        this.ivUnitCost = ivUnitCost;
    }

    public String getIvTotalCost() {
        return ivTotalCost;
    }

    public void setIvTotalCost(String ivTotalCost) {
        this.ivTotalCost = ivTotalCost;
    }

    public String getIvAccumuDepreciation() {
        return ivAccumuDepreciation;
    }

    public void setIvAccumuDepreciation(String ivAccumuDepreciation) {
        this.ivAccumuDepreciation = ivAccumuDepreciation;
    }

    public String getIvAccumuImpairmentLoss() {
        return ivAccumuImpairmentLoss;
    }

    public void setIvAccumuImpairmentLoss(String ivAccumuImpairmentLoss) {
        this.ivAccumuImpairmentLoss = ivAccumuImpairmentLoss;
    }

    public Float getIvCarryAmount() {
        return ivCarryAmount;
    }

    public void setIvCarryAmount(Float ivCarryAmount) {
        this.ivCarryAmount = ivCarryAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIadSale() {
        return iadSale;
    }

    public void setIadSale(String iadSale) {
        this.iadSale = iadSale;
    }

    public String getIadTransfer() {
        return iadTransfer;
    }

    public void setIadTransfer(String iadTransfer) {
        this.iadTransfer = iadTransfer;
    }

    public String getIadDestruction() {
        return iadDestruction;
    }

    public void setIadDestruction(String iadDestruction) {
        this.iadDestruction = iadDestruction;
    }

    public String getIadOthers() {
        return iadOthers;
    }

    public void setIadOthers(String iadOthers) {
        this.iadOthers = iadOthers;
    }

    public String getIadTotal() {
        return iadTotal;
    }

    public void setIadTotal(String iadTotal) {
        this.iadTotal = iadTotal;
    }

    public String getIadAppraisedValue() {
        return iadAppraisedValue;
    }

    public void setIadAppraisedValue(String iadAppraisedValue) {
        this.iadAppraisedValue = iadAppraisedValue;
    }

    public String getIadRecordOrNumber() {
        return iadRecordOrNumber;
    }

    public void setIadRecordOrNumber(String iadRecordOrNumber) {
        this.iadRecordOrNumber = iadRecordOrNumber;
    }

    public Float getIadRecordAmount() {
        return iadRecordAmount;
    }

    public void setIadRecordAmount(Float iadRecordAmount) {
        this.iadRecordAmount = iadRecordAmount;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getInspectionOfficer() {
        return inspectionOfficer;
    }

    public void setInspectionOfficer(String inspectionOfficer) {
        this.inspectionOfficer = inspectionOfficer;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public Generalinventory getIdItem() {
        return idItem;
    }

    public void setIdItem(Generalinventory idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIIRUP != null ? idIIRUP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iirup)) {
            return false;
        }
        Iirup other = (Iirup) object;
        if ((this.idIIRUP == null && other.idIIRUP != null) || (this.idIIRUP != null && !this.idIIRUP.equals(other.idIIRUP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Iirup[ idIIRUP=" + idIIRUP + " ]";
    }
    
}
