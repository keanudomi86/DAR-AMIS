/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
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
    @UniqueConstraint(columnNames = {"id_asset"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a")
    , @NamedQuery(name = "Asset.findByIdAsset", query = "SELECT a FROM Asset a WHERE a.idAsset = :idAsset")
    , @NamedQuery(name = "Asset.findByQuantity", query = "SELECT a FROM Asset a WHERE a.quantity = :quantity")
    , @NamedQuery(name = "Asset.findByIdPo", query = "SELECT a FROM Asset a WHERE a.idPo = :idPo")})
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asset", nullable = false)
    private Integer idAsset;
    private Integer quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_po", nullable = false)
    private int idPo;
    @JoinColumn(name = "id_apc", referencedColumnName = "id_apc", nullable = false)
    @ManyToOne(optional = false)
    private Apc idApc;
    @OneToMany(mappedBy = "idAsset")
    private List<Po> poList;

    public Asset() {
    }

    public Asset(Integer idAsset) {
        this.idAsset = idAsset;
    }

    public Asset(Integer idAsset, int idPo) {
        this.idAsset = idAsset;
        this.idPo = idPo;
    }

    public Integer getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(Integer idAsset) {
        this.idAsset = idAsset;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getIdPo() {
        return idPo;
    }

    public void setIdPo(int idPo) {
        this.idPo = idPo;
    }

    public Apc getIdApc() {
        return idApc;
    }

    public void setIdApc(Apc idApc) {
        this.idApc = idApc;
    }

    @XmlTransient
    public List<Po> getPoList() {
        return poList;
    }

    public void setPoList(List<Po> poList) {
        this.poList = poList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsset != null ? idAsset.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.idAsset == null && other.idAsset != null) || (this.idAsset != null && !this.idAsset.equals(other.idAsset))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Asset[ idAsset=" + idAsset + " ]";
    }
    
}
