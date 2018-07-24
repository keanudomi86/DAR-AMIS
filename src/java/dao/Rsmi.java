/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_rsmi"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rsmi.findAll", query = "SELECT r FROM Rsmi r")
    , @NamedQuery(name = "Rsmi.findByIdRsmi", query = "SELECT r FROM Rsmi r WHERE r.idRsmi = :idRsmi")})
public class Rsmi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rsmi", nullable = false)
    private Integer idRsmi;
    @OneToMany(mappedBy = "idRsmi")
    private List<FormRepo> formRepoList;
    @JoinColumn(name = "id_dr", referencedColumnName = "id_dr", nullable = false)
    @ManyToOne(optional = false)
    private Dr idDr;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris", nullable = false)
    @ManyToOne(optional = false)
    private Ris idRis;

    public Rsmi() {
    }

    public Rsmi(Integer idRsmi) {
        this.idRsmi = idRsmi;
    }

    public Integer getIdRsmi() {
        return idRsmi;
    }

    public void setIdRsmi(Integer idRsmi) {
        this.idRsmi = idRsmi;
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

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRsmi != null ? idRsmi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rsmi)) {
            return false;
        }
        Rsmi other = (Rsmi) object;
        if ((this.idRsmi == null && other.idRsmi != null) || (this.idRsmi != null && !this.idRsmi.equals(other.idRsmi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rsmi[ idRsmi=" + idRsmi + " ]";
    }
    
}
