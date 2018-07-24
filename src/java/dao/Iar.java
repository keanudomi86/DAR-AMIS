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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(catalog = "daramis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iar.findAll", query = "SELECT i FROM Iar i")
    , @NamedQuery(name = "Iar.findByIdIar", query = "SELECT i FROM Iar i WHERE i.idIar = :idIar")
    , @NamedQuery(name = "Iar.findByEntityName", query = "SELECT i FROM Iar i WHERE i.entityName = :entityName")
    , @NamedQuery(name = "Iar.findByRisNo", query = "SELECT i FROM Iar i WHERE i.risNo = :risNo")
    , @NamedQuery(name = "Iar.findByFundCluster", query = "SELECT i FROM Iar i WHERE i.fundCluster = :fundCluster")
    , @NamedQuery(name = "Iar.findByRisDate", query = "SELECT i FROM Iar i WHERE i.risDate = :risDate")
    , @NamedQuery(name = "Iar.findBySupplier", query = "SELECT i FROM Iar i WHERE i.supplier = :supplier")
    , @NamedQuery(name = "Iar.findByInvoiceNo", query = "SELECT i FROM Iar i WHERE i.invoiceNo = :invoiceNo")
    , @NamedQuery(name = "Iar.findByPoNo", query = "SELECT i FROM Iar i WHERE i.poNo = :poNo")
    , @NamedQuery(name = "Iar.findByInvoiceDate", query = "SELECT i FROM Iar i WHERE i.invoiceDate = :invoiceDate")
    , @NamedQuery(name = "Iar.findByRequisitioningDept", query = "SELECT i FROM Iar i WHERE i.requisitioningDept = :requisitioningDept")
    , @NamedQuery(name = "Iar.findByResponsibilityCode", query = "SELECT i FROM Iar i WHERE i.responsibilityCode = :responsibilityCode")
    , @NamedQuery(name = "Iar.findByDateInspected", query = "SELECT i FROM Iar i WHERE i.dateInspected = :dateInspected")
    , @NamedQuery(name = "Iar.findByVerified", query = "SELECT i FROM Iar i WHERE i.verified = :verified")
    , @NamedQuery(name = "Iar.findByInspectionCommittee", query = "SELECT i FROM Iar i WHERE i.inspectionCommittee = :inspectionCommittee")
    , @NamedQuery(name = "Iar.findByDateReceived", query = "SELECT i FROM Iar i WHERE i.dateReceived = :dateReceived")
    , @NamedQuery(name = "Iar.findByComplete", query = "SELECT i FROM Iar i WHERE i.complete = :complete")
    , @NamedQuery(name = "Iar.findByPartial", query = "SELECT i FROM Iar i WHERE i.partial = :partial")
    , @NamedQuery(name = "Iar.findBySpecificQuantity", query = "SELECT i FROM Iar i WHERE i.specificQuantity = :specificQuantity")
    , @NamedQuery(name = "Iar.findBySupplyOfficer", query = "SELECT i FROM Iar i WHERE i.supplyOfficer = :supplyOfficer")})
public class Iar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_iar", nullable = false)
    private Integer idIar;
    @Size(max = 45)
    @Column(name = "entity_name", length = 45)
    private String entityName;
    @Column(name = "ris_no")
    private Integer risNo;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Column(name = "ris_date")
    @Temporal(TemporalType.DATE)
    private Date risDate;
    @Size(max = 45)
    @Column(length = 45)
    private String supplier;
    @Column(name = "invoice_no")
    private Integer invoiceNo;
    @Column(name = "po_no")
    private Integer poNo;
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @Size(max = 45)
    @Column(name = "requisitioning_dept", length = 45)
    private String requisitioningDept;
    @Size(max = 45)
    @Column(name = "responsibility_code", length = 45)
    private String responsibilityCode;
    @Column(name = "date_inspected")
    @Temporal(TemporalType.DATE)
    private Date dateInspected;
    private Short verified;
    @Size(max = 45)
    @Column(name = "inspection_committee", length = 45)
    private String inspectionCommittee;
    @Column(name = "date_received")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    private Short complete;
    private Short partial;
    @Column(name = "specific_quantity")
    private Integer specificQuantity;
    @Size(max = 45)
    @Column(name = "supply_officer", length = 45)
    private String supplyOfficer;

    public Iar() {
    }

    public Iar(Integer idIar) {
        this.idIar = idIar;
    }

    public Integer getIdIar() {
        return idIar;
    }

    public void setIdIar(Integer idIar) {
        this.idIar = idIar;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getRisNo() {
        return risNo;
    }

    public void setRisNo(Integer risNo) {
        this.risNo = risNo;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
    }

    public Date getRisDate() {
        return risDate;
    }

    public void setRisDate(Date risDate) {
        this.risDate = risDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Integer getPoNo() {
        return poNo;
    }

    public void setPoNo(Integer poNo) {
        this.poNo = poNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getRequisitioningDept() {
        return requisitioningDept;
    }

    public void setRequisitioningDept(String requisitioningDept) {
        this.requisitioningDept = requisitioningDept;
    }

    public String getResponsibilityCode() {
        return responsibilityCode;
    }

    public void setResponsibilityCode(String responsibilityCode) {
        this.responsibilityCode = responsibilityCode;
    }

    public Date getDateInspected() {
        return dateInspected;
    }

    public void setDateInspected(Date dateInspected) {
        this.dateInspected = dateInspected;
    }

    public Short getVerified() {
        return verified;
    }

    public void setVerified(Short verified) {
        this.verified = verified;
    }

    public String getInspectionCommittee() {
        return inspectionCommittee;
    }

    public void setInspectionCommittee(String inspectionCommittee) {
        this.inspectionCommittee = inspectionCommittee;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Short getComplete() {
        return complete;
    }

    public void setComplete(Short complete) {
        this.complete = complete;
    }

    public Short getPartial() {
        return partial;
    }

    public void setPartial(Short partial) {
        this.partial = partial;
    }

    public Integer getSpecificQuantity() {
        return specificQuantity;
    }

    public void setSpecificQuantity(Integer specificQuantity) {
        this.specificQuantity = specificQuantity;
    }

    public String getSupplyOfficer() {
        return supplyOfficer;
    }

    public void setSupplyOfficer(String supplyOfficer) {
        this.supplyOfficer = supplyOfficer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIar != null ? idIar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iar)) {
            return false;
        }
        Iar other = (Iar) object;
        if ((this.idIar == null && other.idIar != null) || (this.idIar != null && !this.idIar.equals(other.idIar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Iar[ idIar=" + idIar + " ]";
    }
    
}
