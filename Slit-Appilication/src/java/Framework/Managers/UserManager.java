/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Managers;

import DataModels.UsersDataModel;
import SlitServer.UserSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Cheezy
 */
public class UserManager {

    private UserSessionBeanRemote lookupUserSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (UserSessionBeanRemote) c.lookup("java:comp/env/UserSessionBean");
            return (UserSessionBeanRemote) c.lookup("java:global/Slit-Server-ejb/UserSessionBean");

        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public UsersDataModel loginUser(String userName, String password)
    {
        return this.lookupUserSessionBeanRemote().loginUser(userName, password);
    }
    
    public void createUser(UsersDataModel userDataModel)
    {
        this.lookupUserSessionBeanRemote().createUser(userDataModel);
    }

    
}
