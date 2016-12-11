/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import View.Main;
import DataModels.UsersDataModel;
import Framework.Managers.UserManager;
import Framework.Names.ViewNames;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cheezy
 * @author Basse
 */
public class TestController implements Initializable {

    @FXML
    private TextField UsernameTextField;
    @FXML
    private TextField PasswordTextField;
    @FXML
    private Label InfoText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.InfoText.setText("Tommy sliter");
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
                Main.getInstance().setScene(ViewNames.loginView);
            }
            else
            {
                this.InfoText.setText("The information is incorrect");
            }
             
        }
        else
        {
            this.InfoText.setText("Password and Username can't be empty"); 
        }
    }
    
}
