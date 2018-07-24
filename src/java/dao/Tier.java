/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    @UniqueConstraint(columnNames = {"id_tier"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tier.findAll", query = "SELECT t FROM Tier t")
    , @NamedQuery(name = "Tier.findByIdTier", query = "SELECT t FROM Tier t WHERE t.idTier = :idTier")})
public class Tier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tier", nullable = false)
    private Integer idTier;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(nullable = false, length = 16777215)
    private String position;
    @OneToMany(mappedBy = "idTier")
    private List<Employee> employeeList;

    public Tier() {
    }

    public Tier(Integer idTier) {
        this.idTier = idTier;
    }

    public Tier(Integer idTier, String position) {
        this.idTier = idTier;
        this.position = position;
    }

    public Integer getIdTier() {
        return idTier;
    }

    public void setIdTier(Integer idTier) {
        this.idTier = idTier;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTier != null ? idTier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tier)) {
            return false;
        }
        Tier other = (Tier) object;
        if ((this.idTier == null && other.idTier != null) || (this.idTier != null && !this.idTier.equals(other.idTier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Tier[ idTier=" + idTier + " ]";
    }
    
}
