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
@Table(name = "wmr_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_wmr_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WmrDetails.findAll", query = "SELECT w FROM WmrDetails w")
    , @NamedQuery(name = "WmrDetails.findByIdWmrDetails", query = "SELECT w FROM WmrDetails w WHERE w.idWmrDetails = :idWmrDetails")})
public class WmrDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wmr_details", nullable = false)
    private Integer idWmrDetails;
    @JoinColumn(name = "id_wmr", referencedColumnName = "id_wmr", nullable = false)
    @ManyToOne(optional = false)
    private Wmr idWmr;

    public WmrDetails() {
    }

    public WmrDetails(Integer idWmrDetails) {
        this.idWmrDetails = idWmrDetails;
    }

    public Integer getIdWmrDetails() {
        return idWmrDetails;
    }

    public void setIdWmrDetails(Integer idWmrDetails) {
        this.idWmrDetails = idWmrDetails;
    }

    public Wmr getIdWmr() {
        return idWmr;
    }

    public void setIdWmr(Wmr idWmr) {
        this.idWmr = idWmr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWmrDetails != null ? idWmrDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WmrDetails)) {
            return false;
        }
        WmrDetails other = (WmrDetails) object;
        if ((this.idWmrDetails == null && other.idWmrDetails != null) || (this.idWmrDetails != null && !this.idWmrDetails.equals(other.idWmrDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.WmrDetails[ idWmrDetails=" + idWmrDetails + " ]";
    }
    
}
