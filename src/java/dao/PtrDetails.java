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
@Table(name = "ptr_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ptr_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtrDetails.findAll", query = "SELECT p FROM PtrDetails p")
    , @NamedQuery(name = "PtrDetails.findByIdPtrDetails", query = "SELECT p FROM PtrDetails p WHERE p.idPtrDetails = :idPtrDetails")})
public class PtrDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ptr_details", nullable = false)
    private Integer idPtrDetails;
    @JoinColumn(name = "id_ptr", referencedColumnName = "id_ptr", nullable = false)
    @ManyToOne(optional = false)
    private Ptr idPtr;

    public PtrDetails() {
    }

    public PtrDetails(Integer idPtrDetails) {
        this.idPtrDetails = idPtrDetails;
    }

    public Integer getIdPtrDetails() {
        return idPtrDetails;
    }

    public void setIdPtrDetails(Integer idPtrDetails) {
        this.idPtrDetails = idPtrDetails;
    }

    public Ptr getIdPtr() {
        return idPtr;
    }

    public void setIdPtr(Ptr idPtr) {
        this.idPtr = idPtr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPtrDetails != null ? idPtrDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtrDetails)) {
            return false;
        }
        PtrDetails other = (PtrDetails) object;
        if ((this.idPtrDetails == null && other.idPtrDetails != null) || (this.idPtrDetails != null && !this.idPtrDetails.equals(other.idPtrDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.PtrDetails[ idPtrDetails=" + idPtrDetails + " ]";
    }
    
}
