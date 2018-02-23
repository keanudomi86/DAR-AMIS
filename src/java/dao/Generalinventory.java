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
    @NamedQuery(name = "Generalinventory.findAll", query = "SELECT g FROM Generalinventory g")
    , @NamedQuery(name = "Generalinventory.findByIdGeneralInventory", query = "SELECT g FROM Generalinventory g WHERE g.idGeneralInventory = :idGeneralInventory")
    , @NamedQuery(name = "Generalinventory.findByDescription", query = "SELECT g FROM Generalinventory g WHERE g.description = :description")
    , @NamedQuery(name = "Generalinventory.findByEstimatedAmount", query = "SELECT g FROM Generalinventory g WHERE g.estimatedAmount = :estimatedAmount")
    , @NamedQuery(name = "Generalinventory.findByIdItem", query = "SELECT g FROM Generalinventory g WHERE g.idItem = :idItem")})
public class Generalinventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_GeneralInventory")
    private Integer idGeneralInventory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estimated_amount")
    private float estimatedAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_item")
    private int idItem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private List<Rppe> rppeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private List<Dv> dvList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private List<Iirup> iirupList;
    @JoinColumn(name = "id_asset", referencedColumnName = "id_Asset")
    @ManyToOne(optional = false)
    private Asset idAsset;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_AIF")
    @ManyToOne(optional = false)
    private Aif upAsset;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_ICS")
    @ManyToOne(optional = false)
    private Ics upAsset1;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_PAR")
    @ManyToOne(optional = false)
    private Par upAsset2;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_PPELC")
    @ManyToOne(optional = false)
    private Ppelc upAsset3;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_PTR")
    @ManyToOne(optional = false)
    private Ptr upAsset4;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_RFI")
    @ManyToOne(optional = false)
    private Rfi upAsset5;
    @JoinColumn(name = "up_asset", referencedColumnName = "id_RIS")
    @ManyToOne(optional = false)
    private Ris upAsset6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItem")
    private List<Wmr> wmrList;

    public Generalinventory() {
    }

    public Generalinventory(Integer idGeneralInventory) {
        this.idGeneralInventory = idGeneralInventory;
    }

    public Generalinventory(Integer idGeneralInventory, String description, float estimatedAmount, int idItem) {
        this.idGeneralInventory = idGeneralInventory;
        this.description = description;
        this.estimatedAmount = estimatedAmount;
        this.idItem = idItem;
    }

    public Integer getIdGeneralInventory() {
        return idGeneralInventory;
    }

    public void setIdGeneralInventory(Integer idGeneralInventory) {
        this.idGeneralInventory = idGeneralInventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(float estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @XmlTransient
    public List<Rppe> getRppeList() {
        return rppeList;
    }

    public void setRppeList(List<Rppe> rppeList) {
        this.rppeList = rppeList;
    }

    @XmlTransient
    public List<Dv> getDvList() {
        return dvList;
    }

    public void setDvList(List<Dv> dvList) {
        this.dvList = dvList;
    }

    @XmlTransient
    public List<Iirup> getIirupList() {
        return iirupList;
    }

    public void setIirupList(List<Iirup> iirupList) {
        this.iirupList = iirupList;
    }

    public Asset getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(Asset idAsset) {
        this.idAsset = idAsset;
    }

    public Aif getUpAsset() {
        return upAsset;
    }

    public void setUpAsset(Aif upAsset) {
        this.upAsset = upAsset;
    }

    public Ics getUpAsset1() {
        return upAsset1;
    }

    public void setUpAsset1(Ics upAsset1) {
        this.upAsset1 = upAsset1;
    }

    public Par getUpAsset2() {
        return upAsset2;
    }

    public void setUpAsset2(Par upAsset2) {
        this.upAsset2 = upAsset2;
    }

    public Ppelc getUpAsset3() {
        return upAsset3;
    }

    public void setUpAsset3(Ppelc upAsset3) {
        this.upAsset3 = upAsset3;
    }

    public Ptr getUpAsset4() {
        return upAsset4;
    }

    public void setUpAsset4(Ptr upAsset4) {
        this.upAsset4 = upAsset4;
    }

    public Rfi getUpAsset5() {
        return upAsset5;
    }

    public void setUpAsset5(Rfi upAsset5) {
        this.upAsset5 = upAsset5;
    }

    public Ris getUpAsset6() {
        return upAsset6;
    }

    public void setUpAsset6(Ris upAsset6) {
        this.upAsset6 = upAsset6;
    }

    @XmlTransient
    public List<Wmr> getWmrList() {
        return wmrList;
    }

    public void setWmrList(List<Wmr> wmrList) {
        this.wmrList = wmrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGeneralInventory != null ? idGeneralInventory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generalinventory)) {
            return false;
        }
        Generalinventory other = (Generalinventory) object;
        if ((this.idGeneralInventory == null && other.idGeneralInventory != null) || (this.idGeneralInventory != null && !this.idGeneralInventory.equals(other.idGeneralInventory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Generalinventory[ idGeneralInventory=" + idGeneralInventory + " ]";
    }
    
}
