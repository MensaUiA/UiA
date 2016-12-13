/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;


import DataModels.DeliverableDataModel;
import DataModels.ModuleDataModel;
import Database.Deliverable;
import Database.Module;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cheezy
 */
@Stateless
@LocalBean
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;
    

    /**
     * Get all the current modules in the database.
     * @return dataModuleModel
     */
    @Override
    public List<ModuleDataModel> getModules()
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
    *@param Module_title 
    *@return ModuleDataModel
    */
    @Override
    public ModuleDataModel findModuleByName(String Module_title){

            ModuleDataModel returnModule = new ModuleDataModel();

            try
            {
                Query query = em.createNamedQuery("Module.findByModuletitle", Module.class);

                query.setParameter("Module_title", Module_title);

                Module module = (Module)query.getSingleResult();

                returnModule = this.convertModule(module);
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }

            return returnModule;

    }
    
    @Override
    public ModuleDataModel findModuleById(int moduleId){

            ModuleDataModel returnModule = new ModuleDataModel();

            try
            {
                
                Module module = em.find(Module.class, moduleId); 
                
                /*Query query = em.createNamedQuery("Module.findByModuleID", Module.class);

                query.setParameter("ModuleID", moduleId);

                Module module = (Module)query.getSingleResult();*/

                returnModule = this.convertModule(module);
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }

            return returnModule;

    }

    private Connection getConnection(){

        Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://:3306/SLIT","root","root");
            } catch (SQLException ex) {
                Logger.getLogger(ModuleSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        return con;
    }



    public ArrayList<ModuleDataModel> getUserz(){

        ArrayList<ModuleDataModel> userz = new ArrayList<ModuleDataModel>();


        /*Connection con = getConnection();

        Statement st;
        ResultSet rs;
        ModuleDataModel mdm;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Module");

            while(rs.next()){

                mdm = new ModuleDataModel (
                    rs.getString("Module_title"),
                    rs.getString("Module_description"),
                    rs.getString("Module_criteria"),
                    rs.getDate("Module_deadline")
                );
                userz.add(mdm);
            }

        }catch(SQLException ex) {
             Logger.getLogger(ModuleSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        return userz;
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
        modulesDataModel.setModuleTitle(module.getModuletitle());
        modulesDataModel.setModule_description(module.getModuledescription());
        modulesDataModel.setModule_criteria(module.getModulecriteria());
        modulesDataModel.setModule_resources(module.getModuleresources());
        modulesDataModel.setModule_status(module.getModulestatus());
        modulesDataModel.setModule_deadline(module.getModuledeadline());

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

        ModuleEntity.setModuleID(module.getModule_ID());
        ModuleEntity.setModuletitle(module.getModuleTitle());
        ModuleEntity.setModuledescription(module.getModule_description());
        ModuleEntity.setModulecriteria(module.getModule_criteria());
        ModuleEntity.setModuleresources(module.getModule_resources());
        ModuleEntity.setModulestatus(module.getModule_status());
        ModuleEntity.setModuledeadline(module.getModule_deadline());

        return ModuleEntity;
    }

    public void persist(Object object){
            em.persist(object);
    }

    @Override
    public void createModule(ModuleDataModel obj) {
        obj.setModule_ID(Integer.SIZE);
        em.persist(convertModuleToEntity(obj));
    }

    
    
}

