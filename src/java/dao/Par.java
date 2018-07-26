/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_par"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Par.findAll", query = "SELECT p FROM Par p")
    , @NamedQuery(name = "Par.findByIdPar", query = "SELECT p FROM Par p WHERE p.idPar = :idPar")
    , @NamedQuery(name = "Par.findByIdPc", query = "SELECT p FROM Par p WHERE p.idPc = :idPc")
    , @NamedQuery(name = "Par.findByEntityName", query = "SELECT p FROM Par p WHERE p.entityName = :entityName")
    , @NamedQuery(name = "Par.findByRisNo", query = "SELECT p FROM Par p WHERE p.risNo = :risNo")
    , @NamedQuery(name = "Par.findByFundCluster", query = "SELECT p FROM Par p WHERE p.fundCluster = :fundCluster")
    , @NamedQuery(name = "Par.findByPurpose", query = "SELECT p FROM Par p WHERE p.purpose = :purpose")
    , @NamedQuery(name = "Par.findByReceivedName", query = "SELECT p FROM Par p WHERE p.receivedName = :receivedName")
    , @NamedQuery(name = "Par.findByReceivedPosition", query = "SELECT p FROM Par p WHERE p.receivedPosition = :receivedPosition")
    , @NamedQuery(name = "Par.findByReceivedDate", query = "SELECT p FROM Par p WHERE p.receivedDate = :receivedDate")
    , @NamedQuery(name = "Par.findByIssuedName", query = "SELECT p FROM Par p WHERE p.issuedName = :issuedName")
    , @NamedQuery(name = "Par.findByIssuedPosition", query = "SELECT p FROM Par p WHERE p.issuedPosition = :issuedPosition")
    , @NamedQuery(name = "Par.findByIssuedOffice", query = "SELECT p FROM Par p WHERE p.issuedOffice = :issuedOffice")
    , @NamedQuery(name = "Par.findByIssuedDate", query = "SELECT p FROM Par p WHERE p.issuedDate = :issuedDate")})
public class Par implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_par", nullable = false)
    private Integer idPar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pc", nullable = false)
    private int idPc;
    @Size(max = 45)
    @Column(name = "entity_name", length = 45)
    private String entityName;
    @Column(name = "ris_no")
    private Integer risNo;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Size(max = 45)
    @Column(length = 45)
    private String purpose;
    @Size(max = 45)
    @Column(name = "received_name", length = 45)
    private String receivedName;
    @Size(max = 45)
    @Column(name = "received_position", length = 45)
    private String receivedPosition;
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @Size(max = 45)
    @Column(name = "issued_name", length = 45)
    private String issuedName;
    @Size(max = 45)
    @Column(name = "issued_position", length = 45)
    private String issuedPosition;
    @Size(max = 45)
    @Column(name = "issued_office", length = 45)
    private String issuedOffice;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @JoinColumn(name = "received_office", referencedColumnName = "id_office")
    @ManyToOne
    private Office receivedOffice;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPar")
    private ParDetails parDetails;

    public Par() {
    }

    public Par(Integer idPar) {
        this.idPar = idPar;
    }

    public Par(Integer idPar, int idPc) {
        this.idPar = idPar;
        this.idPc = idPc;
    }

    public Integer getIdPar() {
        return idPar;
    }

    public void setIdPar(Integer idPar) {
        this.idPar = idPar;
    }

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getReceivedName() {
        return receivedName;
    }

    public void setReceivedName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedPosition() {
        return receivedPosition;
    }

    public void setReceivedPosition(String receivedPosition) {
        this.receivedPosition = receivedPosition;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getIssuedName() {
        return issuedName;
    }

    public void setIssuedName(String issuedName) {
        this.issuedName = issuedName;
    }

    public String getIssuedPosition() {
        return issuedPosition;
    }

    public void setIssuedPosition(String issuedPosition) {
        this.issuedPosition = issuedPosition;
    }

    public String getIssuedOffice() {
        return issuedOffice;
    }

    public void setIssuedOffice(String issuedOffice) {
        this.issuedOffice = issuedOffice;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Office getReceivedOffice() {
        return receivedOffice;
    }

    public void setReceivedOffice(Office receivedOffice) {
        this.receivedOffice = receivedOffice;
    }

    public ParDetails getParDetails() {
        return parDetails;
    }

    public void setParDetails(ParDetails parDetails) {
        this.parDetails = parDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPar != null ? idPar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Par)) {
            return false;
        }
        Par other = (Par) object;
        if ((this.idPar == null && other.idPar != null) || (this.idPar != null && !this.idPar.equals(other.idPar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Par[ idPar=" + idPar + " ]";
    }
    
}
