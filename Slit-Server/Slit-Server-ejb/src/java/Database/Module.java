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
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleID", query = "SELECT m FROM Module m WHERE m.moduleID = :moduleID"),
    @NamedQuery(name = "Module.findByModuletitle", query = "SELECT m FROM Module m WHERE m.moduletitle = :moduletitle"),
    @NamedQuery(name = "Module.findByModuledescription", query = "SELECT m FROM Module m WHERE m.moduledescription = :moduledescription"),
    @NamedQuery(name = "Module.findByModulecriteria", query = "SELECT m FROM Module m WHERE m.modulecriteria = :modulecriteria"),
    @NamedQuery(name = "Module.findByModulestatus", query = "SELECT m FROM Module m WHERE m.modulestatus = :modulestatus"),
    @NamedQuery(name = "Module.findByModuleresources", query = "SELECT m FROM Module m WHERE m.moduleresources = :moduleresources"),
    @NamedQuery(name = "Module.findByModuledeadline", query = "SELECT m FROM Module m WHERE m.moduledeadline = :moduledeadline")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Module_ID")
    private Integer moduleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Module_title")
    private String moduletitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "Module_description")
    private String moduledescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Module_criteria")
    private String modulecriteria;
    @Size(max = 14)
    @Column(name = "Module_status")
    private String modulestatus;
    @Size(max = 200)
    @Column(name = "Module_resources")
    private String moduleresources;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Module_deadline")
    @Temporal(TemporalType.DATE)
    private Date moduledeadline;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKModuleID")
    private Collection<Deliverable> deliverableCollection;

    public Module() {
    }

    public Module(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public Module(Integer moduleID, String moduletitle, String moduledescription, String modulecriteria, Date moduledeadline) {
        this.moduleID = moduleID;
        this.moduletitle = moduletitle;
        this.moduledescription = moduledescription;
        this.modulecriteria = modulecriteria;
        this.moduledeadline = moduledeadline;
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuletitle() {
        return moduletitle;
    }

    public void setModuletitle(String moduletitle) {
        this.moduletitle = moduletitle;
    }

    public String getModuledescription() {
        return moduledescription;
    }

    public void setModuledescription(String moduledescription) {
        this.moduledescription = moduledescription;
    }

    public String getModulecriteria() {
        return modulecriteria;
    }

    public void setModulecriteria(String modulecriteria) {
        this.modulecriteria = modulecriteria;
    }

    public String getModulestatus() {
        return modulestatus;
    }

    public void setModulestatus(String modulestatus) {
        this.modulestatus = modulestatus;
    }

    public String getModuleresources() {
        return moduleresources;
    }

    public void setModuleresources(String moduleresources) {
        this.moduleresources = moduleresources;
    }

    public Date getModuledeadline() {
        return moduledeadline;
    }

    public void setModuledeadline(Date moduledeadline) {
        this.moduledeadline = moduledeadline;
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
        hash += (moduleID != null ? moduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleID == null && other.moduleID != null) || (this.moduleID != null && !this.moduleID.equals(other.moduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Module[ moduleID=" + moduleID + " ]";
    }
    
}
