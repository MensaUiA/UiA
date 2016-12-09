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
public class ModuleDataModel {
    private int Module_ID;
    
    private String Module_title;
    
    private String Module_description;
    
    private String Module_criteria;
    
    private String Module_status = "Publisert";
    
    private String Module_resources;
    
    private String Module_deadline;

    public void setModule_ID(int Module_ID) {
        this.Module_ID = Module_ID;
    }

    public void setModule_title(String Module_title) {
        this.Module_title = Module_title;
    }

    public void setModule_description(String Module_description) {
        this.Module_description = Module_description;
    }

    public void setModule_criteria(String Module_criteria) {
        this.Module_criteria = Module_criteria;
    }

    public void setModule_status(String Module_status) {
        this.Module_status = Module_status;
    }

    public void setModule_resources(String Module_resources) {
        this.Module_resources = Module_resources;
    }

    public void setModule_deadline(String Module_deadline) {
        this.Module_deadline = Module_deadline;
    }
    
    public int getModule_ID() {
        return Module_ID;
    }

    public String getModule_title() {
        return Module_title;
    }

    public String getModule_description() {
        return Module_description;
    }

    public String getModule_criteria() {
        return Module_criteria;
    }

    public String getModule_status() {
        return Module_status;
    }

    public String getModule_resources() {
        return Module_resources;
    }

    public String getModule_deadline() {
        return Module_deadline;
    }
    
}
