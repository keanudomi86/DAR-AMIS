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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
    , @NamedQuery(name = "Aif.findByIdAif", query = "SELECT a FROM Aif a WHERE a.idAif = :idAif")})
public class Aif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aif", nullable = false)
    private Integer idAif;
    @OneToMany(mappedBy = "idAif")
    private List<FormRepo> formRepoList;
    @JoinColumn(name = "id_aif", referencedColumnName = "idaif_details", nullable = false, insertable = false, updatable = false)
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

    public Integer getIdAif() {
        return idAif;
    }

    public void setIdAif(Integer idAif) {
        this.idAif = idAif;
    }

    @XmlTransient
    public List<FormRepo> getFormRepoList() {
        return formRepoList;
    }

    public void setFormRepoList(List<FormRepo> formRepoList) {
        this.formRepoList = formRepoList;
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
