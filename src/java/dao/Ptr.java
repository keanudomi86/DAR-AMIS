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
    @NamedQuery(name = "Ptr.findAll", query = "SELECT p FROM Ptr p")
    , @NamedQuery(name = "Ptr.findByIdPTR", query = "SELECT p FROM Ptr p WHERE p.idPTR = :idPTR")
    , @NamedQuery(name = "Ptr.findByIdFundCluster", query = "SELECT p FROM Ptr p WHERE p.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Ptr.findByFromCluster", query = "SELECT p FROM Ptr p WHERE p.fromCluster = :fromCluster")
    , @NamedQuery(name = "Ptr.findByToCluster", query = "SELECT p FROM Ptr p WHERE p.toCluster = :toCluster")
    , @NamedQuery(name = "Ptr.findByPtrNum", query = "SELECT p FROM Ptr p WHERE p.ptrNum = :ptrNum")
    , @NamedQuery(name = "Ptr.findByDate", query = "SELECT p FROM Ptr p WHERE p.date = :date")
    , @NamedQuery(name = "Ptr.findByTransferType", query = "SELECT p FROM Ptr p WHERE p.transferType = :transferType")
    , @NamedQuery(name = "Ptr.findByDateAcquired", query = "SELECT p FROM Ptr p WHERE p.dateAcquired = :dateAcquired")
    , @NamedQuery(name = "Ptr.findByPropertyNum", query = "SELECT p FROM Ptr p WHERE p.propertyNum = :propertyNum")
    , @NamedQuery(name = "Ptr.findByDescription", query = "SELECT p FROM Ptr p WHERE p.description = :description")
    , @NamedQuery(name = "Ptr.findByAmount", query = "SELECT p FROM Ptr p WHERE p.amount = :amount")
    , @NamedQuery(name = "Ptr.findByConditionPpe", query = "SELECT p FROM Ptr p WHERE p.conditionPpe = :conditionPpe")
    , @NamedQuery(name = "Ptr.findByReasonTransfer", query = "SELECT p FROM Ptr p WHERE p.reasonTransfer = :reasonTransfer")
    , @NamedQuery(name = "Ptr.findByApprovedBy", query = "SELECT p FROM Ptr p WHERE p.approvedBy = :approvedBy")
    , @NamedQuery(name = "Ptr.findByReleasedIssuedBy", query = "SELECT p FROM Ptr p WHERE p.releasedIssuedBy = :releasedIssuedBy")
    , @NamedQuery(name = "Ptr.findByReceivedBy", query = "SELECT p FROM Ptr p WHERE p.receivedBy = :receivedBy")
    , @NamedQuery(name = "Ptr.findByUpAsset", query = "SELECT p FROM Ptr p WHERE p.upAsset = :upAsset")})
public class Ptr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_PTR")
    private Integer idPTR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Size(max = 45)
    @Column(name = "from_cluster")
    private String fromCluster;
    @Size(max = 45)
    @Column(name = "to_cluster")
    private String toCluster;
    @Size(max = 45)
    @Column(name = "ptr_num")
    private String ptrNum;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "transfer_type")
    private Integer transferType;
    @Column(name = "date_acquired")
    @Temporal(TemporalType.DATE)
    private Date dateAcquired;
    @Column(name = "property_num")
    private Integer propertyNum;
    @Size(max = 100)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float amount;
    @Size(max = 100)
    @Column(name = "condition_ppe")
    private String conditionPpe;
    @Size(max = 100)
    @Column(name = "reason_transfer")
    private String reasonTransfer;
    @Size(max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @Size(max = 45)
    @Column(name = "released_issued_by")
    private String releasedIssuedBy;
    @Size(max = 45)
    @Column(name = "received_by")
    private String receivedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset4")
    private List<Generalinventory> generalinventoryList;

    public Ptr() {
    }

    public Ptr(Integer idPTR) {
        this.idPTR = idPTR;
    }

    public Ptr(Integer idPTR, int idFundCluster, int upAsset) {
        this.idPTR = idPTR;
        this.idFundCluster = idFundCluster;
        this.upAsset = upAsset;
    }

    public Integer getIdPTR() {
        return idPTR;
    }

    public void setIdPTR(Integer idPTR) {
        this.idPTR = idPTR;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public String getFromCluster() {
        return fromCluster;
    }

    public void setFromCluster(String fromCluster) {
        this.fromCluster = fromCluster;
    }

    public String getToCluster() {
        return toCluster;
    }

    public void setToCluster(String toCluster) {
        this.toCluster = toCluster;
    }

    public String getPtrNum() {
        return ptrNum;
    }

    public void setPtrNum(String ptrNum) {
        this.ptrNum = ptrNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public Integer getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(Integer propertyNum) {
        this.propertyNum = propertyNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getConditionPpe() {
        return conditionPpe;
    }

    public void setConditionPpe(String conditionPpe) {
        this.conditionPpe = conditionPpe;
    }

    public String getReasonTransfer() {
        return reasonTransfer;
    }

    public void setReasonTransfer(String reasonTransfer) {
        this.reasonTransfer = reasonTransfer;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getReleasedIssuedBy() {
        return releasedIssuedBy;
    }

    public void setReleasedIssuedBy(String releasedIssuedBy) {
        this.releasedIssuedBy = releasedIssuedBy;
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
        hash += (idPTR != null ? idPTR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ptr)) {
            return false;
        }
        Ptr other = (Ptr) object;
        if ((this.idPTR == null && other.idPTR != null) || (this.idPTR != null && !this.idPTR.equals(other.idPTR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ptr[ idPTR=" + idPTR + " ]";
    }
    
}
