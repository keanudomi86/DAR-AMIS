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
    @NamedQuery(name = "Pr.findAll", query = "SELECT p FROM Pr p")
    , @NamedQuery(name = "Pr.findByIdpurchaseReq", query = "SELECT p FROM Pr p WHERE p.idpurchaseReq = :idpurchaseReq")
    , @NamedQuery(name = "Pr.findByIdFundCluster", query = "SELECT p FROM Pr p WHERE p.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Pr.findByOffice", query = "SELECT p FROM Pr p WHERE p.office = :office")
    , @NamedQuery(name = "Pr.findByResponsibilityCentercode", query = "SELECT p FROM Pr p WHERE p.responsibilityCentercode = :responsibilityCentercode")
    , @NamedQuery(name = "Pr.findByDate", query = "SELECT p FROM Pr p WHERE p.date = :date")
    , @NamedQuery(name = "Pr.findByStockPropnum", query = "SELECT p FROM Pr p WHERE p.stockPropnum = :stockPropnum")
    , @NamedQuery(name = "Pr.findByUnit", query = "SELECT p FROM Pr p WHERE p.unit = :unit")
    , @NamedQuery(name = "Pr.findByItemDescription", query = "SELECT p FROM Pr p WHERE p.itemDescription = :itemDescription")
    , @NamedQuery(name = "Pr.findByQuantity", query = "SELECT p FROM Pr p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Pr.findByUnitCost", query = "SELECT p FROM Pr p WHERE p.unitCost = :unitCost")
    , @NamedQuery(name = "Pr.findByTotalCost", query = "SELECT p FROM Pr p WHERE p.totalCost = :totalCost")
    , @NamedQuery(name = "Pr.findByPrPurpose", query = "SELECT p FROM Pr p WHERE p.prPurpose = :prPurpose")
    , @NamedQuery(name = "Pr.findByRequestedBy", query = "SELECT p FROM Pr p WHERE p.requestedBy = :requestedBy")
    , @NamedQuery(name = "Pr.findByApprovedBy", query = "SELECT p FROM Pr p WHERE p.approvedBy = :approvedBy")})
public class Pr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpurchase_req")
    private Integer idpurchaseReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Basic(optional = false)
    @NotNull
    private int office;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "responsibility_centercode")
    private String responsibilityCentercode;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_propnum")
    private int stockPropnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String unit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "item_description")
    private String itemDescription;
    @Basic(optional = false)
    @NotNull
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unit_cost")
    private String unitCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total_cost")
    private String totalCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pr_purpose")
    private String prPurpose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requested_by")
    private int requestedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    private List<Wfp> wfpList;
    @JoinColumn(name = "enduser", referencedColumnName = "id_APP")
    @ManyToOne(optional = false)
    private App enduser;
    @JoinColumn(name = "enduser", referencedColumnName = "id_PPMP")
    @ManyToOne(optional = false)
    private Ppmp enduser1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pr")
    private Asset asset;

    public Pr() {
    }

    public Pr(Integer idpurchaseReq) {
        this.idpurchaseReq = idpurchaseReq;
    }

    public Pr(Integer idpurchaseReq, int idFundCluster, int office, String responsibilityCentercode, Date date, int stockPropnum, String unit, String itemDescription, int quantity, String unitCost, String totalCost, String prPurpose, int requestedBy, String approvedBy) {
        this.idpurchaseReq = idpurchaseReq;
        this.idFundCluster = idFundCluster;
        this.office = office;
        this.responsibilityCentercode = responsibilityCentercode;
        this.date = date;
        this.stockPropnum = stockPropnum;
        this.unit = unit;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.totalCost = totalCost;
        this.prPurpose = prPurpose;
        this.requestedBy = requestedBy;
        this.approvedBy = approvedBy;
    }

    public Integer getIdpurchaseReq() {
        return idpurchaseReq;
    }

    public void setIdpurchaseReq(Integer idpurchaseReq) {
        this.idpurchaseReq = idpurchaseReq;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public String getResponsibilityCentercode() {
        return responsibilityCentercode;
    }

    public void setResponsibilityCentercode(String responsibilityCentercode) {
        this.responsibilityCentercode = responsibilityCentercode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStockPropnum() {
        return stockPropnum;
    }

    public void setStockPropnum(int stockPropnum) {
        this.stockPropnum = stockPropnum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPrPurpose() {
        return prPurpose;
    }

    public void setPrPurpose(String prPurpose) {
        this.prPurpose = prPurpose;
    }

    public int getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(int requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @XmlTransient
    public List<Wfp> getWfpList() {
        return wfpList;
    }

    public void setWfpList(List<Wfp> wfpList) {
        this.wfpList = wfpList;
    }

    public App getEnduser() {
        return enduser;
    }

    public void setEnduser(App enduser) {
        this.enduser = enduser;
    }

    public Ppmp getEnduser1() {
        return enduser1;
    }

    public void setEnduser1(Ppmp enduser1) {
        this.enduser1 = enduser1;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpurchaseReq != null ? idpurchaseReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pr)) {
            return false;
        }
        Pr other = (Pr) object;
        if ((this.idpurchaseReq == null && other.idpurchaseReq != null) || (this.idpurchaseReq != null && !this.idpurchaseReq.equals(other.idpurchaseReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Pr[ idpurchaseReq=" + idpurchaseReq + " ]";
    }
    
}
