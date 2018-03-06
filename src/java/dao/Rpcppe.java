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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_rpcppe"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rpcppe.findAll", query = "SELECT r FROM Rpcppe r")
    , @NamedQuery(name = "Rpcppe.findByIdRpcppe", query = "SELECT r FROM Rpcppe r WHERE r.idRpcppe = :idRpcppe")})
public class Rpcppe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rpcppe", nullable = false)
    private Integer idRpcppe;
    @JoinColumn(name = "id_pc", referencedColumnName = "id_pc", nullable = false)
    @ManyToOne(optional = false)
    private Pc idPc;

    public Rpcppe() {
    }

    public Rpcppe(Integer idRpcppe) {
        this.idRpcppe = idRpcppe;
    }

    public Integer getIdRpcppe() {
        return idRpcppe;
    }

    public void setIdRpcppe(Integer idRpcppe) {
        this.idRpcppe = idRpcppe;
    }

    public Pc getIdPc() {
        return idPc;
    }

    public void setIdPc(Pc idPc) {
        this.idPc = idPc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRpcppe != null ? idRpcppe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rpcppe)) {
            return false;
        }
        Rpcppe other = (Rpcppe) object;
        if ((this.idRpcppe == null && other.idRpcppe != null) || (this.idRpcppe != null && !this.idRpcppe.equals(other.idRpcppe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rpcppe[ idRpcppe=" + idRpcppe + " ]";
    }
    
}
