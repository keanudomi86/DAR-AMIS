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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fundcluster.findAll", query = "SELECT f FROM Fundcluster f")
    , @NamedQuery(name = "Fundcluster.findByIdFundCluster", query = "SELECT f FROM Fundcluster f WHERE f.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Fundcluster.findByFundclusterName", query = "SELECT f FROM Fundcluster f WHERE f.fundclusterName = :fundclusterName")
    , @NamedQuery(name = "Fundcluster.findByIdEntity", query = "SELECT f FROM Fundcluster f WHERE f.idEntity = :idEntity")})
public class Fundcluster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_FundCluster")
    private Integer idFundCluster;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fundcluster_name")
    private String fundclusterName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_entity")
    private int idEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFundCluster")
    private List<Asset> assetList;

    public Fundcluster() {
    }

    public Fundcluster(Integer idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public Fundcluster(Integer idFundCluster, String fundclusterName, int idEntity) {
        this.idFundCluster = idFundCluster;
        this.fundclusterName = fundclusterName;
        this.idEntity = idEntity;
    }

    public Integer getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(Integer idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public String getFundclusterName() {
        return fundclusterName;
    }

    public void setFundclusterName(String fundclusterName) {
        this.fundclusterName = fundclusterName;
    }

    public int getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(int idEntity) {
        this.idEntity = idEntity;
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
        hash += (idFundCluster != null ? idFundCluster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fundcluster)) {
            return false;
        }
        Fundcluster other = (Fundcluster) object;
        if ((this.idFundCluster == null && other.idFundCluster != null) || (this.idFundCluster != null && !this.idFundCluster.equals(other.idFundCluster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Fundcluster[ idFundCluster=" + idFundCluster + " ]";
    }
    
}
