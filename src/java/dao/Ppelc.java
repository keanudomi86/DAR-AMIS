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
    @UniqueConstraint(columnNames = {"id_ppelc"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ppelc.findAll", query = "SELECT p FROM Ppelc p")
    , @NamedQuery(name = "Ppelc.findByIdPpelc", query = "SELECT p FROM Ppelc p WHERE p.idPpelc = :idPpelc")})
public class Ppelc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ppelc", nullable = false)
    private Integer idPpelc;
    @JoinColumn(name = "id_pc", referencedColumnName = "id_pc", nullable = false)
    @ManyToOne(optional = false)
    private Pc idPc;
    @OneToMany(mappedBy = "idPpelc")
    private List<FormRepo> formRepoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPpelc")
    private List<Iirup> iirupList;

    public Ppelc() {
    }

    public Ppelc(Integer idPpelc) {
        this.idPpelc = idPpelc;
    }

    public Integer getIdPpelc() {
        return idPpelc;
    }

    public void setIdPpelc(Integer idPpelc) {
        this.idPpelc = idPpelc;
    }

    public Pc getIdPc() {
        return idPc;
    }

    public void setIdPc(Pc idPc) {
        this.idPc = idPc;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPpelc != null ? idPpelc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ppelc)) {
            return false;
        }
        Ppelc other = (Ppelc) object;
        if ((this.idPpelc == null && other.idPpelc != null) || (this.idPpelc != null && !this.idPpelc.equals(other.idPpelc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ppelc[ idPpelc=" + idPpelc + " ]";
    }
    
}
