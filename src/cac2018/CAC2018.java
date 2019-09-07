/* This is the main class that will be used to run the application.
 * Avoid writing the majority of code in main and instead use calls
 * 	to other classes and methods.
 */

package cac2018;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nikhi
 */
public class CAC2018 extends Application {
    
    UIManager UiMan = new UIManager();
    
    @Override
    public void start(Stage stage) throws Exception {
        UiMan.startUI(stage);
        GameManager.initJobs();
        GameManager.initCards();
        GameManager.initQuestions();
        GameManager.initSaved();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
