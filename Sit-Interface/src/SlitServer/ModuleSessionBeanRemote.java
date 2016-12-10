/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import javax.ejb.Remote;
import DataModels.ModuleDataModel;
import java.util.List;

/**
 *
 * @author Cheezy
 */
@Remote
public interface ModuleSessionBeanRemote {
    List<ModuleDataModel> getModules();
}
