/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import DataModels.DeliverableDataModel;
import DataModels.FeedBackDataModel;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Basse
 */
@Remote
public interface DeliverableSessionBeanRemote {
    List<DeliverableDataModel> getDeliverableFromUsersId(int userid);
    
    FeedBackDataModel getFeedbackFromDeliverableId(int deliverableId);
}
