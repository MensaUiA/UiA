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
public class FeedBackDataModel implements java.io.Serializable {
    private int Feedback_ID;
    private String Feedback_comment;
    private int Feedback_score;
    private String Feedback_status;
    private Date Date_received;
    private int Deliverable_ID;
    private int Users_ID;

    public int getFeedback_ID() {
        return Feedback_ID;
    }

    public void setFeedback_ID(int Feedback_ID) {
        this.Feedback_ID = Feedback_ID;
    }

    public String getFeedback_comment() {
        return Feedback_comment;
    }

    public void setFeedback_comment(String Feedback_comment) {
        this.Feedback_comment = Feedback_comment;
    }

    public int getFeedback_score() {
        return Feedback_score;
    }

    public void setFeedback_score(int Feedback_score) {
        this.Feedback_score = Feedback_score;
    }

    public String getFeedback_status() {
        return Feedback_status;
    }

    public void setFeedback_status(String Feedback_status) {
        this.Feedback_status = Feedback_status;
    }

    public Date getDate_received() {
        return Date_received;
    }

    public void setDate_received(Date Date_received) {
        this.Date_received = Date_received;
    }

    public int getDeliverable_ID() {
        return Deliverable_ID;
    }

    public void setDeliverable_ID(int Deliverable_ID) {
        this.Deliverable_ID = Deliverable_ID;
    }

    public int getUsers_ID() {
        return Users_ID;
    }

    public void setUsers_ID(int Users_ID) {
        this.Users_ID = Users_ID;
    }
   
   
    
}
