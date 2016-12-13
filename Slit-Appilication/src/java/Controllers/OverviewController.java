/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Common.OverviewListObject;
import DataModels.DeliverableDataModel;
import DataModels.FeedBackDataModel;
import DataModels.ModuleDataModel;
import DataModels.UsersDataModel;
import Framework.Managers.DeliverableManager;
import Framework.Managers.ModuleManager;
import Framework.Managers.UserManager;
import Framework.Names.ViewNames;
import View.Main;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Basse
 */
public class OverviewController implements Initializable{
    
    @FXML private TableView<OverviewListObject> table;
    @FXML private TableColumn<OverviewListObject, String> firstNameCol, lastNameCol, moduleOneCol, statusCol; 
    @FXML private TextField filterSearchInput;
    private final UserManager userManager = new UserManager();
    private ModuleManager moduleManager = new ModuleManager();
    private DeliverableManager deliverableManager = new DeliverableManager(); 
    @FXML private Button overviewBtn, moduleBtn,logoutBtn;
    
    ObservableList<OverviewListObject> listData = FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        filterSearchInput.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterObservableUserList((String) oldValue, (String) newValue);
            }
        });
    
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory<OverviewListObject, String>("firstName"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory<OverviewListObject, String>("lastName"));
        this.moduleOneCol.setCellValueFactory(new PropertyValueFactory<OverviewListObject, String>("ModuleTitle"));
        this.statusCol.setCellValueFactory(new PropertyValueFactory<OverviewListObject, String>("status")); 
        

        
        List<UsersDataModel> users = this.userManager.getUsers(); 
        
        for(UsersDataModel user : users) {
            for(DeliverableDataModel deliverable : this.deliverableManager.getModelsForUserId(user.getId()))
            {
                OverviewListObject listObject = new OverviewListObject();
                listObject.setFirstName(user.getFirstName());
                listObject.setLastName(user.getLastName());
                
                ModuleDataModel model = this.moduleManager.getModuleFromId(deliverable.getModule_ID()); 
                
                listObject.setModuleID(model.getModule_ID());
                listObject.setModuleTitle(model.getModuleTitle());
                
                FeedBackDataModel feedback = this.deliverableManager.getModelFromDeliverableId(deliverable.getDeliverable_ID());
                
                if(feedback != null)
                {
                    listObject.setStatus(feedback.getFeedback_status());
                }
                                
                listData.add(listObject);
            }

        }
        table.setItems(listData);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setPlaceholder(new Label("Your Table is Empty"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
    } // END OF INIT
    
    public void handleModuleAction(ActionEvent event) throws Exception{
        Main.getInstance().setScene(ViewNames.mainView);
    }
    
    public void handleLogoutAction(ActionEvent event) throws Exception{
        Main.getInstance().setScene(ViewNames.loginView);
    }
    
    public void filterObservableUserList(String oldValue, String newValue) {
        ObservableList<OverviewListObject> filteredList = FXCollections.observableArrayList();
        if(filterSearchInput == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(listData);
        }
        else {
            newValue = newValue.toUpperCase();
            for(OverviewListObject model : table.getItems()) {
                String filterFirstName = model.getFirstName();
                String filterLastName = model.getLastName();
                if(filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue))
                {
                    filteredList.add(model);
                }
            }
            table.setItems(filteredList);
        } 
    }
    
}
