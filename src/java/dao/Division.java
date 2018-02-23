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
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d")
    , @NamedQuery(name = "Division.findByIdDivision", query = "SELECT d FROM Division d WHERE d.idDivision = :idDivision")
    , @NamedQuery(name = "Division.findByDivisionName", query = "SELECT d FROM Division d WHERE d.divisionName = :divisionName")})
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Division")
    private Integer idDivision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "division_name")
    private String divisionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private List<Usertier> usertierList;

    public Division() {
    }

    public Division(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public Division(Integer idDivision, String divisionName) {
        this.idDivision = idDivision;
        this.divisionName = divisionName;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    @XmlTransient
    public List<Usertier> getUsertierList() {
        return usertierList;
    }

    public void setUsertierList(List<Usertier> usertierList) {
        this.usertierList = usertierList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivision != null ? idDivision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.idDivision == null && other.idDivision != null) || (this.idDivision != null && !this.idDivision.equals(other.idDivision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Division[ idDivision=" + idDivision + " ]";
    }
    
}
