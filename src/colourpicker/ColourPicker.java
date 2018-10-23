/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourpicker;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



/**
 * Reads the JSON provided by the server program, and displays them in a JavaFX program.
 * @author J380446
 */
public class ColourPicker extends Application {
        
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Colour Picker");

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                
        Scene scene = new Scene(root);
               
        
       
        stage.setScene(scene);
        stage.show();
       

        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}
