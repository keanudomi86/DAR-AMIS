/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aif.findAll", query = "SELECT a FROM Aif a")
    , @NamedQuery(name = "Aif.findByIdAIF", query = "SELECT a FROM Aif a WHERE a.idAIF = :idAIF")
    , @NamedQuery(name = "Aif.findByDateRequest", query = "SELECT a FROM Aif a WHERE a.dateRequest = :dateRequest")
    , @NamedQuery(name = "Aif.findByControlNum", query = "SELECT a FROM Aif a WHERE a.controlNum = :controlNum")
    , @NamedQuery(name = "Aif.findByDateReceived", query = "SELECT a FROM Aif a WHERE a.dateReceived = :dateReceived")
    , @NamedQuery(name = "Aif.findByReceivedFrom", query = "SELECT a FROM Aif a WHERE a.receivedFrom = :receivedFrom")
    , @NamedQuery(name = "Aif.findByReceivedBy", query = "SELECT a FROM Aif a WHERE a.receivedBy = :receivedBy")
    , @NamedQuery(name = "Aif.findByTypeInspection", query = "SELECT a FROM Aif a WHERE a.typeInspection = :typeInspection")
    , @NamedQuery(name = "Aif.findByReceipient", query = "SELECT a FROM Aif a WHERE a.receipient = :receipient")
    , @NamedQuery(name = "Aif.findByRequiredAction", query = "SELECT a FROM Aif a WHERE a.requiredAction = :requiredAction")
    , @NamedQuery(name = "Aif.findBySignedOn", query = "SELECT a FROM Aif a WHERE a.signedOn = :signedOn")
    , @NamedQuery(name = "Aif.findByUpAsset", query = "SELECT a FROM Aif a WHERE a.upAsset = :upAsset")})
public class Aif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_AIF")
    private Integer idAIF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_request")
    @Temporal(TemporalType.DATE)
    private Date dateRequest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_num")
    private int controlNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_received")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "received_from")
    private String receivedFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "received_by")
    private String receivedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type_inspection")
    private String typeInspection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String receipient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "required_action")
    private String requiredAction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "signed_on")
    @Temporal(TemporalType.DATE)
    private Date signedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "up_asset")
    private int upAsset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "upAsset")
    private List<Generalinventory> generalinventoryList;

    public Aif() {
    }

    public Aif(Integer idAIF) {
        this.idAIF = idAIF;
    }

    public Aif(Integer idAIF, Date dateRequest, int controlNum, Date dateReceived, String receivedFrom, String receivedBy, String typeInspection, String receipient, String requiredAction, Date signedOn, int upAsset) {
        this.idAIF = idAIF;
        this.dateRequest = dateRequest;
        this.controlNum = controlNum;
        this.dateReceived = dateReceived;
        this.receivedFrom = receivedFrom;
        this.receivedBy = receivedBy;
        this.typeInspection = typeInspection;
        this.receipient = receipient;
        this.requiredAction = requiredAction;
        this.signedOn = signedOn;
        this.upAsset = upAsset;
    }

    public Integer getIdAIF() {
        return idAIF;
    }

    public void setIdAIF(Integer idAIF) {
        this.idAIF = idAIF;
    }

    public Date getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(Date dateRequest) {
        this.dateRequest = dateRequest;
    }

    public int getControlNum() {
        return controlNum;
    }

    public void setControlNum(int controlNum) {
        this.controlNum = controlNum;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getReceivedFrom() {
        return receivedFrom;
    }

    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getTypeInspection() {
        return typeInspection;
    }

    public void setTypeInspection(String typeInspection) {
        this.typeInspection = typeInspection;
    }

    public String getReceipient() {
        return receipient;
    }

    public void setReceipient(String receipient) {
        this.receipient = receipient;
    }

    public String getRequiredAction() {
        return requiredAction;
    }

    public void setRequiredAction(String requiredAction) {
        this.requiredAction = requiredAction;
    }

    public Date getSignedOn() {
        return signedOn;
    }

    public void setSignedOn(Date signedOn) {
        this.signedOn = signedOn;
    }

    public int getUpAsset() {
        return upAsset;
    }

    public void setUpAsset(int upAsset) {
        this.upAsset = upAsset;
    }

    @XmlTransient
    public List<Generalinventory> getGeneralinventoryList() {
        return generalinventoryList;
    }

    public void setGeneralinventoryList(List<Generalinventory> generalinventoryList) {
        this.generalinventoryList = generalinventoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAIF != null ? idAIF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aif)) {
            return false;
        }
        Aif other = (Aif) object;
        if ((this.idAIF == null && other.idAIF != null) || (this.idAIF != null && !this.idAIF.equals(other.idAIF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Aif[ idAIF=" + idAIF + " ]";
    }
    
}
