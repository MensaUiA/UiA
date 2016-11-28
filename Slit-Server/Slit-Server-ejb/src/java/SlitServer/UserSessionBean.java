/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import DataModels.UsersDataModel;
import Database.Userlist;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cheezy
 */
@Stateless
public class UserSessionBean implements UserSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;

    
    @Override
    public UsersDataModel loginUser(String mail, String password) {
        
        UsersDataModel user = new UsersDataModel(); 
        
        try 
        {   
            Query query = em.createNamedQuery("Userlist.findByUsermail", Userlist.class);
        
            query.setParameter("usermail", mail);
            
            Userlist usersResult = (Userlist)query.getSingleResult();
            
            if(usersResult.getUserpasswords().equals(password))
            {
               user = this.convertEntity(usersResult);
            }

            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return user;
    }
    
    @Override
    public void createUser(UsersDataModel userDataModel)
    {
        Userlist user = this.convertUserDataModel(userDataModel);
        
        em.persist(user);
    }
    
    
    public UsersDataModel convertEntity(Userlist user)
    {
        UsersDataModel userDataModel = new UsersDataModel(); 
        
        userDataModel.setId(user.getUserID());
        userDataModel.setFirstName(user.getUserfirstName());
        userDataModel.setLastName(user.getUserlastName());
        userDataModel.setMail(user.getUsermail());
        userDataModel.setPasswords(user.getUserpasswords());
        userDataModel.setUser_type(user.getUsertype());
        
        return userDataModel; 
        
        
    }

     public Userlist convertUserDataModel(UsersDataModel user)
    {
        Userlist userDataModel = new Userlist(); 
        
        userDataModel.setUserID(user.getId());
        userDataModel.setUserfirstName(user.getFirstName());
        userDataModel.setUserlastName(user.getLastName());
        userDataModel.setUsermail(user.getMail());
        userDataModel.setUserpasswords(user.getPasswords());
        userDataModel.setUsertype(user.getUser_type());
        
        return userDataModel; 
        
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
