/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "wfp_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_wfp_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WfpDetails.findAll", query = "SELECT w FROM WfpDetails w")
    , @NamedQuery(name = "WfpDetails.findByIdWfpDetails", query = "SELECT w FROM WfpDetails w WHERE w.idWfpDetails = :idWfpDetails")
    , @NamedQuery(name = "WfpDetails.findByObjectExp", query = "SELECT w FROM WfpDetails w WHERE w.objectExp = :objectExp")
    , @NamedQuery(name = "WfpDetails.findByQ1", query = "SELECT w FROM WfpDetails w WHERE w.q1 = :q1")
    , @NamedQuery(name = "WfpDetails.findByQ2", query = "SELECT w FROM WfpDetails w WHERE w.q2 = :q2")
    , @NamedQuery(name = "WfpDetails.findByQ3", query = "SELECT w FROM WfpDetails w WHERE w.q3 = :q3")
    , @NamedQuery(name = "WfpDetails.findByQ4", query = "SELECT w FROM WfpDetails w WHERE w.q4 = :q4")
    , @NamedQuery(name = "WfpDetails.findByTotalQty", query = "SELECT w FROM WfpDetails w WHERE w.totalQty = :totalQty")})
public class WfpDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_wfp_details", nullable = false)
    private Integer idWfpDetails;
    @Size(max = 45)
    @Column(name = "object_exp", length = 45)
    private String objectExp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double q1;
    @Column(precision = 22)
    private Double q2;
    @Column(precision = 22)
    private Double q3;
    @Column(precision = 22)
    private Double q4;
    @Column(name = "total_qty", precision = 22)
    private Double totalQty;
    @JoinColumn(name = "id_wfp", referencedColumnName = "id_wfp", nullable = false)
    @ManyToOne(optional = false)
    private Wfp idWfp;

    public WfpDetails() {
    }

    public WfpDetails(Integer idWfpDetails) {
        this.idWfpDetails = idWfpDetails;
    }

    public Integer getIdWfpDetails() {
        return idWfpDetails;
    }

    public void setIdWfpDetails(Integer idWfpDetails) {
        this.idWfpDetails = idWfpDetails;
    }

    public String getObjectExp() {
        return objectExp;
    }

    public void setObjectExp(String objectExp) {
        this.objectExp = objectExp;
    }

    public Double getQ1() {
        return q1;
    }

    public void setQ1(Double q1) {
        this.q1 = q1;
    }

    public Double getQ2() {
        return q2;
    }

    public void setQ2(Double q2) {
        this.q2 = q2;
    }

    public Double getQ3() {
        return q3;
    }

    public void setQ3(Double q3) {
        this.q3 = q3;
    }

    public Double getQ4() {
        return q4;
    }

    public void setQ4(Double q4) {
        this.q4 = q4;
    }

    public Double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Double totalQty) {
        this.totalQty = totalQty;
    }

    public Wfp getIdWfp() {
        return idWfp;
    }

    public void setIdWfp(Wfp idWfp) {
        this.idWfp = idWfp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWfpDetails != null ? idWfpDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WfpDetails)) {
            return false;
        }
        WfpDetails other = (WfpDetails) object;
        if ((this.idWfpDetails == null && other.idWfpDetails != null) || (this.idWfpDetails != null && !this.idWfpDetails.equals(other.idWfpDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.WfpDetails[ idWfpDetails=" + idWfpDetails + " ]";
    }

}
