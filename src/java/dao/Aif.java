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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_aif"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aif.findAll", query = "SELECT a FROM Aif a")
    , @NamedQuery(name = "Aif.findByIdAif", query = "SELECT a FROM Aif a WHERE a.idAif = :idAif")
    , @NamedQuery(name = "Aif.findByDateRequested", query = "SELECT a FROM Aif a WHERE a.dateRequested = :dateRequested")
    , @NamedQuery(name = "Aif.findByControlNo", query = "SELECT a FROM Aif a WHERE a.controlNo = :controlNo")
    , @NamedQuery(name = "Aif.findByDateReceived", query = "SELECT a FROM Aif a WHERE a.dateReceived = :dateReceived")
    , @NamedQuery(name = "Aif.findByReceivedFrom", query = "SELECT a FROM Aif a WHERE a.receivedFrom = :receivedFrom")
    , @NamedQuery(name = "Aif.findByReceivedBy", query = "SELECT a FROM Aif a WHERE a.receivedBy = :receivedBy")})
public class Aif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aif", nullable = false)
    private Integer idAif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_requested", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRequested;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_no", nullable = false)
    private int controlNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_received", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "received_from", nullable = false, length = 45)
    private String receivedFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "received_by", nullable = false, length = 45)
    private String receivedBy;
    @OneToMany(mappedBy = "idAif")
    private List<FormRepo> formRepoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAif")
    private List<AifDetails> aifDetailsList;
    @JoinColumn(name = "id_aif", referencedColumnName = "id_aif_details", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AifDetails aifDetails;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;

    public Aif() {
    }

    public Aif(Integer idAif) {
        this.idAif = idAif;
    }

    public Aif(Integer idAif, Date dateRequested, int controlNo, Date dateReceived, String receivedFrom, String receivedBy) {
        this.idAif = idAif;
        this.dateRequested = dateRequested;
        this.controlNo = controlNo;
        this.dateReceived = dateReceived;
        this.receivedFrom = receivedFrom;
        this.receivedBy = receivedBy;
    }

    public Integer getIdAif() {
        return idAif;
    }

    public void setIdAif(Integer idAif) {
        this.idAif = idAif;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public int getControlNo() {
        return controlNo;
    }

    public void setControlNo(int controlNo) {
        this.controlNo = controlNo;
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

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
    }

    @XmlTransient
    public List<AifDetails> getAifDetailsList() {
        return aifDetailsList;
    }

    public void setAifDetailsList(List<AifDetails> aifDetailsList) {
        this.aifDetailsList = aifDetailsList;
    }

    public AifDetails getAifDetails() {
        return aifDetails;
    }

    public void setAifDetails(AifDetails aifDetails) {
        this.aifDetails = aifDetails;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAif != null ? idAif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aif)) {
            return false;
        }
        Aif other = (Aif) object;
        if ((this.idAif == null && other.idAif != null) || (this.idAif != null && !this.idAif.equals(other.idAif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Aif[ idAif=" + idAif + " ]";
    }
    
}
