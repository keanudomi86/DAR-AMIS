/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "par_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_par"})
    , @UniqueConstraint(columnNames = {"id_par_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParDetails.findAll", query = "SELECT p FROM ParDetails p")
    , @NamedQuery(name = "ParDetails.findByIdParDetails", query = "SELECT p FROM ParDetails p WHERE p.idParDetails = :idParDetails")
    , @NamedQuery(name = "ParDetails.findByIdPar", query = "SELECT p FROM ParDetails p WHERE p.idPar = :idPar")
    , @NamedQuery(name = "ParDetails.findByParId", query = "SELECT p FROM ParDetails p WHERE p.parId = :parId")
    , @NamedQuery(name = "ParDetails.findByQuantity", query = "SELECT p FROM ParDetails p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "ParDetails.findByUnit", query = "SELECT p FROM ParDetails p WHERE p.unit = :unit")
    , @NamedQuery(name = "ParDetails.findByDescription", query = "SELECT p FROM ParDetails p WHERE p.description = :description")
    , @NamedQuery(name = "ParDetails.findByPropertyNo", query = "SELECT p FROM ParDetails p WHERE p.propertyNo = :propertyNo")
    , @NamedQuery(name = "ParDetails.findByDateAcq", query = "SELECT p FROM ParDetails p WHERE p.dateAcq = :dateAcq")
    , @NamedQuery(name = "ParDetails.findByAmount", query = "SELECT p FROM ParDetails p WHERE p.amount = :amount")})
public class ParDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_par_details", nullable = false)
    private Integer idParDetails;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_par", nullable = false)
    private int idPar;
    @Column(name = "par_id")
    private Integer parId;
    private Integer quantity;
    @Size(max = 45)
    @Column(length = 45)
    private String unit;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Column(name = "property_no")
    private Integer propertyNo;
    @Column(name = "date_acq")
    @Temporal(TemporalType.DATE)
    private Date dateAcq;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float amount;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "parDetails")
    private Par par;

    public ParDetails() {
    }

    public ParDetails(Integer idParDetails) {
        this.idParDetails = idParDetails;
    }

    public ParDetails(Integer idParDetails, int idPar) {
        this.idParDetails = idParDetails;
        this.idPar = idPar;
    }

    public Integer getIdParDetails() {
        return idParDetails;
    }

    public void setIdParDetails(Integer idParDetails) {
        this.idParDetails = idParDetails;
    }

    public int getIdPar() {
        return idPar;
    }

    public void setIdPar(int idPar) {
        this.idPar = idPar;
    }

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Integer getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(Integer propertyNo) {
        this.propertyNo = propertyNo;
    }

    public Date getDateAcq() {
        return dateAcq;
    }

    public void setDateAcq(Date dateAcq) {
        this.dateAcq = dateAcq;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Par getPar() {
        return par;
    }

    public void setPar(Par par) {
        this.par = par;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParDetails != null ? idParDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParDetails)) {
            return false;
        }
        ParDetails other = (ParDetails) object;
        if ((this.idParDetails == null && other.idParDetails != null) || (this.idParDetails != null && !this.idParDetails.equals(other.idParDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ParDetails[ idParDetails=" + idParDetails + " ]";
    }
    
}
