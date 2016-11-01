/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherID", query = "SELECT t FROM Teacher t WHERE t.teacherID = :teacherID"),
    @NamedQuery(name = "Teacher.findByTeacherfirstName", query = "SELECT t FROM Teacher t WHERE t.teacherfirstName = :teacherfirstName"),
    @NamedQuery(name = "Teacher.findByTeacherlastName", query = "SELECT t FROM Teacher t WHERE t.teacherlastName = :teacherlastName")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Teacher_ID")
    private String teacherID;
    @Size(max = 20)
    @Column(name = "Teacher_firstName")
    private String teacherfirstName;
    @Size(max = 20)
    @Column(name = "Teacher_lastName")
    private String teacherlastName;
    @OneToMany(mappedBy = "fKTeacherID")
    private List<Feedback> feedbackList;

    public Teacher() {
    }

    public Teacher(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherfirstName() {
        return teacherfirstName;
    }

    public void setTeacherfirstName(String teacherfirstName) {
        this.teacherfirstName = teacherfirstName;
    }

    public String getTeacherlastName() {
        return teacherlastName;
    }

    public void setTeacherlastName(String teacherlastName) {
        this.teacherlastName = teacherlastName;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherID != null ? teacherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherID == null && other.teacherID != null) || (this.teacherID != null && !this.teacherID.equals(other.teacherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Teacher[ teacherID=" + teacherID + " ]";
    }
    
}
