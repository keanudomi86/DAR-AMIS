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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Po.findByIdPc", query = "SELECT p FROM Po p WHERE p.idPc = :idPc")})
public class Po implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_po", nullable = false)
    private Integer idPo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sc", nullable = false)
    private int idSc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pc", nullable = false)
    private int idPc;
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
    @JoinColumn(name = "id_asset", referencedColumnName = "id_asset", nullable = false)
    @ManyToOne(optional = false)
    private Asset idAsset;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;

    public Po() {
    }

    public Po(Integer idPo) {
        this.idPo = idPo;
    }

    public Po(Integer idPo, int idSc, int idPc) {
        this.idPo = idPo;
        this.idSc = idSc;
        this.idPc = idPc;
    }

    public Integer getIdPo() {
        return idPo;
    }

    public void setIdPo(Integer idPo) {
        this.idPo = idPo;
    }

    public int getIdSc() {
        return idSc;
    }

    public void setIdSc(int idSc) {
        this.idSc = idSc;
    }

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
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
