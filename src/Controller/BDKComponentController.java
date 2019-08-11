/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class BDKComponentController implements Initializable {
    @FXML
    private JFXComboBox<?> dateCombobox;

    @FXML
    private LineChart<String, Number> lineChartTxT;

    @FXML
    private Text billTxT;

    @FXML
    private Text foodTxT;

    @FXML
    private Text moneyTxT;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        lineChartTxT.getData().add(series);
        
    }    
    
    private void FadeEffect() {
         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.onFinishedProperty();
        fadeTransition.play();
    }
    
}
