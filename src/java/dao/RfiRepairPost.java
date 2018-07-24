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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "rfi_repair_post", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_repair_post"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RfiRepairPost.findAll", query = "SELECT r FROM RfiRepairPost r")
    , @NamedQuery(name = "RfiRepairPost.findByIdRepairPost", query = "SELECT r FROM RfiRepairPost r WHERE r.idRepairPost = :idRepairPost")
    , @NamedQuery(name = "RfiRepairPost.findByNameRequest", query = "SELECT r FROM RfiRepairPost r WHERE r.nameRequest = :nameRequest")
    , @NamedQuery(name = "RfiRepairPost.findByDateRequested", query = "SELECT r FROM RfiRepairPost r WHERE r.dateRequested = :dateRequested")
    , @NamedQuery(name = "RfiRepairPost.findByTypeOfRequest", query = "SELECT r FROM RfiRepairPost r WHERE r.typeOfRequest = :typeOfRequest")})
public class RfiRepairPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_repair_post", nullable = false)
    private Integer idRepairPost;
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

    public RfiRepairPost() {
    }

    public RfiRepairPost(Integer idRepairPost) {
        this.idRepairPost = idRepairPost;
    }

    public RfiRepairPost(Integer idRepairPost, String nameRequest, Date dateRequested, String typeOfRequest) {
        this.idRepairPost = idRepairPost;
        this.nameRequest = nameRequest;
        this.dateRequested = dateRequested;
        this.typeOfRequest = typeOfRequest;
    }

    public Integer getIdRepairPost() {
        return idRepairPost;
    }

    public void setIdRepairPost(Integer idRepairPost) {
        this.idRepairPost = idRepairPost;
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
        hash += (idRepairPost != null ? idRepairPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RfiRepairPost)) {
            return false;
        }
        RfiRepairPost other = (RfiRepairPost) object;
        if ((this.idRepairPost == null && other.idRepairPost != null) || (this.idRepairPost != null && !this.idRepairPost.equals(other.idRepairPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.RfiRepairPost[ idRepairPost=" + idRepairPost + " ]";
    }
    
}
