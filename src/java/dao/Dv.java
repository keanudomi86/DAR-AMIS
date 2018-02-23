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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dv.findAll", query = "SELECT d FROM Dv d")
    , @NamedQuery(name = "Dv.findByIdDV", query = "SELECT d FROM Dv d WHERE d.idDV = :idDV")
    , @NamedQuery(name = "Dv.findByIdFundCluster", query = "SELECT d FROM Dv d WHERE d.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Dv.findByDate", query = "SELECT d FROM Dv d WHERE d.date = :date")
    , @NamedQuery(name = "Dv.findByDvNum", query = "SELECT d FROM Dv d WHERE d.dvNum = :dvNum")
    , @NamedQuery(name = "Dv.findByPayee", query = "SELECT d FROM Dv d WHERE d.payee = :payee")
    , @NamedQuery(name = "Dv.findByTinEmpNum", query = "SELECT d FROM Dv d WHERE d.tinEmpNum = :tinEmpNum")
    , @NamedQuery(name = "Dv.findByOrsBursNum", query = "SELECT d FROM Dv d WHERE d.orsBursNum = :orsBursNum")
    , @NamedQuery(name = "Dv.findByAddress", query = "SELECT d FROM Dv d WHERE d.address = :address")
    , @NamedQuery(name = "Dv.findByParticulars", query = "SELECT d FROM Dv d WHERE d.particulars = :particulars")
    , @NamedQuery(name = "Dv.findByRespCenter", query = "SELECT d FROM Dv d WHERE d.respCenter = :respCenter")
    , @NamedQuery(name = "Dv.findByMfoPap", query = "SELECT d FROM Dv d WHERE d.mfoPap = :mfoPap")
    , @NamedQuery(name = "Dv.findByAmount", query = "SELECT d FROM Dv d WHERE d.amount = :amount")
    , @NamedQuery(name = "Dv.findByAmountDue", query = "SELECT d FROM Dv d WHERE d.amountDue = :amountDue")
    , @NamedQuery(name = "Dv.findByCertifiedSignSupervisor", query = "SELECT d FROM Dv d WHERE d.certifiedSignSupervisor = :certifiedSignSupervisor")
    , @NamedQuery(name = "Dv.findByAeAccountTitle", query = "SELECT d FROM Dv d WHERE d.aeAccountTitle = :aeAccountTitle")
    , @NamedQuery(name = "Dv.findByAeUacsCode", query = "SELECT d FROM Dv d WHERE d.aeUacsCode = :aeUacsCode")
    , @NamedQuery(name = "Dv.findByAeDebit", query = "SELECT d FROM Dv d WHERE d.aeDebit = :aeDebit")
    , @NamedQuery(name = "Dv.findByAeCredit", query = "SELECT d FROM Dv d WHERE d.aeCredit = :aeCredit")
    , @NamedQuery(name = "Dv.findByCertified", query = "SELECT d FROM Dv d WHERE d.certified = :certified")
    , @NamedQuery(name = "Dv.findByApprovedForPayment", query = "SELECT d FROM Dv d WHERE d.approvedForPayment = :approvedForPayment")})
public class Dv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_DV")
    private Integer idDV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dv_num")
    private int dvNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String payee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tin_emp_num")
    private int tinEmpNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ors_burs_num")
    private int orsBursNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String address;
    @Size(max = 45)
    private String particulars;
    @Size(max = 45)
    @Column(name = "resp_center")
    private String respCenter;
    @Size(max = 45)
    @Column(name = "mfo_pap")
    private String mfoPap;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float amount;
    @Column(name = "amount_due")
    private Integer amountDue;
    @Size(max = 45)
    @Column(name = "certified_sign_supervisor")
    private String certifiedSignSupervisor;
    @Size(max = 45)
    @Column(name = "ae_account_title")
    private String aeAccountTitle;
    @Size(max = 45)
    @Column(name = "ae_uacs_code")
    private String aeUacsCode;
    @Size(max = 45)
    @Column(name = "ae_debit")
    private String aeDebit;
    @Size(max = 45)
    @Column(name = "ae_credit")
    private String aeCredit;
    private Integer certified;
    @Size(max = 45)
    @Column(name = "approved_for_payment")
    private String approvedForPayment;
    @JoinColumn(name = "id_item", referencedColumnName = "id_GeneralInventory")
    @ManyToOne(optional = false)
    private Generalinventory idItem;

    public Dv() {
    }

    public Dv(Integer idDV) {
        this.idDV = idDV;
    }

    public Dv(Integer idDV, int idFundCluster, Date date, int dvNum, String payee, int tinEmpNum, int orsBursNum, String address) {
        this.idDV = idDV;
        this.idFundCluster = idFundCluster;
        this.date = date;
        this.dvNum = dvNum;
        this.payee = payee;
        this.tinEmpNum = tinEmpNum;
        this.orsBursNum = orsBursNum;
        this.address = address;
    }

    public Integer getIdDV() {
        return idDV;
    }

    public void setIdDV(Integer idDV) {
        this.idDV = idDV;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDvNum() {
        return dvNum;
    }

    public void setDvNum(int dvNum) {
        this.dvNum = dvNum;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public int getTinEmpNum() {
        return tinEmpNum;
    }

    public void setTinEmpNum(int tinEmpNum) {
        this.tinEmpNum = tinEmpNum;
    }

    public int getOrsBursNum() {
        return orsBursNum;
    }

    public void setOrsBursNum(int orsBursNum) {
        this.orsBursNum = orsBursNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getRespCenter() {
        return respCenter;
    }

    public void setRespCenter(String respCenter) {
        this.respCenter = respCenter;
    }

    public String getMfoPap() {
        return mfoPap;
    }

    public void setMfoPap(String mfoPap) {
        this.mfoPap = mfoPap;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Integer amountDue) {
        this.amountDue = amountDue;
    }

    public String getCertifiedSignSupervisor() {
        return certifiedSignSupervisor;
    }

    public void setCertifiedSignSupervisor(String certifiedSignSupervisor) {
        this.certifiedSignSupervisor = certifiedSignSupervisor;
    }

    public String getAeAccountTitle() {
        return aeAccountTitle;
    }

    public void setAeAccountTitle(String aeAccountTitle) {
        this.aeAccountTitle = aeAccountTitle;
    }

    public String getAeUacsCode() {
        return aeUacsCode;
    }

    public void setAeUacsCode(String aeUacsCode) {
        this.aeUacsCode = aeUacsCode;
    }

    public String getAeDebit() {
        return aeDebit;
    }

    public void setAeDebit(String aeDebit) {
        this.aeDebit = aeDebit;
    }

    public String getAeCredit() {
        return aeCredit;
    }

    public void setAeCredit(String aeCredit) {
        this.aeCredit = aeCredit;
    }

    public Integer getCertified() {
        return certified;
    }

    public void setCertified(Integer certified) {
        this.certified = certified;
    }

    public String getApprovedForPayment() {
        return approvedForPayment;
    }

    public void setApprovedForPayment(String approvedForPayment) {
        this.approvedForPayment = approvedForPayment;
    }

    public Generalinventory getIdItem() {
        return idItem;
    }

    public void setIdItem(Generalinventory idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDV != null ? idDV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dv)) {
            return false;
        }
        Dv other = (Dv) object;
        if ((this.idDV == null && other.idDV != null) || (this.idDV != null && !this.idDV.equals(other.idDV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Dv[ idDV=" + idDV + " ]";
    }
    
}
