/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cac2018;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.control.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.WindowEvent;

/**
 *
 * @author nikhi
 */
public class UIManager implements Initializable {
    
    @FXML
    private Button btnPlayGame;
    
    @FXML
    private Button btnPlay;
    
    @FXML
    private Button btnToCredit;
    
    @FXML
    private Button btnHelp;
    
    @FXML
    private RadioButton radHouse;
    
    @FXML
    private RadioButton radApart;
    
    @FXML
    private ChoiceBox cbHousing;
    
    @FXML
    private ChoiceBox cbProfession;
    
    @FXML
    private ChoiceBox cbDependants;
    
    @FXML
    private Tooltip tltHousing;
    
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
    private Label lblSavings;
    
    @FXML
    private Label lblScore;
    
    @FXML
    private Label lblMonSal;
    
    @FXML
    private Label lblMonthTax;
    
    @FXML
    private Label lblTotDep;
    
    @FXML
    private Label lblTotCost;
    
    @FXML
    private Label lblHappiness;
    
    @FXML
    private Label lblPrompt;
    
    @FXML
    private Label lblBox;
    
    @FXML
    private Label lblHouseCost;
    
    @FXML
    private Label lblEnd;
    
    @FXML
    private Label lblFSavings;
    
    @FXML
    private Label lblFScore;
    
    @FXML
    private Label lblFWellBeing;
    
    @FXML
    private Label lblFSal;
    
    @FXML
    private Label lblFDeps;
    
    @FXML
    private Label lblGoldLimit;
    
    @FXML
    private Label lblPlatLimit;
    
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private Button btn4;
    
    @FXML
    private Button btn5;
    
    @FXML
    private ListView lstJan;
    
    @FXML
    private ListView lstFeb;
    
    @FXML
    private ListView lstMar;
    
    @FXML
    private ListView lstApr;
    
    @FXML
    private ListView lstMay;
    
    @FXML
    private ListView lstJun;
    
    @FXML
    private ListView lstJul;
    
    @FXML
    private ListView lstAug;
    
    @FXML
    private ListView lstSep;
    
    @FXML
    private ListView lstOct;
    
    @FXML
    private ListView lstNov;
    
    @FXML
    private ListView lstDec;
    
    @FXML
    private RadioButton radGoldCard;
    
    @FXML
    private RadioButton radPlatCard;
    
    @FXML
    private Label lblDue;
    
    @FXML
    private Label lblAvailable;
    
    @FXML
    private Label lblCredit;
    
    @FXML
    private Label lblCredAmt;
    
    @FXML
    private Label lblMinPay;
    
    @FXML
    private Label lblInterest;
    
    @FXML 
    private Slider sldPayCred;
    
    @FXML
    private RadioButton radCard;
    
    private Question currentQ;
    
    private int qNum;
    
    Stage current = new Stage();
    
    public void startUI(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        
        Scene startScreen = new Scene(root);
        
        current = stage;
        
        current.setResizable(false);
        
        current.setTitle("Wallet Wise");
        current.setScene(startScreen);
        current.show();
    }

    @FXML
    private void handlePlayGButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CharacterCreation.fxml"));
        btnPlayGame.getScene().setRoot(root);
    }    
    
    @FXML
    private void handleBackCCButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        btnToCredit.getScene().setRoot(root);
    }
    
    @FXML
    private void handleBackCreditButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CharacterCreation.fxml"));
        btnPlay.getScene().setRoot(root);
    }
    
    @FXML
    private void handleMenuButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        lblScore.getScene().setRoot(root);
    }
    
    @FXML
    private void handleFMenuButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        lblFSavings.getScene().setRoot(root);
    }
    
    @FXML
    private void handleHelpButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        Stage stage = new Stage();
        stage.initOwner((Stage)btnHelp.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setTitle("Wallet Wise Help");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handleCreditsButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Credits.fxml"));
        Stage stage = new Stage();
        stage.initOwner((Stage)btnHelp.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setTitle("Credits");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handleToCreditButtonAction(ActionEvent event) throws Exception{
        try{
            int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
            int value = Integer.parseInt(((String)cbHousing.getValue()).trim().substring(1)); 
            int housing = 0;
            Boolean house = false;        
            if(radHouse.isSelected()){
                house = true;
                housing = getArrayIndex(GameManager.houses,value);
            }
            else{
                housing = getArrayIndex(GameManager.apartments,value);
            }
            int deps = Integer.parseInt(((String)cbDependants.getValue()).trim());
            GameManager.dep = deps;
            GameManager.housing = housing;
            GameManager.haveHouse = house;
            GameManager.index = index;
            
            Parent root = FXMLLoader.load(getClass().getResource("CreditCard.fxml"));
            btnToCredit.getScene().setRoot(root);
        }
        catch (Exception ex){
            System.out.println(ex.toString()+" @handleToCreditButtonAction,UIManager");
            System.out.println(ex.getCause());
        }
    }
    
    @FXML
    private void handlePlayButtonAction(ActionEvent event) throws Exception{
        try{
            int card = 0;
            if (radGoldCard.isSelected()){
                card = 1;
            }
            else if (radPlatCard.isSelected()){
                card = 2;
            }
            GameManager.cardStatus = card;
            GameManager.initGame();
            Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
            btnPlay.getScene().setRoot(root);
        }
        catch (Exception ex){
            System.out.println(ex.toString()+" @handlePlayButtonAction,UIManager");
            System.out.println(ex.getCause());
        }
    }
    
    private void initCards(){
        int ind = GameManager.index;
        int cardTier = GameManager.cardChoice[ind];
        int goldLimit = GameManager.goldCards[cardTier];
        int platLimit = GameManager.platCards[cardTier];
        
        lblGoldLimit.setText("$"+Integer.toString(goldLimit));
        lblPlatLimit.setText("$"+Integer.toString(platLimit));
    }
    
    private void initCC(){
        List<String> list = new ArrayList<String>();
        ObservableList houses = FXCollections.observableList(list);
        for (int house: GameManager.houses){
            houses.add("$"+Integer.toString(house));
        }
        cbHousing.setItems(houses);
        cbHousing.setValue(houses.get(0));
        GameManager.mortIns(GameManager.houses[0]);
        lblMort.setText("Mortgage: $"+Integer.toString(GameManager.mort) +"/month");
        lblHouseCost.setText("House Value:");
        lblIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns)+"/month");
        tltHousing.setText("House Value ($)");
        int depo = Integer.parseInt(((String)cbDependants.getValue()).trim());
        lblTotDep.setText("Total Cost of Living: $"+Integer.toString((depo+1)*1100)+"/month");
    }
    
    @FXML
    private void handleJobChoiceAction(ActionEvent event) throws Exception{
        int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
        lblSal.setText("Yearly Salary: $" + Integer.toString(GameManager.salaries[index]));
        lblMonSal.setText("Monthly Salary: $" + Integer.toString((int)(GameManager.salaries[index]/12)));
        lblMonthTax.setText("Tax: $" + Integer.toString(GameManager.tax(GameManager.salaries[index]))+"/month");
        lblTotCost.setText("Total Monthly Cost: $"+Integer.toString(calcTot()));
        if(checkEx()){
            btnToCredit.disableProperty().set(false);
        }
        else{
            popup("Your monthly expenses exceed your monthly salary. Monthly salary must exceed expenses to proceed.",(Stage)lblSal.getScene().getWindow());
            btnToCredit.disableProperty().set(true);
        }
    }
    
    @FXML
    private void handleHouseRadAction(ActionEvent event) throws Exception{
        List<String> list = new ArrayList<String>();
        ObservableList houses = FXCollections.observableList(list);
        for (int house: GameManager.houses){
            houses.add("$"+Integer.toString(house));
        }
        cbHousing.setItems(houses);
        cbHousing.setValue(houses.get(0));
        GameManager.mortIns(GameManager.houses[0]);
        lblMort.setText("Mortgage: $"+Integer.toString(GameManager.mort)+"/month");
        lblIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns)+"/month");
        lblHouseCost.setText("House Value:");
        tltHousing.setText("House Value ($)");
        if(checkEx()){
            btnToCredit.disableProperty().set(false);
        }
        else{
            popup("Your monthly expenses exceed your monthly salary. Monthly salary must exceed expenses to proceed.",(Stage)lblSal.getScene().getWindow());
            btnToCredit.disableProperty().set(true);
        }
    }
    
    @FXML
    private void handleApartRadAction(ActionEvent event) throws Exception{
        List<String> list = new ArrayList<String>();
        ObservableList houses = FXCollections.observableList(list);
        for (int house: GameManager.apartments){
            houses.add("$"+Integer.toString(house));
        }
        cbHousing.setItems(houses);
        cbHousing.setValue(houses.get(0));
        lblMort.setText("");
        lblIns.setText("");
        lblHouseCost.setText("Monthly Rent:");
        tltHousing.setText("Monthly Rent ($)");
        lblTotCost.setText("Total Monthly Cost: $"+Integer.toString(calcTot()));
    }
    
    @FXML
    private void handleDepChoiceAction(ActionEvent event) throws Exception{
        int deps = Integer.parseInt(((String)cbDependants.getValue()).trim());
        lblTotDep.setText("Total Cost of Living: $"+Integer.toString((deps+1)*1100)+"/month");
        lblTotCost.setText("Total Monthly Cost: $"+Integer.toString(calcTot()));
        lblTotCost.setTextFill(javafx.scene.paint.Color.BLACK);
        if(checkEx()){
            btnToCredit.disableProperty().set(false);
        }
        else{
            popup("Your monthly expenses exceed your monthly salary. Monthly salary must exceed expenses to proceed.",(Stage)lblSal.getScene().getWindow());
            btnToCredit.disableProperty().set(true);
        }
    }
    
    @FXML
    private void handleHouseChoiceAction(ActionEvent event) throws Exception{
        try{
            if(radHouse.isSelected()){
                String str = ((String)cbHousing.getValue()).trim().substring(1);
                int house = Integer.parseInt(str);
                GameManager.mortIns(house);
                lblMort.setText("Mortgage: $" + GameManager.mort+"/month");
                lblHouseCost.setText("House Value:");
                lblIns.setText("Home Insurance: $" + GameManager.homeIns+"/month");
            }
            lblTotCost.setText("Total Monthly Cost: $"+Integer.toString(calcTot()));
            if(checkEx()){
                btnToCredit.disableProperty().set(false);
            }
            else{
                popup("Your monthly expenses exceed your monthly salary. Monthly salary must exceed expenses to proceed.",(Stage)lblSal.getScene().getWindow());
                btnToCredit.disableProperty().set(true);
            }
        }
        catch (Exception ex){
            System.out.println(ex.toString()+" @handleHouseChoiceAction,UIManager");
        }
    }
    
    private Boolean checkEx(){
        int deps = Integer.parseInt(((String)cbDependants.getValue()).trim());
        int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
        int value = Integer.parseInt(((String)cbHousing.getValue()).trim().substring(1)); 
        Boolean house = radHouse.isSelected();
        return GameManager.check(index, deps, value, house);
    }
    
    private int calcTot(){
        int deps = Integer.parseInt(((String)cbDependants.getValue()).trim());
        int index = java.util.Arrays.asList(GameManager.jobs).indexOf(cbProfession.getValue());
        int value = Integer.parseInt(((String)cbHousing.getValue()).trim().substring(1)); 
        Boolean house = radHouse.isSelected();
        return GameManager.calc(index, deps, value, house);
    }
    
    private void firstLoad() throws InterruptedException{
        lblGross.setText("Monthly Salary: $"+Integer.toString(GameManager.gross));
        lblMCosts.setText("Monthly Costs: $"+Integer.toString(GameManager.fixed));
        lblSavings.setText("Balance: $"+Integer.toString(GameManager.savings));
        sldPayCred.minProperty().set(0);
        sldPayCred.maxProperty().set(0);
        if (GameManager.cardStatus == 0){
            lblDue.disableProperty().set(true);
            lblAvailable.disableProperty().set(true);
            lblCredit.disableProperty().set(true);
            lblCredAmt.disableProperty().set(true);
            lblMinPay.disableProperty().set(true);
            lblInterest.disableProperty().set(true);
            sldPayCred.disableProperty().set(true);
            lblDue.visibleProperty().set(false);
            lblAvailable.visibleProperty().set(false);
            lblCredit.visibleProperty().set(false);
            lblCredAmt.visibleProperty().set(false);
            lblMinPay.visibleProperty().set(false);
            lblInterest.visibleProperty().set(false);
            sldPayCred.visibleProperty().set(false);
        }
        else{
            lblAvailable.textProperty().set("Available Credit: $"+String.format("%.2f",GameManager.available));
            lblInterest.textProperty().set("Monthly Interest: "+Double.toString(GameManager.interest)+"%");
        }
        
        sldPayCred.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue source, Object oldValue, Object newValue){
                lblCredAmt.textProperty().setValue(String.format("$%.2f",sldPayCred.getValue()));
            }
        });
    }
    
    @FXML
    private void handleCredSliderAction(ActionEvent event) throws Exception{
        double value = sldPayCred.valueProperty().get();
        lblCredAmt.textProperty().set("$"+String.format("%.2f",value));        
    }
    
    @FXML
    private void handleHistButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("History.fxml"));
        Stage stage = new Stage();
        stage.initOwner((Stage)lblScore.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setTitle("Spending History");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handleFHistButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("History.fxml"));
        Stage stage = new Stage();
        stage.initOwner((Stage)lblFScore.getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setTitle("Spending History");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handleNextButtonAction(ActionEvent event) throws Exception{
        if(GameManager.monthDone){
            GameManager.crunchCredit(sldPayCred.valueProperty().get());
            if (GameManager.month == 12){
                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                lblScore.getScene().setRoot(root);
            }
            GameManager.savings+= GameManager.net;
            lblSavings.setText("Balance: $"+Integer.toString(GameManager.savings));
            GameManager.score =(int) ((int) Math.round(GameManager.savings*GameManager.wellB)/(Math.sqrt((double)Math.abs(GameManager.savings*GameManager.wellB))));
            lblScore.setText("Game Score: "+Integer.toString(GameManager.score));
            lblHappiness.setText("Wellness Index: "+Integer.toString(GameManager.wellB));
            lblAvailable.textProperty().set("Available Credit: $"+String.format("%.2f",GameManager.available));
            lblDue.textProperty().set("Credit Card Bill: $"+String.format("%.2f",GameManager.bills));
            lblMinPay.textProperty().set("Min. Payment: $"+String.format("%.2f",GameManager.bills/10));
            sldPayCred.minProperty().set(GameManager.bills/10);
            if (GameManager.savings > GameManager.bills){
                sldPayCred.maxProperty().set(GameManager.bills);
            }
            else{
                sldPayCred.maxProperty().set(GameManager.savings);
            }
            if (GameManager.savings < (GameManager.bills/10)){
                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                lblScore.getScene().setRoot(root);
            }
            GameManager.month+=1;
            GameManager.monthDone = false;
            GameManager.setMonthly();
            qNum = 0;
            switch (GameManager.month){
                case 1: lblMonth.setText("Month 1: January");break;
                case 2: lblMonth.setText("Month 2: February");break;
                case 3: lblMonth.setText("Month 3: March");break;
                case 4: lblMonth.setText("Month 4: April");break;
                case 5: lblMonth.setText("Month 5: May");break;
                case 6: lblMonth.setText("Month 6: June");break;
                case 7: lblMonth.setText("Month 7: July");break;
                case 8: lblMonth.setText("Month 8: August");break;
                case 9: lblMonth.setText("Month 9: September");break;
                case 10: lblMonth.setText("Month 10: October");break;
                case 11: lblMonth.setText("Month 11: November");break;
                case 12: lblMonth.setText("Month 12: December");break;
            }
        }
        else{
            popup("Make monthly descisions before ending the month.",(Stage)lblScore.getScene().getWindow());
        }
    }
    
    @FXML
    private void handleRadCardAction(ActionEvent event) throws Exception{
        switch (currentQ.answers.length){
            case 2:
                if (radCard.selectedProperty().get()){
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                            btn4.disableProperty().set(false);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.available){
                            btn4.disableProperty().set(true);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                    }
                }
                else{
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings){
                            btn4.disableProperty().set(false);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.savings){
                            btn4.disableProperty().set(true);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                    }
                }
                break;           
            case 3:
                if (radCard.selectedProperty().get()){
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                            btn3.disableProperty().set(false);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.available){
                            btn5.disableProperty().set(false);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.available){
                            btn3.disableProperty().set(true);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]>GameManager.available){
                            btn5.disableProperty().set(true);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                }
                else{
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings){
                            btn3.disableProperty().set(false);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.savings){
                            btn5.disableProperty().set(false);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.savings){
                            btn3.disableProperty().set(true);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]>GameManager.savings){
                            btn5.disableProperty().set(true);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                }
                break;  
            case 4:
                if (radCard.selectedProperty().get()){
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                            btn2.disableProperty().set(false);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.available){
                            btn4.disableProperty().set(false);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]*(GameManager.dep+1)>GameManager.available){
                            btn5.disableProperty().set(false);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.available){
                            btn2.disableProperty().set(true);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]>GameManager.available){
                            btn4.disableProperty().set(true);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[4]>GameManager.available){
                            btn5.disableProperty().set(true);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                }
                else{
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings){
                            btn2.disableProperty().set(false);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.savings){
                            btn4.disableProperty().set(false);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]*(GameManager.dep+1)>GameManager.savings){
                            btn5.disableProperty().set(false);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.savings){
                            btn2.disableProperty().set(true);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]>GameManager.savings){
                            btn4.disableProperty().set(true);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]>GameManager.savings){
                            btn5.disableProperty().set(true);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                }
                break;
            case 5:
                if (radCard.selectedProperty().get()){
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                            btn2.disableProperty().set(false);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.available){
                            btn3.disableProperty().set(false);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]*(GameManager.dep+1)>GameManager.available){
                            btn4.disableProperty().set(false);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[4]*(GameManager.dep+1)>GameManager.available){
                            btn5.disableProperty().set(false);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.available){
                            btn2.disableProperty().set(true);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]>GameManager.available){
                            btn3.disableProperty().set(true);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]>GameManager.available){
                            btn4.disableProperty().set(true);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[4]>GameManager.available){
                            btn5.disableProperty().set(true);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                }
                else{
                    if (currentQ.scalable){
                        if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings){
                            btn2.disableProperty().set(false);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.savings){
                            btn3.disableProperty().set(false);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]*(GameManager.dep+1)>GameManager.savings){
                            btn4.disableProperty().set(false);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[4]*(GameManager.dep+1)>GameManager.savings){
                            btn5.disableProperty().set(false);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                    else{
                        if (currentQ.cost[1]>GameManager.savings){
                            btn2.disableProperty().set(true);
                        }
                        else{
                            btn2.disableProperty().set(false);
                        }
                        if (currentQ.cost[2]>GameManager.savings){
                            btn3.disableProperty().set(true);
                        }
                        else{
                            btn3.disableProperty().set(false);
                        }
                        if (currentQ.cost[3]>GameManager.savings){
                            btn4.disableProperty().set(true);
                        }
                        else{
                            btn4.disableProperty().set(false);
                        }
                        if (currentQ.cost[4]>GameManager.savings){
                            btn5.disableProperty().set(true);
                        }
                        else{
                            btn5.disableProperty().set(false);
                        }
                    }
                }
                break;
        }
    }
    
    @FXML
    private void handle1ButtonAction(ActionEvent event) throws Exception{
        int resps = GameManager.monthly.get(qNum).answers.length;
        switch (resps){
            case 3: GameManager.monthly.get(qNum).setResponse(0,radCard.selectedProperty().get());break;
            case 4: GameManager.monthly.get(qNum).setResponse(0,radCard.selectedProperty().get());break;
            case 5: GameManager.monthly.get(qNum).setResponse(0,radCard.selectedProperty().get());break;
        }
        if (qNum == (GameManager.monthly.size()-1)){
            GameManager.monthDone = true;
            if (lblPrompt != null){
                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        }
        else{
            runQuestions();
        }
    }

    @FXML
    private void handle2ButtonAction(ActionEvent event) throws Exception{ 
        int resps = GameManager.monthly.get(qNum).answers.length;
        switch (resps){
            case 2: GameManager.monthly.get(qNum).setResponse(0,radCard.selectedProperty().get());break;
            case 4: GameManager.monthly.get(qNum).setResponse(1,radCard.selectedProperty().get());break;
            case 5: GameManager.monthly.get(qNum).setResponse(1,radCard.selectedProperty().get());break;
        }
        if (qNum == (GameManager.monthly.size()-1)){
            GameManager.monthDone = true;
            if (lblPrompt != null){
                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        }
        else{
            runQuestions();
        }
    }

    @FXML
    private void handle3ButtonAction(ActionEvent event) throws Exception{
        int resps = GameManager.monthly.get(qNum).answers.length;
        switch (resps){
            case 3: GameManager.monthly.get(qNum).setResponse(1,radCard.selectedProperty().get());break;
            case 5: GameManager.monthly.get(qNum).setResponse(2,radCard.selectedProperty().get());break;
        }
        if (qNum == (GameManager.monthly.size()-1)){
            GameManager.monthDone = true;
            if (lblPrompt != null){
                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        }
        else{
            runQuestions();
        }
    }

    @FXML
    private void handle4ButtonAction(ActionEvent event) throws Exception{
        int resps = GameManager.monthly.get(qNum).answers.length;
        switch (resps){
            case 2: GameManager.monthly.get(qNum).setResponse(1,radCard.selectedProperty().get());break;
            case 4: GameManager.monthly.get(qNum).setResponse(2,radCard.selectedProperty().get());break;
            case 5: GameManager.monthly.get(qNum).setResponse(3,radCard.selectedProperty().get());break;
        }
        if (qNum == (GameManager.monthly.size()-1)){
            GameManager.monthDone = true;
            if (lblPrompt != null){
                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        }
        else{
            runQuestions();
        }
    }

    @FXML
    private void handle5ButtonAction(ActionEvent event) throws Exception{
        int resps = GameManager.monthly.get(qNum).answers.length;
        switch (resps){
            case 3: GameManager.monthly.get(qNum).setResponse(2,radCard.selectedProperty().get());break;
            case 4: GameManager.monthly.get(qNum).setResponse(3,radCard.selectedProperty().get());break;
            case 5: GameManager.monthly.get(qNum).setResponse(4,radCard.selectedProperty().get());break;
        }
        if (qNum == (GameManager.monthly.size()-1)){
            GameManager.monthDone = true;
            if (lblPrompt != null){
                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        }
        else{
            runQuestions();
        }
    }

    
    @FXML
    private void handleDescButtonAction(ActionEvent event) throws Exception{
        if (lblPrompt == null){
            if (!GameManager.monthDone){
                Stage stage = new Stage();
                stage.initOwner(lblScore.getScene().getWindow());
                stage.initModality(Modality.WINDOW_MODAL);
                Parent root = FXMLLoader.load(getClass().getResource("Desc.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Wallet Wise");
                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent ev) -> {
                    try {
                        update();
                    } catch (Exception ex) {
                        Logger.getLogger(UIManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                stage.show();
            }
            else{
                popup("All monthly decisions complete. Hit the next month button to continue.",(Stage)lblScore.getScene().getWindow());
            }            
        }
    }
    
    private void update() throws Exception{
        GameManager.score =(int) ((int) Math.round(GameManager.savings*GameManager.wellB)/(Math.sqrt((double)Math.abs(GameManager.savings*GameManager.wellB))));
        lblSavings.setText("Balance: $"+Integer.toString(GameManager.savings));
        lblHappiness.setText("Wellness Index: "+Integer.toString(GameManager.wellB));
        lblScore.setText("Game Score: "+Integer.toString(GameManager.score));
        lblAvailable.textProperty().set("Available Credit: $"+String.format("%.2f",GameManager.available));
        lblDue.textProperty().set("Credit Card Bill: $"+String.format("%.2f",GameManager.bills));
        lblMinPay.textProperty().set("Min. Payment: $"+String.format("%.2f",GameManager.bills/10));
        sldPayCred.minProperty().set(GameManager.bills/10);
        sldPayCred.valueProperty().set(GameManager.bills/10);
        if (GameManager.savings > GameManager.bills){
            sldPayCred.maxProperty().set(GameManager.bills);
        }
        else{
            sldPayCred.maxProperty().set(GameManager.savings);
        }
        if (GameManager.savings < (GameManager.bills/10)){
            Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
            lblScore.getScene().setRoot(root);
        }
    }
    
    private void runQuestions() throws Exception{
        int reps = GameManager.monthly.size();
        for (int i = 0; i < reps; i++){
            if (!GameManager.monthly.get(i).answered){
                currentQ = GameManager.monthly.get(i);
                switch(currentQ.answers.length){
                    case 2: btn1.setDisable(true); btn2.setDisable(false); btn3.setDisable(true); btn4.setDisable(false); btn5.setDisable(true);
                        btn1.setVisible(false); btn2.setVisible(true); btn3.setVisible(false); btn4.setVisible(true); btn5.setVisible(false);
                        lblPrompt.setText(currentQ.prompt);
                        btn2.setText(currentQ.answers[0]);
                        btn4.setText(currentQ.answers[1]);
                        if (currentQ.scalable){
                            if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                                ((Stage) lblPrompt.getScene().getWindow()).getOwner().getScene().setRoot(root);
                                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        else{
                            if (currentQ.cost[0]>GameManager.savings && currentQ.cost[0]>GameManager.available){
                            
                            }
                            else if (currentQ.cost[0]>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        if (currentQ.scalable){
                            if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                                btn4.disableProperty().set(true);
                            }
                        }
                        else{
                            if (currentQ.cost[1]>GameManager.savings && currentQ.cost[1]>GameManager.available){
                                btn4.disableProperty().set(true);
                            }
                        }
                        break;
                    case 3: btn1.setDisable(false); btn2.setDisable(true); btn3.setDisable(false); btn4.setDisable(true); btn5.setDisable(false);
                        btn1.setVisible(true); btn2.setVisible(false); btn3.setVisible(true); btn4.setVisible(false); btn5.setVisible(true);
                        lblPrompt.setText(currentQ.prompt);
                        btn1.setText(currentQ.answers[0]);
                        btn3.setText(currentQ.answers[1]);
                        btn5.setText(currentQ.answers[2]);
                        if (currentQ.scalable){
                            if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                                ((Stage) lblPrompt.getScene().getWindow()).getOwner().getScene().setRoot(root);
                                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        else{
                            if (currentQ.cost[0]>GameManager.savings && currentQ.cost[0]>GameManager.available){
                            
                            }
                            else if (currentQ.cost[0]>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        if (currentQ.scalable){
                            if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                                btn3.disableProperty().set(true);
                            }
                            if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[2]*(GameManager.dep+1)>GameManager.available){
                                btn5.disableProperty().set(true);
                            }
                        }
                        else{
                            if (currentQ.cost[1]>GameManager.savings && currentQ.cost[1]>GameManager.available){
                                btn3.disableProperty().set(true);
                            }
                            if (currentQ.cost[2]>GameManager.savings && currentQ.cost[2]>GameManager.available){
                                btn5.disableProperty().set(true);
                            }
                        }
                        break;
                    case 4: btn1.setDisable(false); btn2.setDisable(false); btn3.setDisable(true); btn4.setDisable(false); btn5.setDisable(false);
                        btn1.setVisible(true); btn2.setVisible(true); btn3.setVisible(false); btn4.setVisible(true); btn5.setVisible(true);
                        lblPrompt.setText(currentQ.prompt);
                        btn1.setText(currentQ.answers[0]);
                        btn2.setText(currentQ.answers[1]);
                        btn4.setText(currentQ.answers[2]);
                        btn5.setText(currentQ.answers[3]);
                        if (currentQ.scalable){
                            if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                                ((Stage) lblPrompt.getScene().getWindow()).getOwner().getScene().setRoot(root);
                                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        else{
                            if (currentQ.cost[0]>GameManager.savings && currentQ.cost[0]>GameManager.available){
                                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                                ((Stage) lblPrompt.getScene().getWindow()).getOwner().getScene().setRoot(root);
                                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
                            }
                            else if (currentQ.cost[0]>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        if (currentQ.scalable){
                            if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                                btn2.disableProperty().set(true);
                            }
                            if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[2]*(GameManager.dep+1)>GameManager.available){
                                btn4.disableProperty().set(true);
                            }
                            if (currentQ.cost[3]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[3]*(GameManager.dep+1)>GameManager.available){
                                btn5.disableProperty().set(true);
                            }
                        }
                        else{
                            if (currentQ.cost[1]>GameManager.savings && currentQ.cost[1]>GameManager.available){
                                btn2.disableProperty().set(true);
                            }
                            if (currentQ.cost[2]>GameManager.savings && currentQ.cost[2]>GameManager.available){
                                btn4.disableProperty().set(true);
                            }
                            if (currentQ.cost[3]>GameManager.savings && currentQ.cost[3]>GameManager.available){
                                btn5.disableProperty().set(true);
                            }
                        }
                        break;
                    case 5: btn1.setDisable(false); btn2.setDisable(false); btn3.setDisable(false); btn4.setDisable(false); btn5.setDisable(false);
                        btn1.setVisible(true); btn2.setVisible(true); btn3.setVisible(true); btn4.setVisible(true); btn5.setVisible(true);
                        lblPrompt.setText(currentQ.prompt);
                        btn1.setText(currentQ.answers[0]);
                        btn2.setText(currentQ.answers[1]);
                        btn3.setText(currentQ.answers[2]);
                        btn4.setText(currentQ.answers[3]);
                        btn5.setText(currentQ.answers[4]);
                        if (currentQ.scalable){
                            if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                                ((Stage) lblPrompt.getScene().getWindow()).getOwner().getScene().setRoot(root);
                                Stage stage = (Stage) lblPrompt.getScene().getWindow();
                                stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]*(GameManager.dep+1)>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        else{
                            if (currentQ.cost[0]>GameManager.savings && currentQ.cost[0]>GameManager.available){
                            
                            }
                            else if (currentQ.cost[0]>GameManager.savings){
                                radCard.selectedProperty().set(true);
                                radCard.disableProperty().set(true);
                            }
                            else if (currentQ.cost[0]>GameManager.available){
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(true);
                            }
                            else{
                                radCard.selectedProperty().set(false);
                                radCard.disableProperty().set(false);
                            }
                        }
                        if (currentQ.scalable){
                            if (currentQ.cost[1]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[1]*(GameManager.dep+1)>GameManager.available){
                                btn2.disableProperty().set(true);
                            }
                            if (currentQ.cost[2]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[2]*(GameManager.dep+1)>GameManager.available){
                                btn3.disableProperty().set(true);
                            }
                            if (currentQ.cost[3]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[3]*(GameManager.dep+1)>GameManager.available){
                                btn4.disableProperty().set(true);
                            }
                            if (currentQ.cost[4]*(GameManager.dep+1)>GameManager.savings && currentQ.cost[4]*(GameManager.dep+1)>GameManager.available){
                                btn5.disableProperty().set(true);
                            }
                        }
                        else{
                            if (currentQ.cost[1]>GameManager.savings && currentQ.cost[1]>GameManager.available){
                                btn2.disableProperty().set(true);
                            }
                            if (currentQ.cost[2]>GameManager.savings && currentQ.cost[2]>GameManager.available){
                                btn3.disableProperty().set(true);
                            }
                            if (currentQ.cost[3]>GameManager.savings && currentQ.cost[3]>GameManager.available){
                                btn4.disableProperty().set(true);
                            }
                            if (currentQ.cost[4]>GameManager.savings && currentQ.cost[4]>GameManager.available){
                                btn5.disableProperty().set(true);
                            }
                        }
                        break;
                }
                qNum = i;
                i = reps;
            }
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
    
    private void popup(String msg, Stage owner) throws IOException{
        GameManager.message = msg;
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("Box.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Wallet Wise");
        stage.setScene(scene);
        stage.show();
    }
    
    private void box(){
        lblBox.setText(GameManager.message);
    }
    
    private void populate(){
        ObservableList temp = FXCollections.observableArrayList();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(0)){
            temp.add(str.question+": "+str.answer);
        }
        lstJan.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(1)){
            temp.add(str.question+": "+str.answer);
        }
        lstFeb.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(2)){
            temp.add(str.question+": "+str.answer);
        }
        lstMar.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(3)){
            temp.add(str.question+": "+str.answer);
        }
        lstApr.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(4)){
            temp.add(str.question+": "+str.answer);
        }
        lstMay.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(5)){
            temp.add(str.question+": "+str.answer);
        }
        lstJun.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(6)){
            temp.add(str.question+": "+str.answer);
        }
        lstJul.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(7)){
            temp.add(str.question+": "+str.answer);
        }
        lstAug.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(8)){
            temp.add(str.question+": "+str.answer);
        }
        lstSep.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(9)){
            temp.add(str.question+": "+str.answer);
        }
        lstOct.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(10)){
            temp.add(str.question+": "+str.answer);
        }
        lstNov.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt: Answer");
        for (Storage str: GameManager.saved.get(11)){
            temp.add(str.question+": "+str.answer);
        }
        lstDec.getItems().setAll(temp);
        temp.clear();
    }
    
    private void endGame(){
        lblFSavings.setText("Final Savings: $" + Integer.toString(GameManager.savings));
        lblFScore.setText("Final Score: " + Integer.toString(GameManager.score));
        lblFWellBeing.setText("Final Well Being: " + Integer.toString(GameManager.wellB));
        lblFSal.setText("Salary: $" + Integer.toString(GameManager.gross));
        lblFDeps.setText("Number of Dependents: " + Integer.toString(GameManager.dep));
        if(GameManager.month != 12){
            String monthReached = "";
            switch (GameManager.month){
                case 1: monthReached = "January";break;
                case 2: monthReached = "February";break;
                case 3: monthReached = "March";break;
                case 4: monthReached = "April";break;
                case 5: monthReached = "May";break;
                case 6: monthReached = "June";break;
                case 7: monthReached = "July";break;
                case 8: monthReached = "August";break;
                case 9: monthReached = "September";break;
                case 10: monthReached = "October";break;
                case 11: monthReached = "November";break;
                case 12: monthReached = "December";break;
            }
            lblEnd.setText("You ran out of money! Try again.");
            lblFScore.setText("Last Month Reached: " + monthReached);
        }
    }
    
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb){
        if (lblGross != null){
            try {
                firstLoad();
            } catch (InterruptedException ex) {
                Logger.getLogger(UIManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (lblGoldLimit != null){
            initCards();
        }
        
        if (radHouse != null){
            initCC();
        }
        
        if (lblPrompt != null){
            try {
                runQuestions();
            } catch (Exception ex) {
                Logger.getLogger(UIManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (lblFSavings != null){
            try{
                endGame();
            }
            catch(Exception exc){
                System.out.println(exc);
            }
        }
        if (lblBox != null){
            box();
        }
        
        if (lstJan != null){
            populate();
        }
    }
    
}
