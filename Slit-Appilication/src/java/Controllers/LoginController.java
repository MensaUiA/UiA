/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataModels.UsersDataModel;
import Framework.Managers.UserManager;
import Framework.Names.ViewNames;
import View.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cheezy & Haris
 */
public class LoginController implements Initializable {

    @FXML
    private TextField UsernameTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private Label InfoText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void onClick(ActionEvent event) throws Exception {
        if(!this.PasswordTextField.getText().isEmpty() && !this.UsernameTextField.getText().isEmpty())
        {
            UserManager user = new UserManager();
            
            UsersDataModel userModule = user.loginUser(this.UsernameTextField.getText(), this.PasswordTextField.getText());
            
            if(userModule.getFirstName() != null)
            {
                this.InfoText.setText("Login successfull");
                Main.getInstance().setScene(ViewNames.overviewView);
            }
            else
            {
                this.InfoText.setText("The information is incorrect");
            }
             
        }
        else
        {
            this.InfoText.setText("Password and Username can't be null"); 
        }
    }
      
}
