/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "po_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_po_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoDetails.findAll", query = "SELECT p FROM PoDetails p")
    , @NamedQuery(name = "PoDetails.findByIdPoDetails", query = "SELECT p FROM PoDetails p WHERE p.idPoDetails = :idPoDetails")
    , @NamedQuery(name = "PoDetails.findByEntity", query = "SELECT p FROM PoDetails p WHERE p.entity = :entity")
    , @NamedQuery(name = "PoDetails.findByPoNo", query = "SELECT p FROM PoDetails p WHERE p.poNo = :poNo")
    , @NamedQuery(name = "PoDetails.findBySupplier", query = "SELECT p FROM PoDetails p WHERE p.supplier = :supplier")
    , @NamedQuery(name = "PoDetails.findByDate", query = "SELECT p FROM PoDetails p WHERE p.date = :date")
    , @NamedQuery(name = "PoDetails.findByAddress", query = "SELECT p FROM PoDetails p WHERE p.address = :address")
    , @NamedQuery(name = "PoDetails.findByModeOfProc", query = "SELECT p FROM PoDetails p WHERE p.modeOfProc = :modeOfProc")
    , @NamedQuery(name = "PoDetails.findByTin", query = "SELECT p FROM PoDetails p WHERE p.tin = :tin")
    , @NamedQuery(name = "PoDetails.findByGentlemen", query = "SELECT p FROM PoDetails p WHERE p.gentlemen = :gentlemen")
    , @NamedQuery(name = "PoDetails.findByPlaceDelivery", query = "SELECT p FROM PoDetails p WHERE p.placeDelivery = :placeDelivery")
    , @NamedQuery(name = "PoDetails.findByModeOfProc2", query = "SELECT p FROM PoDetails p WHERE p.modeOfProc2 = :modeOfProc2")
    , @NamedQuery(name = "PoDetails.findByDateDelivery", query = "SELECT p FROM PoDetails p WHERE p.dateDelivery = :dateDelivery")
    , @NamedQuery(name = "PoDetails.findByPayTerm", query = "SELECT p FROM PoDetails p WHERE p.payTerm = :payTerm")
    , @NamedQuery(name = "PoDetails.findByStockNo", query = "SELECT p FROM PoDetails p WHERE p.stockNo = :stockNo")
    , @NamedQuery(name = "PoDetails.findByUnit", query = "SELECT p FROM PoDetails p WHERE p.unit = :unit")
    , @NamedQuery(name = "PoDetails.findByDescription", query = "SELECT p FROM PoDetails p WHERE p.description = :description")
    , @NamedQuery(name = "PoDetails.findByQuantity", query = "SELECT p FROM PoDetails p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PoDetails.findByCost", query = "SELECT p FROM PoDetails p WHERE p.cost = :cost")
    , @NamedQuery(name = "PoDetails.findByAmout", query = "SELECT p FROM PoDetails p WHERE p.amout = :amout")
    , @NamedQuery(name = "PoDetails.findByAmountWords", query = "SELECT p FROM PoDetails p WHERE p.amountWords = :amountWords")
    , @NamedQuery(name = "PoDetails.findByNameConforme", query = "SELECT p FROM PoDetails p WHERE p.nameConforme = :nameConforme")
    , @NamedQuery(name = "PoDetails.findByNameTruly", query = "SELECT p FROM PoDetails p WHERE p.nameTruly = :nameTruly")
    , @NamedQuery(name = "PoDetails.findByDateDelivery2", query = "SELECT p FROM PoDetails p WHERE p.dateDelivery2 = :dateDelivery2")
    , @NamedQuery(name = "PoDetails.findByPayTerm2", query = "SELECT p FROM PoDetails p WHERE p.payTerm2 = :payTerm2")
    , @NamedQuery(name = "PoDetails.findByFundCluster", query = "SELECT p FROM PoDetails p WHERE p.fundCluster = :fundCluster")
    , @NamedQuery(name = "PoDetails.findByOrsBursNo", query = "SELECT p FROM PoDetails p WHERE p.orsBursNo = :orsBursNo")
    , @NamedQuery(name = "PoDetails.findByDateOrsburs", query = "SELECT p FROM PoDetails p WHERE p.dateOrsburs = :dateOrsburs")
    , @NamedQuery(name = "PoDetails.findByNameReq", query = "SELECT p FROM PoDetails p WHERE p.nameReq = :nameReq")
    , @NamedQuery(name = "PoDetails.findByAmount", query = "SELECT p FROM PoDetails p WHERE p.amount = :amount")})
public class PoDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_po_details", nullable = false)
    private Integer idPoDetails;
    @Size(max = 45)
    @Column(length = 45)
    private String entity;
    @Column(name = "po_no")
    private Integer poNo;
    @Size(max = 45)
    @Column(length = 45)
    private String supplier;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(length = 45)
    private String address;
    @Size(max = 45)
    @Column(name = "mode_of_proc", length = 45)
    private String modeOfProc;
    private String tin;
    @Size(max = 45)
    @Column(length = 45)
    private String gentlemen;
    @Size(max = 45)
    @Column(name = "place_delivery", length = 45)
    private String placeDelivery;
    @Size(max = 45)
    @Column(name = "mode_of_proc2", length = 45)
    private String modeOfProc2;
    @Column(name = "date_delivery")
    @Temporal(TemporalType.DATE)
    private Date dateDelivery;
    @Size(max = 45)
    @Column(name = "pay_term", length = 45)
    private String payTerm;
    @Column(name = "stock_no")
    private Integer stockNo;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float cost;
    @Column(precision = 12)
    private Float amout;
    @Size(max = 45)
    @Column(name = "amount_words", length = 45)
    private String amountWords;
    @Size(max = 45)
    @Column(name = "name_conforme", length = 45)
    private String nameConforme;
    @Size(max = 45)
    @Column(name = "name_truly", length = 45)
    private String nameTruly;
    @Column(name = "date_delivery2")
    @Temporal(TemporalType.DATE)
    private Date dateDelivery2;
    @Size(max = 45)
    @Column(name = "pay_term2", length = 45)
    private String payTerm2;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Column(name = "ors_burs_no")
    private Integer orsBursNo;
    @Column(name = "date_orsburs")
    @Temporal(TemporalType.DATE)
    private Date dateOrsburs;
    @Size(max = 45)
    @Column(name = "name_req", length = 45)
    private String nameReq;
    @Column(precision = 12)
    private Float amount;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;

    public PoDetails() {
    }

    public PoDetails(Integer idPoDetails) {
        this.idPoDetails = idPoDetails;
    }

    public Integer getIdPoDetails() {
        return idPoDetails;
    }

    public void setIdPoDetails(Integer idPoDetails) {
        this.idPoDetails = idPoDetails;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getPoNo() {
        return poNo;
    }

    public void setPoNo(Integer poNo) {
        this.poNo = poNo;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModeOfProc() {
        return modeOfProc;
    }

    public void setModeOfProc(String modeOfProc) {
        this.modeOfProc = modeOfProc;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getGentlemen() {
        return gentlemen;
    }

    public void setGentlemen(String gentlemen) {
        this.gentlemen = gentlemen;
    }

    public String getPlaceDelivery() {
        return placeDelivery;
    }

    public void setPlaceDelivery(String placeDelivery) {
        this.placeDelivery = placeDelivery;
    }

    public String getModeOfProc2() {
        return modeOfProc2;
    }

    public void setModeOfProc2(String modeOfProc2) {
        this.modeOfProc2 = modeOfProc2;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getPayTerm() {
        return payTerm;
    }

    public void setPayTerm(String payTerm) {
        this.payTerm = payTerm;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getAmout() {
        return amout;
    }

    public void setAmout(Float amout) {
        this.amout = amout;
    }

    public String getAmountWords() {
        return amountWords;
    }

    public void setAmountWords(String amountWords) {
        this.amountWords = amountWords;
    }

    public String getNameConforme() {
        return nameConforme;
    }

    public void setNameConforme(String nameConforme) {
        this.nameConforme = nameConforme;
    }

    public String getNameTruly() {
        return nameTruly;
    }

    public void setNameTruly(String nameTruly) {
        this.nameTruly = nameTruly;
    }

    public Date getDateDelivery2() {
        return dateDelivery2;
    }

    public void setDateDelivery2(Date dateDelivery2) {
        this.dateDelivery2 = dateDelivery2;
    }

    public String getPayTerm2() {
        return payTerm2;
    }

    public void setPayTerm2(String payTerm2) {
        this.payTerm2 = payTerm2;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
    }

    public Integer getOrsBursNo() {
        return orsBursNo;
    }

    public void setOrsBursNo(Integer orsBursNo) {
        this.orsBursNo = orsBursNo;
    }

    public Date getDateOrsburs() {
        return dateOrsburs;
    }

    public void setDateOrsburs(Date dateOrsburs) {
        this.dateOrsburs = dateOrsburs;
    }

    public String getNameReq() {
        return nameReq;
    }

    public void setNameReq(String nameReq) {
        this.nameReq = nameReq;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoDetails != null ? idPoDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoDetails)) {
            return false;
        }
        PoDetails other = (PoDetails) object;
        if ((this.idPoDetails == null && other.idPoDetails != null) || (this.idPoDetails != null && !this.idPoDetails.equals(other.idPoDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.PoDetails[ idPoDetails=" + idPoDetails + " ]";
    }
    
}
