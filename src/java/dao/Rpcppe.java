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
    @UniqueConstraint(columnNames = {"id_rpcppe"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rpcppe.findAll", query = "SELECT r FROM Rpcppe r")
    , @NamedQuery(name = "Rpcppe.findByIdRpcppe", query = "SELECT r FROM Rpcppe r WHERE r.idRpcppe = :idRpcppe")
    , @NamedQuery(name = "Rpcppe.findByInventoryType", query = "SELECT r FROM Rpcppe r WHERE r.inventoryType = :inventoryType")
    , @NamedQuery(name = "Rpcppe.findByDate", query = "SELECT r FROM Rpcppe r WHERE r.date = :date")
    , @NamedQuery(name = "Rpcppe.findByFundCluster", query = "SELECT r FROM Rpcppe r WHERE r.fundCluster = :fundCluster")
    , @NamedQuery(name = "Rpcppe.findByAccountableOfficer", query = "SELECT r FROM Rpcppe r WHERE r.accountableOfficer = :accountableOfficer")
    , @NamedQuery(name = "Rpcppe.findByOfficerDesignation", query = "SELECT r FROM Rpcppe r WHERE r.officerDesignation = :officerDesignation")
    , @NamedQuery(name = "Rpcppe.findByEntity", query = "SELECT r FROM Rpcppe r WHERE r.entity = :entity")
    , @NamedQuery(name = "Rpcppe.findByAccountabilityDate", query = "SELECT r FROM Rpcppe r WHERE r.accountabilityDate = :accountabilityDate")
    , @NamedQuery(name = "Rpcppe.findByArticle", query = "SELECT r FROM Rpcppe r WHERE r.article = :article")
    , @NamedQuery(name = "Rpcppe.findByDescription", query = "SELECT r FROM Rpcppe r WHERE r.description = :description")
    , @NamedQuery(name = "Rpcppe.findByPoNum", query = "SELECT r FROM Rpcppe r WHERE r.poNum = :poNum")
    , @NamedQuery(name = "Rpcppe.findByUnitMeasure", query = "SELECT r FROM Rpcppe r WHERE r.unitMeasure = :unitMeasure")
    , @NamedQuery(name = "Rpcppe.findByUnitValue", query = "SELECT r FROM Rpcppe r WHERE r.unitValue = :unitValue")
    , @NamedQuery(name = "Rpcppe.findByPcQuantity", query = "SELECT r FROM Rpcppe r WHERE r.pcQuantity = :pcQuantity")
    , @NamedQuery(name = "Rpcppe.findByPhcQuantity", query = "SELECT r FROM Rpcppe r WHERE r.phcQuantity = :phcQuantity")
    , @NamedQuery(name = "Rpcppe.findByShortageOverage", query = "SELECT r FROM Rpcppe r WHERE r.shortageOverage = :shortageOverage")
    , @NamedQuery(name = "Rpcppe.findByValue", query = "SELECT r FROM Rpcppe r WHERE r.value = :value")
    , @NamedQuery(name = "Rpcppe.findByRemarks", query = "SELECT r FROM Rpcppe r WHERE r.remarks = :remarks")
    , @NamedQuery(name = "Rpcppe.findByNameChecker", query = "SELECT r FROM Rpcppe r WHERE r.nameChecker = :nameChecker")
    , @NamedQuery(name = "Rpcppe.findByDesignationChecker", query = "SELECT r FROM Rpcppe r WHERE r.designationChecker = :designationChecker")
    , @NamedQuery(name = "Rpcppe.findByNameApp", query = "SELECT r FROM Rpcppe r WHERE r.nameApp = :nameApp")
    , @NamedQuery(name = "Rpcppe.findByDesignationApp", query = "SELECT r FROM Rpcppe r WHERE r.designationApp = :designationApp")
    , @NamedQuery(name = "Rpcppe.findByNameVer", query = "SELECT r FROM Rpcppe r WHERE r.nameVer = :nameVer")
    , @NamedQuery(name = "Rpcppe.findByDesignationVer", query = "SELECT r FROM Rpcppe r WHERE r.designationVer = :designationVer")})
public class Rpcppe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rpcppe", nullable = false)
    private Integer idRpcppe;
    @Size(max = 45)
    @Column(name = "inventory_type", length = 45)
    private String inventoryType;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Size(max = 45)
    @Column(name = "accountable_officer", length = 45)
    private String accountableOfficer;
    @Size(max = 45)
    @Column(name = "officer_designation", length = 45)
    private String officerDesignation;
    @Size(max = 45)
    @Column(length = 45)
    private String entity;
    @Column(name = "accountability_date")
    @Temporal(TemporalType.DATE)
    private Date accountabilityDate;
    @Size(max = 45)
    @Column(length = 45)
    private String article;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Column(name = "po_num")
    private Integer poNum;
    @Size(max = 45)
    @Column(name = "unit_measure", length = 45)
    private String unitMeasure;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unit_value", precision = 12)
    private Float unitValue;
    @Column(name = "pc_quantity")
    private Integer pcQuantity;
    @Column(name = "phc_quantity")
    private Integer phcQuantity;
    @Size(max = 45)
    @Column(name = "shortage_overage", length = 45)
    private String shortageOverage;
    @Column(precision = 12)
    private Float value;
    @Size(max = 45)
    @Column(length = 45)
    private String remarks;
    @Size(max = 45)
    @Column(name = "name_checker", length = 45)
    private String nameChecker;
    @Size(max = 45)
    @Column(name = "designation_checker", length = 45)
    private String designationChecker;
    @Size(max = 45)
    @Column(name = "name_app", length = 45)
    private String nameApp;
    @Size(max = 45)
    @Column(name = "designation_app", length = 45)
    private String designationApp;
    @Size(max = 45)
    @Column(name = "name_ver", length = 45)
    private String nameVer;
    @Size(max = 45)
    @Column(name = "designation_ver", length = 45)
    private String designationVer;
    @JoinColumn(name = "id_pc", referencedColumnName = "id_pc", nullable = false)
    @ManyToOne(optional = false)
    private Pc idPc;
    @OneToMany(mappedBy = "idRpcppe")
    private List<FormRepo> formRepoList;

    public Rpcppe() {
    }

    public Rpcppe(Integer idRpcppe) {
        this.idRpcppe = idRpcppe;
    }

    public Integer getIdRpcppe() {
        return idRpcppe;
    }

    public void setIdRpcppe(Integer idRpcppe) {
        this.idRpcppe = idRpcppe;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
    }

    public String getAccountableOfficer() {
        return accountableOfficer;
    }

    public void setAccountableOfficer(String accountableOfficer) {
        this.accountableOfficer = accountableOfficer;
    }

    public String getOfficerDesignation() {
        return officerDesignation;
    }

    public void setOfficerDesignation(String officerDesignation) {
        this.officerDesignation = officerDesignation;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Date getAccountabilityDate() {
        return accountabilityDate;
    }

    public void setAccountabilityDate(Date accountabilityDate) {
        this.accountabilityDate = accountabilityDate;
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

    public Integer getPoNum() {
        return poNum;
    }

    public void setPoNum(Integer poNum) {
        this.poNum = poNum;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public Float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Float unitValue) {
        this.unitValue = unitValue;
    }

    public Integer getPcQuantity() {
        return pcQuantity;
    }

    public void setPcQuantity(Integer pcQuantity) {
        this.pcQuantity = pcQuantity;
    }

    public Integer getPhcQuantity() {
        return phcQuantity;
    }

    public void setPhcQuantity(Integer phcQuantity) {
        this.phcQuantity = phcQuantity;
    }

    public String getShortageOverage() {
        return shortageOverage;
    }

    public void setShortageOverage(String shortageOverage) {
        this.shortageOverage = shortageOverage;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNameChecker() {
        return nameChecker;
    }

    public void setNameChecker(String nameChecker) {
        this.nameChecker = nameChecker;
    }

    public String getDesignationChecker() {
        return designationChecker;
    }

    public void setDesignationChecker(String designationChecker) {
        this.designationChecker = designationChecker;
    }

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    public String getDesignationApp() {
        return designationApp;
    }

    public void setDesignationApp(String designationApp) {
        this.designationApp = designationApp;
    }

    public String getNameVer() {
        return nameVer;
    }

    public void setNameVer(String nameVer) {
        this.nameVer = nameVer;
    }

    public String getDesignationVer() {
        return designationVer;
    }

    public void setDesignationVer(String designationVer) {
        this.designationVer = designationVer;
    }

    public Pc getIdPc() {
        return idPc;
    }

    public void setIdPc(Pc idPc) {
        this.idPc = idPc;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRpcppe != null ? idRpcppe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rpcppe)) {
            return false;
        }
        Rpcppe other = (Rpcppe) object;
        if ((this.idRpcppe == null && other.idRpcppe != null) || (this.idRpcppe != null && !this.idRpcppe.equals(other.idRpcppe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rpcppe[ idRpcppe=" + idRpcppe + " ]";
    }
    
}
