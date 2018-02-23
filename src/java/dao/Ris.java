/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
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
    @NamedQuery(name = "Ris.findAll", query = "SELECT r FROM Ris r")
    , @NamedQuery(name = "Ris.findByIdRIS", query = "SELECT r FROM Ris r WHERE r.idRIS = :idRIS")
    , @NamedQuery(name = "Ris.findByIdFundCluster", query = "SELECT r FROM Ris r WHERE r.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Ris.findByRIScol", query = "SELECT r FROM Ris r WHERE r.rIScol = :rIScol")
    , @NamedQuery(name = "Ris.findByDivision", query = "SELECT r FROM Ris r WHERE r.division = :division")
    , @NamedQuery(name = "Ris.findByOffice", query = "SELECT r FROM Ris r WHERE r.office = :office")
    , @NamedQuery(name = "Ris.findByResponsibilityCcode", query = "SELECT r FROM Ris r WHERE r.responsibilityCcode = :responsibilityCcode")
    , @NamedQuery(name = "Ris.findByRisNo", query = "SELECT r FROM Ris r WHERE r.risNo = :risNo")
    , @NamedQuery(name = "Ris.findByReqStockNum", query = "SELECT r FROM Ris r WHERE r.reqStockNum = :reqStockNum")
    , @NamedQuery(name = "Ris.findByReqUnit", query = "SELECT r FROM Ris r WHERE r.reqUnit = :reqUnit")
    , @NamedQuery(name = "Ris.findByReqDescription", query = "SELECT r FROM Ris r WHERE r.reqDescription = :reqDescription")
    , @NamedQuery(name = "Ris.findByReqQuantity", query = "SELECT r FROM Ris r WHERE r.reqQuantity = :reqQuantity")
    , @NamedQuery(name = "Ris.findByStockAveY", query = "SELECT r FROM Ris r WHERE r.stockAveY = :stockAveY")
    , @NamedQuery(name = "Ris.findByStockAveN", query = "SELECT r FROM Ris r WHERE r.stockAveN = :stockAveN")
    , @NamedQuery(name = "Ris.findByIssueQuantity", query = "SELECT r FROM Ris r WHERE r.issueQuantity = :issueQuantity")
    , @NamedQuery(name = "Ris.findByIssueRemarks", query = "SELECT r FROM Ris r WHERE r.issueRemarks = :issueRemarks")
    , @NamedQuery(name = "Ris.findByPurpose", query = "SELECT r FROM Ris r WHERE r.purpose = :purpose")
    , @NamedQuery(name = "Ris.findByRequestedBy", query = "SELECT r FROM Ris r WHERE r.requestedBy = :requestedBy")
    , @NamedQuery(name = "Ris.findByApprovedBy", query = "SELECT r FROM Ris r WHERE r.approvedBy = :approvedBy")
    , @NamedQuery(name = "Ris.findByIssuedBy", query = "SELECT r FROM Ris r WHERE r.issuedBy = :issuedBy")
    , @NamedQuery(name = "Ris.findByReceivedBy", query = "SELECT r FROM Ris r WHERE r.receivedBy = :receivedBy")
    , @NamedQuery(name = "Ris.findByUpAsset", query = "SELECT r FROM Ris r WHERE r.upAsset = :upAsset")})
public class Ris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_RIS")
    private Integer idRIS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Size(max = 45)
    private String rIScol;
    @Size(max = 45)
    private String division;
    @Size(max = 45)
    private String office;
    @Size(max = 45)
    @Column(name = "responsibility_ccode")
    private String responsibilityCcode;
    @Column(name = "ris_no")
    private Integer risNo;
    @Column(name = "req_stock_num")
    private Integer reqStockNum;
    @Column(name = "req_unit")
    private Integer reqUnit;
    @Size(max = 45)
    @Column(name = "req_description")
    private String reqDescription;
    @Column(name = "req_quantity")
    private Integer reqQuantity;
    @Column(name = "stock_ave_y")
    private Integer stockAveY;
    @Column(name = "stock_ave_n")
    private Integer stockAveN;
    @Column(name = "issue_quantity")
    private Integer issueQuantity;
    @Size(max = 100)
    @Column(name = "issue_remarks")
    private String issueRemarks;
    @Size(max = 200)
    private String purpose;
    @Size(max = 45)
    @Column(name = "requested_by")
    private String requestedBy;
    @Size(max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @Size(max = 45)
    @Column(name = "issued_by")
    private String issuedBy;
    @Size(max = 45)
    @Column(name = "received_by")
    private String receivedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset6")
    private List<Generalinventory> generalinventoryList;

    public Ris() {
    }

    public Ris(Integer idRIS) {
        this.idRIS = idRIS;
    }

    public Ris(Integer idRIS, int idFundCluster, int upAsset) {
        this.idRIS = idRIS;
        this.idFundCluster = idFundCluster;
        this.upAsset = upAsset;
    }

    public Integer getIdRIS() {
        return idRIS;
    }

    public void setIdRIS(Integer idRIS) {
        this.idRIS = idRIS;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public String getRIScol() {
        return rIScol;
    }

    public void setRIScol(String rIScol) {
        this.rIScol = rIScol;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getResponsibilityCcode() {
        return responsibilityCcode;
    }

    public void setResponsibilityCcode(String responsibilityCcode) {
        this.responsibilityCcode = responsibilityCcode;
    }

    public Integer getRisNo() {
        return risNo;
    }

    public void setRisNo(Integer risNo) {
        this.risNo = risNo;
    }

    public Integer getReqStockNum() {
        return reqStockNum;
    }

    public void setReqStockNum(Integer reqStockNum) {
        this.reqStockNum = reqStockNum;
    }

    public Integer getReqUnit() {
        return reqUnit;
    }

    public void setReqUnit(Integer reqUnit) {
        this.reqUnit = reqUnit;
    }

    public String getReqDescription() {
        return reqDescription;
    }

    public void setReqDescription(String reqDescription) {
        this.reqDescription = reqDescription;
    }

    public Integer getReqQuantity() {
        return reqQuantity;
    }

    public void setReqQuantity(Integer reqQuantity) {
        this.reqQuantity = reqQuantity;
    }

    public Integer getStockAveY() {
        return stockAveY;
    }

    public void setStockAveY(Integer stockAveY) {
        this.stockAveY = stockAveY;
    }

    public Integer getStockAveN() {
        return stockAveN;
    }

    public void setStockAveN(Integer stockAveN) {
        this.stockAveN = stockAveN;
    }

    public Integer getIssueQuantity() {
        return issueQuantity;
    }

    public void setIssueQuantity(Integer issueQuantity) {
        this.issueQuantity = issueQuantity;
    }

    public String getIssueRemarks() {
        return issueRemarks;
    }

    public void setIssueRemarks(String issueRemarks) {
        this.issueRemarks = issueRemarks;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
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
        hash += (idRIS != null ? idRIS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ris)) {
            return false;
        }
        Ris other = (Ris) object;
        if ((this.idRIS == null && other.idRIS != null) || (this.idRIS != null && !this.idRIS.equals(other.idRIS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ris[ idRIS=" + idRIS + " ]";
    }
    
}
