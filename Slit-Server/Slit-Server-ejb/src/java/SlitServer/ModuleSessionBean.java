/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import DataModels.ModuleDataModel;
import Database.Module;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cheezy
 */
@Stateless
@LocalBean
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;
    
    ModuleDataModel modules = new ModuleDataModel();

/**
 * Get all the current modules in the database.
 * @return dataModuleModel
 */
public List<ModuleDataModel> getModule()
{
    List<ModuleDataModel> dataModuleModel = new ArrayList<ModuleDataModel>();
    
    try
    {
        Query query = em.createNamedQuery("Module.findAll", Module.class);
        
        List<Module> moduleList = query.getResultList();
        
        for(Module module : moduleList)
        {
            dataModuleModel.add(this.convertModule(module));
        }
        
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return dataModuleModel;
}

/**
 * Converts the module entity to ModuleDataModel
 * @param module
 * @return 
 */
public ModuleDataModel convertModule(Module module)
{
    ModuleDataModel modulesDataModel = new ModuleDataModel();
    
    modulesDataModel.setModule_ID(module.getModuleID());
    modulesDataModel.setModule_title(modules.getModule_title());
    modulesDataModel.setModule_description(modules.getModule_description());
    modulesDataModel.setModule_criteria(modules.getModule_criteria());
    modulesDataModel.setModule_resources(modules.getModule_resources());
    modulesDataModel.setModule_status(modules.getModule_status());
    modulesDataModel.setModule_deadline(modules.getModule_deadline());
    
    return modulesDataModel;
}

/**
 * Converts ModuleDataModel to an entity
 * @param module
 * @return 
 */
public Module convertModuleToEntity(ModuleDataModel module)
{
    Module ModuleEntity = new Module();
    
    ModuleEntity.setModuleID(modules.getModule_ID());
    ModuleEntity.setModuletitle(modules.getModule_title());
    ModuleEntity.setModuledescription(modules.getModule_description());
    ModuleEntity.setModulecriteria(modules.getModule_criteria());
    ModuleEntity.setModuleresources(modules.getModule_resources());
    ModuleEntity.setModulestatus(modules.getModule_status());
    ModuleEntity.setModuledeadline(modules.getModule_deadline());
    
    return ModuleEntity;
}

public void persist(Object object){
        em.persist(object);
    }

    @Override
    public List<ModuleDataModel> getModules() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

