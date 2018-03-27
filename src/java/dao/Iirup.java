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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_iirup"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iirup.findAll", query = "SELECT i FROM Iirup i")
    , @NamedQuery(name = "Iirup.findByIdIirup", query = "SELECT i FROM Iirup i WHERE i.idIirup = :idIirup")})
public class Iirup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_iirup", nullable = false)
    private Integer idIirup;
    @OneToMany(mappedBy = "idIirup")
    private List<FormRepo> formRepoList;
    @JoinColumn(name = "id_ppelc", referencedColumnName = "id_ppelc", nullable = false)
    @ManyToOne(optional = false)
    private Ppelc idPpelc;
    @JoinColumn(name = "id_wmr", referencedColumnName = "id_wmr", nullable = false)
    @ManyToOne(optional = false)
    private Wmr idWmr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIirup")
    private List<IirupDetails> iirupDetailsList;

    public Iirup() {
    }

    public Iirup(Integer idIirup) {
        this.idIirup = idIirup;
    }

    public Integer getIdIirup() {
        return idIirup;
    }

    public void setIdIirup(Integer idIirup) {
        this.idIirup = idIirup;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    public Ppelc getIdPpelc() {
        return idPpelc;
    }

    public void setIdPpelc(Ppelc idPpelc) {
        this.idPpelc = idPpelc;
    }

    public Wmr getIdWmr() {
        return idWmr;
    }

    public void setIdWmr(Wmr idWmr) {
        this.idWmr = idWmr;
    }

    @XmlTransient
    public List<IirupDetails> getIirupDetailsList() {
        return iirupDetailsList;
    }

    public void setIirupDetailsList(List<IirupDetails> iirupDetailsList) {
        this.iirupDetailsList = iirupDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIirup != null ? idIirup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iirup)) {
            return false;
        }
        Iirup other = (Iirup) object;
        if ((this.idIirup == null && other.idIirup != null) || (this.idIirup != null && !this.idIirup.equals(other.idIirup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Iirup[ idIirup=" + idIirup + " ]";
    }
    
}
