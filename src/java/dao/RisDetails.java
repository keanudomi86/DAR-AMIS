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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "ris_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ris_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RisDetails.findAll", query = "SELECT r FROM RisDetails r")
    , @NamedQuery(name = "RisDetails.findByIdRisDetails", query = "SELECT r FROM RisDetails r WHERE r.idRisDetails = :idRisDetails")
    , @NamedQuery(name = "RisDetails.findByEnityName", query = "SELECT r FROM RisDetails r WHERE r.enityName = :enityName")
    , @NamedQuery(name = "RisDetails.findByOffice", query = "SELECT r FROM RisDetails r WHERE r.office = :office")
    , @NamedQuery(name = "RisDetails.findByFundCluster", query = "SELECT r FROM RisDetails r WHERE r.fundCluster = :fundCluster")
    , @NamedQuery(name = "RisDetails.findByDivision", query = "SELECT r FROM RisDetails r WHERE r.division = :division")
    , @NamedQuery(name = "RisDetails.findByResponsibility", query = "SELECT r FROM RisDetails r WHERE r.responsibility = :responsibility")
    , @NamedQuery(name = "RisDetails.findByStockNo", query = "SELECT r FROM RisDetails r WHERE r.stockNo = :stockNo")
    , @NamedQuery(name = "RisDetails.findByUnit", query = "SELECT r FROM RisDetails r WHERE r.unit = :unit")
    , @NamedQuery(name = "RisDetails.findByDescription", query = "SELECT r FROM RisDetails r WHERE r.description = :description")
    , @NamedQuery(name = "RisDetails.findByReqQuantity", query = "SELECT r FROM RisDetails r WHERE r.reqQuantity = :reqQuantity")
    , @NamedQuery(name = "RisDetails.findByStockAvail", query = "SELECT r FROM RisDetails r WHERE r.stockAvail = :stockAvail")
    , @NamedQuery(name = "RisDetails.findByIssuedQuantity", query = "SELECT r FROM RisDetails r WHERE r.issuedQuantity = :issuedQuantity")
    , @NamedQuery(name = "RisDetails.findByRemarks", query = "SELECT r FROM RisDetails r WHERE r.remarks = :remarks")
    , @NamedQuery(name = "RisDetails.findByPurpose", query = "SELECT r FROM RisDetails r WHERE r.purpose = :purpose")
    , @NamedQuery(name = "RisDetails.findByNameReq", query = "SELECT r FROM RisDetails r WHERE r.nameReq = :nameReq")
    , @NamedQuery(name = "RisDetails.findByDesignationReq", query = "SELECT r FROM RisDetails r WHERE r.designationReq = :designationReq")
    , @NamedQuery(name = "RisDetails.findByDateReq", query = "SELECT r FROM RisDetails r WHERE r.dateReq = :dateReq")
    , @NamedQuery(name = "RisDetails.findByNameApp", query = "SELECT r FROM RisDetails r WHERE r.nameApp = :nameApp")
    , @NamedQuery(name = "RisDetails.findByDesignationApp", query = "SELECT r FROM RisDetails r WHERE r.designationApp = :designationApp")
    , @NamedQuery(name = "RisDetails.findByDateApp", query = "SELECT r FROM RisDetails r WHERE r.dateApp = :dateApp")
    , @NamedQuery(name = "RisDetails.findByNameIssued", query = "SELECT r FROM RisDetails r WHERE r.nameIssued = :nameIssued")
    , @NamedQuery(name = "RisDetails.findByDesignationIssued", query = "SELECT r FROM RisDetails r WHERE r.designationIssued = :designationIssued")
    , @NamedQuery(name = "RisDetails.findByDateIssued", query = "SELECT r FROM RisDetails r WHERE r.dateIssued = :dateIssued")
    , @NamedQuery(name = "RisDetails.findByNameRec", query = "SELECT r FROM RisDetails r WHERE r.nameRec = :nameRec")
    , @NamedQuery(name = "RisDetails.findByDesignation", query = "SELECT r FROM RisDetails r WHERE r.designation = :designation")
    , @NamedQuery(name = "RisDetails.findByDateRec", query = "SELECT r FROM RisDetails r WHERE r.dateRec = :dateRec")})
public class RisDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ris_details", nullable = false)
    private Integer idRisDetails;
    @Size(max = 45)
    @Column(name = "enity_name", length = 45)
    private String enityName;
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
    @Column(length = 45)
    private String responsibility;
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Column(name = "req_quantity")
    private Integer reqQuantity;
    @Column(name = "stock_avail")
    private Integer stockAvail;
    @Column(name = "issued_quantity")
    private Integer issuedQuantity;
    @Size(max = 45)
    @Column(length = 45)
    private String remarks;
    @Size(max = 45)
    @Column(length = 45)
    private String purpose;
    @Size(max = 45)
    @Column(name = "name_req", length = 45)
    private String nameReq;
    @Size(max = 45)
    @Column(name = "designation_req", length = 45)
    private String designationReq;
    @Column(name = "date_req")
    @Temporal(TemporalType.DATE)
    private Date dateReq;
    @Size(max = 45)
    @Column(name = "name_app", length = 45)
    private String nameApp;
    @Size(max = 45)
    @Column(name = "designation_app", length = 45)
    private String designationApp;
    @Column(name = "date_app")
    @Temporal(TemporalType.DATE)
    private Date dateApp;
    @Size(max = 45)
    @Column(name = "name_issued", length = 45)
    private String nameIssued;
    @Size(max = 45)
    @Column(name = "designation_issued", length = 45)
    private String designationIssued;
    @Column(name = "date_issued")
    @Temporal(TemporalType.DATE)
    private Date dateIssued;
    @Size(max = 45)
    @Column(name = "name_rec", length = 45)
    private String nameRec;
    @Size(max = 45)
    @Column(length = 45)
    private String designation;
    @Column(name = "date_rec")
    @Temporal(TemporalType.DATE)
    private Date dateRec;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris", nullable = false)
    @ManyToOne(optional = false)
    private Ris idRis;

    public RisDetails() {
    }

    public RisDetails(Integer idRisDetails) {
        this.idRisDetails = idRisDetails;
    }

    public Integer getIdRisDetails() {
        return idRisDetails;
    }

    public void setIdRisDetails(Integer idRisDetails) {
        this.idRisDetails = idRisDetails;
    }

    public String getEnityName() {
        return enityName;
    }

    public void setEnityName(String enityName) {
        this.enityName = enityName;
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

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public Integer getStockNo() {
        return stockNo;
    }

    public void setStockNo(Integer stockNo) {
        this.stockNo = stockNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReqQuantity() {
        return reqQuantity;
    }

    public void setReqQuantity(Integer reqQuantity) {
        this.reqQuantity = reqQuantity;
    }

    public Integer getStockAvail() {
        return stockAvail;
    }

    public void setStockAvail(Integer stockAvail) {
        this.stockAvail = stockAvail;
    }

    public Integer getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(Integer issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNameReq() {
        return nameReq;
    }

    public void setNameReq(String nameReq) {
        this.nameReq = nameReq;
    }

    public String getDesignationReq() {
        return designationReq;
    }

    public void setDesignationReq(String designationReq) {
        this.designationReq = designationReq;
    }

    public Date getDateReq() {
        return dateReq;
    }

    public void setDateReq(Date dateReq) {
        this.dateReq = dateReq;
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

    public Date getDateApp() {
        return dateApp;
    }

    public void setDateApp(Date dateApp) {
        this.dateApp = dateApp;
    }

    public String getNameIssued() {
        return nameIssued;
    }

    public void setNameIssued(String nameIssued) {
        this.nameIssued = nameIssued;
    }

    public String getDesignationIssued() {
        return designationIssued;
    }

    public void setDesignationIssued(String designationIssued) {
        this.designationIssued = designationIssued;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getNameRec() {
        return nameRec;
    }

    public void setNameRec(String nameRec) {
        this.nameRec = nameRec;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRisDetails != null ? idRisDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RisDetails)) {
            return false;
        }
        RisDetails other = (RisDetails) object;
        if ((this.idRisDetails == null && other.idRisDetails != null) || (this.idRisDetails != null && !this.idRisDetails.equals(other.idRisDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RisDetails[ idRisDetails=" + idRisDetails + " ]";
    }
    
}
