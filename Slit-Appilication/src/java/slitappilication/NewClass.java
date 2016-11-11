/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitappilication;

import Framework.Managers.UserManager;
import SlitServer.NewSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Haris
 */
public class NewClass {

    private NewSessionBeanRemote lookupNewSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (NewSessionBeanRemote) c.lookup("java:comp/env/NewSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    private UserManager userManager = new UserManager(); 
    
    public String getBusinessMethod()
    {
        return this.lookupNewSessionBeanRemote().businessMethod();
    }
}
