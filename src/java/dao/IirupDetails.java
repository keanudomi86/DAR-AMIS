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
@Table(name = "iirup_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_iirup_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IirupDetails.findAll", query = "SELECT i FROM IirupDetails i")
    , @NamedQuery(name = "IirupDetails.findByIdIirupDetails", query = "SELECT i FROM IirupDetails i WHERE i.idIirupDetails = :idIirupDetails")})
public class IirupDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_iirup_details", nullable = false)
    private Integer idIirupDetails;
    @JoinColumn(name = "id_iirup", referencedColumnName = "id_iirup", nullable = false)
    @ManyToOne(optional = false)
    private Iirup idIirup;

    public IirupDetails() {
    }

    public IirupDetails(Integer idIirupDetails) {
        this.idIirupDetails = idIirupDetails;
    }

    public Integer getIdIirupDetails() {
        return idIirupDetails;
    }

    public void setIdIirupDetails(Integer idIirupDetails) {
        this.idIirupDetails = idIirupDetails;
    }

    public Iirup getIdIirup() {
        return idIirup;
    }

    public void setIdIirup(Iirup idIirup) {
        this.idIirup = idIirup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIirupDetails != null ? idIirupDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IirupDetails)) {
            return false;
        }
        IirupDetails other = (IirupDetails) object;
        if ((this.idIirupDetails == null && other.idIirupDetails != null) || (this.idIirupDetails != null && !this.idIirupDetails.equals(other.idIirupDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.IirupDetails[ idIirupDetails=" + idIirupDetails + " ]";
    }
    
}
