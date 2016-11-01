/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cheezy
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByStudentfirstName", query = "SELECT s FROM Student s WHERE s.studentfirstName = :studentfirstName"),
    @NamedQuery(name = "Student.findByStudentlastName", query = "SELECT s FROM Student s WHERE s.studentlastName = :studentlastName")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Student_ID")
    private String studentID;
    @Size(max = 20)
    @Column(name = "Student_firstName")
    private String studentfirstName;
    @Size(max = 20)
    @Column(name = "Student_lastName")
    private String studentlastName;

    public Student() {
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentfirstName() {
        return studentfirstName;
    }

    public void setStudentfirstName(String studentfirstName) {
        this.studentfirstName = studentfirstName;
    }

    public String getStudentlastName() {
        return studentlastName;
    }

    public void setStudentlastName(String studentlastName) {
        this.studentlastName = studentlastName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Student[ studentID=" + studentID + " ]";
    }
    
}
