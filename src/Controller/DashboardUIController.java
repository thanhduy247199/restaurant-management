/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.sun.javafx.scene.layout.region.Margins;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class DashboardUIController implements Initializable {
    
    double x,y;
    @FXML
    private HBox aside;
    @FXML
    private AnchorPane mainLayout;
    @FXML
    private Pane pn_1, pn_2, pn_3, pn_4, pn_5;
    @FXML
    private GridPane gridPane;
    @FXML
    private LineChart<String, Number> lineChartTxT1;
    @FXML
    private StackPane stackPane;
    @FXML
    private Text billTxT1;

    @FXML
    private Text foodTxT1;

    @FXML
    private Text moneyTxT1;
    @FXML
    private Circle avatar;
    
    @FXML
    private AnchorPane header;
     @FXML
    private AnchorPane article;
     
     @FXML
    private VBox FoodPane,TablePane,BDKPane,BillPane;

    @FXML
    private VBox MenuPane;
 
    
    
    @FXML
    private AnchorPane anchorPaneSide;


    @FXML
    void billBtnAction(ActionEvent event) throws IOException {

                BillPane.toFront();
                 System.out.println(6);
    }

    @FXML
    void dashboardBtnAction(ActionEvent event) throws IOException {
       
        BDKPane.toFront();
           
               
                 System.out.println(5);
    }

  

    @FXML
    void foodBtnAction(ActionEvent event) throws IOException {

               FoodPane.toFront();
                 System.out.println(3);
    }

    @FXML
    void menuBtnAction(ActionEvent event) throws IOException {
  
               MenuPane.toFront();
                 System.out.println(2);
    }

    @FXML
    void tableBtnAction(ActionEvent event) throws IOException {
     
              TablePane.toFront();
                System.out.println(1);
                
    }
     @FXML
    void dragged(MouseEvent event) {
         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setX(event.getScreenX() - x);
         stage.setY(event.getScreenY() - y);
                 
    }
    
      @FXML
    void released(MouseEvent event) {
         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
      
      
    }
    
    @FXML
    void pressed(MouseEvent event) {
         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
      
         
       
        x = event.getSceneX();
        y = event.getSceneY();
       
    }
    
     @FXML
    void loadSettingAction(ActionEvent event) {
         JFXDialogLayout content = new JFXDialogLayout();
           content.setHeading(new Text("Chọn màu background"));
         content.setBody(new Text("Bạn hãy chọn 1 trong 4 màu của hệ thống ."));
        
        
         JFXButton choiseColorBlue = new JFXButton("Blue");
         JFXButton choiseColorGreen = new JFXButton("Green");
         JFXButton choiseColorOrange = new JFXButton("Pink");
         JFXButton choiseColorPink = new JFXButton("Orange");
         JFXButton close = new JFXButton("Lưu");
         close.setCursor(Cursor.HAND);
         close.setFont(Font.font(20));
         
         choiseColorBlue.setPrefWidth(100);
         choiseColorGreen.setPrefWidth(100);
         choiseColorOrange.setPrefWidth(100);
         choiseColorPink.setPrefWidth(100);
         close.setPadding(new Insets(10, 50 , 10, 50));
         
         choiseColorBlue.setLayoutX(0);
         choiseColorGreen.setLayoutX(110);
         choiseColorOrange.setLayoutX(220);
         choiseColorPink.setLayoutX(330);
       
         
         choiseColorBlue.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #2998ff,  #5643fa);  -fx-text-fill:  #ffffff;");
         choiseColorGreen.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #7ed56f,  #28b485); -fx-text-fill:  #ffffff;");
         choiseColorOrange.styleProperty().set(" -fx-background-color: linear-gradient(to right bottom,  #ff3366,  #ba265d); -fx-text-fill:  #ffffff;");
         choiseColorPink.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #ffca28,  #f57c00);  -fx-text-fill:  #ffffff;");
         close.styleProperty().set(" -fx-text-fill:  #2998ff;");
          choiseColorBlue.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 header.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #2998ff,  #5643fa)");
                    article.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #2998ff,  #5643fa)");
                    
                 
             }
         });
          
           choiseColorGreen.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 header.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #7ed56f,  #28b485);");
                 article.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #7ed56f,  #28b485);");
             }
         });
           
            choiseColorOrange.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 header.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #ff3366,  #ba265d)");
                 article.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #ff3366,  #ba265d)");
             }
         });
            
             choiseColorPink.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 header.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #ffca28,  #f57c00);");
                 article.styleProperty().set("-fx-background-color: linear-gradient(to right bottom,  #ffca28,  #f57c00);");
             }
         });
             
        
  
             
         
        
             
                
         
         
          AnchorPane anchorPaneS = new AnchorPane(choiseColorBlue,choiseColorGreen,choiseColorOrange,choiseColorPink);
         content.setBody(anchorPaneS);
         
          JFXDialog dialog = new JFXDialog(stackPane,content,JFXDialog.DialogTransition.CENTER);
          content.setActions(close);
          
                   close.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                dialog.close();
             }
         });
         
         dialog.show();
                 
         
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//          changeScene("/Component/BDKComponent.fxml");
            XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String,Number>("Tháng 1" , 300));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 2" , 100));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 3" , 200));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 4" , 320));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 5" , 310));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 6" , 410));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 8" , 250));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 9" , 120));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 10" , 330));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 11" , 240));
        series.getData().add(new XYChart.Data<String,Number>("Tháng 12" , 360));
        lineChartTxT1.getData().add(series);  
        
      BDKPane.toFront();
      
       
        
          
    }
    
    private void changeScene(String URL){
         AnchorPane anchorPane;
        
     
        try {
            anchorPane = (AnchorPane)FXMLLoader.load(getClass().getResource(URL));
            System.out.println(anchorPane.getPrefWidth());
            
                anchorPaneSide.getChildren().setAll(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(DashboardUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
                
    }
}
