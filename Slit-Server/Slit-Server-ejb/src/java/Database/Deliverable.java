/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cheezy
 */
@Entity
@Table(name = "deliverable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverable.findAll", query = "SELECT d FROM Deliverable d"),
    @NamedQuery(name = "Deliverable.findByDeliverableID", query = "SELECT d FROM Deliverable d WHERE d.deliverableID = :deliverableID"),
    @NamedQuery(name = "Deliverable.findByDeliverablemessage", query = "SELECT d FROM Deliverable d WHERE d.deliverablemessage = :deliverablemessage"),
    @NamedQuery(name = "Deliverable.findByDeliverablefile", query = "SELECT d FROM Deliverable d WHERE d.deliverablefile = :deliverablefile"),
    @NamedQuery(name = "Deliverable.findByDeliverabledateSent", query = "SELECT d FROM Deliverable d WHERE d.deliverabledateSent = :deliverabledateSent")})
public class Deliverable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Deliverable_ID")
    private Integer deliverableID;
    @Size(max = 200)
    @Column(name = "Deliverable_message")
    private String deliverablemessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Deliverable_file")
    private String deliverablefile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Deliverable_dateSent")
    @Temporal(TemporalType.DATE)
    private Date deliverabledateSent;
    @OneToMany(mappedBy = "fKDeliverableID")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "FK_Module_ID", referencedColumnName = "Module_ID")
    @ManyToOne(optional = false)
    private Module fKModuleID;
    @JoinColumn(name = "FK_Users_ID", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private Userlist fKUsersID;

    public Deliverable() {
    }

    public Deliverable(Integer deliverableID) {
        this.deliverableID = deliverableID;
    }

    public Deliverable(Integer deliverableID, String deliverablefile, Date deliverabledateSent) {
        this.deliverableID = deliverableID;
        this.deliverablefile = deliverablefile;
        this.deliverabledateSent = deliverabledateSent;
    }

    public Integer getDeliverableID() {
        return deliverableID;
    }

    public void setDeliverableID(Integer deliverableID) {
        this.deliverableID = deliverableID;
    }

    public String getDeliverablemessage() {
        return deliverablemessage;
    }

    public void setDeliverablemessage(String deliverablemessage) {
        this.deliverablemessage = deliverablemessage;
    }

    public String getDeliverablefile() {
        return deliverablefile;
    }

    public void setDeliverablefile(String deliverablefile) {
        this.deliverablefile = deliverablefile;
    }

    public Date getDeliverabledateSent() {
        return deliverabledateSent;
    }

    public void setDeliverabledateSent(Date deliverabledateSent) {
        this.deliverabledateSent = deliverabledateSent;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    public Module getFKModuleID() {
        return fKModuleID;
    }

    public void setFKModuleID(Module fKModuleID) {
        this.fKModuleID = fKModuleID;
    }

    public Userlist getFKUsersID() {
        return fKUsersID;
    }

    public void setFKUsersID(Userlist fKUsersID) {
        this.fKUsersID = fKUsersID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliverableID != null ? deliverableID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliverable)) {
            return false;
        }
        Deliverable other = (Deliverable) object;
        if ((this.deliverableID == null && other.deliverableID != null) || (this.deliverableID != null && !this.deliverableID.equals(other.deliverableID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Deliverable[ deliverableID=" + deliverableID + " ]";
    }
    
}
