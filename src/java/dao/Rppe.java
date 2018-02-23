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
    @NamedQuery(name = "Rppe.findAll", query = "SELECT r FROM Rppe r")
    , @NamedQuery(name = "Rppe.findByIdRPPE", query = "SELECT r FROM Rppe r WHERE r.idRPPE = :idRPPE")
    , @NamedQuery(name = "Rppe.findByTypeofPropPlntEquip", query = "SELECT r FROM Rppe r WHERE r.typeofPropPlntEquip = :typeofPropPlntEquip")
    , @NamedQuery(name = "Rppe.findByAsAt", query = "SELECT r FROM Rppe r WHERE r.asAt = :asAt")
    , @NamedQuery(name = "Rppe.findByIdFundCluster", query = "SELECT r FROM Rppe r WHERE r.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Rppe.findByAccountableOfficer", query = "SELECT r FROM Rppe r WHERE r.accountableOfficer = :accountableOfficer")
    , @NamedQuery(name = "Rppe.findByOfficialDesignation", query = "SELECT r FROM Rppe r WHERE r.officialDesignation = :officialDesignation")
    , @NamedQuery(name = "Rppe.findByDateofAssumption", query = "SELECT r FROM Rppe r WHERE r.dateofAssumption = :dateofAssumption")
    , @NamedQuery(name = "Rppe.findByArticle", query = "SELECT r FROM Rppe r WHERE r.article = :article")
    , @NamedQuery(name = "Rppe.findByDescription", query = "SELECT r FROM Rppe r WHERE r.description = :description")
    , @NamedQuery(name = "Rppe.findByPropertyNum", query = "SELECT r FROM Rppe r WHERE r.propertyNum = :propertyNum")
    , @NamedQuery(name = "Rppe.findByUnitofMeasure", query = "SELECT r FROM Rppe r WHERE r.unitofMeasure = :unitofMeasure")
    , @NamedQuery(name = "Rppe.findByUnitValue", query = "SELECT r FROM Rppe r WHERE r.unitValue = :unitValue")
    , @NamedQuery(name = "Rppe.findByQuantityPerProperty", query = "SELECT r FROM Rppe r WHERE r.quantityPerProperty = :quantityPerProperty")
    , @NamedQuery(name = "Rppe.findByQuantityPerPhysicalCount", query = "SELECT r FROM Rppe r WHERE r.quantityPerPhysicalCount = :quantityPerPhysicalCount")
    , @NamedQuery(name = "Rppe.findByShoOvrQuantity", query = "SELECT r FROM Rppe r WHERE r.shoOvrQuantity = :shoOvrQuantity")
    , @NamedQuery(name = "Rppe.findByShoOvrValue", query = "SELECT r FROM Rppe r WHERE r.shoOvrValue = :shoOvrValue")
    , @NamedQuery(name = "Rppe.findByRemarks", query = "SELECT r FROM Rppe r WHERE r.remarks = :remarks")
    , @NamedQuery(name = "Rppe.findByCertifiedBy", query = "SELECT r FROM Rppe r WHERE r.certifiedBy = :certifiedBy")
    , @NamedQuery(name = "Rppe.findByApprovedBy", query = "SELECT r FROM Rppe r WHERE r.approvedBy = :approvedBy")})
public class Rppe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_RPPE")
    private Integer idRPPE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "typeof_prop_plnt_equip")
    private String typeofPropPlntEquip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "as_at")
    private String asAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Size(max = 45)
    @Column(name = "accountable_officer")
    private String accountableOfficer;
    @Size(max = 45)
    @Column(name = "official_designation")
    private String officialDesignation;
    @Column(name = "dateof_assumption")
    @Temporal(TemporalType.DATE)
    private Date dateofAssumption;
    @Size(max = 45)
    private String article;
    @Size(max = 45)
    private String description;
    @Column(name = "property_num")
    private Integer propertyNum;
    @Column(name = "unitof_measure")
    private Integer unitofMeasure;
    @Column(name = "unit_value")
    private Integer unitValue;
    @Column(name = "quantity_per_property")
    private Integer quantityPerProperty;
    @Size(max = 45)
    @Column(name = "quantity_per_physical_count")
    private String quantityPerPhysicalCount;
    @Column(name = "sho_ovr_quantity")
    private Integer shoOvrQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sho_ovr_value")
    private Double shoOvrValue;
    @Size(max = 100)
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "certified_by")
    private String certifiedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @JoinColumn(name = "id_item", referencedColumnName = "id_GeneralInventory")
    @ManyToOne(optional = false)
    private Generalinventory idItem;

    public Rppe() {
    }

    public Rppe(Integer idRPPE) {
        this.idRPPE = idRPPE;
    }

    public Rppe(Integer idRPPE, String typeofPropPlntEquip, String asAt, int idFundCluster, String certifiedBy, String approvedBy) {
        this.idRPPE = idRPPE;
        this.typeofPropPlntEquip = typeofPropPlntEquip;
        this.asAt = asAt;
        this.idFundCluster = idFundCluster;
        this.certifiedBy = certifiedBy;
        this.approvedBy = approvedBy;
    }

    public Integer getIdRPPE() {
        return idRPPE;
    }

    public void setIdRPPE(Integer idRPPE) {
        this.idRPPE = idRPPE;
    }

    public String getTypeofPropPlntEquip() {
        return typeofPropPlntEquip;
    }

    public void setTypeofPropPlntEquip(String typeofPropPlntEquip) {
        this.typeofPropPlntEquip = typeofPropPlntEquip;
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

    public String getAccountableOfficer() {
        return accountableOfficer;
    }

    public void setAccountableOfficer(String accountableOfficer) {
        this.accountableOfficer = accountableOfficer;
    }

    public String getOfficialDesignation() {
        return officialDesignation;
    }

    public void setOfficialDesignation(String officialDesignation) {
        this.officialDesignation = officialDesignation;
    }

    public Date getDateofAssumption() {
        return dateofAssumption;
    }

    public void setDateofAssumption(Date dateofAssumption) {
        this.dateofAssumption = dateofAssumption;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(Integer propertyNum) {
        this.propertyNum = propertyNum;
    }

    public Integer getUnitofMeasure() {
        return unitofMeasure;
    }

    public void setUnitofMeasure(Integer unitofMeasure) {
        this.unitofMeasure = unitofMeasure;
    }

    public Integer getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Integer unitValue) {
        this.unitValue = unitValue;
    }

    public Integer getQuantityPerProperty() {
        return quantityPerProperty;
    }

    public void setQuantityPerProperty(Integer quantityPerProperty) {
        this.quantityPerProperty = quantityPerProperty;
    }

    public String getQuantityPerPhysicalCount() {
        return quantityPerPhysicalCount;
    }

    public void setQuantityPerPhysicalCount(String quantityPerPhysicalCount) {
        this.quantityPerPhysicalCount = quantityPerPhysicalCount;
    }

    public Integer getShoOvrQuantity() {
        return shoOvrQuantity;
    }

    public void setShoOvrQuantity(Integer shoOvrQuantity) {
        this.shoOvrQuantity = shoOvrQuantity;
    }

    public Double getShoOvrValue() {
        return shoOvrValue;
    }

    public void setShoOvrValue(Double shoOvrValue) {
        this.shoOvrValue = shoOvrValue;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCertifiedBy() {
        return certifiedBy;
    }

    public void setCertifiedBy(String certifiedBy) {
        this.certifiedBy = certifiedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
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
        hash += (idRPPE != null ? idRPPE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rppe)) {
            return false;
        }
        Rppe other = (Rppe) object;
        if ((this.idRPPE == null && other.idRPPE != null) || (this.idRPPE != null && !this.idRPPE.equals(other.idRPPE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rppe[ idRPPE=" + idRPPE + " ]";
    }
    
}
