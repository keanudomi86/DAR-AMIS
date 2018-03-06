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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "wfp_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WfpDetails.findAll", query = "SELECT w FROM WfpDetails w")
    , @NamedQuery(name = "WfpDetails.findByIdDetails", query = "SELECT w FROM WfpDetails w WHERE w.idDetails = :idDetails")})
public class WfpDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_details", nullable = false)
    private Integer idDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetails")
    private List<Wfp> wfpList;

    public WfpDetails() {
    }

    public WfpDetails(Integer idDetails) {
        this.idDetails = idDetails;
    }

    public Integer getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(Integer idDetails) {
        this.idDetails = idDetails;
    }

    @XmlTransient
    public List<Wfp> getWfpList() {
        return wfpList;
    }

    public void setWfpList(List<Wfp> wfpList) {
        this.wfpList = wfpList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetails != null ? idDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WfpDetails)) {
            return false;
        }
        WfpDetails other = (WfpDetails) object;
        if ((this.idDetails == null && other.idDetails != null) || (this.idDetails != null && !this.idDetails.equals(other.idDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.WfpDetails[ idDetails=" + idDetails + " ]";
    }
    
}
