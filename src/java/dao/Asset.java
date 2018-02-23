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
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a")
    , @NamedQuery(name = "Asset.findByIdAsset", query = "SELECT a FROM Asset a WHERE a.idAsset = :idAsset")
    , @NamedQuery(name = "Asset.findByPropertyNum", query = "SELECT a FROM Asset a WHERE a.propertyNum = :propertyNum")
    , @NamedQuery(name = "Asset.findByAssetName", query = "SELECT a FROM Asset a WHERE a.assetName = :assetName")
    , @NamedQuery(name = "Asset.findByAssetDesc", query = "SELECT a FROM Asset a WHERE a.assetDesc = :assetDesc")
    , @NamedQuery(name = "Asset.findByUnitMeasurement", query = "SELECT a FROM Asset a WHERE a.unitMeasurement = :unitMeasurement")
    , @NamedQuery(name = "Asset.findByIdSpecificNumber", query = "SELECT a FROM Asset a WHERE a.idSpecificNumber = :idSpecificNumber")})
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Asset")
    private Integer idAsset;
    @Basic(optional = false)
    @NotNull
    @Column(name = "property_num")
    private int propertyNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asset_name")
    private String assetName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asset_desc")
    private String assetDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unit_measurement")
    private String unitMeasurement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_SpecificNumber")
    private int idSpecificNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "asset")
    private Specificnumber specificnumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsset")
    private List<Generalinventory> generalinventoryList;
    @JoinColumn(name = "id_Asset", referencedColumnName = "idpurchase_req", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pr pr;
    @JoinColumn(name = "id_FundCluster", referencedColumnName = "id_FundCluster")
    @ManyToOne(optional = false)
    private Fundcluster idFundCluster;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetId")
    private List<Stockcard> stockcardList;

    public Asset() {
    }

    public Asset(Integer idAsset) {
        this.idAsset = idAsset;
    }

    public Asset(Integer idAsset, int propertyNum, String assetName, String assetDesc, String unitMeasurement, int idSpecificNumber) {
        this.idAsset = idAsset;
        this.propertyNum = propertyNum;
        this.assetName = assetName;
        this.assetDesc = assetDesc;
        this.unitMeasurement = unitMeasurement;
        this.idSpecificNumber = idSpecificNumber;
    }

    public Integer getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(Integer idAsset) {
        this.idAsset = idAsset;
    }

    public int getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(int propertyNum) {
        this.propertyNum = propertyNum;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public int getIdSpecificNumber() {
        return idSpecificNumber;
    }

    public void setIdSpecificNumber(int idSpecificNumber) {
        this.idSpecificNumber = idSpecificNumber;
    }

    public Specificnumber getSpecificnumber() {
        return specificnumber;
    }

    public void setSpecificnumber(Specificnumber specificnumber) {
        this.specificnumber = specificnumber;
    }

    @XmlTransient
    public List<Generalinventory> getGeneralinventoryList() {
        return generalinventoryList;
    }

    public void setGeneralinventoryList(List<Generalinventory> generalinventoryList) {
        this.generalinventoryList = generalinventoryList;
    }

    public Pr getPr() {
        return pr;
    }

    public void setPr(Pr pr) {
        this.pr = pr;
    }

    public Fundcluster getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(Fundcluster idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    @XmlTransient
    public List<Stockcard> getStockcardList() {
        return stockcardList;
    }

    public void setStockcardList(List<Stockcard> stockcardList) {
        this.stockcardList = stockcardList;
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
