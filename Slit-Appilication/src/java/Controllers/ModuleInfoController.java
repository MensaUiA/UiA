package Controllers;
/**
 * Created by Basse.
 */

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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModuleInfoController implements Initializable {

    @FXML
    private TableColumn<User, String> firstNameCol, lastNameCol, moduleOneCol;

    @FXML
    private TextField firstNameField, lastNameField, filterSearchInput;

    @FXML
    private ComboBox<String> statusBox;

    @FXML
    private TableView<User> table;

    @FXML
    private Label printApplicationStatus;

    ObservableList<User> observableUserList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        filterSearchInput.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterObservableUserList((String) oldValue, (String) newValue);
            }
        });

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        moduleOneCol.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
git
        statusBox.setItems(getStatusBoxData());

        table.setItems(observableUserList);
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
    
    public void handleTommyClick(ActionEvent event) throws IOException {
        System.out.println("Tommy sliter");
        
        Parent page = FXMLLoader.load(getClass().getResource("View"));
        Scene scene = new Scene(page);
        Stage sampleStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sampleStage.setScene(scene);
        sampleStage.show();
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
    public void firstNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<User, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User, String>) e;
        User user = cellEditEvent.getRowValue();
        user.setFirstName(cellEditEvent.getNewValue());
    }

    public void lastNameCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<User, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User, String>) e;
        User user = cellEditEvent.getRowValue();
        user.setLastName(cellEditEvent.getNewValue());
    }

    public void moduleOneCol_OnEditCommit(Event e) {
        TableColumn.CellEditEvent<User, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<User, String>) e;
        User user = cellEditEvent.getRowValue();
        user.setStatus(cellEditEvent.getNewValue());
    }

    public void handleDeleteButtonClick(ActionEvent event) {
        ObservableList<User> userSelected;
        userSelected = table.getItems();
        if(!userSelected.isEmpty()) {
            userSelected.removeAll(table.getSelectionModel().getSelectedItems());
            table.getSelectionModel().clearSelection();
        }
    }

    public void handleClearButtonClick(ActionEvent event) {
        firstNameField.clear();
        lastNameField.clear();
        statusBox.setValue("Status");
    }

    public void filterObservableUserList(String oldValue, String newValue) {
        ObservableList<User> filteredList = FXCollections.observableArrayList();
        if(filterSearchInput == null || (newValue.length() < oldValue.length())) {
           table.setItems(observableUserList);
        }
        else {
            newValue = newValue.toUpperCase();
            for(User users : table.getItems()) {
                String filterFirstName = users.getFirstName();
                String filterLastName = users.getLastName();
                if(filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue)) {
                    filteredList.add(users);
                }
            }
            table.setItems(filteredList);
        }
    }

    /*
    .........................................Provide methods.........................................
         */

    public void provideAddButtonAction() {
        filterSearchInput.clear();
        User user = new User();
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setStatus(statusBox.getValue());
        table.getItems().add(user);
        System.out.println(user.toString());
        firstNameField.clear();
        lastNameField.clear();
        statusBox.setValue("Status");
    }

    public ObservableList<String> getStatusBoxData(){
        ObservableList<String> data = FXCollections.observableArrayList();
        data.add(new String("Approved"));
        data.add(new String("Failed"));
        return data;
    }


}



