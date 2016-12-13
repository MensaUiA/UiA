/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import javax.ejb.Remote;
import DataModels.UsersDataModel;
import java.util.List;

/**
 *
 * @author Cheezy, Basse
 */
@Remote
public interface UserSessionBeanRemote {
    
    List<UsersDataModel> getUsers();

    @Override
    public boolean equals(Object obj);
    
    UsersDataModel loginUser(String userName, String password); 
    
    void createUser(UsersDataModel userDataModel);
}
