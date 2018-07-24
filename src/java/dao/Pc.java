/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pc"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pc.findAll", query = "SELECT p FROM Pc p")
    , @NamedQuery(name = "Pc.findByIdPc", query = "SELECT p FROM Pc p WHERE p.idPc = :idPc")
    , @NamedQuery(name = "Pc.findByPpeId", query = "SELECT p FROM Pc p WHERE p.ppeId = :ppeId")
    , @NamedQuery(name = "Pc.findByPropertyNo", query = "SELECT p FROM Pc p WHERE p.propertyNo = :propertyNo")
    , @NamedQuery(name = "Pc.findByDescription", query = "SELECT p FROM Pc p WHERE p.description = :description")
    , @NamedQuery(name = "Pc.findBySupplier", query = "SELECT p FROM Pc p WHERE p.supplier = :supplier")
    , @NamedQuery(name = "Pc.findByDrSiNo", query = "SELECT p FROM Pc p WHERE p.drSiNo = :drSiNo")
    , @NamedQuery(name = "Pc.findByQuantity", query = "SELECT p FROM Pc p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Pc.findByAmount", query = "SELECT p FROM Pc p WHERE p.amount = :amount")
    , @NamedQuery(name = "Pc.findByRepairNature", query = "SELECT p FROM Pc p WHERE p.repairNature = :repairNature")
    , @NamedQuery(name = "Pc.findByDate", query = "SELECT p FROM Pc p WHERE p.date = :date")
    , @NamedQuery(name = "Pc.findByRemarks", query = "SELECT p FROM Pc p WHERE p.remarks = :remarks")
    , @NamedQuery(name = "Pc.findByOffice", query = "SELECT p FROM Pc p WHERE p.office = :office")
    , @NamedQuery(name = "Pc.findByEndUser", query = "SELECT p FROM Pc p WHERE p.endUser = :endUser")})
public class Pc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pc", nullable = false)
    private Integer idPc;
    @Column(name = "ppe_id")
    private Integer ppeId;
    @Column(name = "property_no")
    private Integer propertyNo;
    @Size(max = 45)
    @Column(length = 45)
    private String description;
    @Size(max = 45)
    @Column(length = 45)
    private String supplier;
    @Column(name = "dr_si_no")
    private Integer drSiNo;
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12)
    private Float amount;
    @Size(max = 45)
    @Column(name = "repair_nature", length = 45)
    private String repairNature;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(length = 45)
    private String remarks;
    @Size(max = 45)
    @Column(length = 45)
    private String office;
    @Size(max = 45)
    @Column(name = "end_user", length = 45)
    private String endUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPc")
    private List<Rpcppe> rpcppeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPc")
    private List<Ppelc> ppelcList;
    @JoinColumn(name = "id_dr", referencedColumnName = "id_dr", nullable = false)
    @ManyToOne(optional = false)
    private Dr idDr;
    @JoinColumn(name = "id_par", referencedColumnName = "id_par", nullable = false)
    @ManyToOne(optional = false)
    private Par idPar;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po", nullable = false)
    @ManyToOne(optional = false)
    private Po idPo;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr", nullable = false)
    @ManyToOne(optional = false)
    private Pr idPr;

    public Pc() {
    }

    public Pc(Integer idPc) {
        this.idPc = idPc;
    }

    public Integer getIdPc() {
        return idPc;
    }

    public void setIdPc(Integer idPc) {
        this.idPc = idPc;
    }

    public Integer getPpeId() {
        return ppeId;
    }

    public void setPpeId(Integer ppeId) {
        this.ppeId = ppeId;
    }

    public Integer getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(Integer propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getDrSiNo() {
        return drSiNo;
    }

    public void setDrSiNo(Integer drSiNo) {
        this.drSiNo = drSiNo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getRepairNature() {
        return repairNature;
    }

    public void setRepairNature(String repairNature) {
        this.repairNature = repairNature;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getEndUser() {
        return endUser;
    }

    public void setEndUser(String endUser) {
        this.endUser = endUser;
    }

    @XmlTransient
    public List<Rpcppe> getRpcppeList() {
        return rpcppeList;
    }

    public void setRpcppeList(List<Rpcppe> rpcppeList) {
        this.rpcppeList = rpcppeList;
    }

    @XmlTransient
    public List<Ppelc> getPpelcList() {
        return ppelcList;
    }

    public void setPpelcList(List<Ppelc> ppelcList) {
        this.ppelcList = ppelcList;
    }

    public Dr getIdDr() {
        return idDr;
    }

    public void setIdDr(Dr idDr) {
        this.idDr = idDr;
    }

    public Par getIdPar() {
        return idPar;
    }

    public void setIdPar(Par idPar) {
        this.idPar = idPar;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
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
        hash += (idPc != null ? idPc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pc)) {
            return false;
        }
        Pc other = (Pc) object;
        if ((this.idPc == null && other.idPc != null) || (this.idPc != null && !this.idPc.equals(other.idPc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Pc[ idPc=" + idPc + " ]";
    }
    
}
