/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Framework.Names.ViewNames;
import View.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Basse
 */
public class CreateController {

    @FXML
    private Button publishBtn;
    @FXML
    private TextField nameText;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField deadlineText;
    
    public void handleCancelAction(ActionEvent event) throws Exception{
        Main.getInstance().setScene(ViewNames.mainView);
    }
    
}
