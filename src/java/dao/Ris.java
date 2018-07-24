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
    @UniqueConstraint(columnNames = {"id_ris"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ris.findAll", query = "SELECT r FROM Ris r")
    , @NamedQuery(name = "Ris.findByIdRis", query = "SELECT r FROM Ris r WHERE r.idRis = :idRis")
    , @NamedQuery(name = "Ris.findByIdSc", query = "SELECT r FROM Ris r WHERE r.idSc = :idSc")
    , @NamedQuery(name = "Ris.findByEntityName", query = "SELECT r FROM Ris r WHERE r.entityName = :entityName")
    , @NamedQuery(name = "Ris.findByRisNo", query = "SELECT r FROM Ris r WHERE r.risNo = :risNo")
    , @NamedQuery(name = "Ris.findByOffice", query = "SELECT r FROM Ris r WHERE r.office = :office")
    , @NamedQuery(name = "Ris.findByFundCluster", query = "SELECT r FROM Ris r WHERE r.fundCluster = :fundCluster")
    , @NamedQuery(name = "Ris.findByDivision", query = "SELECT r FROM Ris r WHERE r.division = :division")
    , @NamedQuery(name = "Ris.findByResponsibilityCode", query = "SELECT r FROM Ris r WHERE r.responsibilityCode = :responsibilityCode")
    , @NamedQuery(name = "Ris.findByPurpose", query = "SELECT r FROM Ris r WHERE r.purpose = :purpose")
    , @NamedQuery(name = "Ris.findByRequestedName", query = "SELECT r FROM Ris r WHERE r.requestedName = :requestedName")
    , @NamedQuery(name = "Ris.findByRequestedDesignation", query = "SELECT r FROM Ris r WHERE r.requestedDesignation = :requestedDesignation")
    , @NamedQuery(name = "Ris.findByRequestedDate", query = "SELECT r FROM Ris r WHERE r.requestedDate = :requestedDate")
    , @NamedQuery(name = "Ris.findByApprovedName", query = "SELECT r FROM Ris r WHERE r.approvedName = :approvedName")
    , @NamedQuery(name = "Ris.findByApprovedDesgination", query = "SELECT r FROM Ris r WHERE r.approvedDesgination = :approvedDesgination")
    , @NamedQuery(name = "Ris.findByApprovedDate", query = "SELECT r FROM Ris r WHERE r.approvedDate = :approvedDate")
    , @NamedQuery(name = "Ris.findByIssuedName", query = "SELECT r FROM Ris r WHERE r.issuedName = :issuedName")
    , @NamedQuery(name = "Ris.findByIssuedDesignation", query = "SELECT r FROM Ris r WHERE r.issuedDesignation = :issuedDesignation")
    , @NamedQuery(name = "Ris.findByIssuedDate", query = "SELECT r FROM Ris r WHERE r.issuedDate = :issuedDate")
    , @NamedQuery(name = "Ris.findByReceivedName", query = "SELECT r FROM Ris r WHERE r.receivedName = :receivedName")
    , @NamedQuery(name = "Ris.findByReceivedDesignation", query = "SELECT r FROM Ris r WHERE r.receivedDesignation = :receivedDesignation")
    , @NamedQuery(name = "Ris.findByReceivedDate", query = "SELECT r FROM Ris r WHERE r.receivedDate = :receivedDate")})
public class Ris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ris", nullable = false)
    private Integer idRis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sc", nullable = false)
    private int idSc;
    @Size(max = 45)
    @Column(name = "entity_name", length = 45)
    private String entityName;
    @Column(name = "ris_no")
    private Integer risNo;
    @Size(max = 45)
    @Column(length = 45)
    private String office;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Size(max = 45)
    @Column(length = 45)
    private String division;
    @Size(max = 45)
    @Column(name = "responsibility_code", length = 45)
    private String responsibilityCode;
    @Size(max = 45)
    @Column(length = 45)
    private String purpose;
    @Size(max = 45)
    @Column(name = "requested_name", length = 45)
    private String requestedName;
    @Size(max = 45)
    @Column(name = "requested_designation", length = 45)
    private String requestedDesignation;
    @Column(name = "requested_date")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    @Size(max = 45)
    @Column(name = "approved_name", length = 45)
    private String approvedName;
    @Size(max = 45)
    @Column(name = "approved_desgination", length = 45)
    private String approvedDesgination;
    @Column(name = "approved_date")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @Size(max = 45)
    @Column(name = "issued_name", length = 45)
    private String issuedName;
    @Size(max = 45)
    @Column(name = "issued_designation", length = 45)
    private String issuedDesignation;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Size(max = 45)
    @Column(name = "received_name", length = 45)
    private String receivedName;
    @Size(max = 45)
    @Column(name = "received_designation", length = 45)
    private String receivedDesignation;
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @OneToMany(mappedBy = "idRis")
    private List<Pr> prList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRis")
    private List<RisDetails> risDetailsList;
    @OneToMany(mappedBy = "idRis")
    private List<FormRepo> formRepoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRis")
    private List<Sc> scList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRis")
    private List<Rsmi> rsmiList;

    public Ris() {
    }

    public Ris(Integer idRis) {
        this.idRis = idRis;
    }

    public Ris(Integer idRis, int idSc) {
        this.idRis = idRis;
        this.idSc = idSc;
    }

    public Integer getIdRis() {
        return idRis;
    }

    public void setIdRis(Integer idRis) {
        this.idRis = idRis;
    }

    public int getIdSc() {
        return idSc;
    }

    public void setIdSc(int idSc) {
        this.idSc = idSc;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getResponsibilityCode() {
        return responsibilityCode;
    }

    public void setResponsibilityCode(String responsibilityCode) {
        this.responsibilityCode = responsibilityCode;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRequestedName() {
        return requestedName;
    }

    public void setRequestedName(String requestedName) {
        this.requestedName = requestedName;
    }

    public String getRequestedDesignation() {
        return requestedDesignation;
    }

    public void setRequestedDesignation(String requestedDesignation) {
        this.requestedDesignation = requestedDesignation;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getApprovedName() {
        return approvedName;
    }

    public void setApprovedName(String approvedName) {
        this.approvedName = approvedName;
    }

    public String getApprovedDesgination() {
        return approvedDesgination;
    }

    public void setApprovedDesgination(String approvedDesgination) {
        this.approvedDesgination = approvedDesgination;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getIssuedName() {
        return issuedName;
    }

    public void setIssuedName(String issuedName) {
        this.issuedName = issuedName;
    }

    public String getIssuedDesignation() {
        return issuedDesignation;
    }

    public void setIssuedDesignation(String issuedDesignation) {
        this.issuedDesignation = issuedDesignation;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getReceivedName() {
        return receivedName;
    }

    public void setReceivedName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedDesignation() {
        return receivedDesignation;
    }

    public void setReceivedDesignation(String receivedDesignation) {
        this.receivedDesignation = receivedDesignation;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    @XmlTransient
    public List<Pr> getPrList() {
        return prList;
    }

    public void setPrList(List<Pr> prList) {
        this.prList = prList;
    }

    @XmlTransient
    public List<RisDetails> getRisDetailsList() {
        return risDetailsList;
    }

    public void setRisDetailsList(List<RisDetails> risDetailsList) {
        this.risDetailsList = risDetailsList;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    @XmlTransient
    public List<Sc> getScList() {
        return scList;
    }

    public void setScList(List<Sc> scList) {
        this.scList = scList;
    }

    @XmlTransient
    public List<Rsmi> getRsmiList() {
        return rsmiList;
    }

    public void setRsmiList(List<Rsmi> rsmiList) {
        this.rsmiList = rsmiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRis != null ? idRis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ris)) {
            return false;
        }
        Ris other = (Ris) object;
        if ((this.idRis == null && other.idRis != null) || (this.idRis != null && !this.idRis.equals(other.idRis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ris[ idRis=" + idRis + " ]";
    }
    
}
