/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 *
 * @author Rebecca
 */
public class FXMLDocumentController{
    @FXML private Text actiontarget;
    @FXML ColorPicker colorPicker = new ColorPicker();
    @FXML private GridPane gridpane;
   
    
    @FXML protected void handleSettingsChangeButton(ActionEvent event) {
        actiontarget.setText("Settings changed");
    }
    
    @FXML protected void handleColorPicker(ActionEvent event) {
        Paint color = colorPicker.getValue();
        BackgroundFill bgcolor = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg = new Background(bgcolor);
        gridpane.setBackground(bg);
        actiontarget.setText("Background selected");
    }
    
    
}
