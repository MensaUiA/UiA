/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Deliverable_ID")
    private String deliverableID;
    @Size(max = 200)
    @Column(name = "Deliverable_message")
    private String deliverablemessage;
    @Size(max = 50)
    @Column(name = "Deliverable_file")
    private String deliverablefile;
    @Column(name = "Deliverable_dateSent")
    @Temporal(TemporalType.DATE)
    private Date deliverabledateSent;
    @OneToMany(mappedBy = "fKDeliverableID")
    private List<Feedback> feedbackList;
    @JoinColumn(name = "FK_Module_ID", referencedColumnName = "Module_ID")
    @ManyToOne
    private Module fKModuleID;
    @JoinColumn(name = "FK_Student_ID", referencedColumnName = "Student_ID")
    @ManyToOne
    private Student fKStudentID;

    public Deliverable() {
    }

    public Deliverable(String deliverableID) {
        this.deliverableID = deliverableID;
    }

    public String getDeliverableID() {
        return deliverableID;
    }

    public void setDeliverableID(String deliverableID) {
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
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Module getFKModuleID() {
        return fKModuleID;
    }

    public void setFKModuleID(Module fKModuleID) {
        this.fKModuleID = fKModuleID;
    }

    public Student getFKStudentID() {
        return fKStudentID;
    }

    public void setFKStudentID(Student fKStudentID) {
        this.fKStudentID = fKStudentID;
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
