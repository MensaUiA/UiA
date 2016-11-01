/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitappilication;

import DataModels.UsersDataModel;
import Framework.Managers.UserManager;
import SlitServer.NewSessionBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Haris
 */
public class Main {

    @EJB
    private static NewSessionBeanRemote newSessionBean;
    
    
    private static UserManager userManager = new UserManager(); 
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        NewClass clas = new NewClass();
        
        System.out.println(clas.getBusinessMethod());
        
        System.out.println(newSessionBean.businessMethod());
        
        UsersDataModel userModel = new UsersDataModel();
        
        userModel.setFirstName("John");
        userModel.setLastName("Dahl");
        userModel.setMail("kaalsaas@outlook.com");
        userModel.setPasswords("Test123");
     
        userManager.createUser(userModel);
    }
    
}
