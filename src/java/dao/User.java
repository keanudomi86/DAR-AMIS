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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<App> appList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Wfp> wfpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Ppmp> ppmpList;
    @JoinColumn(name = "id_PersonalInfo", referencedColumnName = "id_PersonalInfo")
    @ManyToOne(optional = false)
    private Personalinfo idPersonalInfo;
    @JoinColumn(name = "usertier_id", referencedColumnName = "id_UserTier")
    @ManyToOne(optional = false)
    private Usertier usertierId;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<App> getAppList() {
        return appList;
    }

    public void setAppList(List<App> appList) {
        this.appList = appList;
    }

    @XmlTransient
    public List<Wfp> getWfpList() {
        return wfpList;
    }

    public void setWfpList(List<Wfp> wfpList) {
        this.wfpList = wfpList;
    }

    @XmlTransient
    public List<Ppmp> getPpmpList() {
        return ppmpList;
    }

    public void setPpmpList(List<Ppmp> ppmpList) {
        this.ppmpList = ppmpList;
    }

    public Personalinfo getIdPersonalInfo() {
        return idPersonalInfo;
    }

    public void setIdPersonalInfo(Personalinfo idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public Usertier getUsertierId() {
        return usertierId;
    }

    public void setUsertierId(Usertier usertierId) {
        this.usertierId = usertierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.User[ userId=" + userId + " ]";
    }
    
}
