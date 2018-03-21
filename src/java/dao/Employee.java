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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_employee"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByIdEmployee", query = "SELECT e FROM Employee e WHERE e.idEmployee = :idEmployee")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByMiddleInitial", query = "SELECT e FROM Employee e WHERE e.middleInitial = :middleInitial")
    , @NamedQuery(name = "Employee.findByCivilStatus", query = "SELECT e FROM Employee e WHERE e.civilStatus = :civilStatus")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address")
    , @NamedQuery(name = "Employee.findByDob", query = "SELECT e FROM Employee e WHERE e.dob = :dob")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByMobileNum", query = "SELECT e FROM Employee e WHERE e.mobileNum = :mobileNum")
    , @NamedQuery(name = "Employee.findByEmployeeStatus", query = "SELECT e FROM Employee e WHERE e.employeeStatus = :employeeStatus")
    , @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByUserActivated", query = "SELECT e FROM Employee e WHERE e.userActivated = :userActivated")
    , @NamedQuery(name = "Employee.findByStartDate", query = "SELECT e FROM Employee e WHERE e.startDate = :startDate")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Size(max = 45)
    @Column(name = "middle_initial", length = 45)
    private String middleInitial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "civil_status", nullable = false, length = 45)
    private String civilStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(nullable = false, length = 120)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobile_num", nullable = false, length = 45)
    private String mobileNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "employee_status", nullable = false, length = 45)
    private String employeeStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_activated", nullable = false)
    private int userActivated;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @JoinColumn(name = "id_division", referencedColumnName = "id_division")
    @ManyToOne
    private Division idDivision;
    @JoinColumn(name = "id_tier", referencedColumnName = "id_tier")
    @ManyToOne
    private Tier idTier;

    public Employee() {
    }

    public Employee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Employee(Integer idEmployee, String lastName, String firstName, String civilStatus, String gender, String address, Date dob, String email, String mobileNum, String employeeStatus, String username, String password, int userActivated) {
        this.idEmployee = idEmployee;
        this.lastName = lastName;
        this.firstName = firstName;
        this.civilStatus = civilStatus;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.mobileNum = mobileNum;
        this.employeeStatus = employeeStatus;
        this.username = username;
        this.password = password;
        this.userActivated = userActivated;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserActivated() {
        return userActivated;
    }

    public void setUserActivated(int userActivated) {
        this.userActivated = userActivated;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Division getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Division idDivision) {
        this.idDivision = idDivision;
    }

    public Tier getIdTier() {
        return idTier;
    }

    public void setIdTier(Tier idTier) {
        this.idTier = idTier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployee != null ? idEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.idEmployee == null && other.idEmployee != null) || (this.idEmployee != null && !this.idEmployee.equals(other.idEmployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Employee[ idEmployee=" + idEmployee + " ]";
    }
    
}
