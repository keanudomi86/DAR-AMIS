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
    @UniqueConstraint(columnNames = {"id_apc"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apc.findAll", query = "SELECT a FROM Apc a")
    , @NamedQuery(name = "Apc.findByIdApc", query = "SELECT a FROM Apc a WHERE a.idApc = :idApc")})
public class Apc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_apc", nullable = false)
    private Integer idApc;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApc")
    private List<Asset> assetList;

    public Apc() {
    }

    public Apc(Integer idApc) {
        this.idApc = idApc;
    }

    public Integer getIdApc() {
        return idApc;
    }

    public void setIdApc(Integer idApc) {
        this.idApc = idApc;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    @XmlTransient
    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApc != null ? idApc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apc)) {
            return false;
        }
        Apc other = (Apc) object;
        if ((this.idApc == null && other.idApc != null) || (this.idApc != null && !this.idApc.equals(other.idApc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Apc[ idApc=" + idApc + " ]";
    }
    
}
