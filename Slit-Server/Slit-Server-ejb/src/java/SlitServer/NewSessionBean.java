/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import javax.ejb.Stateless;

/**
 *
 * @author Haris
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote {

    @Override
    public String businessMethod() {
        return "Test";
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}