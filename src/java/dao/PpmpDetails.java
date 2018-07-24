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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "ppmp_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ppmp_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PpmpDetails.findAll", query = "SELECT p FROM PpmpDetails p")
    , @NamedQuery(name = "PpmpDetails.findByIdPpmpDetails", query = "SELECT p FROM PpmpDetails p WHERE p.idPpmpDetails = :idPpmpDetails")
    , @NamedQuery(name = "PpmpDetails.findByItemSpec", query = "SELECT p FROM PpmpDetails p WHERE p.itemSpec = :itemSpec")
    , @NamedQuery(name = "PpmpDetails.findByQ1", query = "SELECT p FROM PpmpDetails p WHERE p.q1 = :q1")
    , @NamedQuery(name = "PpmpDetails.findByQ2", query = "SELECT p FROM PpmpDetails p WHERE p.q2 = :q2")
    , @NamedQuery(name = "PpmpDetails.findByQ3", query = "SELECT p FROM PpmpDetails p WHERE p.q3 = :q3")
    , @NamedQuery(name = "PpmpDetails.findByQ4", query = "SELECT p FROM PpmpDetails p WHERE p.q4 = :q4")
    , @NamedQuery(name = "PpmpDetails.findByTotalQty", query = "SELECT p FROM PpmpDetails p WHERE p.totalQty = :totalQty")
    , @NamedQuery(name = "PpmpDetails.findByTotalPriceAfn", query = "SELECT p FROM PpmpDetails p WHERE p.totalPriceAfn = :totalPriceAfn")
    , @NamedQuery(name = "PpmpDetails.findByIdOffice", query = "SELECT p FROM PpmpDetails p WHERE p.idOffice = :idOffice")})
public class PpmpDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ppmp_details", nullable = false)
    private Integer idPpmpDetails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "item_spec", nullable = false, length = 120)
    private String itemSpec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double q1;
    @Column(precision = 22)
    private Double q2;
    @Column(precision = 22)
    private Double q3;
    @Column(precision = 22)
    private Double q4;
    @Column(name = "total_qty")
    private Integer totalQty;
    @Column(name = "total_price_afn", precision = 22)
    private Double totalPriceAfn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_office", nullable = false)
    private int idOffice;
    @JoinColumn(name = "id_ppmp", referencedColumnName = "id_ppmp", nullable = false)
    @ManyToOne(optional = false)
    private Ppmp idPpmp;

    public PpmpDetails() {
    }

    public PpmpDetails(Integer idPpmpDetails) {
        this.idPpmpDetails = idPpmpDetails;
    }

    public PpmpDetails(Integer idPpmpDetails, String itemSpec, int idOffice) {
        this.idPpmpDetails = idPpmpDetails;
        this.itemSpec = itemSpec;
        this.idOffice = idOffice;
    }

    public Integer getIdPpmpDetails() {
        return idPpmpDetails;
    }

    public void setIdPpmpDetails(Integer idPpmpDetails) {
        this.idPpmpDetails = idPpmpDetails;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
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

    public Integer getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Integer totalQty) {
        this.totalQty = totalQty;
    }

    public Double getTotalPriceAfn() {
        return totalPriceAfn;
    }

    public void setTotalPriceAfn(Double totalPriceAfn) {
        this.totalPriceAfn = totalPriceAfn;
    }

    public int getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(int idOffice) {
        this.idOffice = idOffice;
    }

    public Ppmp getIdPpmp() {
        return idPpmp;
    }

    public void setIdPpmp(Ppmp idPpmp) {
        this.idPpmp = idPpmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPpmpDetails != null ? idPpmpDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PpmpDetails)) {
            return false;
        }
        PpmpDetails other = (PpmpDetails) object;
        if ((this.idPpmpDetails == null && other.idPpmpDetails != null) || (this.idPpmpDetails != null && !this.idPpmpDetails.equals(other.idPpmpDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.PpmpDetails[ idPpmpDetails=" + idPpmpDetails + " ]";
    }
    
}
