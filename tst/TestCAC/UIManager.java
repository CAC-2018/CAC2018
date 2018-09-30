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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.stage.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 *
 * @author nikhi
 */
public class UIManager implements Initializable {
    
    @FXML
    private Button btnReturn;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private Button btnCreate;
    
    Stage current = new Stage();
    
    public void startUI(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        
        Scene startScreen = new Scene(root);
        
        current = stage;
        
        current.setTitle("Basic Finance Sim");
        current.setScene(startScreen);
        current.show();
    }
    
    @FXML
    private void handleReturnButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        btnReturn.getScene().setRoot(root);
    }
    
    @FXML
    private void handleCreateButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
        btnReturn.getScene().setRoot(root);
    }
    
    @FXML
    private void handleBackLButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        btnLogin.getScene().setRoot(root);
    }
    
    @FXML
    private void handleBackCNUButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        btnCreate.getScene().setRoot(root);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
