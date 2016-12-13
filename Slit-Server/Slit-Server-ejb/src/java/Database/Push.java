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
@Table(name = "push")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Push.findAll", query = "SELECT p FROM Push p"),
    @NamedQuery(name = "Push.findByPushID", query = "SELECT p FROM Push p WHERE p.pushID = :pushID"),
    @NamedQuery(name = "Push.findByPushtext", query = "SELECT p FROM Push p WHERE p.pushtext = :pushtext"),
    @NamedQuery(name = "Push.findByPushdate", query = "SELECT p FROM Push p WHERE p.pushdate = :pushdate")})
public class Push implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Push_ID")
    private Integer pushID;
    @Size(max = 50)
    @Column(name = "Push_text")
    private String pushtext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Push_date")
    @Temporal(TemporalType.DATE)
    private Date pushdate;

    public Push() {
    }

    public Push(Integer pushID) {
        this.pushID = pushID;
    }

    public Push(Integer pushID, Date pushdate) {
        this.pushID = pushID;
        this.pushdate = pushdate;
    }

    public Integer getPushID() {
        return pushID;
    }

    public void setPushID(Integer pushID) {
        this.pushID = pushID;
    }

    public String getPushtext() {
        return pushtext;
    }

    public void setPushtext(String pushtext) {
        this.pushtext = pushtext;
    }

    public Date getPushdate() {
        return pushdate;
    }

    public void setPushdate(Date pushdate) {
        this.pushdate = pushdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pushID != null ? pushID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Push)) {
            return false;
        }
        Push other = (Push) object;
        if ((this.pushID == null && other.pushID != null) || (this.pushID != null && !this.pushID.equals(other.pushID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Push[ pushID=" + pushID + " ]";
    }
    
}
