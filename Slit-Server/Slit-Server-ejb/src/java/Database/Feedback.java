/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cheezy
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByFeedbackID", query = "SELECT f FROM Feedback f WHERE f.feedbackID = :feedbackID"),
    @NamedQuery(name = "Feedback.findByFeedbackcomment", query = "SELECT f FROM Feedback f WHERE f.feedbackcomment = :feedbackcomment"),
    @NamedQuery(name = "Feedback.findByFeedbackscore", query = "SELECT f FROM Feedback f WHERE f.feedbackscore = :feedbackscore"),
    @NamedQuery(name = "Feedback.findByFeedbackstatus", query = "SELECT f FROM Feedback f WHERE f.feedbackstatus = :feedbackstatus"),
    @NamedQuery(name = "Feedback.findByDatereceived", query = "SELECT f FROM Feedback f WHERE f.datereceived = :datereceived")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Feedback_ID")
    private Integer feedbackID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Feedback_comment")
    private String feedbackcomment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Feedback_score")
    private int feedbackscore;
    @Size(max = 13)
    @Column(name = "Feedback_status")
    private String feedbackstatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_received")
    @Temporal(TemporalType.DATE)
    private Date datereceived;
    @JoinColumn(name = "FK_Deliverable_ID", referencedColumnName = "Deliverable_ID")
    @ManyToOne
    private Deliverable fKDeliverableID;
    @JoinColumn(name = "FK_Users_ID", referencedColumnName = "User_ID")
    @ManyToOne
    private Userlist fKUsersID;

    public Feedback() {
    }

    public Feedback(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Feedback(Integer feedbackID, String feedbackcomment, int feedbackscore, Date datereceived) {
        this.feedbackID = feedbackID;
        this.feedbackcomment = feedbackcomment;
        this.feedbackscore = feedbackscore;
        this.datereceived = datereceived;
    }

    public Integer getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFeedbackcomment() {
        return feedbackcomment;
    }

    public void setFeedbackcomment(String feedbackcomment) {
        this.feedbackcomment = feedbackcomment;
    }

    public int getFeedbackscore() {
        return feedbackscore;
    }

    public void setFeedbackscore(int feedbackscore) {
        this.feedbackscore = feedbackscore;
    }

    public String getFeedbackstatus() {
        return feedbackstatus;
    }

    public void setFeedbackstatus(String feedbackstatus) {
        this.feedbackstatus = feedbackstatus;
    }

    public Date getDatereceived() {
        return datereceived;
    }

    public void setDatereceived(Date datereceived) {
        this.datereceived = datereceived;
    }

    public Deliverable getFKDeliverableID() {
        return fKDeliverableID;
    }

    public void setFKDeliverableID(Deliverable fKDeliverableID) {
        this.fKDeliverableID = fKDeliverableID;
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
        hash += (feedbackID != null ? feedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.feedbackID == null && other.feedbackID != null) || (this.feedbackID != null && !this.feedbackID.equals(other.feedbackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Feedback[ feedbackID=" + feedbackID + " ]";
    }
    
}
