/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModels;

/**
 *
 * @author Cheezy
 */
public class StudentModel implements java.io.Serializable {
    private String Student_ID;
    private String Student_firstName;
    private String Student_lastName;

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String Student_ID) {
        this.Student_ID = Student_ID;
    }

    public String getStudent_firstName() {
        return Student_firstName;
    }

    public void setStudent_firstName(String Student_firstName) {
        this.Student_firstName = Student_firstName;
    }

    public String getStudent_lastName() {
        return Student_lastName;
    }

    public void setStudent_lastName(String Student_lastName) {
        this.Student_lastName = Student_lastName;
    }
}
