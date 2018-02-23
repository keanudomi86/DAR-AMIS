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
    @NamedQuery(name = "Usertier.findAll", query = "SELECT u FROM Usertier u")
    , @NamedQuery(name = "Usertier.findByIdUserTier", query = "SELECT u FROM Usertier u WHERE u.idUserTier = :idUserTier")
    , @NamedQuery(name = "Usertier.findByUserType", query = "SELECT u FROM Usertier u WHERE u.userType = :userType")})
public class Usertier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_UserTier")
    private Integer idUserTier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_type")
    private String userType;
    @JoinColumn(name = "division", referencedColumnName = "id_Division")
    @ManyToOne(optional = false)
    private Division division;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usertierId")
    private List<User> userList;

    public Usertier() {
    }

    public Usertier(Integer idUserTier) {
        this.idUserTier = idUserTier;
    }

    public Usertier(Integer idUserTier, String userType) {
        this.idUserTier = idUserTier;
        this.userType = userType;
    }

    public Integer getIdUserTier() {
        return idUserTier;
    }

    public void setIdUserTier(Integer idUserTier) {
        this.idUserTier = idUserTier;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
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
        hash += (idUserTier != null ? idUserTier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertier)) {
            return false;
        }
        Usertier other = (Usertier) object;
        if ((this.idUserTier == null && other.idUserTier != null) || (this.idUserTier != null && !this.idUserTier.equals(other.idUserTier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Usertier[ idUserTier=" + idUserTier + " ]";
    }
    
}
