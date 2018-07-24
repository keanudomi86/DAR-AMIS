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
@Table(name = "ics_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ics_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IcsDetails.findAll", query = "SELECT i FROM IcsDetails i")
    , @NamedQuery(name = "IcsDetails.findByIdIcsDetails", query = "SELECT i FROM IcsDetails i WHERE i.idIcsDetails = :idIcsDetails")})
public class IcsDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ics_details", nullable = false)
    private Integer idIcsDetails;
    @JoinColumn(name = "id_ics", referencedColumnName = "id_ics", nullable = false)
    @ManyToOne(optional = false)
    private Ics idIcs;

    public IcsDetails() {
    }

    public IcsDetails(Integer idIcsDetails) {
        this.idIcsDetails = idIcsDetails;
    }

    public Integer getIdIcsDetails() {
        return idIcsDetails;
    }

    public void setIdIcsDetails(Integer idIcsDetails) {
        this.idIcsDetails = idIcsDetails;
    }

    public Ics getIdIcs() {
        return idIcs;
    }

    public void setIdIcs(Ics idIcs) {
        this.idIcs = idIcs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIcsDetails != null ? idIcsDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IcsDetails)) {
            return false;
        }
        IcsDetails other = (IcsDetails) object;
        if ((this.idIcsDetails == null && other.idIcsDetails != null) || (this.idIcsDetails != null && !this.idIcsDetails.equals(other.idIcsDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.IcsDetails[ idIcsDetails=" + idIcsDetails + " ]";
    }
    
}
