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
    @NamedQuery(name = "Ppmp.findAll", query = "SELECT p FROM Ppmp p")
    , @NamedQuery(name = "Ppmp.findByIdPPMP", query = "SELECT p FROM Ppmp p WHERE p.idPPMP = :idPPMP")
    , @NamedQuery(name = "Ppmp.findByEnduser", query = "SELECT p FROM Ppmp p WHERE p.enduser = :enduser")
    , @NamedQuery(name = "Ppmp.findByCode", query = "SELECT p FROM Ppmp p WHERE p.code = :code")
    , @NamedQuery(name = "Ppmp.findByGenDescription", query = "SELECT p FROM Ppmp p WHERE p.genDescription = :genDescription")
    , @NamedQuery(name = "Ppmp.findBySize", query = "SELECT p FROM Ppmp p WHERE p.size = :size")
    , @NamedQuery(name = "Ppmp.findByEstimatedBudget", query = "SELECT p FROM Ppmp p WHERE p.estimatedBudget = :estimatedBudget")
    , @NamedQuery(name = "Ppmp.findByModeOfProcure", query = "SELECT p FROM Ppmp p WHERE p.modeOfProcure = :modeOfProcure")
    , @NamedQuery(name = "Ppmp.findBySchJan", query = "SELECT p FROM Ppmp p WHERE p.schJan = :schJan")
    , @NamedQuery(name = "Ppmp.findBySchFeb", query = "SELECT p FROM Ppmp p WHERE p.schFeb = :schFeb")
    , @NamedQuery(name = "Ppmp.findBySchMar", query = "SELECT p FROM Ppmp p WHERE p.schMar = :schMar")
    , @NamedQuery(name = "Ppmp.findBySchApr", query = "SELECT p FROM Ppmp p WHERE p.schApr = :schApr")
    , @NamedQuery(name = "Ppmp.findBySchMay", query = "SELECT p FROM Ppmp p WHERE p.schMay = :schMay")
    , @NamedQuery(name = "Ppmp.findBySchJun", query = "SELECT p FROM Ppmp p WHERE p.schJun = :schJun")
    , @NamedQuery(name = "Ppmp.findBySchJul", query = "SELECT p FROM Ppmp p WHERE p.schJul = :schJul")
    , @NamedQuery(name = "Ppmp.findBySchAug", query = "SELECT p FROM Ppmp p WHERE p.schAug = :schAug")
    , @NamedQuery(name = "Ppmp.findBySchSep", query = "SELECT p FROM Ppmp p WHERE p.schSep = :schSep")
    , @NamedQuery(name = "Ppmp.findBySchOct", query = "SELECT p FROM Ppmp p WHERE p.schOct = :schOct")
    , @NamedQuery(name = "Ppmp.findBySchNov", query = "SELECT p FROM Ppmp p WHERE p.schNov = :schNov")
    , @NamedQuery(name = "Ppmp.findBySchDec", query = "SELECT p FROM Ppmp p WHERE p.schDec = :schDec")})
public class Ppmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_PPMP")
    private Integer idPPMP;
    @Basic(optional = false)
    @NotNull
    private int enduser;
    @Basic(optional = false)
    @NotNull
    private int code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "gen_description")
    private String genDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estimated_budget")
    private float estimatedBudget;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mode_of_procure")
    private int modeOfProcure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_jan")
    private String schJan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_feb")
    private String schFeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_mar")
    private String schMar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_apr")
    private String schApr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_may")
    private String schMay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_jun")
    private String schJun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_jul")
    private String schJul;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_aug")
    private String schAug;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_sep")
    private String schSep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_oct")
    private String schOct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_nov")
    private String schNov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sch_dec")
    private String schDec;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ppmp")
    private App app;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enduser1")
    private List<Pr> prList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "id_PPMP", referencedColumnName = "id_workfinplan", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Wfp wfp;

    public Ppmp() {
    }

    public Ppmp(Integer idPPMP) {
        this.idPPMP = idPPMP;
    }

    public Ppmp(Integer idPPMP, int enduser, int code, String genDescription, String size, float estimatedBudget, int modeOfProcure, String schJan, String schFeb, String schMar, String schApr, String schMay, String schJun, String schJul, String schAug, String schSep, String schOct, String schNov, String schDec) {
        this.idPPMP = idPPMP;
        this.enduser = enduser;
        this.code = code;
        this.genDescription = genDescription;
        this.size = size;
        this.estimatedBudget = estimatedBudget;
        this.modeOfProcure = modeOfProcure;
        this.schJan = schJan;
        this.schFeb = schFeb;
        this.schMar = schMar;
        this.schApr = schApr;
        this.schMay = schMay;
        this.schJun = schJun;
        this.schJul = schJul;
        this.schAug = schAug;
        this.schSep = schSep;
        this.schOct = schOct;
        this.schNov = schNov;
        this.schDec = schDec;
    }

    public Integer getIdPPMP() {
        return idPPMP;
    }

    public void setIdPPMP(Integer idPPMP) {
        this.idPPMP = idPPMP;
    }

    public int getEnduser() {
        return enduser;
    }

    public void setEnduser(int enduser) {
        this.enduser = enduser;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getGenDescription() {
        return genDescription;
    }

    public void setGenDescription(String genDescription) {
        this.genDescription = genDescription;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(float estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public int getModeOfProcure() {
        return modeOfProcure;
    }

    public void setModeOfProcure(int modeOfProcure) {
        this.modeOfProcure = modeOfProcure;
    }

    public String getSchJan() {
        return schJan;
    }

    public void setSchJan(String schJan) {
        this.schJan = schJan;
    }

    public String getSchFeb() {
        return schFeb;
    }

    public void setSchFeb(String schFeb) {
        this.schFeb = schFeb;
    }

    public String getSchMar() {
        return schMar;
    }

    public void setSchMar(String schMar) {
        this.schMar = schMar;
    }

    public String getSchApr() {
        return schApr;
    }

    public void setSchApr(String schApr) {
        this.schApr = schApr;
    }

    public String getSchMay() {
        return schMay;
    }

    public void setSchMay(String schMay) {
        this.schMay = schMay;
    }

    public String getSchJun() {
        return schJun;
    }

    public void setSchJun(String schJun) {
        this.schJun = schJun;
    }

    public String getSchJul() {
        return schJul;
    }

    public void setSchJul(String schJul) {
        this.schJul = schJul;
    }

    public String getSchAug() {
        return schAug;
    }

    public void setSchAug(String schAug) {
        this.schAug = schAug;
    }

    public String getSchSep() {
        return schSep;
    }

    public void setSchSep(String schSep) {
        this.schSep = schSep;
    }

    public String getSchOct() {
        return schOct;
    }

    public void setSchOct(String schOct) {
        this.schOct = schOct;
    }

    public String getSchNov() {
        return schNov;
    }

    public void setSchNov(String schNov) {
        this.schNov = schNov;
    }

    public String getSchDec() {
        return schDec;
    }

    public void setSchDec(String schDec) {
        this.schDec = schDec;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    @XmlTransient
    public List<Pr> getPrList() {
        return prList;
    }

    public void setPrList(List<Pr> prList) {
        this.prList = prList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Wfp getWfp() {
        return wfp;
    }

    public void setWfp(Wfp wfp) {
        this.wfp = wfp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPPMP != null ? idPPMP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ppmp)) {
            return false;
        }
        Ppmp other = (Ppmp) object;
        if ((this.idPPMP == null && other.idPPMP != null) || (this.idPPMP != null && !this.idPPMP.equals(other.idPPMP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ppmp[ idPPMP=" + idPPMP + " ]";
    }
    
}
