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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_rfi"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rfi.findAll", query = "SELECT r FROM Rfi r")
    , @NamedQuery(name = "Rfi.findByIdRfi", query = "SELECT r FROM Rfi r WHERE r.idRfi = :idRfi")
    , @NamedQuery(name = "Rfi.findByTypeInspection", query = "SELECT r FROM Rfi r WHERE r.typeInspection = :typeInspection")
    , @NamedQuery(name = "Rfi.findByTypeRepair", query = "SELECT r FROM Rfi r WHERE r.typeRepair = :typeRepair")
    , @NamedQuery(name = "Rfi.findByTypeProperty", query = "SELECT r FROM Rfi r WHERE r.typeProperty = :typeProperty")
    , @NamedQuery(name = "Rfi.findByDescTypeProperty", query = "SELECT r FROM Rfi r WHERE r.descTypeProperty = :descTypeProperty")
    , @NamedQuery(name = "Rfi.findByDescModel", query = "SELECT r FROM Rfi r WHERE r.descModel = :descModel")
    , @NamedQuery(name = "Rfi.findByDescEngineNo", query = "SELECT r FROM Rfi r WHERE r.descEngineNo = :descEngineNo")
    , @NamedQuery(name = "Rfi.findByDescPlateNo", query = "SELECT r FROM Rfi r WHERE r.descPlateNo = :descPlateNo")
    , @NamedQuery(name = "Rfi.findByDescDefectsComplaintsScope", query = "SELECT r FROM Rfi r WHERE r.descDefectsComplaintsScope = :descDefectsComplaintsScope")
    , @NamedQuery(name = "Rfi.findByDescEndUser", query = "SELECT r FROM Rfi r WHERE r.descEndUser = :descEndUser")
    , @NamedQuery(name = "Rfi.findByDescAmout", query = "SELECT r FROM Rfi r WHERE r.descAmout = :descAmout")
    , @NamedQuery(name = "Rfi.findByDescAttachmentsPreRepair", query = "SELECT r FROM Rfi r WHERE r.descAttachmentsPreRepair = :descAttachmentsPreRepair")
    , @NamedQuery(name = "Rfi.findByDescAttachmentsPostRepair", query = "SELECT r FROM Rfi r WHERE r.descAttachmentsPostRepair = :descAttachmentsPostRepair")
    , @NamedQuery(name = "Rfi.findByDeliveriesSupplier", query = "SELECT r FROM Rfi r WHERE r.deliveriesSupplier = :deliveriesSupplier")
    , @NamedQuery(name = "Rfi.findByDeliveriesInvoiceNo", query = "SELECT r FROM Rfi r WHERE r.deliveriesInvoiceNo = :deliveriesInvoiceNo")
    , @NamedQuery(name = "Rfi.findByDeliveriesDrNo", query = "SELECT r FROM Rfi r WHERE r.deliveriesDrNo = :deliveriesDrNo")
    , @NamedQuery(name = "Rfi.findByDeliveriesPrNo", query = "SELECT r FROM Rfi r WHERE r.deliveriesPrNo = :deliveriesPrNo")
    , @NamedQuery(name = "Rfi.findByDeliveriesEndUser", query = "SELECT r FROM Rfi r WHERE r.deliveriesEndUser = :deliveriesEndUser")
    , @NamedQuery(name = "Rfi.findByDeliveriesAmount", query = "SELECT r FROM Rfi r WHERE r.deliveriesAmount = :deliveriesAmount")
    , @NamedQuery(name = "Rfi.findByDeliveriesAttachments", query = "SELECT r FROM Rfi r WHERE r.deliveriesAttachments = :deliveriesAttachments")
    , @NamedQuery(name = "Rfi.findByApprovalName", query = "SELECT r FROM Rfi r WHERE r.approvalName = :approvalName")
    , @NamedQuery(name = "Rfi.findByApprovalDesignation", query = "SELECT r FROM Rfi r WHERE r.approvalDesignation = :approvalDesignation")
    , @NamedQuery(name = "Rfi.findByApprovalDate", query = "SELECT r FROM Rfi r WHERE r.approvalDate = :approvalDate")
    , @NamedQuery(name = "Rfi.findByDeliveries", query = "SELECT r FROM Rfi r WHERE r.deliveries = :deliveries")
    , @NamedQuery(name = "Rfi.findByControlNo", query = "SELECT r FROM Rfi r WHERE r.controlNo = :controlNo")
    , @NamedQuery(name = "Rfi.findByPreRepair", query = "SELECT r FROM Rfi r WHERE r.preRepair = :preRepair")
    , @NamedQuery(name = "Rfi.findByPostRepair", query = "SELECT r FROM Rfi r WHERE r.postRepair = :postRepair")})
public class Rfi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rfi", nullable = false)
    private Integer idRfi;
    @Size(max = 45)
    @Column(name = "type_inspection", length = 45)
    private String typeInspection;
    @Size(max = 45)
    @Column(name = "type_repair", length = 45)
    private String typeRepair;
    @Size(max = 45)
    @Column(name = "type_property", length = 45)
    private String typeProperty;
    @Size(max = 45)
    @Column(name = "desc_type_property", length = 45)
    private String descTypeProperty;
    @Size(max = 45)
    @Column(name = "desc_model", length = 45)
    private String descModel;
    @Column(name = "desc_engine_no")
    private Integer descEngineNo;
    @Size(max = 45)
    @Column(name = "desc_plate_no", length = 45)
    private String descPlateNo;
    @Size(max = 45)
    @Column(name = "desc_defects_complaints_scope", length = 45)
    private String descDefectsComplaintsScope;
    @Size(max = 45)
    @Column(name = "desc_end_user", length = 45)
    private String descEndUser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "desc_amout", precision = 12)
    private Float descAmout;
    @Column(name = "desc_attachments_pre_repair")
    private Short descAttachmentsPreRepair;
    @Column(name = "desc_attachments_post_repair")
    private Short descAttachmentsPostRepair;
    @Size(max = 45)
    @Column(name = "deliveries_supplier", length = 45)
    private String deliveriesSupplier;
    @Column(name = "deliveries_invoice_no")
    private Integer deliveriesInvoiceNo;
    @Column(name = "deliveries_dr_no")
    private Integer deliveriesDrNo;
    @Column(name = "deliveries_pr_no")
    private Integer deliveriesPrNo;
    @Size(max = 45)
    @Column(name = "deliveries_end_user", length = 45)
    private String deliveriesEndUser;
    @Column(name = "deliveries_amount", precision = 12)
    private Float deliveriesAmount;
    @Column(name = "deliveries_attachments")
    private Short deliveriesAttachments;
    @Size(max = 45)
    @Column(name = "approval_name", length = 45)
    private String approvalName;
    @Size(max = 45)
    @Column(name = "approval_designation", length = 45)
    private String approvalDesignation;
    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @Size(max = 45)
    @Column(length = 45)
    private String deliveries;
    @Column(name = "control_no")
    private Integer controlNo;
    @Size(max = 45)
    @Column(name = "pre_repair", length = 45)
    private String preRepair;
    @Size(max = 45)
    @Column(name = "post_repair", length = 45)
    private String postRepair;
    @OneToMany(mappedBy = "idRfi")
    private List<FormRepo> formRepoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRfi")
    private List<RfiDeliveries> rfiDeliveriesList;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @JoinColumn(name = "id_rfi", referencedColumnName = "idrfi_details", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private RfiFk rfiFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRfi")
    private List<RfiRepairPost> rfiRepairPostList;

    public Rfi() {
    }

    public Rfi(Integer idRfi) {
        this.idRfi = idRfi;
    }

    public Integer getIdRfi() {
        return idRfi;
    }

    public void setIdRfi(Integer idRfi) {
        this.idRfi = idRfi;
    }

    public String getTypeInspection() {
        return typeInspection;
    }

    public void setTypeInspection(String typeInspection) {
        this.typeInspection = typeInspection;
    }

    public String getTypeRepair() {
        return typeRepair;
    }

    public void setTypeRepair(String typeRepair) {
        this.typeRepair = typeRepair;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public String getDescTypeProperty() {
        return descTypeProperty;
    }

    public void setDescTypeProperty(String descTypeProperty) {
        this.descTypeProperty = descTypeProperty;
    }

    public String getDescModel() {
        return descModel;
    }

    public void setDescModel(String descModel) {
        this.descModel = descModel;
    }

    public Integer getDescEngineNo() {
        return descEngineNo;
    }

    public void setDescEngineNo(Integer descEngineNo) {
        this.descEngineNo = descEngineNo;
    }

    public String getDescPlateNo() {
        return descPlateNo;
    }

    public void setDescPlateNo(String descPlateNo) {
        this.descPlateNo = descPlateNo;
    }

    public String getDescDefectsComplaintsScope() {
        return descDefectsComplaintsScope;
    }

    public void setDescDefectsComplaintsScope(String descDefectsComplaintsScope) {
        this.descDefectsComplaintsScope = descDefectsComplaintsScope;
    }

    public String getDescEndUser() {
        return descEndUser;
    }

    public void setDescEndUser(String descEndUser) {
        this.descEndUser = descEndUser;
    }

    public Float getDescAmout() {
        return descAmout;
    }

    public void setDescAmout(Float descAmout) {
        this.descAmout = descAmout;
    }

    public Short getDescAttachmentsPreRepair() {
        return descAttachmentsPreRepair;
    }

    public void setDescAttachmentsPreRepair(Short descAttachmentsPreRepair) {
        this.descAttachmentsPreRepair = descAttachmentsPreRepair;
    }

    public Short getDescAttachmentsPostRepair() {
        return descAttachmentsPostRepair;
    }

    public void setDescAttachmentsPostRepair(Short descAttachmentsPostRepair) {
        this.descAttachmentsPostRepair = descAttachmentsPostRepair;
    }

    public String getDeliveriesSupplier() {
        return deliveriesSupplier;
    }

    public void setDeliveriesSupplier(String deliveriesSupplier) {
        this.deliveriesSupplier = deliveriesSupplier;
    }

    public Integer getDeliveriesInvoiceNo() {
        return deliveriesInvoiceNo;
    }

    public void setDeliveriesInvoiceNo(Integer deliveriesInvoiceNo) {
        this.deliveriesInvoiceNo = deliveriesInvoiceNo;
    }

    public Integer getDeliveriesDrNo() {
        return deliveriesDrNo;
    }

    public void setDeliveriesDrNo(Integer deliveriesDrNo) {
        this.deliveriesDrNo = deliveriesDrNo;
    }

    public Integer getDeliveriesPrNo() {
        return deliveriesPrNo;
    }

    public void setDeliveriesPrNo(Integer deliveriesPrNo) {
        this.deliveriesPrNo = deliveriesPrNo;
    }

    public String getDeliveriesEndUser() {
        return deliveriesEndUser;
    }

    public void setDeliveriesEndUser(String deliveriesEndUser) {
        this.deliveriesEndUser = deliveriesEndUser;
    }

    public Float getDeliveriesAmount() {
        return deliveriesAmount;
    }

    public void setDeliveriesAmount(Float deliveriesAmount) {
        this.deliveriesAmount = deliveriesAmount;
    }

    public Short getDeliveriesAttachments() {
        return deliveriesAttachments;
    }

    public void setDeliveriesAttachments(Short deliveriesAttachments) {
        this.deliveriesAttachments = deliveriesAttachments;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalDesignation() {
        return approvalDesignation;
    }

    public void setApprovalDesignation(String approvalDesignation) {
        this.approvalDesignation = approvalDesignation;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(String deliveries) {
        this.deliveries = deliveries;
    }

    public Integer getControlNo() {
        return controlNo;
    }

    public void setControlNo(Integer controlNo) {
        this.controlNo = controlNo;
    }

    public String getPreRepair() {
        return preRepair;
    }

    public void setPreRepair(String preRepair) {
        this.preRepair = preRepair;
    }

    public String getPostRepair() {
        return postRepair;
    }

    public void setPostRepair(String postRepair) {
        this.postRepair = postRepair;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    @XmlTransient
    public List<RfiDeliveries> getRfiDeliveriesList() {
        return rfiDeliveriesList;
    }

    public void setRfiDeliveriesList(List<RfiDeliveries> rfiDeliveriesList) {
        this.rfiDeliveriesList = rfiDeliveriesList;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    public RfiFk getRfiFk() {
        return rfiFk;
    }

    public void setRfiFk(RfiFk rfiFk) {
        this.rfiFk = rfiFk;
    }

    @XmlTransient
    public List<RfiRepairPost> getRfiRepairPostList() {
        return rfiRepairPostList;
    }

    public void setRfiRepairPostList(List<RfiRepairPost> rfiRepairPostList) {
        this.rfiRepairPostList = rfiRepairPostList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRfi != null ? idRfi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rfi)) {
            return false;
        }
        Rfi other = (Rfi) object;
        if ((this.idRfi == null && other.idRfi != null) || (this.idRfi != null && !this.idRfi.equals(other.idRfi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rfi[ idRfi=" + idRfi + " ]";
    }
    
}
