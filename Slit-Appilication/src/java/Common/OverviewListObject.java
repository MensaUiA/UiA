/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author Basse
 */
public class OverviewListObject {
    
    private int id;
    private String firstName;
    private String lastName;
    private int Module_ID;
    private String ModuleTitle;
    private String status; 
    
    /**
     * Getters
     */
    
    public int getID(){return id;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public int getModuleID(){return Module_ID;}
    public String getModuleTitle(){return ModuleTitle;}
    
    /**
     * Setters
     */
    
    public void setID(int id){this.id = id;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setModuleID(int Module_ID){this.Module_ID = Module_ID;}
    public void setModuleTitle(String ModuleTitle){this.ModuleTitle = ModuleTitle;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
