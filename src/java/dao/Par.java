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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @UniqueConstraint(columnNames = {"id_par"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Par.findAll", query = "SELECT p FROM Par p")
    , @NamedQuery(name = "Par.findByIdPar", query = "SELECT p FROM Par p WHERE p.idPar = :idPar")
    , @NamedQuery(name = "Par.findByIdPc", query = "SELECT p FROM Par p WHERE p.idPc = :idPc")})
public class Par implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_par", nullable = false)
    private Integer idPar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pc", nullable = false)
    private int idPc;
    @JoinColumn(name = "id_par", referencedColumnName = "idpar_details", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ParDetails parDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPar")
    private List<Ptr> ptrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPar")
    private List<Pc> pcList;

    public Par() {
    }

    public Par(Integer idPar) {
        this.idPar = idPar;
    }

    public Par(Integer idPar, int idPc) {
        this.idPar = idPar;
        this.idPc = idPc;
    }

    public Integer getIdPar() {
        return idPar;
    }

    public void setIdPar(Integer idPar) {
        this.idPar = idPar;
    }

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
    }

    public ParDetails getParDetails() {
        return parDetails;
    }

    public void setParDetails(ParDetails parDetails) {
        this.parDetails = parDetails;
    }

    @XmlTransient
    public List<Ptr> getPtrList() {
        return ptrList;
    }

    public void setPtrList(List<Ptr> ptrList) {
        this.ptrList = ptrList;
    }

    @XmlTransient
    public List<Pc> getPcList() {
        return pcList;
    }

    public void setPcList(List<Pc> pcList) {
        this.pcList = pcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPar != null ? idPar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Par)) {
            return false;
        }
        Par other = (Par) object;
        if ((this.idPar == null && other.idPar != null) || (this.idPar != null && !this.idPar.equals(other.idPar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Par[ idPar=" + idPar + " ]";
    }
    
}
