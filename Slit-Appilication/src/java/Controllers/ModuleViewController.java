/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Tommy
 */
public class ModuleViewController implements Initializable {

    @FXML
    private TreeView<?> tree;
    @FXML
    private TableView<?> table;
    @FXML
    private AnchorPane details;
    @FXML
    private HBox titleLine;
    @FXML
    private HBox labels;
    @FXML
    private Hyperlink project;
    @FXML
    private Label bugid;
    @FXML
    private TextField synopsis;
    @FXML
    private TextArea descriptionValue;
    @FXML
    private Button newModule;
    @FXML
    private Button saveModule;
    @FXML
    private Button deleteModule;
    @FXML
    private Label messageBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newModuleFired(ActionEvent event) {
    }

    @FXML
    private void saveModuleFired(ActionEvent event) {
    }

    @FXML
    private void deleteModuleFired(ActionEvent event) {
    }
    
}
