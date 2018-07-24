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
    @UniqueConstraint(columnNames = {"id_ptr"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ptr.findAll", query = "SELECT p FROM Ptr p")
    , @NamedQuery(name = "Ptr.findByIdPtr", query = "SELECT p FROM Ptr p WHERE p.idPtr = :idPtr")})
public class Ptr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ptr", nullable = false)
    private Integer idPtr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPtr")
    private List<PtrDetails> ptrDetailsList;
    @OneToMany(mappedBy = "idPtr")
    private List<FormRepo> formRepoList;
    @JoinColumn(name = "id_ics", referencedColumnName = "id_ics", nullable = false)
    @ManyToOne(optional = false)
    private Ics idIcs;
    @JoinColumn(name = "id_par", referencedColumnName = "id_par", nullable = false)
    @ManyToOne(optional = false)
    private Par idPar;

    public Ptr() {
    }

    public Ptr(Integer idPtr) {
        this.idPtr = idPtr;
    }

    public Integer getIdPtr() {
        return idPtr;
    }

    public void setIdPtr(Integer idPtr) {
        this.idPtr = idPtr;
    }

    @XmlTransient
    public List<PtrDetails> getPtrDetailsList() {
        return ptrDetailsList;
    }

    public void setPtrDetailsList(List<PtrDetails> ptrDetailsList) {
        this.ptrDetailsList = ptrDetailsList;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    public Ics getIdIcs() {
        return idIcs;
    }

    public void setIdIcs(Ics idIcs) {
        this.idIcs = idIcs;
    }

    public Par getIdPar() {
        return idPar;
    }

    public void setIdPar(Par idPar) {
        this.idPar = idPar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPtr != null ? idPtr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ptr)) {
            return false;
        }
        Ptr other = (Ptr) object;
        if ((this.idPtr == null && other.idPtr != null) || (this.idPtr != null && !this.idPtr.equals(other.idPtr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ptr[ idPtr=" + idPtr + " ]";
    }
    
}
