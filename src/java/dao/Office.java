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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_office"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o")
    , @NamedQuery(name = "Office.findByIdOffice", query = "SELECT o FROM Office o WHERE o.idOffice = :idOffice")
    , @NamedQuery(name = "Office.findByDepartment", query = "SELECT o FROM Office o WHERE o.department = :department")})
public class Office implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_office", nullable = false)
    private Integer idOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String department;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOffice")
    private List<Division> divisionList;

    public Office() {
    }

    public Office(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public Office(Integer idOffice, String department) {
        this.idOffice = idOffice;
        this.department = department;
    }

    public Integer getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Integer idOffice) {
        this.idOffice = idOffice;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @XmlTransient
    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffice != null ? idOffice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.idOffice == null && other.idOffice != null) || (this.idOffice != null && !this.idOffice.equals(other.idOffice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Office[ idOffice=" + idOffice + " ]";
    }
    
}
