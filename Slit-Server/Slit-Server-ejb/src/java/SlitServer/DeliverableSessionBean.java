/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import DataModels.DeliverableDataModel;
import DataModels.FeedBackDataModel;
import Database.Deliverable;
import Database.Feedback;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Basse
 */
@Stateless
public class DeliverableSessionBean implements DeliverableSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;

    @Override
    public List<DeliverableDataModel> getDeliverableFromUsersId(int userid)
    {
        List<DeliverableDataModel> returnList = new ArrayList<DeliverableDataModel>(); 
        
        try
        {
            
            Query query = em.createQuery("SELECT d FROM Deliverable d WHERE d.fKUsersID.userID = :userId");
            
            query.setParameter("userId", userid); 
            
            List<Deliverable> queryList = query.getResultList(); 
            
            for(Deliverable deliverable : queryList)
            {
                returnList.add(this.convertDeliverableModel(deliverable)); 
            }
            
            
        }catch(Exception e) 
        {
            e.printStackTrace();
        }
        return returnList; 
    }
    
    @Override 
    public FeedBackDataModel getFeedbackFromDeliverableId(int deliverableId) 
    {
        try 
        {
            Query query = em.createQuery("SELECT f FROM Feedback f WHERE f.fKDeliverableID = :deliverable");
         
            query.setParameter("deliverable", em.find(Deliverable.class, deliverableId)); 

            Feedback feedback = (Feedback)query.getSingleResult(); 

            return this.convertFeedbackModel(feedback); 
            
        }
        catch(javax.persistence.NoResultException e){
            return null; 
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return null; 

    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public DeliverableDataModel convertDeliverableModel(Deliverable entity)
    {
        DeliverableDataModel model = new DeliverableDataModel(); 
        
        model.setDeliverable_ID(entity.getDeliverableID());
        model.setDeliverable_dateSent(entity.getDeliverabledateSent());
        model.setDeliverable_file(entity.getDeliverablefile());
        model.setDeliverable_message(entity.getDeliverablemessage());
        model.setModule_ID(entity.getFKModuleID().getModuleID());
        model.setUsers_ID(entity.getFKUsersID().getUserID());
        
        return model; 
    }
    
    public FeedBackDataModel convertFeedbackModel(Feedback entity) 
    {
        FeedBackDataModel feedback = new FeedBackDataModel(); 
        
        feedback.setDate_received(entity.getDatereceived());
        feedback.setFeedback_ID(entity.getFeedbackID());
        feedback.setFeedback_comment(entity.getFeedbackcomment());
        feedback.setFeedback_score(entity.getFeedbackscore());
        feedback.setFeedback_status(entity.getFeedbackstatus());
        
        if(entity.getFKUsersID() != null)
        {
            feedback.setUsers_ID(entity.getFKUsersID().getUserID());
        }
        
        if(entity.getFKDeliverableID() != null)
        {
            feedback.setDeliverable_ID(entity.getFKDeliverableID().getDeliverableID());
        }
        
        return feedback; 
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
