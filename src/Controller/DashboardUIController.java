/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.BillDAO;
import DAO.FoodDAO;
import DAO.MenuDAO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.sun.javafx.scene.layout.region.Margins;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import model.BILL;
import model.BILLDetails;
import model.BillPrint;
import model.FOOD;
import static model.GETData.MyGETRequest;
import model.MENUDetails;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class DashboardUIController implements Initializable {
     Stage stageWindow;
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
    private ComboBox typeFoodCbx;
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
    private ImageView imgFoodView;
    
    @FXML
    private AnchorPane anchorPaneSide;
    
     @FXML
    private TableView<FOOD> foodTableView;

    
     FoodDAO foodDAO = new FoodDAO();

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
              fillOntable();
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
    String imageName = "";
    String imageURL = "";
    @FXML
    void choiseFoodImg(ActionEvent event) {
        System.out.println("Hello");
        Stage stage = (Stage) mainLayout.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.png" ,"*.jpg");
        
        fc.getExtensionFilters().add(imageFilter);
        File file = fc.showOpenDialog(stage);
        if (file != null)
        {
            Image image = new Image(file.toURI().toString());
            imageURL = file.toURI().toString().substring(6, file.toURI().toString().length());
            imageName = java.time.LocalDateTime.now().toString().replace(".","x").replace(":", "y").replace("-", "e") + file.getName() ;
            System.out.println(imageURL);
            imgFoodView.setImage(image);
        }
        
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
    @FXML
      private HBox loaiLayout;
     @FXML
    private HBox LayoutMenuAside;
     
     @FXML
    private TableView<FOOD> billTable;
     
    ArrayList<String> listTmp = new ArrayList<>();
    ComboBox<String> typeFoodbx2;
    
    ComboBox<String> FoodCbx;
    MenuDAO menuDAO = new MenuDAO();
   
    
     @FXML
    private StackPane stackPaneMenu;
     
       @FXML
    private ListView<?> listView;
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
    updtaeBDK();
      
      ObservableList<String> typeFoodList =  FXCollections.observableArrayList();
       typeFoodbx2 = new ComboBox<String>();
      typeFoodList.add("Món chính");
       typeFoodList.add("Món khai vị");
        typeFoodList.add("Đồ uống");
         typeFoodbx2.setValue("Món chính");
        typeFoodbx2.getItems().addAll(typeFoodList);
        loaiLayout.getChildren().add(typeFoodbx2);
     
   fillMenuOnStackPane();
     ObservableList<String> FoodList =  FXCollections.observableArrayList();
       FoodCbx = new ComboBox<String>();
            for(String var : foodDAO.getAllFoodName())
            {
               
               FoodList.add(var);

            }
 
        
         
         FoodCbx.getItems().addAll(FoodList);
       
        LayoutMenuAside.getChildren().add(FoodCbx);
      
        
          
    }
    
       @FXML
    private JFXTextField foodNameTxT;

    @FXML
    private JFXTextField priceFoodTxT;
    
     @FXML
    void addFoodAction(ActionEvent event) {
         System.out.println("asdad");
        try{
             String foodName = foodNameTxT.getText();
             float priceFood = Float.parseFloat(priceFoodTxT.getText());
             String typeFood = typeFoodbx2.getValue();
               try {
                   if(imageURL.isEmpty())
                   {
                       
                   
                   }
                   else{
                    copyFile(new File(imageURL), new File("src/upload/" + imageName));
                     FOOD food = new FOOD(0, foodName, "/upload/" + imageName, typeFood, priceFood);
                        FoodDAO fDAO = new FoodDAO();

                    
                    if(fDAO.insertFood(food)){
                         listTmp.add(imageURL);
                        imageURL = "";
                        imageName = "";
                        System.out.println("Thêm thành công");
                        foodNameTxT.setText("");
                        priceFoodTxT.setText("");
                        imgFoodView.setImage(new Image("/img/Upload-PNG.png"));
                        Alert("thông báo", "Thêm thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                      
                                    fillOntable();
                                    
                        
                     
                    }
                    else {
                        foodNameTxT.setText("");
                        priceFoodTxT.setText("");
                        imgFoodView.setImage(new Image("/img/Upload-PNG.png"));
                         Alert("thông báo", "Thêm thất bại", new ImageView(new Image("/img/warningBee.png")));
                      fillOntable();
                    }
                   }
                } catch (Exception e) {
                       Alert("thông báo", "Thêm thất bại", new ImageView(new Image("/img/warningBee.png")));
                }
              
               
                 
            
             
        }
        catch(Exception e){
             Alert("thông báo", "Thêm thất bại giá phải là số", new ImageView(new Image("/img/warningBee.png")));
        }
       
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
    
    private void fillOntable()
    {
        
        TableColumn<FOOD, Float> priceCols = new TableColumn<FOOD, Float>("Giá");
        priceCols.setPrefWidth(100);
         ImageView im0 = new ImageView(new Image("/img/price-tag.png"));
         im0.setFitWidth(30);
         im0.setFitHeight(30);
         priceCols.setGraphic(im0);
         TableColumn<FOOD, String> nameCol  = new TableColumn<FOOD, String>("Tên món ăn");
         nameCol.setPrefWidth(130);
         ImageView im = new ImageView(new Image("/img/dog-tag.png"));
         im.setFitWidth(30);
         im.setFitHeight(30);
         nameCol.setGraphic(im);


        TableColumn<FOOD, String> dateCreateCol =  new TableColumn<FOOD, String>("Ngày tạo");
        dateCreateCol.setPrefWidth(120);
         ImageView im2 = new ImageView(new Image("/img/calendar.png"));
         im2.setFitWidth(30);
         im2.setFitHeight(30);
         dateCreateCol.setGraphic(im2);
    
        TableColumn<FOOD, String> dateEditCol = new TableColumn<FOOD, String>("Ngày sửa");
        dateEditCol.setPrefWidth(120);
        ImageView im3 = new ImageView(new Image("/img/calendarEdit.png"));
         im3.setFitWidth(30);
         im3.setFitHeight(30);
         dateEditCol.setGraphic(im3);
      
    
        TableColumn<FOOD, Integer> orderCol = new TableColumn<FOOD, Integer>("Order");
        orderCol.setPrefWidth(100);
        ImageView im5 = new ImageView(new Image("/img/smartphone.png"));
         im5.setFitWidth(30);
         im5.setFitHeight(30);
         orderCol.setGraphic(im5);
 
        TableColumn<FOOD, String> typeCol = new TableColumn<FOOD, String>("Loại món ăn");
        typeCol.setPrefWidth(120);
        ImageView im6 = new ImageView(new Image("/img/food.png"));
         im6.setFitWidth(30);
         im6.setFitHeight(30);
         typeCol.setGraphic(im6);
   
        TableColumn<FOOD, String> editCol   = new TableColumn<FOOD, String>("Sửa");
         editCol.setPrefWidth(75);
         
         
         TableColumn<FOOD, String> deleteCol   = new TableColumn<FOOD, String>("Xóa");
         deleteCol.setPrefWidth(75);
        
         
        FoodDAO fDAO = new FoodDAO();
        ObservableList<FOOD> foods = FXCollections.observableArrayList();
       
        
        for(FOOD var : fDAO.getAllFood())
        {
            JFXButton editBtn = new JFXButton("Sửa");
            editBtn.setPrefWidth(75);
            editBtn.setStyle("-fx-background-color: linear-gradient(to left bottom,  #7ed56f,  #28b485); -fx-text-fill:  #ffffff;");
            
             JFXButton deleteBtn = new JFXButton("Xóa");
            deleteBtn.setStyle("-fx-background-color: linear-gradient(to left bottom,  #ff3366,  #ba265d); -fx-text-fill:  #ffffff;");
             deleteBtn.setPrefWidth(75);
            
            editBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    JFXDialogLayout content = new JFXDialogLayout();
                    content.setHeading(new Text("Sửa thông tin món ăn có id là " + var.getId()));
                    final ImageView img = new ImageView();
                    try {
                        System.out.println(var.getImage());
                        img.setImage(new Image(var.getImage()));
                        img.setFitWidth(200);
                        img.setFitHeight(150);
                    } catch (Exception e) {
                         img.setImage(new Image("/img/warningBee.png"));
                        img.setFitWidth(200);
                        img.setFitHeight(150);
                        System.out.println("Lỗi");
                    }
                   
                    HBox hbox = new HBox();
                    VBox vBox = new VBox();
                    
                     HBox hbox2 = new HBox();
                     
                      HBox hbox3 = new HBox();
                    
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefWidth(200);
                    hbox2.getChildren().add(img);
                   
                    JFXButton btnChoiseImg = new JFXButton("Chọn hình");
                    btnChoiseImg.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                                            System.out.println("Hello");
                        Stage stage = (Stage) mainLayout.getScene().getWindow();
                        FileChooser fc = new FileChooser();
                        fc.setTitle("Choose a image");
                        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.png" ,"*.jpg");

                        fc.getExtensionFilters().add(imageFilter);
                        File file = fc.showOpenDialog(stage);
                        if (file != null)
                        {
                            Image image = new Image(file.toURI().toString());
                            imageURL = file.toURI().toString().substring(6, file.toURI().toString().length());
                            imageName = java.time.LocalDateTime.now().toString().replace(".","x").replace(":", "y").replace("-", "e") + file.getName() ;
                            System.out.println(imageURL);
                            img.setImage(image);
                        }
        
                          
                           
                        }
                    });
                    btnChoiseImg.setStyle("-fx-background-color: linear-gradient(to right bottom,  #7ed56f,  #28b485); -fx-text-fill:  #ffffff;");
                     hbox3.getChildren().add(btnChoiseImg);
                     hbox3.setAlignment(Pos.CENTER);
                     hbox3.setPrefHeight(50);
                    
                    vBox.getChildren().addAll(hbox2,hbox3);
                    
                   
                    
                     VBox vBox2 = new VBox();
                     GridPane grid = new GridPane();
                      grid.setVgap(25); 
                       grid.setHgap(25); 
                      grid.setAlignment(Pos.CENTER);
                      
                      Label lb2 = new Label("Tên");
                     lb2.setPadding(new Insets(10, 10, 10, 10));
                     grid.add(lb2, 0, 0);
                     JFXTextField nameTxT = new JFXTextField();
                     nameTxT.setPrefWidth(250);
                     nameTxT.setText(var.getFoodName());
                     grid.add(nameTxT, 1, 0);
                     
                     Label lb = new Label("Giá");
                     lb.setPadding(new Insets(10, 10, 10, 10));
                     grid.add(lb, 0, 1);
                      
                     JFXTextField priceTxT = new JFXTextField();
                     priceTxT.setPrefWidth(250);
                     priceTxT.setText(String.valueOf(var.getPrice()));
                     grid.add(priceTxT, 1, 1);
                     
                      ObservableList<String> typeFoodList =  FXCollections.observableArrayList();
                  ComboBox<String>  typeFoodbxEdit = new ComboBox<String>();
                   typeFoodList.add("Món chính");
                    typeFoodList.add("Món khai vị");
                     typeFoodList.add("Đồ uống");
                      typeFoodbx2.setValue("Món chính");
                     typeFoodbxEdit.getItems().addAll(typeFoodList);
                   
                     HBox hBoxTypeEdit = new HBox();
                     Label lbType = new Label("Loại");
                     lbType.setPadding(new Insets(10, 30, 10, 10));
                     
                     typeFoodbxEdit.setValue(var.getType());
                     hBoxTypeEdit.setAlignment(Pos.CENTER_LEFT);
                     
                     hBoxTypeEdit.getChildren().addAll(lbType,typeFoodbxEdit);
                    
                     vBox2.getChildren().addAll(grid, hBoxTypeEdit);
                     vBox2.setPadding(new Insets(0, 50, 0, 50));
                     
                      
                     
                     
                      hbox.getChildren().addAll(vBox,vBox2);
                      
                      
                      
                     
                     AnchorPane anchorPane = new AnchorPane(hbox);
                     content.setBody(anchorPane);
                     JFXButton saveBtn = new JFXButton("Update");
                     content.setActions(saveBtn);
                     JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
                     saveBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                 String foodName = nameTxT.getText();
                                float priceFood = Float.parseFloat(priceTxT.getText());
                                String typeFood = typeFoodbxEdit.getValue();
                                     try {
                                          
                                         copyFile(new File(imageURL), new File("src/upload/" + imageName));
                                         if(imageURL.isEmpty())
                                         {
                                              FOOD food = new FOOD(var.getId(), foodName, var.getImage(), typeFood, priceFood);
                                         }
                                         else{
                                               FOOD food = new FOOD(var.getId(), foodName, "/upload/" + imageName, typeFood, priceFood);
                                         }
                                          FOOD food = new FOOD(var.getId(), foodName, "/upload/" + imageName, typeFood, priceFood);
                                             FoodDAO fDAO = new FoodDAO();


                                             if(fDAO.updateFood(food)){
                                                 System.out.println(priceFood + " " + typeFood);
                                                  listTmp.add(imageURL);
                                                 imageURL = "";
                                                 imageName = "";
                                                 System.out.println("Thêm thành công");
                                                 foodNameTxT.setText("");
                                                 priceFoodTxT.setText("");
                                                 imgFoodView.setImage(new Image("/img/Upload-PNG.png"));
                                                  fillOntable();
                                                  Alert("thông báo", "Sửa thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                                                  dialog.close();


                                             }
                                             else {
                                                 foodNameTxT.setText("");
                                                 priceFoodTxT.setText("");
                                                 imgFoodView.setImage(new Image("/img/Upload-PNG.png"));
                                               fillOntable();
                                                 Alert("thông báo", "Sửa thất bại vui lòng xem lại thông tin", new ImageView(new Image("/img/SuBeeTeam.png")));
                                                  dialog.close();
                                             }
                                            
                                         } catch (Exception e) {
                                                e.printStackTrace();
                                                 Alert("thông báo", "Sửa thất bại vui lòng xem lại thông tin", new ImageView(new Image("/img/SuBeeTeam.png")));
                                         }
              
                            
                            } catch (Exception e) {
                                Alert("thông báo", "Sửa thất bại giá phải là số", new ImageView(new Image("/img/SuBeeTeam.png")));
                            }
                          
                            
                            
                        }
                    });
                     
                    
                     
                     dialog.show();
                    
                    
                    
                    
                    System.out.println(var.getId());
                }
            });
            
            deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    
                    foodDAO.deleteFood(var.getId());
                    Alert("Đã xóa", "Xóa thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                    fillOntable();
                    
                    System.out.println(var.getId());
                }
            });
                    System.out.println(var.getImage());
          
                   
            System.out.println(var.getEditBtn().getText());
            
            foods.add(new FOOD(var.getId(), var.getOrder(), var.getFoodName(), var.getDateCreate(), var.getDateEdit(), var.getImage(), var.getType(), var.getPrice(), editBtn, deleteBtn));
        }
        
        nameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        priceCols.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateCreateCol.setCellValueFactory(new PropertyValueFactory<>("dateCreate"));
        dateEditCol.setCellValueFactory(new PropertyValueFactory<>("dateEdit"));
        
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        orderCol.setCellValueFactory(new PropertyValueFactory<>("order"));
        editCol.setCellValueFactory(new PropertyValueFactory<>("editBtn"));
        deleteCol.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        
        foodTableView.getColumns().clear();
        foodTableView.getColumns().addAll(nameCol,priceCols,dateCreateCol,dateEditCol,orderCol,typeCol,editCol,deleteCol);
        foodTableView.setItems(foods);
        
        System.out.println("Fill on Table");
        
        
        
    }
    
    
    private void copyFile(File source, File dest  ) throws IOException {
            BufferedImage bImage;
            String imgPath = imageURL;
            String getName = imageName;
            String extension = "";
            int i = getName.lastIndexOf('.');
            int p = Math.max(getName.lastIndexOf('/'), getName.lastIndexOf('\\'));
            if (i > p) {
                extension = getName.substring(i + 1);
            }
            try {
                File initialImage = new File(imgPath);
                bImage = ImageIO.read(initialImage);
                ImageIO.write(bImage, extension, new File("src/upload/" + getName));
               
            } catch (IOException e) {
            }
    }
    
    private String choiseFile() 
    {
          System.out.println("Hello");
        Stage stage = (Stage) mainLayout.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg");
        
        fc.getExtensionFilters().add(imageFilter);
        File file = fc.showOpenDialog(stage);
        if (file != null)
        {
            Image image = new Image(file.toURI().toString());
            imageURL = file.toURI().toString().substring(6, file.toURI().toString().length());
            imageName = java.time.LocalDateTime.now().toString().replace(".","x").replace(":", "y").replace("-", "e") + file.getName() ;
            System.out.println(imageURL);
         
            return imageURL;
        }
        return null;
        
    }
    
     @FXML
    void addMenuDetailsAction(ActionEvent event) {
         try {
               int index = Integer.parseInt(FoodCbx.getValue().substring(0,2));
         System.out.print(index);
            
            if(menuDAO.insertMenuDetails(index))
            {
                 Alert("Thông Báo", "Thêm món ăn thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                 fillMenuOnStackPane();
            }
            else
            {
                Alert("Thông Báo", "Đã có món này trong thực đơn", new ImageView(new Image("/img/SuBeeTeam.png")));
            }
         } catch (Exception e) {
             Alert("Thông Báo", "Vui lòng chọn món ăn", new ImageView(new Image("/img/SuBeeTeam.png")));
         }
      
    }
    
    private void Alert(String title, String Body, ImageView imgView)
    {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text(title));
        HBox hbox = new HBox();
        Label lb = new Label(Body);
        lb.setPadding(new Insets(10, 10, 10, 10));
        lb.setFont(new Font(20));
        imgView.setFitHeight(100);
        imgView.setFitWidth(100);
        hbox.getChildren().addAll(imgView,lb);
        AnchorPane an = new AnchorPane(hbox);
        content.setBody(an);
         JFXButton close = new JFXButton("OK");
         close.setStyle(" -fx-background-color: linear-gradient(to left bottom,  #ff3366,  #ba265d); -fx-text-fill : #FFFFFF");
        content.setActions(close);
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        
           close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        dialog.show();
    };
    
    private void fillMenuOnStackPane(){
        stackPaneMenu.getChildren().clear();
         ObservableList<String> menus = FXCollections.observableArrayList();
            VBox vbox = new VBox();
           for(String var : menuDAO.getAllMenu())
           {
              Label label = new Label(var);
              label.setPadding(new Insets(10, 10, 10, 10));
              vbox.getChildren().addAll(label);

           }
           vbox.setAlignment(Pos.TOP_CENTER);
               stackPaneMenu.getChildren().addAll(vbox);
     }
    
    @FXML
    void resetMenu(ActionEvent event) {
       menuDAO.deleteMenu();
            Alert("Thông Báo", "Làm mới menu thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
       
        fillMenuOnStackPane();
    }
    
    private int idBillNow = -1;
    
    private void fillFoodInBill(int idBill){
        System.out.println(idBill);
       
         TableColumn<FOOD, String> nameCol  = new TableColumn<FOOD, String>("Tên món ăn");
         nameCol.setPrefWidth(130);
         ImageView im = new ImageView(new Image("/img/dog-tag.png"));
         im.setFitWidth(30);
         im.setFitHeight(30);
         nameCol.setGraphic(im);


        TableColumn<FOOD, String> addCol =  new TableColumn<FOOD, String>("Thêm");
        addCol.setPrefWidth(120);
         ImageView im2 = new ImageView(new Image("/img/calendar.png"));
         im2.setFitWidth(30);
         im2.setFitHeight(30);
         addCol.setGraphic(im2);
         
         ArrayList<FOOD> listFood = foodDAO.getAllFood();
         ObservableList<FOOD> foods = FXCollections.observableArrayList();
         
         for(FOOD var : listFood)
         {
             JFXButton btnAdd = new JFXButton("Thêm");
             btnAdd.setStyle("-fx-background-color: linear-gradient(to left bottom,  #ff3366,  #ba265d); -fx-text-fill : #FFFFFF");
            btnAdd.setOnAction(new EventHandler<ActionEvent>() {
                BILLDetails bILLDetails = new BILLDetails(idBill,var.getId(),1);
                 @Override
                 public void handle(ActionEvent event) {
                     System.out.println(idBill+ " "+ var.getId());
                     if(billDao.checkDetailsBillAvaiable(bILLDetails) != null)
                     {
                          billDao.updateDetailsBill(bILLDetails);
                           sumPriceTxT.setText("Tổng tiền : " + String.valueOf(billDao.sumPriceBill(idBill)) + "đ");
                     }
                     else 
                     {
                          billDao.insertDetailsBill(bILLDetails);
                          sumPriceTxT.setText("Tổng tiền : " +String.valueOf(billDao.sumPriceBill(idBill))+ "đ");
                       
                     }
                 }
             });
             foods.add(new FOOD(var.getFoodName(), btnAdd));
         
         }
         
         
        nameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        addCol.setCellValueFactory(new PropertyValueFactory<>("editBtn"));
       
        
        billTable.getColumns().clear();
        billTable.getColumns().addAll(nameCol,addCol);
        billTable.setItems(foods);
        
        System.out.println("Fill on Table");
    }
    
     BillDAO billDao;
    
     @FXML
    void addNewBill(ActionEvent event) {
         billDao = new BillDAO();
        billDao.insertBill();
        
        fillFoodInBill(billDao.getIdBillNow());
        idBillNow = billDao.getIdBillNow();
        sumPriceTxT.setText("Tổng tiền : 0đ");
    }
    
    @FXML
    private Label sumPriceTxT;
    
    @FXML
    void createBill(ActionEvent event) {
     
        
             if(idBillNow != -1){
                 if(banThuong.isSelected())
                 {
                     BILL bill = new BILL(idBillNow, "", banThuong.getText());
                     billDao.updateBill(bill);
                     printPDF();
                      Alert("Thông Báo", "Xuất file PFD thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                    
                 }
                    else if(banDoi.isSelected())
                    {
                        BILL bill = new BILL(idBillNow, "", banDoi.getText());
                     billDao.updateBill(bill);
                      printPDF();
                       Alert("Thông Báo", "Xuất file PFD thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                    }
                 else if(banGiaDinh.isSelected())
                    {
                        BILL bill = new BILL(idBillNow, "", banGiaDinh.getText());
                     billDao.updateBill(bill);
                      printPDF();
                       Alert("Thông Báo", "Xuất file PFD thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                    }
                 else if(banHangSang.isSelected())
                    {
                        BILL bill = new BILL(idBillNow, "", banHangSang.getText());
                     billDao.updateBill(bill);
                      printPDF();
                       Alert("Thông Báo", "Xuất file PFD thành công", new ImageView(new Image("/img/SuBeeTeam.png")));
                    }
             }
             else{
                  Alert("Thông Báo", "Xuất file PFD thất bại", new ImageView(new Image("/img/SuBeeTeam.png")));
             }
           
        
    
   
    }
    
    private void printPDF() {
        // Tạo đối tượng tài liệu
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {
                        
			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("C:\\hoaDon.pdf"));

			// Mở file để thực hiện ghi
			document.open();
                        Paragraph title1 = new Paragraph("Bill number " + idBillNow,
					FontFactory.getFont(FontFactory.HELVETICA, 18, new CMYKColor(0, 255, 255, 17)));

			PdfPTable t = new PdfPTable(3);
                        t.setSpacingBefore(25);
                        t.setSpacingAfter(25);
           
			document.add(title1);
		

			
                        PdfPCell c1 = new PdfPCell(new Phrase("Food Name"));
                        t.addCell(c1);
                        PdfPCell c2 = new PdfPCell(new Phrase("Amount"));
                        t.addCell(c2);
                        PdfPCell c3 = new PdfPCell(new Phrase("Price"));
                        t.addCell(c3);

                       
                        
                        for(BillPrint var : billDao.getBillInPrintPDF(idBillNow) )
                        {
                                t.addCell(var.getFoodName());
                                t.addCell(String.valueOf(var.getAmount()) + " suất");
                                t.addCell(String.valueOf(var.getPrice()) +"đ");
                        }
                        
                                t.addCell("");
                                t.addCell("");
                                t.addCell("Sum Price : " + billDao.sumPriceBill(idBillNow) );
                        
                        document.add(t);


			// Đóng File
			document.close();
			System.out.println("Write file succes!");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
    }
    
        @FXML
    private JFXRadioButton banThuong;

    @FXML
    private ToggleGroup tableRadio;

    @FXML
    private JFXRadioButton banDoi;

    @FXML
    private JFXRadioButton banGiaDinh;

    @FXML
    private JFXRadioButton banHangSang;
    
    
    private void updtaeBDK() {
      
    }

    
}

