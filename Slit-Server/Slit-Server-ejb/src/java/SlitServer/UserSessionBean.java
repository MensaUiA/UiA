/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import DataModels.UsersDataModel;
import Database.Users;
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
            Query query = em.createNamedQuery("Users.findByMail", Users.class);
        
            query.setParameter("mail", mail);
            
            Users usersResult = (Users)query.getSingleResult();
            
            user = this.convertEntity(usersResult);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return user;
    }
    
    @Override
    public void createUser(UsersDataModel userDataModel)
    {
        Users user = this.convertUserDataModel(userDataModel);
        
        em.persist(user);
    }
    
    
    public UsersDataModel convertEntity(Users user)
    {
        UsersDataModel userDataModel = new UsersDataModel(); 
        
        userDataModel.setId(user.getId());
        userDataModel.setFirstName(user.getFirstName());
        userDataModel.setLastName(user.getLastName());
        userDataModel.setMail(user.getMail());
        userDataModel.setPasswords(user.getPasswords());
        userDataModel.setUser_type(user.getUserType());
        
        return userDataModel; 
        
        
    }

     public Users convertUserDataModel(UsersDataModel user)
    {
        Users userDataModel = new Users(); 
        
        userDataModel.setId(user.getId());
        userDataModel.setFirstName(user.getFirstName());
        userDataModel.setLastName(user.getLastName());
        userDataModel.setMail(user.getMail());
        userDataModel.setPasswords(user.getPasswords());
        userDataModel.setUserType(user.getUser_type());
        
        return userDataModel; 
        
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    public void persist(Object object) {
        em.persist(object);
    }
    
    
}
