package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML private TextField username;

    public void handleLogin(ActionEvent actionEvent) {
        System.out.printf("You are logged in %s! %n", username.getText());
    }
}
