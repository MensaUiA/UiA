/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModels;

import java.util.Date;

/**
 *
 * @author Basse
 */
public class DeliverableDataModel implements java.io.Serializable {
   private int Deliverable_ID;
   private String Deliverable_message; 
   private String Deliverable_file; 
   private Date Deliverable_dateSent;
   private int module_ID; 
   private int Users_ID; 

    public int getDeliverable_ID() {
        return Deliverable_ID;
    }

    public void setDeliverable_ID(int Deliverable_ID) {
        this.Deliverable_ID = Deliverable_ID;
    }

    public String getDeliverable_message() {
        return Deliverable_message;
    }

    public void setDeliverable_message(String Deliverable_message) {
        this.Deliverable_message = Deliverable_message;
    }

    public String getDeliverable_file() {
        return Deliverable_file;
    }

    public void setDeliverable_file(String Deliverable_file) {
        this.Deliverable_file = Deliverable_file;
    }

    public Date getDeliverable_dateSent() {
        return Deliverable_dateSent;
    }

    public void setDeliverable_dateSent(Date Deliverable_dateSent) {
        this.Deliverable_dateSent = Deliverable_dateSent;
    }

    public int getModule_ID() {
        return module_ID;
    }

    public void setModule_ID(int module_ID) {
        this.module_ID = module_ID;
    }

    public int getUsers_ID() {
        return Users_ID;
    }

    public void setUsers_ID(int Users_ID) {
        this.Users_ID = Users_ID;
    }

    
   
   
}
