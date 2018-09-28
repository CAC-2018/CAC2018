/* This is the test class that will be used to test the application.
 * Avoid writing the majority of code in main and instead use calls
 * 	to other classes and methods.
 * First try out new changes here and later update them to the Main
 * 	class in the source folder if they are satisfactory.
 */

package TestCAC;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nikhi
 */
public class TestCAC extends Application {
    
    UIManager UiMan = new UIManager();
    
    @Override
    public void start(Stage stage) throws Exception {
        UiMan.startUI(stage);
    }
    
    public void switchToGame(){
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}