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
@Table(name = "pr_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pr_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrDetails.findAll", query = "SELECT p FROM PrDetails p")
    , @NamedQuery(name = "PrDetails.findByIdPrDetails", query = "SELECT p FROM PrDetails p WHERE p.idPrDetails = :idPrDetails")
    , @NamedQuery(name = "PrDetails.findByUnit", query = "SELECT p FROM PrDetails p WHERE p.unit = :unit")
    , @NamedQuery(name = "PrDetails.findByDescription", query = "SELECT p FROM PrDetails p WHERE p.description = :description")
    , @NamedQuery(name = "PrDetails.findByQuantity", query = "SELECT p FROM PrDetails p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "PrDetails.findByCost", query = "SELECT p FROM PrDetails p WHERE p.cost = :cost")})
public class PrDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pr_details", nullable = false)
    private Integer idPrDetails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String unit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private float cost;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;

    public PrDetails() {
    }

    public PrDetails(Integer idPrDetails) {
        this.idPrDetails = idPrDetails;
    }

    public PrDetails(Integer idPrDetails, String unit, String description, int quantity, float cost) {
        this.idPrDetails = idPrDetails;
        this.unit = unit;
        this.description = description;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Integer getIdPrDetails() {
        return idPrDetails;
    }

    public void setIdPrDetails(Integer idPrDetails) {
        this.idPrDetails = idPrDetails;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Pr getIdPr() {
        return idPr;
    }

    public void setIdPr(Pr idPr) {
        this.idPr = idPr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrDetails != null ? idPrDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrDetails)) {
            return false;
        }
        PrDetails other = (PrDetails) object;
        if ((this.idPrDetails == null && other.idPrDetails != null) || (this.idPrDetails != null && !this.idPrDetails.equals(other.idPrDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.PrDetails[ idPrDetails=" + idPrDetails + " ]";
    }
    
}
