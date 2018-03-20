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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pr"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pr.findAll", query = "SELECT p FROM Pr p")
    , @NamedQuery(name = "Pr.findByIdPr", query = "SELECT p FROM Pr p WHERE p.idPr = :idPr")
    , @NamedQuery(name = "Pr.findByIdSc", query = "SELECT p FROM Pr p WHERE p.idSc = :idSc")
    , @NamedQuery(name = "Pr.findByIdPc", query = "SELECT p FROM Pr p WHERE p.idPc = :idPc")
    , @NamedQuery(name = "Pr.findByEntityName", query = "SELECT p FROM Pr p WHERE p.entityName = :entityName")
    , @NamedQuery(name = "Pr.findByDate", query = "SELECT p FROM Pr p WHERE p.date = :date")
    , @NamedQuery(name = "Pr.findByFundCluster", query = "SELECT p FROM Pr p WHERE p.fundCluster = :fundCluster")
    , @NamedQuery(name = "Pr.findByResponsibilityCenterCode", query = "SELECT p FROM Pr p WHERE p.responsibilityCenterCode = :responsibilityCenterCode")})
public class Pr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pr", nullable = false)
    private Integer idPr;
    @Column(name = "id_sc")
    private Integer idSc;
    @Column(name = "id_pc")
    private Integer idPc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "entity_name", nullable = false, length = 45)
    private String entityName;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
    @Size(max = 45)
    @Column(name = "responsibility_center_code", length = 45)
    private String responsibilityCenterCode;
    @JoinColumn(name = "id_app", referencedColumnName = "id_app")
    @ManyToOne
    private App idApp;
    @JoinColumn(name = "id_office", referencedColumnName = "id_office")
    @ManyToOne
    private Office idOffice;
    @JoinColumn(name = "id_ppmp", referencedColumnName = "id_ppmp")
    @ManyToOne
    private Ppmp idPpmp;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris")
    @ManyToOne
    private Ris idRis;
    @JoinColumn(name = "id_wfp", referencedColumnName = "id_wfp")
    @ManyToOne
    private Wfp idWfp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPr")
    private List<PrDetails> prDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPr")
    private List<Sc> scList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPr")
    private List<Pc> pcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPr")
    private List<Po> poList;

    public Pr() {
    }

    public Pr(Integer idPr) {
        this.idPr = idPr;
    }

    public Pr(Integer idPr, String entityName, Date date) {
        this.idPr = idPr;
        this.entityName = entityName;
        this.date = date;
    }

    public Integer getIdPr() {
        return idPr;
    }

    public void setIdPr(Integer idPr) {
        this.idPr = idPr;
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

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
    }

    public String getResponsibilityCenterCode() {
        return responsibilityCenterCode;
    }

    public void setResponsibilityCenterCode(String responsibilityCenterCode) {
        this.responsibilityCenterCode = responsibilityCenterCode;
    }

    public App getIdApp() {
        return idApp;
    }

    public void setIdApp(App idApp) {
        this.idApp = idApp;
    }

    public Office getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Office idOffice) {
        this.idOffice = idOffice;
    }

    public Ppmp getIdPpmp() {
        return idPpmp;
    }

    public void setIdPpmp(Ppmp idPpmp) {
        this.idPpmp = idPpmp;
    }

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    public Wfp getIdWfp() {
        return idWfp;
    }

    public void setIdWfp(Wfp idWfp) {
        this.idWfp = idWfp;
    }

    @XmlTransient
    public List<PrDetails> getPrDetailsList() {
        return prDetailsList;
    }

    public void setPrDetailsList(List<PrDetails> prDetailsList) {
        this.prDetailsList = prDetailsList;
    }

    @XmlTransient
    public List<Sc> getScList() {
        return scList;
    }

    public void setScList(List<Sc> scList) {
        this.scList = scList;
    }

    @XmlTransient
    public List<Pc> getPcList() {
        return pcList;
    }

    public void setPcList(List<Pc> pcList) {
        this.pcList = pcList;
    }

    @XmlTransient
    public List<Po> getPoList() {
        return poList;
    }

    public void setPoList(List<Po> poList) {
        this.poList = poList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPr != null ? idPr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pr)) {
            return false;
        }
        Pr other = (Pr) object;
        if ((this.idPr == null && other.idPr != null) || (this.idPr != null && !this.idPr.equals(other.idPr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Pr[ idPr=" + idPr + " ]";
    }
    
}
