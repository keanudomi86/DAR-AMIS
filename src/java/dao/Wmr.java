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
    @UniqueConstraint(columnNames = {"id_wmr"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wmr.findAll", query = "SELECT w FROM Wmr w")
    , @NamedQuery(name = "Wmr.findByIdWmr", query = "SELECT w FROM Wmr w WHERE w.idWmr = :idWmr")})
public class Wmr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wmr", nullable = false)
    private Integer idWmr;
    @OneToMany(mappedBy = "idWmr")
    private List<FormRepo> formRepoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWmr")
    private List<Iirup> iirupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWmr")
    private List<WmrDetails> wmrDetailsList;

    public Wmr() {
    }

    public Wmr(Integer idWmr) {
        this.idWmr = idWmr;
    }

    public Integer getIdWmr() {
        return idWmr;
    }

    public void setIdWmr(Integer idWmr) {
        this.idWmr = idWmr;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    @XmlTransient
    public List<Iirup> getIirupList() {
        return iirupList;
    }

    public void setIirupList(List<Iirup> iirupList) {
        this.iirupList = iirupList;
    }

    @XmlTransient
    public List<WmrDetails> getWmrDetailsList() {
        return wmrDetailsList;
    }

    public void setWmrDetailsList(List<WmrDetails> wmrDetailsList) {
        this.wmrDetailsList = wmrDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWmr != null ? idWmr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wmr)) {
            return false;
        }
        Wmr other = (Wmr) object;
        if ((this.idWmr == null && other.idWmr != null) || (this.idWmr != null && !this.idWmr.equals(other.idWmr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Wmr[ idWmr=" + idWmr + " ]";
    }
    
}
