package Controllers;
/**
 * Created by Basse.
 */

import Common.DeliveryListObject;
import DataModels.ModuleDataModel;
import DataModels.UsersDataModel;
import Framework.Managers.ModuleManager;
import Framework.Names.ViewNames;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import Model.User;
import View.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ModuleInfoController implements Initializable {

     @FXML
    private TableView<DeliveryListObject> table;
    
    @FXML
    private TableColumn<DeliveryListObject, String> moduleID, moduleTitle, moduleDescription, moduleDeadline; 
    private TextField firstNameField;

    private TextField lastNameField;
    @FXML
    private TextField filterSearchInput;

    private ComboBox<String> statusBox;


    private Label printApplicationStatus;

    ObservableList<User> observableUserList = FXCollections.observableArrayList();
    
    private ModuleManager moduleManager = new ModuleManager(); 
    @FXML
    private Button TommyBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button modulesBtn;
    @FXML
    private Button overviewBtn;

    ObservableList<DeliveryListObject> listData = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        filterSearchInput.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterObservableUserList((String) oldValue, (String) newValue);
            }
        });

        //table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        this.moduleID.setCellValueFactory(new PropertyValueFactory<DeliveryListObject, String>("Module_ID"));
        this.moduleTitle.setCellValueFactory(new PropertyValueFactory<DeliveryListObject, String>("ModuleTitle"));
        this.moduleDescription.setCellValueFactory(new PropertyValueFactory<DeliveryListObject, String>("Module_description"));
        this.moduleDeadline.setCellValueFactory(new PropertyValueFactory<DeliveryListObject, String>("Module_deadline"));
        //this.lastNameCol.setCellValueFactory(new PropertyValueFactory<DeliveryListObject, String>("Module_status"));
        
        
        
        for(ModuleDataModel model : this.moduleManager.getModules())
        {
            DeliveryListObject listObject = new DeliveryListObject(); 
            listObject.setModuleTitle(model.getModuleTitle());
            listObject.setModule_ID(model.getModule_ID());
            listObject.setModule_deadline(model.getModule_deadline().toString());
            listObject.setModule_description(model.getModule_description());
            listObject.setModule_status(model.getModule_description());
     
            listData.add(listObject); 
        }
        
        table.setItems(listData);
         
         
        //firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        //lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        //moduleOneCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        
       

        
        
        //table.setItems(observableUserList);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setPlaceholder(new Label("Your Table is Empty"));


    }//end initialize

    /*
    .........................................Control handlers.........................................
         */
    public void handleAddButtonClick(ActionEvent event) {
        /*
        Get input from user and add to Table
         */
        if (isValidInput(event)) {
            if (statusBox.getValue().equals("Approved") || statusBox.getValue().equals("Failed")) {
                provideAddButtonAction();
            }
        }
    }
    
    @FXML
    public void handleTommyClick(ActionEvent event) throws IOException, Exception {
        System.out.println("Tommy sliter");
        
        Main.getInstance().setScene(ViewNames.createView);
    }


    private boolean isValidInput(ActionEvent event) {

        Boolean validInput = true;

        if(firstNameField == null || firstNameField.getText().trim().isEmpty()) {
            validInput = false;
            printApplicationStatus.setText("First name field is empty");
            firstNameField.requestFocus();
        }
        if(lastNameField == null || lastNameField.getText().trim().isEmpty()) {
            validInput = false;
            printApplicationStatus.setText("Last name field is empty");
            lastNameField.requestFocus();
        }

        if(statusBox == null || statusBox.getValue().equals("Status")) {
            validInput = false;
            printApplicationStatus.setText("Please select a status");
            statusBox.requestFocus();
        }
        return validInput;
    }
    /*
    handle column edits
     */
    @FXML
    public void firstNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<User, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User, String>) e;
        User user = cellEditEvent.getRowValue();
        user.setFirstName(cellEditEvent.getNewValue());
    }

    @FXML
    public void lastNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<User, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User, String>) e;
        User user = cellEditEvent.getRowValue();
        user.setLastName(cellEditEvent.getNewValue());
    }

    @FXML
    public void moduleOneCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<User, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User, String>) e;
        User user = cellEditEvent.getRowValue();
        user.setStatus(cellEditEvent.getNewValue());
    }

    public void handleDeleteButtonClick(ActionEvent event) {
        /*ObservableList<ModuleDataModel> userSelected;
        userSelected = table.getItems();
        if(!userSelected.isEmpty()) {
            userSelected.removeAll(table.getSelectionModel().getSelectedItems());
            table.getSelectionModel().clearSelection();
        }*/
    }

    public void handleClearButtonClick(ActionEvent event) {
        firstNameField.clear();
        lastNameField.clear();
        statusBox.setValue("Status");
    }

    /*
    .........................................Provide methods.........................................
         */

    public void provideAddButtonAction() {
        /*filterSearchInput.clear();
        User user = new User();
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setStatus(statusBox.getValue());
        table.getItems().add(user);
        System.out.println(user.toString());
        firstNameField.clear();
        lastNameField.clear();
        statusBox.setValue("Status");*/
    }

    public ObservableList<String> getStatusBoxData(){
        ObservableList<String> data = FXCollections.observableArrayList();
        data.add(new String("Approved"));
        data.add(new String("Failed"));
        return data;
    }

    public void handleOverviewAction(ActionEvent event) throws Exception{
        Main.getInstance().setScene(ViewNames.overviewView);
    }
    
    public void handleLogoutAction(ActionEvent event) throws Exception{
        Main.getInstance().setScene(ViewNames.loginView);
    }
    
    public void filterObservableUserList(String oldValue, String newValue) {
        ObservableList<DeliveryListObject> filteredList = FXCollections.observableArrayList();
        if(filterSearchInput == null || (newValue.length() < oldValue.length()) || newValue == null) {
            table.setItems(listData);
        }
        else {
            newValue = newValue.toUpperCase();
            for(DeliveryListObject model : table.getItems()) {
                String filterModuleTitle = model.getModuleTitle();
                String filterModuleDescription = model.getModule_description();
                if(filterModuleTitle.toUpperCase().contains(newValue) || filterModuleDescription.toUpperCase().contains(newValue))
                {
                    filteredList.add(model);
                }
            }
            table.setItems(filteredList);
        } 
    }


}



