/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.util.Date;

/**
 *
 * @author Cheezy
 */
public class DeliveryListObject {
    
    private int Module_ID;
    
    private String ModuleTitle;

    private String Module_description;

    private String Module_status = "Publisert";

    private String Module_deadline;
    
    private String userName;

    public int getModule_ID() {
        return Module_ID;
    }

    public void setModule_ID(int Module_ID) {
        this.Module_ID = Module_ID;
    }

    public String getModuleTitle() {
        return ModuleTitle;
    }

    public void setModuleTitle(String ModuleTitle) {
        this.ModuleTitle = ModuleTitle;
    }

    public String getModule_description() {
        return Module_description;
    }

    public void setModule_description(String Module_description) {
        this.Module_description = Module_description;
    }

    public String getModule_status() {
        return Module_status;
    }

    public void setModule_status(String Module_status) {
        this.Module_status = Module_status;
    }

    public String getModule_deadline() {
        return Module_deadline;
    }

    public void setModule_deadline(String Module_deadline) {
        this.Module_deadline = Module_deadline;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
