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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personalinfo.findAll", query = "SELECT p FROM Personalinfo p")
    , @NamedQuery(name = "Personalinfo.findByIdPersonalInfo", query = "SELECT p FROM Personalinfo p WHERE p.idPersonalInfo = :idPersonalInfo")
    , @NamedQuery(name = "Personalinfo.findByLname", query = "SELECT p FROM Personalinfo p WHERE p.lname = :lname")
    , @NamedQuery(name = "Personalinfo.findByFname", query = "SELECT p FROM Personalinfo p WHERE p.fname = :fname")
    , @NamedQuery(name = "Personalinfo.findByMname", query = "SELECT p FROM Personalinfo p WHERE p.mname = :mname")
    , @NamedQuery(name = "Personalinfo.findByGender", query = "SELECT p FROM Personalinfo p WHERE p.gender = :gender")
    , @NamedQuery(name = "Personalinfo.findByAddress", query = "SELECT p FROM Personalinfo p WHERE p.address = :address")
    , @NamedQuery(name = "Personalinfo.findByDateBirth", query = "SELECT p FROM Personalinfo p WHERE p.dateBirth = :dateBirth")
    , @NamedQuery(name = "Personalinfo.findByDivision", query = "SELECT p FROM Personalinfo p WHERE p.division = :division")
    , @NamedQuery(name = "Personalinfo.findByPosition", query = "SELECT p FROM Personalinfo p WHERE p.position = :position")
    , @NamedQuery(name = "Personalinfo.findByEmail", query = "SELECT p FROM Personalinfo p WHERE p.email = :email")
    , @NamedQuery(name = "Personalinfo.findByMobileNum", query = "SELECT p FROM Personalinfo p WHERE p.mobileNum = :mobileNum")
    , @NamedQuery(name = "Personalinfo.findByEmpStatus", query = "SELECT p FROM Personalinfo p WHERE p.empStatus = :empStatus")
    , @NamedQuery(name = "Personalinfo.findByCivilStatus", query = "SELECT p FROM Personalinfo p WHERE p.civilStatus = :civilStatus")})
public class Personalinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_PersonalInfo")
    private Integer idPersonalInfo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String mname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "date_birth")
    private String dateBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String division;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String position;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobile_num")
    private String mobileNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emp_status")
    private String empStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "civil_status")
    private String civilStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonalInfo")
    private List<User> userList;

    public Personalinfo() {
    }

    public Personalinfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public Personalinfo(Integer idPersonalInfo, String lname, String fname, String mname, String gender, String address, String dateBirth, String division, String position, String email, String mobileNum, String empStatus, String civilStatus) {
        this.idPersonalInfo = idPersonalInfo;
        this.lname = lname;
        this.fname = fname;
        this.mname = mname;
        this.gender = gender;
        this.address = address;
        this.dateBirth = dateBirth;
        this.division = division;
        this.position = position;
        this.email = email;
        this.mobileNum = mobileNum;
        this.empStatus = empStatus;
        this.civilStatus = civilStatus;
    }

    public Integer getIdPersonalInfo() {
        return idPersonalInfo;
    }

    public void setIdPersonalInfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonalInfo != null ? idPersonalInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personalinfo)) {
            return false;
        }
        Personalinfo other = (Personalinfo) object;
        if ((this.idPersonalInfo == null && other.idPersonalInfo != null) || (this.idPersonalInfo != null && !this.idPersonalInfo.equals(other.idPersonalInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Personalinfo[ idPersonalInfo=" + idPersonalInfo + " ]";
    }
    
}
