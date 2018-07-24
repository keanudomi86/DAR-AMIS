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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_rpci"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rpci.findAll", query = "SELECT r FROM Rpci r")
    , @NamedQuery(name = "Rpci.findByIdRpci", query = "SELECT r FROM Rpci r WHERE r.idRpci = :idRpci")
    , @NamedQuery(name = "Rpci.findByInventoryType", query = "SELECT r FROM Rpci r WHERE r.inventoryType = :inventoryType")
    , @NamedQuery(name = "Rpci.findByFundCluster", query = "SELECT r FROM Rpci r WHERE r.fundCluster = :fundCluster")
    , @NamedQuery(name = "Rpci.findByAccountableOfficer", query = "SELECT r FROM Rpci r WHERE r.accountableOfficer = :accountableOfficer")
    , @NamedQuery(name = "Rpci.findByOfficialDesignation", query = "SELECT r FROM Rpci r WHERE r.officialDesignation = :officialDesignation")
    , @NamedQuery(name = "Rpci.findByEntity", query = "SELECT r FROM Rpci r WHERE r.entity = :entity")
    , @NamedQuery(name = "Rpci.findByAccountabilityDate", query = "SELECT r FROM Rpci r WHERE r.accountabilityDate = :accountabilityDate")
    , @NamedQuery(name = "Rpci.findByArticle", query = "SELECT r FROM Rpci r WHERE r.article = :article")
    , @NamedQuery(name = "Rpci.findByDescription", query = "SELECT r FROM Rpci r WHERE r.description = :description")
    , @NamedQuery(name = "Rpci.findByStockNo", query = "SELECT r FROM Rpci r WHERE r.stockNo = :stockNo")
    , @NamedQuery(name = "Rpci.findByUnitMeasure", query = "SELECT r FROM Rpci r WHERE r.unitMeasure = :unitMeasure")
    , @NamedQuery(name = "Rpci.findByBpcQuantity", query = "SELECT r FROM Rpci r WHERE r.bpcQuantity = :bpcQuantity")
    , @NamedQuery(name = "Rpci.findByOhpcQuantity", query = "SELECT r FROM Rpci r WHERE r.ohpcQuantity = :ohpcQuantity")
    , @NamedQuery(name = "Rpci.findByShortageOverageQuantity", query = "SELECT r FROM Rpci r WHERE r.shortageOverageQuantity = :shortageOverageQuantity")
    , @NamedQuery(name = "Rpci.findByValue", query = "SELECT r FROM Rpci r WHERE r.value = :value")
    , @NamedQuery(name = "Rpci.findByRemarks", query = "SELECT r FROM Rpci r WHERE r.remarks = :remarks")
    , @NamedQuery(name = "Rpci.findByChecker", query = "SELECT r FROM Rpci r WHERE r.checker = :checker")
    , @NamedQuery(name = "Rpci.findByCheckerDesignation", query = "SELECT r FROM Rpci r WHERE r.checkerDesignation = :checkerDesignation")
    , @NamedQuery(name = "Rpci.findByNameApp", query = "SELECT r FROM Rpci r WHERE r.nameApp = :nameApp")
    , @NamedQuery(name = "Rpci.findByDesignationApp", query = "SELECT r FROM Rpci r WHERE r.designationApp = :designationApp")
    , @NamedQuery(name = "Rpci.findByNameVer", query = "SELECT r FROM Rpci r WHERE r.nameVer = :nameVer")
    , @NamedQuery(name = "Rpci.findByDesignationVer", query = "SELECT r FROM Rpci r WHERE r.designationVer = :designationVer")})
public class Rpci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rpci", nullable = false)
    private Integer idRpci;
    @Size(max = 45)
    @Column(name = "inventory_type", length = 45)
    private String inventoryType;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Size(max = 45)
    @Column(name = "accountable_officer", length = 45)
    private String accountableOfficer;
    @Size(max = 45)
    @Column(name = "official_designation", length = 45)
    private String officialDesignation;
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
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(name = "unit_measure", length = 45)
    private String unitMeasure;
    @Column(name = "bpc_quantity")
    private Integer bpcQuantity;
    @Column(name = "ohpc_quantity")
    private Integer ohpcQuantity;
    @Column(name = "shortage_overage_quantity")
    private Integer shortageOverageQuantity;
    @Size(max = 45)
    @Column(length = 45)
    private String value;
    @Size(max = 45)
    @Column(length = 45)
    private String remarks;
    @Size(max = 45)
    @Column(length = 45)
    private String checker;
    @Size(max = 45)
    @Column(name = "checker_designation", length = 45)
    private String checkerDesignation;
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
    @OneToMany(mappedBy = "idRpci")
    private List<FormRepo> formRepoList;
    @JoinColumn(name = "id_sc", referencedColumnName = "id_sc", nullable = false)
    @ManyToOne(optional = false)
    private Sc idSc;

    public Rpci() {
    }

    public Rpci(Integer idRpci) {
        this.idRpci = idRpci;
    }

    public Integer getIdRpci() {
        return idRpci;
    }

    public void setIdRpci(Integer idRpci) {
        this.idRpci = idRpci;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
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

    public String getOfficialDesignation() {
        return officialDesignation;
    }

    public void setOfficialDesignation(String officialDesignation) {
        this.officialDesignation = officialDesignation;
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

    public Integer getStockNo() {
        return stockNo;
    }

    public void setStockNo(Integer stockNo) {
        this.stockNo = stockNo;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public Integer getBpcQuantity() {
        return bpcQuantity;
    }

    public void setBpcQuantity(Integer bpcQuantity) {
        this.bpcQuantity = bpcQuantity;
    }

    public Integer getOhpcQuantity() {
        return ohpcQuantity;
    }

    public void setOhpcQuantity(Integer ohpcQuantity) {
        this.ohpcQuantity = ohpcQuantity;
    }

    public Integer getShortageOverageQuantity() {
        return shortageOverageQuantity;
    }

    public void setShortageOverageQuantity(Integer shortageOverageQuantity) {
        this.shortageOverageQuantity = shortageOverageQuantity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckerDesignation() {
        return checkerDesignation;
    }

    public void setCheckerDesignation(String checkerDesignation) {
        this.checkerDesignation = checkerDesignation;
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

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    public Sc getIdSc() {
        return idSc;
    }

    public void setIdSc(Sc idSc) {
        this.idSc = idSc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRpci != null ? idRpci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rpci)) {
            return false;
        }
        Rpci other = (Rpci) object;
        if ((this.idRpci == null && other.idRpci != null) || (this.idRpci != null && !this.idRpci.equals(other.idRpci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rpci[ idRpci=" + idRpci + " ]";
    }
    
}
