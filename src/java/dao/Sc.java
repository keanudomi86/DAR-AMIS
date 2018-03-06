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
    @UniqueConstraint(columnNames = {"id_sc"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sc.findAll", query = "SELECT s FROM Sc s")
    , @NamedQuery(name = "Sc.findByIdSc", query = "SELECT s FROM Sc s WHERE s.idSc = :idSc")})
public class Sc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sc", nullable = false)
    private Integer idSc;
    @JoinColumn(name = "id_dr", referencedColumnName = "id_dr", nullable = false)
    @ManyToOne(optional = false)
    private Dr idDr;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris", nullable = false)
    @ManyToOne(optional = false)
    private Ris idRis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSc")
    private List<Rpci> rpciList;

    public Sc() {
    }

    public Sc(Integer idSc) {
        this.idSc = idSc;
    }

    public Integer getIdSc() {
        return idSc;
    }

    public void setIdSc(Integer idSc) {
        this.idSc = idSc;
    }

    public Dr getIdDr() {
        return idDr;
    }

    public void setIdDr(Dr idDr) {
        this.idDr = idDr;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    public Pr getIdPr() {
        return idPr;
    }

    public void setIdPr(Pr idPr) {
        this.idPr = idPr;
    }

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    @XmlTransient
    public List<Rpci> getRpciList() {
        return rpciList;
    }

    public void setRpciList(List<Rpci> rpciList) {
        this.rpciList = rpciList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSc != null ? idSc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sc)) {
            return false;
        }
        Sc other = (Sc) object;
        if ((this.idSc == null && other.idSc != null) || (this.idSc != null && !this.idSc.equals(other.idSc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Sc[ idSc=" + idSc + " ]";
    }
    
}
