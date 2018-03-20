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
    @UniqueConstraint(columnNames = {"id_rfi"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rfi.findAll", query = "SELECT r FROM Rfi r")
    , @NamedQuery(name = "Rfi.findByIdRfi", query = "SELECT r FROM Rfi r WHERE r.idRfi = :idRfi")})
public class Rfi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rfi", nullable = false)
    private Integer idRfi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRfi")
    private List<RfiDeliveries> rfiDeliveriesList;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @JoinColumn(name = "id_rfi", referencedColumnName = "idrfi_details", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private RfiFk rfiFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRfi")
    private List<RfiRepairPost> rfiRepairPostList;

    public Rfi() {
    }

    public Rfi(Integer idRfi) {
        this.idRfi = idRfi;
    }

    public Integer getIdRfi() {
        return idRfi;
    }

    public void setIdRfi(Integer idRfi) {
        this.idRfi = idRfi;
    }

    @XmlTransient
    public List<RfiDeliveries> getRfiDeliveriesList() {
        return rfiDeliveriesList;
    }

    public void setRfiDeliveriesList(List<RfiDeliveries> rfiDeliveriesList) {
        this.rfiDeliveriesList = rfiDeliveriesList;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    public RfiFk getRfiFk() {
        return rfiFk;
    }

    public void setRfiFk(RfiFk rfiFk) {
        this.rfiFk = rfiFk;
    }

    @XmlTransient
    public List<RfiRepairPost> getRfiRepairPostList() {
        return rfiRepairPostList;
    }

    public void setRfiRepairPostList(List<RfiRepairPost> rfiRepairPostList) {
        this.rfiRepairPostList = rfiRepairPostList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRfi != null ? idRfi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rfi)) {
            return false;
        }
        Rfi other = (Rfi) object;
        if ((this.idRfi == null && other.idRfi != null) || (this.idRfi != null && !this.idRfi.equals(other.idRfi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Rfi[ idRfi=" + idRfi + " ]";
    }
    
}
