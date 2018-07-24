/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "form_repo", catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_form_repo"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormRepo.findAll", query = "SELECT f FROM FormRepo f")
    , @NamedQuery(name = "FormRepo.findByIdFormRepo", query = "SELECT f FROM FormRepo f WHERE f.idFormRepo = :idFormRepo")
    , @NamedQuery(name = "FormRepo.findByIdIar", query = "SELECT f FROM FormRepo f WHERE f.idIar = :idIar")
    , @NamedQuery(name = "FormRepo.findByDateCreated", query = "SELECT f FROM FormRepo f WHERE f.dateCreated = :dateCreated")
    , @NamedQuery(name = "FormRepo.findByApproveDate", query = "SELECT f FROM FormRepo f WHERE f.approveDate = :approveDate")
    , @NamedQuery(name = "FormRepo.findByDenyDate", query = "SELECT f FROM FormRepo f WHERE f.denyDate = :denyDate")})
public class FormRepo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_form_repo", nullable = false)
    private Integer idFormRepo;
    @Column(name = "id_iar")
    private Integer idIar;
    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "approve_date")
    @Temporal(TemporalType.DATE)
    private Date approveDate;
    @Column(name = "deny_date")
    @Temporal(TemporalType.DATE)
    private Date denyDate;
    @Lob
    @Size(max = 16777215)
    @Column(length = 16777215)
    private String comments;
    @JoinColumn(name = "id_par", referencedColumnName = "id_par")
    @ManyToOne
    private Par idPar;
    @JoinColumn(name = "id_aif", referencedColumnName = "id_aif")
    @ManyToOne
    private Aif idAif;
    @JoinColumn(name = "approved_by", referencedColumnName = "id_employee")
    @ManyToOne
    private Employee approvedBy;
    @JoinColumn(name = "id_sc", referencedColumnName = "id_sc")
    @ManyToOne
    private Sc idSc;
    @JoinColumn(name = "id_rsmi", referencedColumnName = "id_rsmi")
    @ManyToOne
    private Rsmi idRsmi;
    @JoinColumn(name = "created_by", referencedColumnName = "id_employee")
    @ManyToOne
    private Employee createdBy;
    @JoinColumn(name = "denied_by", referencedColumnName = "id_employee")
    @ManyToOne
    private Employee deniedBy;
    @JoinColumn(name = "id_ris", referencedColumnName = "id_ris")
    @ManyToOne
    private Ris idRis;
    @JoinColumn(name = "id_rpcppe", referencedColumnName = "id_rpcppe")
    @ManyToOne
    private Rpcppe idRpcppe;
    @JoinColumn(name = "id_ics", referencedColumnName = "id_ics")
    @ManyToOne
    private Ics idIcs;
    @JoinColumn(name = "id_iirup", referencedColumnName = "id_iirup")
    @ManyToOne
    private Iirup idIirup;
    @JoinColumn(name = "id_wmr", referencedColumnName = "id_wmr")
    @ManyToOne
    private Wmr idWmr;
    @JoinColumn(name = "id_po", referencedColumnName = "id_po")
    @ManyToOne
    private Po idPo;
    @JoinColumn(name = "id_rfi", referencedColumnName = "id_rfi")
    @ManyToOne
    private Rfi idRfi;
    @JoinColumn(name = "id_ppelc", referencedColumnName = "id_ppelc")
    @ManyToOne
    private Ppelc idPpelc;
    @JoinColumn(name = "id_rpci", referencedColumnName = "id_rpci")
    @ManyToOne
    private Rpci idRpci;
    @JoinColumn(name = "id_pr", referencedColumnName = "id_pr")
    @ManyToOne
    private Pr idPr;
    @JoinColumn(name = "id_ptr", referencedColumnName = "id_ptr")
    @ManyToOne
    private Ptr idPtr;

    public FormRepo() {
    }

    public FormRepo(Integer idFormRepo) {
        this.idFormRepo = idFormRepo;
    }

    public Integer getIdFormRepo() {
        return idFormRepo;
    }

    public void setIdFormRepo(Integer idFormRepo) {
        this.idFormRepo = idFormRepo;
    }

    public Integer getIdIar() {
        return idIar;
    }

    public void setIdIar(Integer idIar) {
        this.idIar = idIar;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Date getDenyDate() {
        return denyDate;
    }

    public void setDenyDate(Date denyDate) {
        this.denyDate = denyDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Par getIdPar() {
        return idPar;
    }

    public void setIdPar(Par idPar) {
        this.idPar = idPar;
    }

    public Aif getIdAif() {
        return idAif;
    }

    public void setIdAif(Aif idAif) {
        this.idAif = idAif;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Sc getIdSc() {
        return idSc;
    }

    public void setIdSc(Sc idSc) {
        this.idSc = idSc;
    }

    public Rsmi getIdRsmi() {
        return idRsmi;
    }

    public void setIdRsmi(Rsmi idRsmi) {
        this.idRsmi = idRsmi;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Employee getDeniedBy() {
        return deniedBy;
    }

    public void setDeniedBy(Employee deniedBy) {
        this.deniedBy = deniedBy;
    }

    public Ris getIdRis() {
        return idRis;
    }

    public void setIdRis(Ris idRis) {
        this.idRis = idRis;
    }

    public Rpcppe getIdRpcppe() {
        return idRpcppe;
    }

    public void setIdRpcppe(Rpcppe idRpcppe) {
        this.idRpcppe = idRpcppe;
    }

    public Ics getIdIcs() {
        return idIcs;
    }

    public void setIdIcs(Ics idIcs) {
        this.idIcs = idIcs;
    }

    public Iirup getIdIirup() {
        return idIirup;
    }

    public void setIdIirup(Iirup idIirup) {
        this.idIirup = idIirup;
    }

    public Wmr getIdWmr() {
        return idWmr;
    }

    public void setIdWmr(Wmr idWmr) {
        this.idWmr = idWmr;
    }

    public Po getIdPo() {
        return idPo;
    }

    public void setIdPo(Po idPo) {
        this.idPo = idPo;
    }

    public Rfi getIdRfi() {
        return idRfi;
    }

    public void setIdRfi(Rfi idRfi) {
        this.idRfi = idRfi;
    }

    public Ppelc getIdPpelc() {
        return idPpelc;
    }

    public void setIdPpelc(Ppelc idPpelc) {
        this.idPpelc = idPpelc;
    }

    public Rpci getIdRpci() {
        return idRpci;
    }

    public void setIdRpci(Rpci idRpci) {
        this.idRpci = idRpci;
    }

    public Pr getIdPr() {
        return idPr;
    }

    public void setIdPr(Pr idPr) {
        this.idPr = idPr;
    }

    public Ptr getIdPtr() {
        return idPtr;
    }

    public void setIdPtr(Ptr idPtr) {
        this.idPtr = idPtr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormRepo != null ? idFormRepo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormRepo)) {
            return false;
        }
        FormRepo other = (FormRepo) object;
        if ((this.idFormRepo == null && other.idFormRepo != null) || (this.idFormRepo != null && !this.idFormRepo.equals(other.idFormRepo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.FormRepo[ idFormRepo=" + idFormRepo + " ]";
    }
    
}
