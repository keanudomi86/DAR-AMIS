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
    @NamedQuery(name = "Rfi.findAll", query = "SELECT r FROM Rfi r")
    , @NamedQuery(name = "Rfi.findByIdRFI", query = "SELECT r FROM Rfi r WHERE r.idRFI = :idRFI")
    , @NamedQuery(name = "Rfi.findByRepair", query = "SELECT r FROM Rfi r WHERE r.repair = :repair")
    , @NamedQuery(name = "Rfi.findByRepairDesc", query = "SELECT r FROM Rfi r WHERE r.repairDesc = :repairDesc")
    , @NamedQuery(name = "Rfi.findByDeliveries", query = "SELECT r FROM Rfi r WHERE r.deliveries = :deliveries")
    , @NamedQuery(name = "Rfi.findByUpAsset", query = "SELECT r FROM Rfi r WHERE r.upAsset = :upAsset")})
public class Rfi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_RFI")
    private Integer idRFI;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String repair;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "repair_desc")
    private String repairDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String deliveries;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset5")
    private List<Generalinventory> generalinventoryList;

    public Rfi() {
    }

    public Rfi(Integer idRFI) {
        this.idRFI = idRFI;
    }

    public Rfi(Integer idRFI, String repair, String repairDesc, String deliveries, int upAsset) {
        this.idRFI = idRFI;
        this.repair = repair;
        this.repairDesc = repairDesc;
        this.deliveries = deliveries;
        this.upAsset = upAsset;
    }

    public Integer getIdRFI() {
        return idRFI;
    }

    public void setIdRFI(Integer idRFI) {
        this.idRFI = idRFI;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    public String getRepairDesc() {
        return repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc;
    }

    public String getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(String deliveries) {
        this.deliveries = deliveries;
    }

    public int getUpAsset() {
        return upAsset;
    }

    public void setUpAsset(int upAsset) {
        this.upAsset = upAsset;
    }

    @XmlTransient
    public List<Generalinventory> getGeneralinventoryList() {
        return generalinventoryList;
    }

    public void setGeneralinventoryList(List<Generalinventory> generalinventoryList) {
        this.generalinventoryList = generalinventoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRFI != null ? idRFI.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rfi)) {
            return false;
        }
        Rfi other = (Rfi) object;
        if ((this.idRFI == null && other.idRFI != null) || (this.idRFI != null && !this.idRFI.equals(other.idRFI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rfi[ idRFI=" + idRFI + " ]";
    }
    
}
