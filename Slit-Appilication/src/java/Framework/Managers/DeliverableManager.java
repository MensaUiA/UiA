/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Managers;

import DataModels.DeliverableDataModel;
import DataModels.FeedBackDataModel;
import SlitServer.DeliverableSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Basse
 */
public class DeliverableManager {

    private DeliverableSessionBeanRemote lookupDeliverableSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (DeliverableSessionBeanRemote) c.lookup("java:comp/env/DeliverableSessionBean");
            return (DeliverableSessionBeanRemote) c.lookup("java:global/Slit-Server-ejb/DeliverableSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<DeliverableDataModel> getModelsForUserId(int userid)
    {
        return this.lookupDeliverableSessionBeanRemote().getDeliverableFromUsersId(userid); 
    }
    
    public FeedBackDataModel getModelFromDeliverableId(int devId)
    {
        return this.lookupDeliverableSessionBeanRemote().getFeedbackFromDeliverableId(devId); 
    }
}
