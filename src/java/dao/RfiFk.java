/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "rfi_fk", catalog = "daramis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RfiFk.findAll", query = "SELECT r FROM RfiFk r")
    , @NamedQuery(name = "RfiFk.findByIdrfiDetails", query = "SELECT r FROM RfiFk r WHERE r.idrfiDetails = :idrfiDetails")
    , @NamedQuery(name = "RfiFk.findByNameRequest", query = "SELECT r FROM RfiFk r WHERE r.nameRequest = :nameRequest")
    , @NamedQuery(name = "RfiFk.findByDateRequested", query = "SELECT r FROM RfiFk r WHERE r.dateRequested = :dateRequested")
    , @NamedQuery(name = "RfiFk.findByTypeOfRequest", query = "SELECT r FROM RfiFk r WHERE r.typeOfRequest = :typeOfRequest")})
public class RfiFk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrfi_details", nullable = false)
    private Integer idrfiDetails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name_request", nullable = false, length = 45)
    private String nameRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_requested", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRequested;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type_of_request", nullable = false, length = 45)
    private String typeOfRequest;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rfiFk")
    private Rfi rfi;

    public RfiFk() {
    }

    public RfiFk(Integer idrfiDetails) {
        this.idrfiDetails = idrfiDetails;
    }

    public RfiFk(Integer idrfiDetails, String nameRequest, Date dateRequested, String typeOfRequest) {
        this.idrfiDetails = idrfiDetails;
        this.nameRequest = nameRequest;
        this.dateRequested = dateRequested;
        this.typeOfRequest = typeOfRequest;
    }

    public Integer getIdrfiDetails() {
        return idrfiDetails;
    }

    public void setIdrfiDetails(Integer idrfiDetails) {
        this.idrfiDetails = idrfiDetails;
    }

    public String getNameRequest() {
        return nameRequest;
    }

    public void setNameRequest(String nameRequest) {
        this.nameRequest = nameRequest;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public Rfi getRfi() {
        return rfi;
    }

    public void setRfi(Rfi rfi) {
        this.rfi = rfi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrfiDetails != null ? idrfiDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RfiFk)) {
            return false;
        }
        RfiFk other = (RfiFk) object;
        if ((this.idrfiDetails == null && other.idrfiDetails != null) || (this.idrfiDetails != null && !this.idrfiDetails.equals(other.idrfiDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RfiFk[ idrfiDetails=" + idrfiDetails + " ]";
    }
    
}
