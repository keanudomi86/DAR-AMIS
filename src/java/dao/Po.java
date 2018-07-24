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
    @UniqueConstraint(columnNames = {"id_po"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Po.findAll", query = "SELECT p FROM Po p")
    , @NamedQuery(name = "Po.findByIdPo", query = "SELECT p FROM Po p WHERE p.idPo = :idPo")
    , @NamedQuery(name = "Po.findByIdSc", query = "SELECT p FROM Po p WHERE p.idSc = :idSc")
    , @NamedQuery(name = "Po.findByIdPc", query = "SELECT p FROM Po p WHERE p.idPc = :idPc")
    , @NamedQuery(name = "Po.findByEntity", query = "SELECT p FROM Po p WHERE p.entity = :entity")
    , @NamedQuery(name = "Po.findBySupplier", query = "SELECT p FROM Po p WHERE p.supplier = :supplier")
    , @NamedQuery(name = "Po.findByDate", query = "SELECT p FROM Po p WHERE p.date = :date")
    , @NamedQuery(name = "Po.findByAddress", query = "SELECT p FROM Po p WHERE p.address = :address")
    , @NamedQuery(name = "Po.findByModeOfProc", query = "SELECT p FROM Po p WHERE p.modeOfProc = :modeOfProc")
    , @NamedQuery(name = "Po.findByTin", query = "SELECT p FROM Po p WHERE p.tin = :tin")
    , @NamedQuery(name = "Po.findByGentlemen", query = "SELECT p FROM Po p WHERE p.gentlemen = :gentlemen")
    , @NamedQuery(name = "Po.findByPlaceOfDelivery", query = "SELECT p FROM Po p WHERE p.placeOfDelivery = :placeOfDelivery")
    , @NamedQuery(name = "Po.findByModeOfProc2", query = "SELECT p FROM Po p WHERE p.modeOfProc2 = :modeOfProc2")
    , @NamedQuery(name = "Po.findByDateDelivery", query = "SELECT p FROM Po p WHERE p.dateDelivery = :dateDelivery")
    , @NamedQuery(name = "Po.findByPayTerm", query = "SELECT p FROM Po p WHERE p.payTerm = :payTerm")
    , @NamedQuery(name = "Po.findByAmountWords", query = "SELECT p FROM Po p WHERE p.amountWords = :amountWords")
    , @NamedQuery(name = "Po.findByNameConforme", query = "SELECT p FROM Po p WHERE p.nameConforme = :nameConforme")
    , @NamedQuery(name = "Po.findByNameTruly", query = "SELECT p FROM Po p WHERE p.nameTruly = :nameTruly")
    , @NamedQuery(name = "Po.findByDateDelivery2", query = "SELECT p FROM Po p WHERE p.dateDelivery2 = :dateDelivery2")
    , @NamedQuery(name = "Po.findByPayTerm2", query = "SELECT p FROM Po p WHERE p.payTerm2 = :payTerm2")
    , @NamedQuery(name = "Po.findByFundCluster", query = "SELECT p FROM Po p WHERE p.fundCluster = :fundCluster")
    , @NamedQuery(name = "Po.findByOrsBursNo", query = "SELECT p FROM Po p WHERE p.orsBursNo = :orsBursNo")
    , @NamedQuery(name = "Po.findByDateOrsburs", query = "SELECT p FROM Po p WHERE p.dateOrsburs = :dateOrsburs")
    , @NamedQuery(name = "Po.findByNameReq", query = "SELECT p FROM Po p WHERE p.nameReq = :nameReq")
    , @NamedQuery(name = "Po.findByAmount2", query = "SELECT p FROM Po p WHERE p.amount2 = :amount2")})
public class Po implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_po", nullable = false)
    private Integer idPo;
    @Column(name = "id_sc")
    private Integer idSc;
    @Column(name = "id_pc")
    private Integer idPc;
    @Size(max = 45)
    @Column(length = 45)
    private String entity;
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
    @Size(max = 45)
    @Column(length = 45)
    private String tin;
    @Size(max = 45)
    @Column(length = 45)
    private String gentlemen;
    @Size(max = 45)
    @Column(name = "place_of_delivery", length = 45)
    private String placeOfDelivery;
    @Size(max = 45)
    @Column(name = "mode_of_proc2", length = 45)
    private String modeOfProc2;
    @Column(name = "date_delivery")
    @Temporal(TemporalType.DATE)
    private Date dateDelivery;
    @Size(max = 45)
    @Column(name = "pay_term", length = 45)
    private String payTerm;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float amount2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<Dr> drList;
    @OneToMany(mappedBy = "idPo")
    private List<FormRepo> formRepoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<Sc> scList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<Apc> apcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<Pc> pcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<PoDetails> poDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<Rfi> rfiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPo")
    private List<Aif> aifList;
    @JoinColumn(name = "id_asset", referencedColumnName = "id_asset")
    @ManyToOne
    private Asset idAsset;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;

    public Po() {
    }

    public Po(Integer idPo) {
        this.idPo = idPo;
    }

    public Integer getIdPo() {
        return idPo;
    }

    public void setIdPo(Integer idPo) {
        this.idPo = idPo;
    }

    public Integer getIdSc() {
        return idSc;
    }

    public void setIdSc(Integer idSc) {
        this.idSc = idSc;
    }

    public Integer getIdPc() {
        return idPc;
    }

    public void setIdPc(Integer idPc) {
        this.idPc = idPc;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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

    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
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

    public Float getAmount2() {
        return amount2;
    }

    public void setAmount2(Float amount2) {
        this.amount2 = amount2;
    }

    @XmlTransient
    public List<Dr> getDrList() {
        return drList;
    }

    public void setDrList(List<Dr> drList) {
        this.drList = drList;
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
    public List<Apc> getApcList() {
        return apcList;
    }

    public void setApcList(List<Apc> apcList) {
        this.apcList = apcList;
    }

    @XmlTransient
    public List<Pc> getPcList() {
        return pcList;
    }

    public void setPcList(List<Pc> pcList) {
        this.pcList = pcList;
    }

    @XmlTransient
    public List<PoDetails> getPoDetailsList() {
        return poDetailsList;
    }

    public void setPoDetailsList(List<PoDetails> poDetailsList) {
        this.poDetailsList = poDetailsList;
    }

    @XmlTransient
    public List<Rfi> getRfiList() {
        return rfiList;
    }

    public void setRfiList(List<Rfi> rfiList) {
        this.rfiList = rfiList;
    }

    @XmlTransient
    public List<Aif> getAifList() {
        return aifList;
    }

    public void setAifList(List<Aif> aifList) {
        this.aifList = aifList;
    }

    public Asset getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(Asset idAsset) {
        this.idAsset = idAsset;
    }

    public Pr getIdPr() {
        return idPr;
    }

    public void setIdPr(Pr idPr) {
        this.idPr = idPr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPo != null ? idPo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Po)) {
            return false;
        }
        Po other = (Po) object;
        if ((this.idPo == null && other.idPo != null) || (this.idPo != null && !this.idPo.equals(other.idPo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Po[ idPo=" + idPo + " ]";
    }
    
}
