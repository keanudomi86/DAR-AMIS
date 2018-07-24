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
@Table(name = "app_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_app_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppDetails.findAll", query = "SELECT a FROM AppDetails a")
    , @NamedQuery(name = "AppDetails.findByIdAppDetails", query = "SELECT a FROM AppDetails a WHERE a.idAppDetails = :idAppDetails")
    , @NamedQuery(name = "AppDetails.findByItemSpec", query = "SELECT a FROM AppDetails a WHERE a.itemSpec = :itemSpec")
    , @NamedQuery(name = "AppDetails.findByQ1", query = "SELECT a FROM AppDetails a WHERE a.q1 = :q1")
    , @NamedQuery(name = "AppDetails.findByQ2", query = "SELECT a FROM AppDetails a WHERE a.q2 = :q2")
    , @NamedQuery(name = "AppDetails.findByQ3", query = "SELECT a FROM AppDetails a WHERE a.q3 = :q3")
    , @NamedQuery(name = "AppDetails.findByQ4", query = "SELECT a FROM AppDetails a WHERE a.q4 = :q4")
    , @NamedQuery(name = "AppDetails.findByTotalQty", query = "SELECT a FROM AppDetails a WHERE a.totalQty = :totalQty")
    , @NamedQuery(name = "AppDetails.findByTotalPriceAfn", query = "SELECT a FROM AppDetails a WHERE a.totalPriceAfn = :totalPriceAfn")
    , @NamedQuery(name = "AppDetails.findByIdOffice", query = "SELECT a FROM AppDetails a WHERE a.idOffice = :idOffice")})
public class AppDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_app_details", nullable = false)
    private Integer idAppDetails;
    @Size(max = 120)
    @Column(name = "item_spec", length = 120)
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
    @JoinColumn(name = "id_app", referencedColumnName = "id_app", nullable = false)
    @ManyToOne(optional = false)
    private App idApp;

    public AppDetails() {
    }

    public AppDetails(Integer idAppDetails) {
        this.idAppDetails = idAppDetails;
    }

    public AppDetails(Integer idAppDetails, int idOffice) {
        this.idAppDetails = idAppDetails;
        this.idOffice = idOffice;
    }

    public Integer getIdAppDetails() {
        return idAppDetails;
    }

    public void setIdAppDetails(Integer idAppDetails) {
        this.idAppDetails = idAppDetails;
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

    public App getIdApp() {
        return idApp;
    }

    public void setIdApp(App idApp) {
        this.idApp = idApp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAppDetails != null ? idAppDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppDetails)) {
            return false;
        }
        AppDetails other = (AppDetails) object;
        if ((this.idAppDetails == null && other.idAppDetails != null) || (this.idAppDetails != null && !this.idAppDetails.equals(other.idAppDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.AppDetails[ idAppDetails=" + idAppDetails + " ]";
    }
    
}
