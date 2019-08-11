/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSpinner;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.animations.FadeAnimation;
import tray.models.CustomStage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class HelloDialogController implements Initializable , Runnable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private JFXProgressBar prosessBar;
      
    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    private VBox AsideComponent;
    
    @FXML
    private ImageView imgView;
    
    @FXML
    private Pane pane;
    @FXML
    private JFXButton closeButton;
    @FXML
    void hello(ActionEvent event) {
       
      
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Thread thread = new Thread(this);
         thread.start();
    }   
    
   
    private void FadeEffect(){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.onFinishedProperty();
        fadeTransition.play();
        fadeTransition.setOnFinished(e -> {
             AnchorPane anchorPane;
            try {
                anchorPane = (AnchorPane)FXMLLoader.load(getClass().getResource("/Views/LoginForm.fxml"));
                AnchorPane.setPrefSize(1080, 720);
                System.out.println(AnchorPane.getPrefWidth());
                AnchorPane.getChildren().setAll(anchorPane);
                
            } catch (IOException ex) {
                Logger.getLogger(HelloDialogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void LoadLoginPage() throws IOException{
      AnchorPane anchorPane = (AnchorPane)FXMLLoader.load(getClass().getResource("/Views/LoginForm.fxml"));
      AnchorPane.getChildren().setAll(anchorPane);
             
    }

    @Override
    public void run() {
        double i = 0;
        while(i < 1)
        {

            try {
               prosessBar.setProgress(i);
                Thread.sleep(50);
                i+= 0.1;
                System.out.println(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloDialogController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         FadeEffect();
        
        
    }
    
}
