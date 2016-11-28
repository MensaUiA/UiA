/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cheezy
 */
@Entity
@Table(name = "userlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlist.findAll", query = "SELECT u FROM Userlist u"),
    @NamedQuery(name = "Userlist.findByUserID", query = "SELECT u FROM Userlist u WHERE u.userID = :userID"),
    @NamedQuery(name = "Userlist.findByUserfirstName", query = "SELECT u FROM Userlist u WHERE u.userfirstName = :userfirstName"),
    @NamedQuery(name = "Userlist.findByUserlastName", query = "SELECT u FROM Userlist u WHERE u.userlastName = :userlastName"),
    @NamedQuery(name = "Userlist.findByUsermail", query = "SELECT u FROM Userlist u WHERE u.usermail = :usermail"),
    @NamedQuery(name = "Userlist.findByUserpasswords", query = "SELECT u FROM Userlist u WHERE u.userpasswords = :userpasswords"),
    @NamedQuery(name = "Userlist.findByUsertype", query = "SELECT u FROM Userlist u WHERE u.usertype = :usertype")})
public class Userlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "User_ID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "User_firstName")
    private String userfirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "User_lastName")
    private String userlastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "User_mail")
    private String usermail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "User_passwords")
    private String userpasswords;
    @Size(max = 8)
    @Column(name = "User_type")
    private String usertype;
    @OneToMany(mappedBy = "fKUsersID")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKUsersID")
    private Collection<Deliverable> deliverableCollection;

    public Userlist() {
    }

    public Userlist(Integer userID) {
        this.userID = userID;
    }

    public Userlist(Integer userID, String userfirstName, String userlastName, String usermail, String userpasswords) {
        this.userID = userID;
        this.userfirstName = userfirstName;
        this.userlastName = userlastName;
        this.usermail = usermail;
        this.userpasswords = userpasswords;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserfirstName() {
        return userfirstName;
    }

    public void setUserfirstName(String userfirstName) {
        this.userfirstName = userfirstName;
    }

    public String getUserlastName() {
        return userlastName;
    }

    public void setUserlastName(String userlastName) {
        this.userlastName = userlastName;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getUserpasswords() {
        return userpasswords;
    }

    public void setUserpasswords(String userpasswords) {
        this.userpasswords = userpasswords;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<Deliverable> getDeliverableCollection() {
        return deliverableCollection;
    }

    public void setDeliverableCollection(Collection<Deliverable> deliverableCollection) {
        this.deliverableCollection = deliverableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlist)) {
            return false;
        }
        Userlist other = (Userlist) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Userlist[ userID=" + userID + " ]";
    }
    
}
