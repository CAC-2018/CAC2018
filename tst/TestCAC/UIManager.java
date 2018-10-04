/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCAC;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resources;

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
    private Button btnCreateC;
    
    @FXML
    private Button btnPlay;
    
    @FXML
    private ChoiceBox cbHousing;
    
    @FXML
    private ChoiceBox cbProfession;
    
    @FXML
    private ChoiceBox cbDependants;
    
    @FXML
    private RadioButton radHouse;
    
    @FXML
    private Tooltip tltHousing;
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextField txtNameL;
    
    @FXML
    private TextField txtPass;
    
    @FXML
    private TextField txtRePass;
    
    @FXML
    private TextField txtPassL;
    
    @FXML
    private Label lblSal;
    
    @FXML
    private Label lblMort;
    
    @FXML
    private Label lblIns;
    
    @FXML
    private Label lblMonth;
    
    @FXML
    private Label lblGross;
    
    @FXML
    private Label lblMCosts;
    
    @FXML
    private Label lblNet;
    
    @FXML
    private Label lblEssentials;
    
    @FXML
    private Label lblMortRent;
    
    @FXML
    private Label lblHIns;
    
    @FXML
    private Label lblMeds;
    
    @FXML
    private Label lblTax;
    
    @FXML
    private Label lblSavings;
    
    @FXML
    private Label lblScore;
    
    @FXML
    private Label lblHappiness;
    
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
        btnCreateC.getScene().setRoot(root);
    }
    
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception{
        if (DataManager.login(txtNameL.getText(), txtPassL.getText())){
            Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
            btnLogin.getScene().setRoot(root);
        } 
    }
    
    @FXML
    private void handleCreateCButtonAction(ActionEvent event) throws Exception{
        if ((txtPass.getText().equals(txtRePass.getText()))&&(txtPass.getLength()>6)&&
                (txtName.getLength()>6)&&DataManager.newLog(txtName.getText(), txtPass.getText())){
            Parent root = FXMLLoader.load(getClass().getResource("CharacterCreation.fxml"));
            btnCreateC.getScene().setRoot(root);
        }
    }
    
    @FXML
    private void handleBackCCButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
        btnPlay.getScene().setRoot(root);
    }
    
    @FXML
    private void handlePlayButtonAction(ActionEvent event) throws Exception{
        try{
            int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
            int value = Integer.parseInt(((String)cbHousing.getValue()).trim().substring(1)); 
            int housing = 0;
            Boolean house = false;        
            if(radHouse.isSelected()){
                house = true;
                housing = getArrayIndex(GameManager.houses[index],value);
            }
            else{
                housing = getArrayIndex(GameManager.apartments[index],value);
            }
            int deps = Integer.parseInt(((String)cbDependants.getValue()).trim());
            DataManager.initGameData(index, house, housing, deps);
            GameManager.initGame(index, house, housing, deps);
            Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
            btnPlay.getScene().setRoot(root);
        }
        catch (Exception ex){
            System.out.println(ex.toString()+" @handlePlayButtonAction,UIManager");
            System.out.println(ex.getCause());
        }
    }
    
    @FXML
    private void handleJobChoiceAction(ActionEvent event) throws Exception{   
        int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
        lblSal.setText("Yearly Salary: $" + Integer.toString(GameManager.salaries[index]));
        List<String> list = new ArrayList<String>();
        ObservableList houses = FXCollections.observableList(list);
        List<String> list2 = new ArrayList<String>();
        ObservableList deps = FXCollections.observableList(list2);
        if(radHouse.isSelected()){
            for (int house: GameManager.houses[index]){
                houses.add("$"+Integer.toString(house));
            }
            cbHousing.setItems(houses);
            cbHousing.setValue(houses.get(0));
            GameManager.mortIns(GameManager.houses[index][0]);
            lblMort.setText("Mortgage: $"+Integer.toString(GameManager.mort));
            lblIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns));
            tltHousing.setText("House Value ($)");
        }
        else{
            for (int house: GameManager.apartments[index]){
                houses.add("$"+Integer.toString(house));
            }
            cbHousing.setItems(houses);
            cbHousing.setValue(houses.get(0));
            lblMort.setText("");
            lblIns.setText("");
            tltHousing.setText("Monthly Rent ($)");
        }
        GameManager.calcDeps(GameManager.salaries[index]);
        for (int dep: GameManager.deps){
            deps.add(Integer.toString(dep));
        }
        cbDependants.setItems(deps);
        cbDependants.setValue("0");
    }
    
    @FXML
    private void handleHouseRadAction(ActionEvent event) throws Exception{
        int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
        List<String> list = new ArrayList<String>();
        ObservableList houses = FXCollections.observableList(list);
        for (int house: GameManager.houses[index]){
            houses.add("$"+Integer.toString(house));
        }
        cbHousing.setItems(houses);
        cbHousing.setValue(houses.get(0));
        GameManager.mortIns(GameManager.houses[index][0]);
        lblMort.setText("Mortgage: $"+Integer.toString(GameManager.mort));
        lblIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns));
        tltHousing.setText("House Value ($)");
    }
    
    @FXML
    private void handleApartRadAction(ActionEvent event) throws Exception{
        int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
        List<String> list = new ArrayList<String>();
        ObservableList houses = FXCollections.observableList(list);
        for (int house: GameManager.apartments[index]){
            houses.add("$"+Integer.toString(house));
        }
        cbHousing.setItems(houses);
        cbHousing.setValue(houses.get(0));
        lblMort.setText("");
        lblIns.setText("");
        tltHousing.setText("Monthly Rent ($)");
    }
    
    @FXML
    private void handleHouseChoiceAction(ActionEvent event) throws Exception{
        try{
            if(radHouse.isSelected()){
                String str = ((String)cbHousing.getValue()).trim().substring(1);
                int house = Integer.parseInt(str);
                GameManager.mortIns(house);
                lblMort.setText("Mortgage: $" + GameManager.mort);
                lblIns.setText("Home Insurance: $" + GameManager.homeIns);
            }
        }
        catch (Exception ex){
            System.out.println(ex.toString()+" @handleHouseChoiceAction,UIManager");
        }
    }
    
    private void firstLoad() throws InterruptedException{
        lblGross.setText("Gross Monthly Income: $"+Integer.toString(GameManager.gross));
        lblMCosts.setText("Monthly Costs: $"+Integer.toString(GameManager.fixed));
        lblNet.setText("Net Monthly Income: $"+Integer.toString(GameManager.net));
        lblTax.setText("Taxes: $"+Integer.toString(GameManager.tax));
        if (GameManager.haveHouse){
            lblMortRent.setText("Mortgage: $"+Integer.toString(GameManager.mortRent));
            lblHIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns));
        }
        else{
            lblMortRent.setText("Rent: $"+Integer.toString(GameManager.mortRent));
            lblHIns.setText("Home Insurance: N/A");
        }
    }
    
    private int getArrayIndex(int[] arr,int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                k=i;
                break;
            }
        }
    return k;
}
    
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (lblGross != null){
            try {
                firstLoad();
            } catch (InterruptedException ex) {
                Logger.getLogger(UIManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
