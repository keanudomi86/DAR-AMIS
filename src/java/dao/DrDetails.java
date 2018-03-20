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
@Table(name = "dr_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_dr_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrDetails.findAll", query = "SELECT d FROM DrDetails d")
    , @NamedQuery(name = "DrDetails.findByIdDrDetails", query = "SELECT d FROM DrDetails d WHERE d.idDrDetails = :idDrDetails")})
public class DrDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dr_details", nullable = false)
    private Integer idDrDetails;
    @JoinColumn(name = "id_dr", referencedColumnName = "id_dr", nullable = false)
    @ManyToOne(optional = false)
    private Dr idDr;

    public DrDetails() {
    }

    public DrDetails(Integer idDrDetails) {
        this.idDrDetails = idDrDetails;
    }

    public Integer getIdDrDetails() {
        return idDrDetails;
    }

    public void setIdDrDetails(Integer idDrDetails) {
        this.idDrDetails = idDrDetails;
    }

    public Dr getIdDr() {
        return idDr;
    }

    public void setIdDr(Dr idDr) {
        this.idDr = idDr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDrDetails != null ? idDrDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrDetails)) {
            return false;
        }
        DrDetails other = (DrDetails) object;
        if ((this.idDrDetails == null && other.idDrDetails != null) || (this.idDrDetails != null && !this.idDrDetails.equals(other.idDrDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.DrDetails[ idDrDetails=" + idDrDetails + " ]";
    }
    
}
