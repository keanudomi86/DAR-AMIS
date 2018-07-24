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
    @UniqueConstraint(columnNames = {"id_announcements"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Announcements.findAll", query = "SELECT a FROM Announcements a")
    , @NamedQuery(name = "Announcements.findByIdAnnouncements", query = "SELECT a FROM Announcements a WHERE a.idAnnouncements = :idAnnouncements")
    , @NamedQuery(name = "Announcements.findByDatePosted", query = "SELECT a FROM Announcements a WHERE a.datePosted = :datePosted")
    , @NamedQuery(name = "Announcements.findBySubject", query = "SELECT a FROM Announcements a WHERE a.subject = :subject")
    , @NamedQuery(name = "Announcements.findByAnnouncement", query = "SELECT a FROM Announcements a WHERE a.announcement = :announcement")})
public class Announcements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_announcements", nullable = false)
    private Integer idAnnouncements;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_posted", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePosted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(nullable = false, length = 90)
    private String announcement;
    @JoinColumn(name = "announcement_by", referencedColumnName = "id_employee", nullable = false)
    @ManyToOne(optional = false)
    private Employee announcementBy;

    public Announcements() {
    }

    public Announcements(Integer idAnnouncements) {
        this.idAnnouncements = idAnnouncements;
    }

    public Announcements(Integer idAnnouncements, Date datePosted, String subject, String announcement) {
        this.idAnnouncements = idAnnouncements;
        this.datePosted = datePosted;
        this.subject = subject;
        this.announcement = announcement;
    }

    public Integer getIdAnnouncements() {
        return idAnnouncements;
    }

    public void setIdAnnouncements(Integer idAnnouncements) {
        this.idAnnouncements = idAnnouncements;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Employee getAnnouncementBy() {
        return announcementBy;
    }

    public void setAnnouncementBy(Employee announcementBy) {
        this.announcementBy = announcementBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnnouncements != null ? idAnnouncements.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announcements)) {
            return false;
        }
        Announcements other = (Announcements) object;
        if ((this.idAnnouncements == null && other.idAnnouncements != null) || (this.idAnnouncements != null && !this.idAnnouncements.equals(other.idAnnouncements))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Announcements[ idAnnouncements=" + idAnnouncements + " ]";
    }
    
}
