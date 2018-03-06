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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "aif_details", catalog = "daramis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AifDetails.findAll", query = "SELECT a FROM AifDetails a")
    , @NamedQuery(name = "AifDetails.findByIdaifDetails", query = "SELECT a FROM AifDetails a WHERE a.idaifDetails = :idaifDetails")
    , @NamedQuery(name = "AifDetails.findByNameRequest", query = "SELECT a FROM AifDetails a WHERE a.nameRequest = :nameRequest")
    , @NamedQuery(name = "AifDetails.findByDateRequested", query = "SELECT a FROM AifDetails a WHERE a.dateRequested = :dateRequested")
    , @NamedQuery(name = "AifDetails.findByTypeOfRequest", query = "SELECT a FROM AifDetails a WHERE a.typeOfRequest = :typeOfRequest")})
public class AifDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaif_details", nullable = false)
    private Integer idaifDetails;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aifDetails")
    private Aif aif;

    public AifDetails() {
    }

    public AifDetails(Integer idaifDetails) {
        this.idaifDetails = idaifDetails;
    }

    public AifDetails(Integer idaifDetails, String nameRequest, Date dateRequested, String typeOfRequest) {
        this.idaifDetails = idaifDetails;
        this.nameRequest = nameRequest;
        this.dateRequested = dateRequested;
        this.typeOfRequest = typeOfRequest;
    }

    public Integer getIdaifDetails() {
        return idaifDetails;
    }

    public void setIdaifDetails(Integer idaifDetails) {
        this.idaifDetails = idaifDetails;
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

    public Aif getAif() {
        return aif;
    }

    public void setAif(Aif aif) {
        this.aif = aif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaifDetails != null ? idaifDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AifDetails)) {
            return false;
        }
        AifDetails other = (AifDetails) object;
        if ((this.idaifDetails == null && other.idaifDetails != null) || (this.idaifDetails != null && !this.idaifDetails.equals(other.idaifDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.AifDetails[ idaifDetails=" + idaifDetails + " ]";
    }
    
}
