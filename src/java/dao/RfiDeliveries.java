/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "rfi_deliveries", catalog = "daramis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RfiDeliveries.findAll", query = "SELECT r FROM RfiDeliveries r")
    , @NamedQuery(name = "RfiDeliveries.findByIdDeliveries", query = "SELECT r FROM RfiDeliveries r WHERE r.idDeliveries = :idDeliveries")
    , @NamedQuery(name = "RfiDeliveries.findByNameRequest", query = "SELECT r FROM RfiDeliveries r WHERE r.nameRequest = :nameRequest")
    , @NamedQuery(name = "RfiDeliveries.findByDateRequested", query = "SELECT r FROM RfiDeliveries r WHERE r.dateRequested = :dateRequested")
    , @NamedQuery(name = "RfiDeliveries.findByTypeOfRequest", query = "SELECT r FROM RfiDeliveries r WHERE r.typeOfRequest = :typeOfRequest")})
public class RfiDeliveries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_deliveries", nullable = false)
    private Integer idDeliveries;
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
    @JoinColumn(name = "id_rfi", referencedColumnName = "id_rfi", nullable = false)
    @ManyToOne(optional = false)
    private Rfi idRfi;

    public RfiDeliveries() {
    }

    public RfiDeliveries(Integer idDeliveries) {
        this.idDeliveries = idDeliveries;
    }

    public RfiDeliveries(Integer idDeliveries, String nameRequest, Date dateRequested, String typeOfRequest) {
        this.idDeliveries = idDeliveries;
        this.nameRequest = nameRequest;
        this.dateRequested = dateRequested;
        this.typeOfRequest = typeOfRequest;
    }

    public Integer getIdDeliveries() {
        return idDeliveries;
    }

    public void setIdDeliveries(Integer idDeliveries) {
        this.idDeliveries = idDeliveries;
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

    public Rfi getIdRfi() {
        return idRfi;
    }

    public void setIdRfi(Rfi idRfi) {
        this.idRfi = idRfi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeliveries != null ? idDeliveries.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RfiDeliveries)) {
            return false;
        }
        RfiDeliveries other = (RfiDeliveries) object;
        if ((this.idDeliveries == null && other.idDeliveries != null) || (this.idDeliveries != null && !this.idDeliveries.equals(other.idDeliveries))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RfiDeliveries[ idDeliveries=" + idDeliveries + " ]";
    }
    
}
