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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "par_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idpar_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParDetails.findAll", query = "SELECT p FROM ParDetails p")
    , @NamedQuery(name = "ParDetails.findByIdparDetails", query = "SELECT p FROM ParDetails p WHERE p.idparDetails = :idparDetails")
    , @NamedQuery(name = "ParDetails.findByNameRequest", query = "SELECT p FROM ParDetails p WHERE p.nameRequest = :nameRequest")
    , @NamedQuery(name = "ParDetails.findByDateRequested", query = "SELECT p FROM ParDetails p WHERE p.dateRequested = :dateRequested")
    , @NamedQuery(name = "ParDetails.findByTypeOfRequest", query = "SELECT p FROM ParDetails p WHERE p.typeOfRequest = :typeOfRequest")})
public class ParDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpar_details", nullable = false)
    private Integer idparDetails;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "parDetails")
    private Par par;

    public ParDetails() {
    }

    public ParDetails(Integer idparDetails) {
        this.idparDetails = idparDetails;
    }

    public ParDetails(Integer idparDetails, String nameRequest, Date dateRequested, String typeOfRequest) {
        this.idparDetails = idparDetails;
        this.nameRequest = nameRequest;
        this.dateRequested = dateRequested;
        this.typeOfRequest = typeOfRequest;
    }

    public Integer getIdparDetails() {
        return idparDetails;
    }

    public void setIdparDetails(Integer idparDetails) {
        this.idparDetails = idparDetails;
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

    public Par getPar() {
        return par;
    }

    public void setPar(Par par) {
        this.par = par;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparDetails != null ? idparDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParDetails)) {
            return false;
        }
        ParDetails other = (ParDetails) object;
        if ((this.idparDetails == null && other.idparDetails != null) || (this.idparDetails != null && !this.idparDetails.equals(other.idparDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ParDetails[ idparDetails=" + idparDetails + " ]";
    }
    
}
