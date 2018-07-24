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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    , @NamedQuery(name = "AifDetails.findByIdAifDetails", query = "SELECT a FROM AifDetails a WHERE a.idAifDetails = :idAifDetails")
    , @NamedQuery(name = "AifDetails.findByTypeOfRequest", query = "SELECT a FROM AifDetails a WHERE a.typeOfRequest = :typeOfRequest")
    , @NamedQuery(name = "AifDetails.findByTypeOfRequest2", query = "SELECT a FROM AifDetails a WHERE a.typeOfRequest2 = :typeOfRequest2")
    , @NamedQuery(name = "AifDetails.findByTypeOfRequestOthers", query = "SELECT a FROM AifDetails a WHERE a.typeOfRequestOthers = :typeOfRequestOthers")
    , @NamedQuery(name = "AifDetails.findByInspector", query = "SELECT a FROM AifDetails a WHERE a.inspector = :inspector")
    , @NamedQuery(name = "AifDetails.findByRequieredAction", query = "SELECT a FROM AifDetails a WHERE a.requieredAction = :requieredAction")
    , @NamedQuery(name = "AifDetails.findByRequiredActionOthers", query = "SELECT a FROM AifDetails a WHERE a.requiredActionOthers = :requiredActionOthers")
    , @NamedQuery(name = "AifDetails.findByNameRequest", query = "SELECT a FROM AifDetails a WHERE a.nameRequest = :nameRequest")
    , @NamedQuery(name = "AifDetails.findByDateSigned", query = "SELECT a FROM AifDetails a WHERE a.dateSigned = :dateSigned")})
public class AifDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aif_details", nullable = false)
    private Integer idAifDetails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type_of_request", nullable = false, length = 45)
    private String typeOfRequest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type_of_request2", nullable = false, length = 45)
    private String typeOfRequest2;
    @Size(max = 45)
    @Column(name = "type_of_request_others", length = 45)
    private String typeOfRequestOthers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String inspector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "requiered_action", nullable = false, length = 45)
    private String requieredAction;
    @Size(max = 45)
    @Column(name = "required_action_others", length = 45)
    private String requiredActionOthers;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name_request", nullable = false, length = 45)
    private String nameRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_signed", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateSigned;
    @JoinColumn(name = "id_aif", referencedColumnName = "id_aif", nullable = false)
    @ManyToOne(optional = false)
    private Aif idAif;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aifDetails")
    private Aif aif;

    public AifDetails() {
    }

    public AifDetails(Integer idAifDetails) {
        this.idAifDetails = idAifDetails;
    }

    public AifDetails(Integer idAifDetails, String typeOfRequest, String typeOfRequest2, String inspector, String requieredAction, String nameRequest, Date dateSigned) {
        this.idAifDetails = idAifDetails;
        this.typeOfRequest = typeOfRequest;
        this.typeOfRequest2 = typeOfRequest2;
        this.inspector = inspector;
        this.requieredAction = requieredAction;
        this.nameRequest = nameRequest;
        this.dateSigned = dateSigned;
    }

    public Integer getIdAifDetails() {
        return idAifDetails;
    }

    public void setIdAifDetails(Integer idAifDetails) {
        this.idAifDetails = idAifDetails;
    }

    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getTypeOfRequest2() {
        return typeOfRequest2;
    }

    public void setTypeOfRequest2(String typeOfRequest2) {
        this.typeOfRequest2 = typeOfRequest2;
    }

    public String getTypeOfRequestOthers() {
        return typeOfRequestOthers;
    }

    public void setTypeOfRequestOthers(String typeOfRequestOthers) {
        this.typeOfRequestOthers = typeOfRequestOthers;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getRequieredAction() {
        return requieredAction;
    }

    public void setRequieredAction(String requieredAction) {
        this.requieredAction = requieredAction;
    }

    public String getRequiredActionOthers() {
        return requiredActionOthers;
    }

    public void setRequiredActionOthers(String requiredActionOthers) {
        this.requiredActionOthers = requiredActionOthers;
    }

    public String getNameRequest() {
        return nameRequest;
    }

    public void setNameRequest(String nameRequest) {
        this.nameRequest = nameRequest;
    }

    public Date getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = dateSigned;
    }

    public Aif getIdAif() {
        return idAif;
    }

    public void setIdAif(Aif idAif) {
        this.idAif = idAif;
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
        hash += (idAifDetails != null ? idAifDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AifDetails)) {
            return false;
        }
        AifDetails other = (AifDetails) object;
        if ((this.idAifDetails == null && other.idAifDetails != null) || (this.idAifDetails != null && !this.idAifDetails.equals(other.idAifDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.AifDetails[ idAifDetails=" + idAifDetails + " ]";
    }
    
}
