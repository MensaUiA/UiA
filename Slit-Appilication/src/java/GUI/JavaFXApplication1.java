/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Framework.Names.ViewNames;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.HashMap; 
import javafx.scene.Parent;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Cheezy
 */
public class JavaFXApplication1 extends Application {
    
    private Stage stage; 
    
    private static JavaFXApplication1 instance;
    
    private HashMap<String, String> views = new HashMap<String, String>() {
        {
            put(ViewNames.loginView, "test.fxml");
            put(ViewNames.mainView, "MainScreen.fxml");
        }
    };
    
    public JavaFXApplication1() {
        instance = this;
    }
    
    public static JavaFXApplication1 getInstance() {
        return instance;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        try
        {
            this.stage = primaryStage;
            this.setScene(ViewNames.loginView); 
            this.stage.show();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
        
    public void setScene(String value) throws Exception
    {
        if(this.views.containsKey(value))
        {
            this.replaceSceneContent(this.views.get(value));
        }
        else 
            throw new Exception("Verdi eksisterer ikke");
    }
        
    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(this.getClass().getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 590, 420);
            //scene.getStylesheets().add(App.class.getResource("demo.css").toExternalForm());
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
    
     public static void main(String[] args) {
        launch(args);
    }
    
}
