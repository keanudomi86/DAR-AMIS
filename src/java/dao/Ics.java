/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ics"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ics.findAll", query = "SELECT i FROM Ics i")
    , @NamedQuery(name = "Ics.findByIdIcs", query = "SELECT i FROM Ics i WHERE i.idIcs = :idIcs")
    , @NamedQuery(name = "Ics.findByIdIcsDetails", query = "SELECT i FROM Ics i WHERE i.idIcsDetails = :idIcsDetails")})
public class Ics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ics", nullable = false)
    private Integer idIcs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ics_details", nullable = false)
    private int idIcsDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIcs")
    private List<IcsDetails> icsDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIcs")
    private List<Ptr> ptrList;

    public Ics() {
    }

    public Ics(Integer idIcs) {
        this.idIcs = idIcs;
    }

    public Ics(Integer idIcs, int idIcsDetails) {
        this.idIcs = idIcs;
        this.idIcsDetails = idIcsDetails;
    }

    public Integer getIdIcs() {
        return idIcs;
    }

    public void setIdIcs(Integer idIcs) {
        this.idIcs = idIcs;
    }

    public int getIdIcsDetails() {
        return idIcsDetails;
    }

    public void setIdIcsDetails(int idIcsDetails) {
        this.idIcsDetails = idIcsDetails;
    }

    @XmlTransient
    public List<IcsDetails> getIcsDetailsList() {
        return icsDetailsList;
    }

    public void setIcsDetailsList(List<IcsDetails> icsDetailsList) {
        this.icsDetailsList = icsDetailsList;
    }

    @XmlTransient
    public List<Ptr> getPtrList() {
        return ptrList;
    }

    public void setPtrList(List<Ptr> ptrList) {
        this.ptrList = ptrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIcs != null ? idIcs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ics)) {
            return false;
        }
        Ics other = (Ics) object;
        if ((this.idIcs == null && other.idIcs != null) || (this.idIcs != null && !this.idIcs.equals(other.idIcs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ics[ idIcs=" + idIcs + " ]";
    }
    
}
