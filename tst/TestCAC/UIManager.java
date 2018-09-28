/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCAC;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 *
 * @author nikhi
 */
public class UIManager implements Initializable {
    
    @FXML
    public void startUI(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        
        Scene startScreen = new Scene(root);
        
        stage.setScene(startScreen);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
