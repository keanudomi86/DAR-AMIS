/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wfp.findAll", query = "SELECT w FROM Wfp w")
    , @NamedQuery(name = "Wfp.findByIdWorkfinplan", query = "SELECT w FROM Wfp w WHERE w.idWorkfinplan = :idWorkfinplan")
    , @NamedQuery(name = "Wfp.findByProgramactproj", query = "SELECT w FROM Wfp w WHERE w.programactproj = :programactproj")
    , @NamedQuery(name = "Wfp.findByWeightassign", query = "SELECT w FROM Wfp w WHERE w.weightassign = :weightassign")
    , @NamedQuery(name = "Wfp.findByKeyperindi", query = "SELECT w FROM Wfp w WHERE w.keyperindi = :keyperindi")
    , @NamedQuery(name = "Wfp.findByActivityStartdate", query = "SELECT w FROM Wfp w WHERE w.activityStartdate = :activityStartdate")
    , @NamedQuery(name = "Wfp.findByActivityEnddate", query = "SELECT w FROM Wfp w WHERE w.activityEnddate = :activityEnddate")
    , @NamedQuery(name = "Wfp.findByActivitytimeline1st", query = "SELECT w FROM Wfp w WHERE w.activitytimeline1st = :activitytimeline1st")
    , @NamedQuery(name = "Wfp.findByActivitytimeline2nd", query = "SELECT w FROM Wfp w WHERE w.activitytimeline2nd = :activitytimeline2nd")
    , @NamedQuery(name = "Wfp.findByActivitytimeline3rd", query = "SELECT w FROM Wfp w WHERE w.activitytimeline3rd = :activitytimeline3rd")
    , @NamedQuery(name = "Wfp.findByActivitytimeline4th", query = "SELECT w FROM Wfp w WHERE w.activitytimeline4th = :activitytimeline4th")
    , @NamedQuery(name = "Wfp.findByTotalCytarget", query = "SELECT w FROM Wfp w WHERE w.totalCytarget = :totalCytarget")
    , @NamedQuery(name = "Wfp.findByCostPerunit", query = "SELECT w FROM Wfp w WHERE w.costPerunit = :costPerunit")
    , @NamedQuery(name = "Wfp.findByUnitofMeasure", query = "SELECT w FROM Wfp w WHERE w.unitofMeasure = :unitofMeasure")
    , @NamedQuery(name = "Wfp.findByQuarterlybudget1st", query = "SELECT w FROM Wfp w WHERE w.quarterlybudget1st = :quarterlybudget1st")
    , @NamedQuery(name = "Wfp.findByQuarterlybudget2nd", query = "SELECT w FROM Wfp w WHERE w.quarterlybudget2nd = :quarterlybudget2nd")
    , @NamedQuery(name = "Wfp.findByQuarterlybudget3rd", query = "SELECT w FROM Wfp w WHERE w.quarterlybudget3rd = :quarterlybudget3rd")
    , @NamedQuery(name = "Wfp.findByQuarterlybudget4th", query = "SELECT w FROM Wfp w WHERE w.quarterlybudget4th = :quarterlybudget4th")
    , @NamedQuery(name = "Wfp.findByTotalCybudget", query = "SELECT w FROM Wfp w WHERE w.totalCybudget = :totalCybudget")
    , @NamedQuery(name = "Wfp.findByRemarks", query = "SELECT w FROM Wfp w WHERE w.remarks = :remarks")
    , @NamedQuery(name = "Wfp.findByTravellingExpenses", query = "SELECT w FROM Wfp w WHERE w.travellingExpenses = :travellingExpenses")
    , @NamedQuery(name = "Wfp.findByTrainingScholarship", query = "SELECT w FROM Wfp w WHERE w.trainingScholarship = :trainingScholarship")
    , @NamedQuery(name = "Wfp.findBySuppliesMaterials", query = "SELECT w FROM Wfp w WHERE w.suppliesMaterials = :suppliesMaterials")
    , @NamedQuery(name = "Wfp.findByCommunicationExp", query = "SELECT w FROM Wfp w WHERE w.communicationExp = :communicationExp")
    , @NamedQuery(name = "Wfp.findByRepresentationExp", query = "SELECT w FROM Wfp w WHERE w.representationExp = :representationExp")
    , @NamedQuery(name = "Wfp.findByProfessionalServ", query = "SELECT w FROM Wfp w WHERE w.professionalServ = :professionalServ")
    , @NamedQuery(name = "Wfp.findByOthers", query = "SELECT w FROM Wfp w WHERE w.others = :others")
    , @NamedQuery(name = "Wfp.findByTotal", query = "SELECT w FROM Wfp w WHERE w.total = :total")})
public class Wfp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_workfinplan")
    private Integer idWorkfinplan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String programactproj;
    @Basic(optional = false)
    @NotNull
    private int weightassign;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String keyperindi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activity_startdate")
    private String activityStartdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activity_enddate")
    private String activityEnddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activitytimeline_1st")
    private String activitytimeline1st;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activitytimeline_2nd")
    private String activitytimeline2nd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activitytimeline_3rd")
    private String activitytimeline3rd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "activitytimeline_4th")
    private String activitytimeline4th;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total_cytarget")
    private String totalCytarget;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cost_perunit")
    private String costPerunit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unitof_measure")
    private String unitofMeasure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "quarterlybudget_1st")
    private String quarterlybudget1st;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "quarterlybudget_2nd")
    private String quarterlybudget2nd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "quarterlybudget_3rd")
    private String quarterlybudget3rd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "quarterlybudget_4th")
    private String quarterlybudget4th;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "total_cybudget")
    private String totalCybudget;
    @Size(max = 45)
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "travelling_expenses")
    private String travellingExpenses;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "training_scholarship")
    private String trainingScholarship;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "supplies_materials")
    private String suppliesMaterials;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "communication_exp")
    private String communicationExp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "representation_exp")
    private String representationExp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "professional_serv")
    private String professionalServ;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String others;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String total;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "office", referencedColumnName = "office")
    @ManyToOne(optional = false)
    private Pr office;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "wfp")
    private Ppmp ppmp;

    public Wfp() {
    }

    public Wfp(Integer idWorkfinplan) {
        this.idWorkfinplan = idWorkfinplan;
    }

    public Wfp(Integer idWorkfinplan, String programactproj, int weightassign, String keyperindi, String activityStartdate, String activityEnddate, String activitytimeline1st, String activitytimeline2nd, String activitytimeline3rd, String activitytimeline4th, String totalCytarget, String costPerunit, String unitofMeasure, String quarterlybudget1st, String quarterlybudget2nd, String quarterlybudget3rd, String quarterlybudget4th, String totalCybudget, String travellingExpenses, String trainingScholarship, String suppliesMaterials, String communicationExp, String representationExp, String professionalServ, String others, String total) {
        this.idWorkfinplan = idWorkfinplan;
        this.programactproj = programactproj;
        this.weightassign = weightassign;
        this.keyperindi = keyperindi;
        this.activityStartdate = activityStartdate;
        this.activityEnddate = activityEnddate;
        this.activitytimeline1st = activitytimeline1st;
        this.activitytimeline2nd = activitytimeline2nd;
        this.activitytimeline3rd = activitytimeline3rd;
        this.activitytimeline4th = activitytimeline4th;
        this.totalCytarget = totalCytarget;
        this.costPerunit = costPerunit;
        this.unitofMeasure = unitofMeasure;
        this.quarterlybudget1st = quarterlybudget1st;
        this.quarterlybudget2nd = quarterlybudget2nd;
        this.quarterlybudget3rd = quarterlybudget3rd;
        this.quarterlybudget4th = quarterlybudget4th;
        this.totalCybudget = totalCybudget;
        this.travellingExpenses = travellingExpenses;
        this.trainingScholarship = trainingScholarship;
        this.suppliesMaterials = suppliesMaterials;
        this.communicationExp = communicationExp;
        this.representationExp = representationExp;
        this.professionalServ = professionalServ;
        this.others = others;
        this.total = total;
    }

    public Integer getIdWorkfinplan() {
        return idWorkfinplan;
    }

    public void setIdWorkfinplan(Integer idWorkfinplan) {
        this.idWorkfinplan = idWorkfinplan;
    }

    public String getProgramactproj() {
        return programactproj;
    }

    public void setProgramactproj(String programactproj) {
        this.programactproj = programactproj;
    }

    public int getWeightassign() {
        return weightassign;
    }

    public void setWeightassign(int weightassign) {
        this.weightassign = weightassign;
    }

    public String getKeyperindi() {
        return keyperindi;
    }

    public void setKeyperindi(String keyperindi) {
        this.keyperindi = keyperindi;
    }

    public String getActivityStartdate() {
        return activityStartdate;
    }

    public void setActivityStartdate(String activityStartdate) {
        this.activityStartdate = activityStartdate;
    }

    public String getActivityEnddate() {
        return activityEnddate;
    }

    public void setActivityEnddate(String activityEnddate) {
        this.activityEnddate = activityEnddate;
    }

    public String getActivitytimeline1st() {
        return activitytimeline1st;
    }

    public void setActivitytimeline1st(String activitytimeline1st) {
        this.activitytimeline1st = activitytimeline1st;
    }

    public String getActivitytimeline2nd() {
        return activitytimeline2nd;
    }

    public void setActivitytimeline2nd(String activitytimeline2nd) {
        this.activitytimeline2nd = activitytimeline2nd;
    }

    public String getActivitytimeline3rd() {
        return activitytimeline3rd;
    }

    public void setActivitytimeline3rd(String activitytimeline3rd) {
        this.activitytimeline3rd = activitytimeline3rd;
    }

    public String getActivitytimeline4th() {
        return activitytimeline4th;
    }

    public void setActivitytimeline4th(String activitytimeline4th) {
        this.activitytimeline4th = activitytimeline4th;
    }

    public String getTotalCytarget() {
        return totalCytarget;
    }

    public void setTotalCytarget(String totalCytarget) {
        this.totalCytarget = totalCytarget;
    }

    public String getCostPerunit() {
        return costPerunit;
    }

    public void setCostPerunit(String costPerunit) {
        this.costPerunit = costPerunit;
    }

    public String getUnitofMeasure() {
        return unitofMeasure;
    }

    public void setUnitofMeasure(String unitofMeasure) {
        this.unitofMeasure = unitofMeasure;
    }

    public String getQuarterlybudget1st() {
        return quarterlybudget1st;
    }

    public void setQuarterlybudget1st(String quarterlybudget1st) {
        this.quarterlybudget1st = quarterlybudget1st;
    }

    public String getQuarterlybudget2nd() {
        return quarterlybudget2nd;
    }

    public void setQuarterlybudget2nd(String quarterlybudget2nd) {
        this.quarterlybudget2nd = quarterlybudget2nd;
    }

    public String getQuarterlybudget3rd() {
        return quarterlybudget3rd;
    }

    public void setQuarterlybudget3rd(String quarterlybudget3rd) {
        this.quarterlybudget3rd = quarterlybudget3rd;
    }

    public String getQuarterlybudget4th() {
        return quarterlybudget4th;
    }

    public void setQuarterlybudget4th(String quarterlybudget4th) {
        this.quarterlybudget4th = quarterlybudget4th;
    }

    public String getTotalCybudget() {
        return totalCybudget;
    }

    public void setTotalCybudget(String totalCybudget) {
        this.totalCybudget = totalCybudget;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTravellingExpenses() {
        return travellingExpenses;
    }

    public void setTravellingExpenses(String travellingExpenses) {
        this.travellingExpenses = travellingExpenses;
    }

    public String getTrainingScholarship() {
        return trainingScholarship;
    }

    public void setTrainingScholarship(String trainingScholarship) {
        this.trainingScholarship = trainingScholarship;
    }

    public String getSuppliesMaterials() {
        return suppliesMaterials;
    }

    public void setSuppliesMaterials(String suppliesMaterials) {
        this.suppliesMaterials = suppliesMaterials;
    }

    public String getCommunicationExp() {
        return communicationExp;
    }

    public void setCommunicationExp(String communicationExp) {
        this.communicationExp = communicationExp;
    }

    public String getRepresentationExp() {
        return representationExp;
    }

    public void setRepresentationExp(String representationExp) {
        this.representationExp = representationExp;
    }

    public String getProfessionalServ() {
        return professionalServ;
    }

    public void setProfessionalServ(String professionalServ) {
        this.professionalServ = professionalServ;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Pr getOffice() {
        return office;
    }

    public void setOffice(Pr office) {
        this.office = office;
    }

    public Ppmp getPpmp() {
        return ppmp;
    }

    public void setPpmp(Ppmp ppmp) {
        this.ppmp = ppmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWorkfinplan != null ? idWorkfinplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wfp)) {
            return false;
        }
        Wfp other = (Wfp) object;
        if ((this.idWorkfinplan == null && other.idWorkfinplan != null) || (this.idWorkfinplan != null && !this.idWorkfinplan.equals(other.idWorkfinplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Wfp[ idWorkfinplan=" + idWorkfinplan + " ]";
    }
    
}
