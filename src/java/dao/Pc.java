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
    @UniqueConstraint(columnNames = {"id_pc"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pc.findAll", query = "SELECT p FROM Pc p")
    , @NamedQuery(name = "Pc.findByIdPc", query = "SELECT p FROM Pc p WHERE p.idPc = :idPc")})
public class Pc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pc", nullable = false)
    private Integer idPc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPc")
    private List<Rpcppe> rpcppeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPc")
    private List<Ppelc> ppelcList;
    @JoinColumn(name = "id_dr", referencedColumnName = "id_dr", nullable = false)
    @ManyToOne(optional = false)
    private Dr idDr;
    @JoinColumn(name = "id_par", referencedColumnName = "id_par", nullable = false)
    @ManyToOne(optional = false)
    private Par idPar;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;

    public Pc() {
    }

    public Pc(Integer idPc) {
        this.idPc = idPc;
    }

    public Integer getIdPc() {
        return idPc;
    }

    public void setIdPc(Integer idPc) {
        this.idPc = idPc;
    }

    @XmlTransient
    public List<Rpcppe> getRpcppeList() {
        return rpcppeList;
    }

    public void setRpcppeList(List<Rpcppe> rpcppeList) {
        this.rpcppeList = rpcppeList;
    }

    @XmlTransient
    public List<Ppelc> getPpelcList() {
        return ppelcList;
    }

    public void setPpelcList(List<Ppelc> ppelcList) {
        this.ppelcList = ppelcList;
    }

    public Dr getIdDr() {
        return idDr;
    }

    public void setIdDr(Dr idDr) {
        this.idDr = idDr;
    }

    public Par getIdPar() {
        return idPar;
    }

    public void setIdPar(Par idPar) {
        this.idPar = idPar;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPc != null ? idPc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pc)) {
            return false;
        }
        Pc other = (Pc) object;
        if ((this.idPc == null && other.idPc != null) || (this.idPc != null && !this.idPc.equals(other.idPc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Pc[ idPc=" + idPc + " ]";
    }
    
}
