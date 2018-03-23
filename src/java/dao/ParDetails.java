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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(name = "par_details", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idpar_details"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParDetails.findAll", query = "SELECT p FROM ParDetails p")
    , @NamedQuery(name = "ParDetails.findByIdparDetails", query = "SELECT p FROM ParDetails p WHERE p.idparDetails = :idparDetails")
    , @NamedQuery(name = "ParDetails.findByEntity", query = "SELECT p FROM ParDetails p WHERE p.entity = :entity")
    , @NamedQuery(name = "ParDetails.findByParNo", query = "SELECT p FROM ParDetails p WHERE p.parNo = :parNo")
    , @NamedQuery(name = "ParDetails.findByFundCluster", query = "SELECT p FROM ParDetails p WHERE p.fundCluster = :fundCluster")
    , @NamedQuery(name = "ParDetails.findByQuantity", query = "SELECT p FROM ParDetails p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "ParDetails.findByUnit", query = "SELECT p FROM ParDetails p WHERE p.unit = :unit")
    , @NamedQuery(name = "ParDetails.findByDescription", query = "SELECT p FROM ParDetails p WHERE p.description = :description")
    , @NamedQuery(name = "ParDetails.findByPropertyNo", query = "SELECT p FROM ParDetails p WHERE p.propertyNo = :propertyNo")
    , @NamedQuery(name = "ParDetails.findByDateAcq", query = "SELECT p FROM ParDetails p WHERE p.dateAcq = :dateAcq")
    , @NamedQuery(name = "ParDetails.findByAmount", query = "SELECT p FROM ParDetails p WHERE p.amount = :amount")
    , @NamedQuery(name = "ParDetails.findByPurpose", query = "SELECT p FROM ParDetails p WHERE p.purpose = :purpose")
    , @NamedQuery(name = "ParDetails.findByNameRec", query = "SELECT p FROM ParDetails p WHERE p.nameRec = :nameRec")
    , @NamedQuery(name = "ParDetails.findByPosRec", query = "SELECT p FROM ParDetails p WHERE p.posRec = :posRec")
    , @NamedQuery(name = "ParDetails.findByOffRec", query = "SELECT p FROM ParDetails p WHERE p.offRec = :offRec")
    , @NamedQuery(name = "ParDetails.findByDateRec", query = "SELECT p FROM ParDetails p WHERE p.dateRec = :dateRec")
    , @NamedQuery(name = "ParDetails.findByNameIss", query = "SELECT p FROM ParDetails p WHERE p.nameIss = :nameIss")
    , @NamedQuery(name = "ParDetails.findByPosIss", query = "SELECT p FROM ParDetails p WHERE p.posIss = :posIss")
    , @NamedQuery(name = "ParDetails.findByOffIss", query = "SELECT p FROM ParDetails p WHERE p.offIss = :offIss")
    , @NamedQuery(name = "ParDetails.findByDateIss", query = "SELECT p FROM ParDetails p WHERE p.dateIss = :dateIss")})
public class ParDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpar_details", nullable = false)
    private Integer idparDetails;
    @Size(max = 45)
    @Column(length = 45)
    private String entity;
    @Column(name = "par_no")
    private Integer parNo;
    @Size(max = 45)
    @Column(name = "fund_cluster", length = 45)
    private String fundCluster;
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
    @Size(max = 45)
    @Column(length = 45)
    private String purpose;
    @Size(max = 45)
    @Column(name = "name_rec", length = 45)
    private String nameRec;
    @Size(max = 45)
    @Column(name = "pos_rec", length = 45)
    private String posRec;
    @Size(max = 45)
    @Column(name = "off_rec", length = 45)
    private String offRec;
    @Column(name = "date_rec")
    @Temporal(TemporalType.DATE)
    private Date dateRec;
    @Size(max = 45)
    @Column(name = "name_iss", length = 45)
    private String nameIss;
    @Size(max = 45)
    @Column(name = "pos_iss", length = 45)
    private String posIss;
    @Size(max = 45)
    @Column(name = "off_iss", length = 45)
    private String offIss;
    @Column(name = "date_iss")
    @Temporal(TemporalType.DATE)
    private Date dateIss;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "parDetails")
    private Par par;

    public ParDetails() {
    }

    public ParDetails(Integer idparDetails) {
        this.idparDetails = idparDetails;
    }

    public Integer getIdparDetails() {
        return idparDetails;
    }

    public void setIdparDetails(Integer idparDetails) {
        this.idparDetails = idparDetails;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getParNo() {
        return parNo;
    }

    public void setParNo(Integer parNo) {
        this.parNo = parNo;
    }

    public String getFundCluster() {
        return fundCluster;
    }

    public void setFundCluster(String fundCluster) {
        this.fundCluster = fundCluster;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNameRec() {
        return nameRec;
    }

    public void setNameRec(String nameRec) {
        this.nameRec = nameRec;
    }

    public String getPosRec() {
        return posRec;
    }

    public void setPosRec(String posRec) {
        this.posRec = posRec;
    }

    public String getOffRec() {
        return offRec;
    }

    public void setOffRec(String offRec) {
        this.offRec = offRec;
    }

    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    public String getNameIss() {
        return nameIss;
    }

    public void setNameIss(String nameIss) {
        this.nameIss = nameIss;
    }

    public String getPosIss() {
        return posIss;
    }

    public void setPosIss(String posIss) {
        this.posIss = posIss;
    }

    public String getOffIss() {
        return offIss;
    }

    public void setOffIss(String offIss) {
        this.offIss = offIss;
    }

    public Date getDateIss() {
        return dateIss;
    }

    public void setDateIss(Date dateIss) {
        this.dateIss = dateIss;
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
        hash += (idparDetails != null ? idparDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParDetails)) {
            return false;
        }
        ParDetails other = (ParDetails) object;
        if ((this.idparDetails == null && other.idparDetails != null) || (this.idparDetails != null && !this.idparDetails.equals(other.idparDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.ParDetails[ idparDetails=" + idparDetails + " ]";
    }
    
}
