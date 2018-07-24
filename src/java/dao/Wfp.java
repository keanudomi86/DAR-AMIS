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
    @UniqueConstraint(columnNames = {"id_wfp"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wfp.findAll", query = "SELECT w FROM Wfp w")
    , @NamedQuery(name = "Wfp.findByIdWfp", query = "SELECT w FROM Wfp w WHERE w.idWfp = :idWfp")})
public class Wfp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wfp", nullable = false)
    private Integer idWfp;
    @JoinColumn(name = "id_office", referencedColumnName = "id_office", nullable = false)
    @ManyToOne(optional = false)
    private Office idOffice;
    @OneToMany(mappedBy = "idWfp")
    private List<Pr> prList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWfp")
    private List<WfpDetails> wfpDetailsList;

    public Wfp() {
    }

    public Wfp(Integer idWfp) {
        this.idWfp = idWfp;
    }

    public Integer getIdWfp() {
        return idWfp;
    }

    public void setIdWfp(Integer idWfp) {
        this.idWfp = idWfp;
    }

    public Office getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Office idOffice) {
        this.idOffice = idOffice;
    }

    @XmlTransient
    public List<Pr> getPrList() {
        return prList;
    }

    public void setPrList(List<Pr> prList) {
        this.prList = prList;
    }

    @XmlTransient
    public List<WfpDetails> getWfpDetailsList() {
        return wfpDetailsList;
    }

    public void setWfpDetailsList(List<WfpDetails> wfpDetailsList) {
        this.wfpDetailsList = wfpDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWfp != null ? idWfp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wfp)) {
            return false;
        }
        Wfp other = (Wfp) object;
        if ((this.idWfp == null && other.idWfp != null) || (this.idWfp != null && !this.idWfp.equals(other.idWfp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Wfp[ idWfp=" + idWfp + " ]";
    }
    
}
