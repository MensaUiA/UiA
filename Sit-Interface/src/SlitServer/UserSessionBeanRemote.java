/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import javax.ejb.Remote;
import DataModels.UsersDataModel;

/**
 *
 * @author Cheezy
 */
@Remote
public interface UserSessionBeanRemote {
    
    UsersDataModel loginUser(String userName, String password); 
    
    void createUser(UsersDataModel userDataModel);
}
