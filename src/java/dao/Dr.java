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
    @UniqueConstraint(columnNames = {"id_dr"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dr.findAll", query = "SELECT d FROM Dr d")
    , @NamedQuery(name = "Dr.findByIdDr", query = "SELECT d FROM Dr d WHERE d.idDr = :idDr")
    , @NamedQuery(name = "Dr.findByIdSc", query = "SELECT d FROM Dr d WHERE d.idSc = :idSc")
    , @NamedQuery(name = "Dr.findByIdPc", query = "SELECT d FROM Dr d WHERE d.idPc = :idPc")})
public class Dr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dr", nullable = false)
    private Integer idDr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sc", nullable = false)
    private int idSc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pc", nullable = false)
    private int idPc;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDr")
    private List<Sc> scList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDr")
    private List<Pc> pcList;

    public Dr() {
    }

    public Dr(Integer idDr) {
        this.idDr = idDr;
    }

    public Dr(Integer idDr, int idSc, int idPc) {
        this.idDr = idDr;
        this.idSc = idSc;
        this.idPc = idPc;
    }

    public Integer getIdDr() {
        return idDr;
    }

    public void setIdDr(Integer idDr) {
        this.idDr = idDr;
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

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDr != null ? idDr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dr)) {
            return false;
        }
        Dr other = (Dr) object;
        if ((this.idDr == null && other.idDr != null) || (this.idDr != null && !this.idDr.equals(other.idDr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Dr[ idDr=" + idDr + " ]";
    }
    
}
