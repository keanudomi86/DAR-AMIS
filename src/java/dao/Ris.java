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
import javax.persistence.Id;
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
    @UniqueConstraint(columnNames = {"id_ris"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ris.findAll", query = "SELECT r FROM Ris r")
    , @NamedQuery(name = "Ris.findByIdRis", query = "SELECT r FROM Ris r WHERE r.idRis = :idRis")
    , @NamedQuery(name = "Ris.findByIdSc", query = "SELECT r FROM Ris r WHERE r.idSc = :idSc")})
public class Ris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ris", nullable = false)
    private Integer idRis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sc", nullable = false)
    private int idSc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRis")
    private List<Pr> prList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRis")
    private List<Sc> scList;

    public Ris() {
    }

    public Ris(Integer idRis) {
        this.idRis = idRis;
    }

    public Ris(Integer idRis, int idSc) {
        this.idRis = idRis;
        this.idSc = idSc;
    }

    public Integer getIdRis() {
        return idRis;
    }

    public void setIdRis(Integer idRis) {
        this.idRis = idRis;
    }

    public int getIdSc() {
        return idSc;
    }

    public void setIdSc(int idSc) {
        this.idSc = idSc;
    }

    @XmlTransient
    public List<Pr> getPrList() {
        return prList;
    }

    public void setPrList(List<Pr> prList) {
        this.prList = prList;
    }

    @XmlTransient
    public List<Sc> getScList() {
        return scList;
    }

    public void setScList(List<Sc> scList) {
        this.scList = scList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRis != null ? idRis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ris)) {
            return false;
        }
        Ris other = (Ris) object;
        if ((this.idRis == null && other.idRis != null) || (this.idRis != null && !this.idRis.equals(other.idRis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ris[ idRis=" + idRis + " ]";
    }
    
}
