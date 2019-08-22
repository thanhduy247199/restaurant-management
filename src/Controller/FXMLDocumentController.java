/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.userDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable, Runnable {
    
    Stage stageWindow;
    Color colorVar = new Color(0, 0, 0, 0);
     int i = 1;
    @FXML
    private HBox slideImg;
    
    @FXML
    private ImageView slideImgView;
    
    @FXML
    private FontAwesomeIcon node1;

    @FXML
    private FontAwesomeIcon node2;

    @FXML
    private FontAwesomeIcon node3;
    
    @FXML
    private Button eyeBtn;
    
   @FXML
    private JFXButton signInBtn;

    @FXML
    private FontAwesomeIcon eyeFontaws;
    
    @FXML
    private JFXTextField emailTxT;

    @FXML
    private JFXPasswordField passwordTxT;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
       
    }
    
    @FXML
    private void ClickNode1(ActionEvent event) {
                makeFadeOut(slideImgView);
                Image img = new Image("/img/slide1.png");
                slideImgView.setImage(img);
        
        
                node1.setFill(colorVar.rgb(63, 92, 196));
                node2.setFill(colorVar.rgb(183, 170, 170));
                node3.setFill(colorVar.rgb(183, 170, 170));
                
                
                i=1;
                
    }

    @FXML
    private void ClickNode2(ActionEvent event) {
                makeFadeOut(slideImgView);
                Image img = new Image("/img/slide2.png");
                slideImgView.setImage(img);
                
                node1.setFill(colorVar.rgb(183, 170, 170));
                node2.setFill(colorVar.rgb(63, 92, 196));
                node3.setFill(colorVar.rgb(183, 170, 170));
                
                
                i=2;
               
             
        
    }

    @FXML
    private void ClickNode3(ActionEvent event) {
                makeFadeOut(slideImgView);
                Image img = new Image("/img/slide3.png");
                slideImgView.setImage(img);
                
                node1.setFill(colorVar.rgb(183, 170, 170));
                node2.setFill(colorVar.rgb(183, 170, 170));
                node3.setFill(colorVar.rgb(63, 92, 196));
                
             
                i=3;
                 
            
            
       
    }
    
    @FXML
    private void hidePassword(ActionEvent event) {
        
        eyeFontaws.setGlyphName("EYESLASH");
    }
    
    @FXML
    private void CloseApp(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private void signIn(ActionEvent event) throws IOException {
        String regex = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
        if(emailTxT.getText().isEmpty() || passwordTxT.getText().isEmpty())
        {
            NotificationType notificationType = NotificationType.CUSTOM;
            TrayNotification trayNotification = new TrayNotification("Cảnh báo", "Email và mật khẩu không được để trống", new Image("/img/warningBee.png"), colorVar.RED );
            trayNotification.showAndDismiss(Duration.seconds(3));
            trayNotification.setAnimationType(AnimationType.POPUP);
            trayNotification.showAndWait();
        }
        else if( passwordTxT.getText().length() <= 6)
        {
            NotificationType notificationType = NotificationType.CUSTOM;
            TrayNotification trayNotification = new TrayNotification("Cảnh báo", "Mật khẩu tối thiểu 6 ký tự", new Image("/img/warningBee.png"), colorVar.RED );
            trayNotification.showAndDismiss(Duration.seconds(3));
            trayNotification.setAnimationType(AnimationType.POPUP);
            trayNotification.showAndWait();
        }
        else if(!emailTxT.getText().matches(regex))
        {
            NotificationType notificationType = NotificationType.CUSTOM;
            TrayNotification trayNotification = new TrayNotification("Cảnh báo", "Email sai định dạng", new Image("/img/warningBee.png"), colorVar.RED );
            trayNotification.showAndDismiss(Duration.seconds(3));
            trayNotification.setAnimationType(AnimationType.POPUP);
            trayNotification.showAndWait();
        }
            
        else{
            userDAO uDAO = new userDAO();
            if(uDAO.checkLogin(emailTxT.getText(), passwordTxT.getText()) != null)
            {
                 Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/DashboardUI.fxml"));
                Parent loginParent = loader.load();
                Scene scene = new Scene(loginParent);
                stage.centerOnScreen();
                stageWindow = new Stage();
                stageWindow.setScene(scene);
                Image icon = new Image("/img/Logo.png");
                stageWindow.getIcons().add(icon);
                stageWindow.setTitle("Phần mềm quản lý nhà hàng");
                stageWindow.show();
                stage.close();
            }
            else
            {
                NotificationType notificationType = NotificationType.CUSTOM;
                TrayNotification trayNotification = new TrayNotification("Cảnh báo", "Sai tài khoản hoặc mật khẩu", new Image("/img/warningBee.png"), colorVar.RED );
                trayNotification.showAndDismiss(Duration.seconds(3));
                trayNotification.setAnimationType(AnimationType.POPUP);
                trayNotification.showAndWait();
            }
                
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
           
          
        Thread thread = new Thread(this);
        thread.start();
    }    
    
    
    private void makeFadeOut(ImageView imgView)
    {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(2.5));
        fadeTransition.setNode(imgView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    
    }
    
  

    @Override
    public void run() {
        
        while (true) {  
           
            try {
                i++;
                if(i > 3)
                {
                    i = 1;
                }
                if( i == 1)
                {
                     makeFadeOut(slideImgView);
                    Image img = new Image("/img/slide1.png");
                    slideImgView.setImage(img);


                     node1.setFill(colorVar.rgb(63, 92, 196));
                node2.setFill(colorVar.rgb(183, 170, 170));
                node3.setFill(colorVar.rgb(183, 170, 170));

                 
                
                }
                else if(i == 2)
                {
                    makeFadeOut(slideImgView);
                    Image img = new Image("/img/slide2.png");
                    slideImgView.setImage(img);

                   node1.setFill(colorVar.rgb(183, 170, 170));
                node2.setFill(colorVar.rgb(63, 92, 196));
                node3.setFill(colorVar.rgb(183, 170, 170));

                   
                }
                else if(i == 3)
                {
                    makeFadeOut(slideImgView);
                Image img = new Image("/img/slide3.png");
                slideImgView.setImage(img);
                
                 node1.setFill(colorVar.rgb(183, 170, 170));
                node2.setFill(colorVar.rgb(183, 170, 170));
                node3.setFill(colorVar.rgb(63, 92, 196));
               
                }
              
                
                Thread.sleep(5000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
  
    
}
