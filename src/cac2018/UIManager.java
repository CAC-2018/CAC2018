/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cac2018;

import java.io.IOException;
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
import javafx.scene.control.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Button btnHelp;
    
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
    private Label lblSal;
    
    @FXML
    private Label lblMort;
    
    @FXML
    private Label lblEssentials;
    
    @FXML
    private Label lblMeds;
    
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
    private Label lblMortRent;
    
    @FXML
    private Label lblHIns;
    
    @FXML
    private Label lblTax;
    
    @FXML
    private Label lblSavings;
    
    @FXML
    private Label lblScore;
    
    @FXML
    private Label lblHappiness;
    
    @FXML
    private Label lblPrompt;
    
    @FXML
    private Label lblBox;
    
    @FXML
    private Label lblHouseCost;
    
    @FXML
    private Label lblFSavings;
    
    @FXML
    private Label lblFScore;
    
    @FXML
    private Label lblFWellBeing;
    
    @FXML
    private Label lblFSal;
    
    @FXML
    private Label lblFHousing;
    
    @FXML
    private Label lblFDeps;
    
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
    
    private Question currentQ;
    
    private int qNum;
    
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
    private void handlePlayGButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CharacterCreation.fxml"));
        btnPlayGame.getScene().setRoot(root);
    }    
    
    @FXML
    private void handleBackCCButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
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
        stage.setTitle("Basic Finance Sim Help");
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
            lblMort.setText("Mortgage: $"+Integer.toString(GameManager.mort) +"/month");
            lblHouseCost.setText("House Value:");
            lblIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns)+"/month");
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
            lblHouseCost.setText("Monthly Rent:");
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
        lblMort.setText("Mortgage: $"+Integer.toString(GameManager.mort)+"/month");
        lblIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns)+"/month");
        lblHouseCost.setText("House Value:");
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
        lblHouseCost.setText("Monthly Rent:");
        tltHousing.setText("Monthly Rent ($)");
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
        }
        catch (Exception ex){
            System.out.println(ex.toString()+" @handleHouseChoiceAction,UIManager");
        }
    }
    
    private void firstLoad() throws InterruptedException{
        lblGross.setText("Gross Monthly Salary: $"+Integer.toString(GameManager.gross));
        lblMCosts.setText("Monthly Costs: $"+Integer.toString(GameManager.fixed));
        lblNet.setText("Net Monthly Income: $"+Integer.toString(GameManager.net));
        lblTax.setText("Taxes: $"+Integer.toString(GameManager.tax));
        lblSavings.setText("Balance: $"+Integer.toString(GameManager.savings));
        lblEssentials.setText("Food, Colothing, & Essentials: $"+Integer.toString(GameManager.ess));
        lblMeds.setText("Medical: $"+Integer.toString(GameManager.meds));
        if (GameManager.haveHouse){
            lblMortRent.setText("Mortgage: $"+Integer.toString(GameManager.mortRent));
            lblHIns.setText("Home Insurance: $"+Integer.toString(GameManager.homeIns));
        }
        else{
            lblMortRent.setText("Rent: $"+Integer.toString(GameManager.mortRent));
            lblHIns.setText("Home Insurance: N/A");
        }
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
            if (GameManager.month == 12){
                Parent root = FXMLLoader.load(getClass().getResource("Last.fxml"));
                lblScore.getScene().setRoot(root);
            }
            GameManager.savings+= GameManager.net;
            lblSavings.setText("Balance: $"+Integer.toString(GameManager.savings));
            GameManager.score = (int) Math.round(Math.sqrt((double)(GameManager.savings*GameManager.wellB)));
            lblScore.setText("Game Score: "+Integer.toString(GameManager.score));
            lblHappiness.setText("Wellness Index: "+Integer.toString(GameManager.wellB));
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
    private void handle1ButtonAction(ActionEvent event) throws Exception{
        int resps = GameManager.monthly.get(qNum).answers.length;
        if (GameManager.monthly.get(qNum).cost[0]>GameManager.savings){
            popup("You did not have enough savings for the least expensive choice. Score was reduced.",(Stage)((Stage)btn1.getScene().getWindow()).getOwner());
            if(GameManager.wellB>10){
                GameManager.wellB-=10;
            }
            else{
                GameManager.wellB = 0;
            }
        }
        else{
            switch (resps){
                case 3: if(GameManager.monthly.get(qNum).cost[0]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(0);}break;
                case 4: if(GameManager.monthly.get(qNum).cost[0]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(0);}break;
                case 5: if(GameManager.monthly.get(qNum).cost[0]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(0);}break;
            }
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
        if (GameManager.monthly.get(qNum).cost[0]>GameManager.savings){
            popup("You did not have enough savings for the least expensive choice. Score was reduced.",(Stage)((Stage)btn1.getScene().getWindow()).getOwner());
            if(GameManager.wellB>10){
                GameManager.wellB-=10;
            }
            else{
                GameManager.wellB = 0;
            }
        }
        else{
           switch (resps){
                case 2: if(GameManager.monthly.get(qNum).cost[0]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(0);}break;
                case 4: if(GameManager.monthly.get(qNum).cost[1]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(1);}break;
                case 5: if(GameManager.monthly.get(qNum).cost[1]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(1);}break;
            } 
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
        if (GameManager.monthly.get(qNum).cost[0]>GameManager.savings){
            popup("You did not have enough savings for the least expensive choice. Score was reduced.",(Stage)((Stage)btn1.getScene().getWindow()).getOwner());
            if(GameManager.wellB>10){
                GameManager.wellB-=10;
            }
            else{
                GameManager.wellB = 0;
            }
        }
        else{
           switch (resps){
                case 3: if(GameManager.monthly.get(qNum).cost[1]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(1);}break;
                case 5: if(GameManager.monthly.get(qNum).cost[2]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(2);}break;
            } 
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
        if (GameManager.monthly.get(qNum).cost[0]>GameManager.savings){
            popup("You did not have enough savings for the least expensive choice. Score was reduced.",(Stage)((Stage)btn1.getScene().getWindow()).getOwner());
            if(GameManager.wellB>10){
                GameManager.wellB-=10;
            }
            else{
                GameManager.wellB = 0;
            }
        }
        else{
            switch (resps){
                case 2: if(GameManager.monthly.get(qNum).cost[1]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(1);}break;
                case 4: if(GameManager.monthly.get(qNum).cost[2]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(2);}break;
                case 5: if(GameManager.monthly.get(qNum).cost[3]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(3);}break;
            }
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
        if (GameManager.monthly.get(qNum).cost[0]>GameManager.savings){
            popup("You did not have enough savings for the least expensive choice. Score was reduced.",(Stage)((Stage)btn1.getScene().getWindow()).getOwner());
            if(GameManager.wellB>10){
                GameManager.wellB-=10;
            }
            else{
                GameManager.wellB = 0;
            }
        }
        else{
            switch (resps){
                case 3: if(GameManager.monthly.get(qNum).cost[2]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(2);}break;
                case 4: if(GameManager.monthly.get(qNum).cost[3]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(3);}break;
                case 5: if(GameManager.monthly.get(qNum).cost[4]<=GameManager.savings){GameManager.monthly.get(qNum).setResponse(4);}break;
            }
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
                stage.setTitle("Basic Finance Sim");
                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent ev) -> {
                    update();
                });
                stage.show();
            }
            else{
                popup("All monthly descisions complete. Hit the next month button to continue.",(Stage)lblScore.getScene().getWindow());
            }            
        }
    }
    
    private void update(){
        GameManager.score = (int) Math.round(Math.sqrt((double)(GameManager.savings*GameManager.wellB)));
        lblSavings.setText("Balance: $"+Integer.toString(GameManager.savings));
        lblHappiness.setText("Wellness Index: "+Integer.toString(GameManager.wellB));
        lblScore.setText("Game Score: "+Integer.toString(GameManager.score));
    }
    
    private void runQuestions(){
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
                        break;
                    case 3: btn1.setDisable(false); btn2.setDisable(true); btn3.setDisable(false); btn4.setDisable(true); btn5.setDisable(false);
                        btn1.setVisible(true); btn2.setVisible(false); btn3.setVisible(true); btn4.setVisible(false); btn5.setVisible(true);
                        lblPrompt.setText(currentQ.prompt);
                        btn1.setText(currentQ.answers[0]);
                        btn3.setText(currentQ.answers[1]);
                        btn5.setText(currentQ.answers[2]);
                        break;
                    case 4: btn1.setDisable(false); btn2.setDisable(false); btn3.setDisable(true); btn4.setDisable(false); btn5.setDisable(false);
                        btn1.setVisible(true); btn2.setVisible(true); btn3.setVisible(false); btn4.setVisible(true); btn5.setVisible(true);
                        lblPrompt.setText(currentQ.prompt);
                        btn1.setText(currentQ.answers[0]);
                        btn2.setText(currentQ.answers[1]);
                        btn4.setText(currentQ.answers[2]);
                        btn5.setText(currentQ.answers[3]);
                        break;
                    case 5: btn1.setDisable(false); btn2.setDisable(false); btn3.setDisable(false); btn4.setDisable(false); btn5.setDisable(false);
                        btn1.setVisible(true); btn2.setVisible(true); btn3.setVisible(true); btn4.setVisible(true); btn5.setVisible(true);
                        lblPrompt.setText(currentQ.prompt);
                        btn1.setText(currentQ.answers[0]);
                        btn2.setText(currentQ.answers[1]);
                        btn3.setText(currentQ.answers[2]);
                        btn4.setText(currentQ.answers[3]);
                        btn5.setText(currentQ.answers[4]);
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
        stage.setTitle("Basic Finance Sim");
        stage.setScene(scene);
        stage.show();
    }
    
    private void box(){
        lblBox.setText(GameManager.message);
    }
    
    private void populate(){
        ObservableList temp = FXCollections.observableArrayList();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(0)){
            temp.add(str.question+","+str.answer);
        }
        lstJan.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(1)){
            temp.add(str.question+","+str.answer);
        }
        lstFeb.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(2)){
            temp.add(str.question+","+str.answer);
        }
        lstMar.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(3)){
            temp.add(str.question+","+str.answer);
        }
        lstApr.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(4)){
            temp.add(str.question+","+str.answer);
        }
        lstMay.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(5)){
            temp.add(str.question+","+str.answer);
        }
        lstJun.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(6)){
            temp.add(str.question+","+str.answer);
        }
        lstJul.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(7)){
            temp.add(str.question+","+str.answer);
        }
        lstAug.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(8)){
            temp.add(str.question+","+str.answer);
        }
        lstSep.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(9)){
            temp.add(str.question+","+str.answer);
        }
        lstOct.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(10)){
            temp.add(str.question+","+str.answer);
        }
        lstNov.getItems().setAll(temp);
        temp.clear();
        temp.add("Prompt,Answer");
        for (Storage str: GameManager.saved.get(11)){
            temp.add(str.question+","+str.answer);
        }
        lstDec.getItems().setAll(temp);
        temp.clear();
    }
    
    private void endGame(){
        lblFSavings.setText("Final Savings: $" + Integer.toString(GameManager.savings));
        lblFScore.setText("Final Score: " + Integer.toString(GameManager.score));
        lblFWellBeing.setText("Final Well Being: " + Integer.toString(GameManager.wellB));
        lblFSal.setText("Salary: $" + Integer.toString(GameManager.savings));
        lblFDeps.setText("Number of Dependents: " + Integer.toString(GameManager.dep));
        if (GameManager.haveHouse){
            lblFHousing.setText("Mortgage: $" + Integer.toString(GameManager.mortRent));
        }
        else{
            lblFHousing.setText("Rent: $" + Integer.toString(GameManager.mortRent));
        }
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
        if (lblPrompt != null){
            runQuestions();
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
