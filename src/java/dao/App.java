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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "App.findAll", query = "SELECT a FROM App a")
    , @NamedQuery(name = "App.findByIdAPP", query = "SELECT a FROM App a WHERE a.idAPP = :idAPP")
    , @NamedQuery(name = "App.findByCodePap", query = "SELECT a FROM App a WHERE a.codePap = :codePap")
    , @NamedQuery(name = "App.findByProcureProgProj", query = "SELECT a FROM App a WHERE a.procureProgProj = :procureProgProj")
    , @NamedQuery(name = "App.findByModeOfProcure", query = "SELECT a FROM App a WHERE a.modeOfProcure = :modeOfProcure")
    , @NamedQuery(name = "App.findBySepaAdpost", query = "SELECT a FROM App a WHERE a.sepaAdpost = :sepaAdpost")
    , @NamedQuery(name = "App.findBySepaSubOpenBids", query = "SELECT a FROM App a WHERE a.sepaSubOpenBids = :sepaSubOpenBids")
    , @NamedQuery(name = "App.findBySepaNoticeAward", query = "SELECT a FROM App a WHERE a.sepaNoticeAward = :sepaNoticeAward")
    , @NamedQuery(name = "App.findBySepaContractSigning", query = "SELECT a FROM App a WHERE a.sepaContractSigning = :sepaContractSigning")
    , @NamedQuery(name = "App.findBySourceOfFunds", query = "SELECT a FROM App a WHERE a.sourceOfFunds = :sourceOfFunds")
    , @NamedQuery(name = "App.findByEstimateBudgetTot", query = "SELECT a FROM App a WHERE a.estimateBudgetTot = :estimateBudgetTot")
    , @NamedQuery(name = "App.findByEstimatedBudgetMode", query = "SELECT a FROM App a WHERE a.estimatedBudgetMode = :estimatedBudgetMode")
    , @NamedQuery(name = "App.findByEstimatedBudgetCo", query = "SELECT a FROM App a WHERE a.estimatedBudgetCo = :estimatedBudgetCo")
    , @NamedQuery(name = "App.findByRemarks", query = "SELECT a FROM App a WHERE a.remarks = :remarks")})
public class App implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_APP")
    private Integer idAPP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code_pap")
    private String codePap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "procure_prog_proj")
    private String procureProgProj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mode_of_procure")
    private int modeOfProcure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sepa_adpost")
    private String sepaAdpost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sepa_sub_open_bids")
    private String sepaSubOpenBids;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sepa_notice_award")
    private String sepaNoticeAward;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sepa_contract_signing")
    private String sepaContractSigning;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "source_of_funds")
    private String sourceOfFunds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estimate_budget_tot")
    private float estimateBudgetTot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estimated_budget_mode")
    private String estimatedBudgetMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estimated_budget_co")
    private String estimatedBudgetCo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    private String remarks;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "id_APP", referencedColumnName = "id_PPMP", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ppmp ppmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enduser")
    private List<Pr> prList;

    public App() {
    }

    public App(Integer idAPP) {
        this.idAPP = idAPP;
    }

    public App(Integer idAPP, String codePap, String procureProgProj, int modeOfProcure, String sepaAdpost, String sepaSubOpenBids, String sepaNoticeAward, String sepaContractSigning, String sourceOfFunds, float estimateBudgetTot, String estimatedBudgetMode, String estimatedBudgetCo, String remarks) {
        this.idAPP = idAPP;
        this.codePap = codePap;
        this.procureProgProj = procureProgProj;
        this.modeOfProcure = modeOfProcure;
        this.sepaAdpost = sepaAdpost;
        this.sepaSubOpenBids = sepaSubOpenBids;
        this.sepaNoticeAward = sepaNoticeAward;
        this.sepaContractSigning = sepaContractSigning;
        this.sourceOfFunds = sourceOfFunds;
        this.estimateBudgetTot = estimateBudgetTot;
        this.estimatedBudgetMode = estimatedBudgetMode;
        this.estimatedBudgetCo = estimatedBudgetCo;
        this.remarks = remarks;
    }

    public Integer getIdAPP() {
        return idAPP;
    }

    public void setIdAPP(Integer idAPP) {
        this.idAPP = idAPP;
    }

    public String getCodePap() {
        return codePap;
    }

    public void setCodePap(String codePap) {
        this.codePap = codePap;
    }

    public String getProcureProgProj() {
        return procureProgProj;
    }

    public void setProcureProgProj(String procureProgProj) {
        this.procureProgProj = procureProgProj;
    }

    public int getModeOfProcure() {
        return modeOfProcure;
    }

    public void setModeOfProcure(int modeOfProcure) {
        this.modeOfProcure = modeOfProcure;
    }

    public String getSepaAdpost() {
        return sepaAdpost;
    }

    public void setSepaAdpost(String sepaAdpost) {
        this.sepaAdpost = sepaAdpost;
    }

    public String getSepaSubOpenBids() {
        return sepaSubOpenBids;
    }

    public void setSepaSubOpenBids(String sepaSubOpenBids) {
        this.sepaSubOpenBids = sepaSubOpenBids;
    }

    public String getSepaNoticeAward() {
        return sepaNoticeAward;
    }

    public void setSepaNoticeAward(String sepaNoticeAward) {
        this.sepaNoticeAward = sepaNoticeAward;
    }

    public String getSepaContractSigning() {
        return sepaContractSigning;
    }

    public void setSepaContractSigning(String sepaContractSigning) {
        this.sepaContractSigning = sepaContractSigning;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public float getEstimateBudgetTot() {
        return estimateBudgetTot;
    }

    public void setEstimateBudgetTot(float estimateBudgetTot) {
        this.estimateBudgetTot = estimateBudgetTot;
    }

    public String getEstimatedBudgetMode() {
        return estimatedBudgetMode;
    }

    public void setEstimatedBudgetMode(String estimatedBudgetMode) {
        this.estimatedBudgetMode = estimatedBudgetMode;
    }

    public String getEstimatedBudgetCo() {
        return estimatedBudgetCo;
    }

    public void setEstimatedBudgetCo(String estimatedBudgetCo) {
        this.estimatedBudgetCo = estimatedBudgetCo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Ppmp getPpmp() {
        return ppmp;
    }

    public void setPpmp(Ppmp ppmp) {
        this.ppmp = ppmp;
    }

    @XmlTransient
    public List<Pr> getPrList() {
        return prList;
    }

    public void setPrList(List<Pr> prList) {
        this.prList = prList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAPP != null ? idAPP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof App)) {
            return false;
        }
        App other = (App) object;
        if ((this.idAPP == null && other.idAPP != null) || (this.idAPP != null && !this.idAPP.equals(other.idAPP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.App[ idAPP=" + idAPP + " ]";
    }
    
}
