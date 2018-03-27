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
    @UniqueConstraint(columnNames = {"id_sc"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sc.findAll", query = "SELECT s FROM Sc s")
    , @NamedQuery(name = "Sc.findByIdSc", query = "SELECT s FROM Sc s WHERE s.idSc = :idSc")
    , @NamedQuery(name = "Sc.findByEntity", query = "SELECT s FROM Sc s WHERE s.entity = :entity")
    , @NamedQuery(name = "Sc.findByFundCluster", query = "SELECT s FROM Sc s WHERE s.fundCluster = :fundCluster")
    , @NamedQuery(name = "Sc.findByItem", query = "SELECT s FROM Sc s WHERE s.item = :item")
    , @NamedQuery(name = "Sc.findByStockNo", query = "SELECT s FROM Sc s WHERE s.stockNo = :stockNo")
    , @NamedQuery(name = "Sc.findByDescription", query = "SELECT s FROM Sc s WHERE s.description = :description")
    , @NamedQuery(name = "Sc.findByReorderPoint", query = "SELECT s FROM Sc s WHERE s.reorderPoint = :reorderPoint")
    , @NamedQuery(name = "Sc.findByUnitOfMeasurement", query = "SELECT s FROM Sc s WHERE s.unitOfMeasurement = :unitOfMeasurement")
    , @NamedQuery(name = "Sc.findByDate", query = "SELECT s FROM Sc s WHERE s.date = :date")
    , @NamedQuery(name = "Sc.findByReference", query = "SELECT s FROM Sc s WHERE s.reference = :reference")
    , @NamedQuery(name = "Sc.findByReceiptQty", query = "SELECT s FROM Sc s WHERE s.receiptQty = :receiptQty")
    , @NamedQuery(name = "Sc.findByIssueQty", query = "SELECT s FROM Sc s WHERE s.issueQty = :issueQty")
    , @NamedQuery(name = "Sc.findByOfficeQty", query = "SELECT s FROM Sc s WHERE s.officeQty = :officeQty")
    , @NamedQuery(name = "Sc.findByBalanceQty", query = "SELECT s FROM Sc s WHERE s.balanceQty = :balanceQty")
    , @NamedQuery(name = "Sc.findByNoDaysLeft", query = "SELECT s FROM Sc s WHERE s.noDaysLeft = :noDaysLeft")})
public class Sc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sc", nullable = false)
    private Integer idSc;
    @Size(max = 45)
    @Column(length = 45)
    private String entity;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Size(max = 45)
    @Column(length = 45)
    private String item;
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Size(max = 45)
    @Column(name = "reorder_point", length = 45)
    private String reorderPoint;
    @Size(max = 45)
    @Column(name = "unit_of_measurement", length = 45)
    private String unitOfMeasurement;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(length = 45)
    private String reference;
    @Column(name = "receipt_qty")
    private Integer receiptQty;
    @Column(name = "issue_qty")
    private Integer issueQty;
    @Column(name = "office_qty")
    private Integer officeQty;
    @Column(name = "balance_qty")
    private Integer balanceQty;
    @Column(name = "no_days_left")
    private Integer noDaysLeft;
    @OneToMany(mappedBy = "idSc")
    private List<FormRepo> formRepoList;
    @JoinColumn(name = "id_dr", referencedColumnName = "id_dr", nullable = false)
    @ManyToOne(optional = false)
    private Dr idDr;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris", nullable = false)
    @ManyToOne(optional = false)
    private Ris idRis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSc")
    private List<Rpci> rpciList;

    public Sc() {
    }

    public Sc(Integer idSc) {
        this.idSc = idSc;
    }

    public Integer getIdSc() {
        return idSc;
    }

    public void setIdSc(Integer idSc) {
        this.idSc = idSc;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getStockNo() {
        return stockNo;
    }

    public void setStockNo(Integer stockNo) {
        this.stockNo = stockNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(String reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getReceiptQty() {
        return receiptQty;
    }

    public void setReceiptQty(Integer receiptQty) {
        this.receiptQty = receiptQty;
    }

    public Integer getIssueQty() {
        return issueQty;
    }

    public void setIssueQty(Integer issueQty) {
        this.issueQty = issueQty;
    }

    public Integer getOfficeQty() {
        return officeQty;
    }

    public void setOfficeQty(Integer officeQty) {
        this.officeQty = officeQty;
    }

    public Integer getBalanceQty() {
        return balanceQty;
    }

    public void setBalanceQty(Integer balanceQty) {
        this.balanceQty = balanceQty;
    }

    public Integer getNoDaysLeft() {
        return noDaysLeft;
    }

    public void setNoDaysLeft(Integer noDaysLeft) {
        this.noDaysLeft = noDaysLeft;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    public Dr getIdDr() {
        return idDr;
    }

    public void setIdDr(Dr idDr) {
        this.idDr = idDr;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    public Pr getIdPr() {
        return idPr;
    }

    public void setIdPr(Pr idPr) {
        this.idPr = idPr;
    }

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    @XmlTransient
    public List<Rpci> getRpciList() {
        return rpciList;
    }

    public void setRpciList(List<Rpci> rpciList) {
        this.rpciList = rpciList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSc != null ? idSc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sc)) {
            return false;
        }
        Sc other = (Sc) object;
        if ((this.idSc == null && other.idSc != null) || (this.idSc != null && !this.idSc.equals(other.idSc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Sc[ idSc=" + idSc + " ]";
    }
    
}
