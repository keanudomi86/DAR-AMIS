/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@Table(catalog = "daramis", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_tier"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tier.findAll", query = "SELECT t FROM Tier t")
    , @NamedQuery(name = "Tier.findByIdTier", query = "SELECT t FROM Tier t WHERE t.idTier = :idTier")})
public class Tier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tier", nullable = false)
    private Integer idTier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTier")
    private List<Employee> employeeList;

    public Tier() {
    }

    public Tier(Integer idTier) {
        this.idTier = idTier;
    }

    public Integer getIdTier() {
        return idTier;
    }

    public void setIdTier(Integer idTier) {
        this.idTier = idTier;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTier != null ? idTier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tier)) {
            return false;
        }
        Tier other = (Tier) object;
        if ((this.idTier == null && other.idTier != null) || (this.idTier != null && !this.idTier.equals(other.idTier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Tier[ idTier=" + idTier + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package dao;

import database.DBConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserType;

public class Tier {

    public ArrayList<Tier> getTiers() {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection con = myFactory.getConnection();

            String query = "SELECT * FROM employee ORDER BY id_Tier;";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            ArrayList<Tier> types = new ArrayList<Tier>();
            while (rs.next()) {
                Tier t = new Tier();

                t.setTierID(rs.getInt("userTypeID"));
                t.setUser(rs.getString("type"));

                types.add(u);
            }

            ps.close();
            con.close();

            return types;
        } catch (SQLException ex) {
            Logger.getLogger(UserTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getTypeName(int tID) {
        String tName = "";

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection con = myFactory.getConnection();

            String query = "SELECT * FROM ref_userType WHERE userTypeID = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, tID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tName = rs.getString("type");
            }

            ps.close();
            con.close();

            return tName;
        } catch (SQLException ex) {
            Logger.getLogger(UserTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tName;
    }

}*/

