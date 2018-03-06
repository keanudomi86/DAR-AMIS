/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_rpci"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rpci.findAll", query = "SELECT r FROM Rpci r")
    , @NamedQuery(name = "Rpci.findByIdRpci", query = "SELECT r FROM Rpci r WHERE r.idRpci = :idRpci")})
public class Rpci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rpci", nullable = false)
    private Integer idRpci;
    @JoinColumn(name = "id_sc", referencedColumnName = "id_sc", nullable = false)
    @ManyToOne(optional = false)
    private Sc idSc;

    public Rpci() {
    }

    public Rpci(Integer idRpci) {
        this.idRpci = idRpci;
    }

    public Integer getIdRpci() {
        return idRpci;
    }

    public void setIdRpci(Integer idRpci) {
        this.idRpci = idRpci;
    }

    public Sc getIdSc() {
        return idSc;
    }

    public void setIdSc(Sc idSc) {
        this.idSc = idSc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRpci != null ? idRpci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rpci)) {
            return false;
        }
        Rpci other = (Rpci) object;
        if ((this.idRpci == null && other.idRpci != null) || (this.idRpci != null && !this.idRpci.equals(other.idRpci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rpci[ idRpci=" + idRpci + " ]";
    }
    
}
