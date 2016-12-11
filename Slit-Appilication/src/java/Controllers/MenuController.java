 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controllers;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by Basse on 22.11.2016.
 */
 
 
 
public class MenuController implements Initializable {
    @FXML
    private MenuBar menuBar; 
 
    @FXML
    private void handleAboutAction(final ActionEvent event) {
        provideAboutFunctionality();
    }
    
    @FXML
    private void handleKeyInput(final InputEvent event)
    {
        if (event instanceof KeyEvent)
        {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.M)
            {
                provideAboutFunctionality();
            }
        }
    }

    private void provideAboutFunctionality()
    {
        System.out.println("You clicked on Module!");
    }
 
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         * When a Scene is created, the system gives focus to a Node whose focusTraversable
         * variable is true and that is eligible to receive the focus,
         * unless the focus had been set explicitly via a call to requestFocus().
         *
         * Default value: False
         *
         * Change to true for focus when changing stage
         */
        menuBar.setFocusTraversable(false);
    }
 
}