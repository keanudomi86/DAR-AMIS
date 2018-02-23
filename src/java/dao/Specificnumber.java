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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specificnumber.findAll", query = "SELECT s FROM Specificnumber s")
    , @NamedQuery(name = "Specificnumber.findByIdSpecificNumber", query = "SELECT s FROM Specificnumber s WHERE s.idSpecificNumber = :idSpecificNumber")
    , @NamedQuery(name = "Specificnumber.findByDescriptionSpec", query = "SELECT s FROM Specificnumber s WHERE s.descriptionSpec = :descriptionSpec")
    , @NamedQuery(name = "Specificnumber.findBySpecificNumbercol", query = "SELECT s FROM Specificnumber s WHERE s.specificNumbercol = :specificNumbercol")})
public class Specificnumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_SpecificNumber")
    private Integer idSpecificNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String descriptionSpec;
    @Size(max = 45)
    private String specificNumbercol;
    @JoinColumn(name = "id_SpecificNumber", referencedColumnName = "id_Asset", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Asset asset;

    public Specificnumber() {
    }

    public Specificnumber(Integer idSpecificNumber) {
        this.idSpecificNumber = idSpecificNumber;
    }

    public Specificnumber(Integer idSpecificNumber, String descriptionSpec) {
        this.idSpecificNumber = idSpecificNumber;
        this.descriptionSpec = descriptionSpec;
    }

    public Integer getIdSpecificNumber() {
        return idSpecificNumber;
    }

    public void setIdSpecificNumber(Integer idSpecificNumber) {
        this.idSpecificNumber = idSpecificNumber;
    }

    public String getDescriptionSpec() {
        return descriptionSpec;
    }

    public void setDescriptionSpec(String descriptionSpec) {
        this.descriptionSpec = descriptionSpec;
    }

    public String getSpecificNumbercol() {
        return specificNumbercol;
    }

    public void setSpecificNumbercol(String specificNumbercol) {
        this.specificNumbercol = specificNumbercol;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecificNumber != null ? idSpecificNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specificnumber)) {
            return false;
        }
        Specificnumber other = (Specificnumber) object;
        if ((this.idSpecificNumber == null && other.idSpecificNumber != null) || (this.idSpecificNumber != null && !this.idSpecificNumber.equals(other.idSpecificNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Specificnumber[ idSpecificNumber=" + idSpecificNumber + " ]";
    }
    
}
