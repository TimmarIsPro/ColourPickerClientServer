/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourpicker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.json.JSONObject;
import javafx.scene.shape.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;


/**
 *
 * @author J380446
 */
public class FXMLDocumentController implements Initializable {
    
    //max amount of colours
    JSONObject[] listColor = new JSONObject[4];
    //String filename = "colors.ser";
    private static final String ENDPOINT_ADDR = "localhost";
    
    @FXML
    private Label colorName, colorHex, colorRGBA;
    
    @FXML
    private ListView colorList;
    
    @FXML
    private Rectangle colorDisp;
    
    @FXML
    private AnchorPane window;
    
    //On click of an entry in the listview, displays the relevant information.
    @FXML
    private void handleMouseClick(MouseEvent event) {
        colorName.setText(listColor[colorList.getSelectionModel().getSelectedIndex()].getString("name"));
        colorHex.setText("#" + listColor[colorList.getSelectionModel().getSelectedIndex()].getString("hex"));
        colorRGBA.setText(listColor[colorList.getSelectionModel().getSelectedIndex()].getString("RGBA"));
        colorDisp.setFill(Color.web(listColor[colorList.getSelectionModel().getSelectedIndex()].getString("hex")));
    }
    
    
    //on a keypress matching the first letter of a colour, displays the relevant information.
    @FXML
    private void handleKeyPress(KeyEvent event)
    {
                if (event.getCode() == KeyCode.R) {
                    colorName.setText(listColor[0].getString("name"));
                    colorHex.setText(listColor[0].getString("hex"));
                    colorRGBA.setText(listColor[0].getString("RGBA"));
                    colorDisp.setFill(Color.web(listColor[0].getString("hex")));
                }
                if (event.getCode() == KeyCode.B) {
                    colorName.setText(listColor[1].getString("name"));
                    colorHex.setText(listColor[1].getString("hex"));
                    colorRGBA.setText(listColor[1].getString("RGBA"));
                    colorDisp.setFill(Color.web(listColor[1].getString("hex")));
                }
                if (event.getCode() == KeyCode.Y) {
                    colorName.setText(listColor[2].getString("name"));
                    colorHex.setText(listColor[2].getString("hex"));
                    colorRGBA.setText(listColor[2].getString("RGBA"));
                    colorDisp.setFill(Color.web(listColor[2].getString("hex")));
                }
                if (event.getCode() == KeyCode.G) {
                    colorName.setText(listColor[3].getString("name"));
                    colorHex.setText(listColor[3].getString("hex"));
                    colorRGBA.setText(listColor[3].getString("RGBA"));
                    colorDisp.setFill(Color.web(listColor[3].getString("hex")));
                }
                
                if (event.getCode() == KeyCode.ESCAPE) {
                    System.exit(0);
                }

    }
    //connects via socket to the server program, and reads in JSON formatted text.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String input = "";
        
        try {
            Socket skt = new Socket(ENDPOINT_ADDR, 1234);
            
            BufferedReader in;
            
            in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            while (!in.ready()) {}
            input = in.readLine();
            String[] colors = input.split("-");
            int i = 0;
            for (String s : colors)
            {            
                listColor[i] = new JSONObject(s);
                i++;
            }
            in.close();
            skt.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (JSONObject obj : listColor)
        {
            colorList.getItems().add(obj);
        }     
        
        /*
        //input = "{\"name\":\"Red\", \"hex\":\"FF0000\", \"RGBA\":\"255,0,0,0\"}-{\"name\":\"Blue\", \"hex\":\"0000FF\", \"RGBA\":\"0,0,255,0\"}-{\"name\":\"Yellow\", \"hex\":\"FFFF00\", \"RGBA\":\"255,255,0,0\"}";
        String[] colors = input.split("-");
        int i = 0;
        for (String s : colors)
        {            
            listColor[i] = new JSONObject(s);
            i++;
        }

        //serializing
        try {
          FileOutputStream fos = new FileOutputStream(filename);
          fos.write(input.getBytes());
          fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
*/
        
                
        
        
    }
    
    
    
    @FXML
    private void displayColor(ActionEvent event) {
        colorName.setText(listColor[colorList.getSelectionModel().getSelectedIndex()].getString("name"));
        colorHex.setText("#" + listColor[colorList.getSelectionModel().getSelectedIndex()].getString("hex"));
        colorRGBA.setText(listColor[colorList.getSelectionModel().getSelectedIndex()].getString("RGBA"));
        colorDisp.setFill(Color.web(listColor[colorList.getSelectionModel().getSelectedIndex()].getString("hex")));
    }  
}