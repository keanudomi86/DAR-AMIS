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
    @UniqueConstraint(columnNames = {"id_ppmp"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ppmp.findAll", query = "SELECT p FROM Ppmp p")
    , @NamedQuery(name = "Ppmp.findByIdPpmp", query = "SELECT p FROM Ppmp p WHERE p.idPpmp = :idPpmp")})
public class Ppmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ppmp", nullable = false)
    private Integer idPpmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPpmp")
    private List<PpmpDetails> ppmpDetailsList;
    @OneToMany(mappedBy = "idPpmp")
    private List<Pr> prList;
    @JoinColumn(name = "id_office", referencedColumnName = "id_office", nullable = false)
    @ManyToOne(optional = false)
    private Office idOffice;

    public Ppmp() {
    }

    public Ppmp(Integer idPpmp) {
        this.idPpmp = idPpmp;
    }

    public Integer getIdPpmp() {
        return idPpmp;
    }

    public void setIdPpmp(Integer idPpmp) {
        this.idPpmp = idPpmp;
    }

    @XmlTransient
    public List<PpmpDetails> getPpmpDetailsList() {
        return ppmpDetailsList;
    }

    public void setPpmpDetailsList(List<PpmpDetails> ppmpDetailsList) {
        this.ppmpDetailsList = ppmpDetailsList;
    }

    @XmlTransient
    public List<Pr> getPrList() {
        return prList;
    }

    public void setPrList(List<Pr> prList) {
        this.prList = prList;
    }

    public Office getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Office idOffice) {
        this.idOffice = idOffice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPpmp != null ? idPpmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ppmp)) {
            return false;
        }
        Ppmp other = (Ppmp) object;
        if ((this.idPpmp == null && other.idPpmp != null) || (this.idPpmp != null && !this.idPpmp.equals(other.idPpmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ppmp[ idPpmp=" + idPpmp + " ]";
    }
    
}
