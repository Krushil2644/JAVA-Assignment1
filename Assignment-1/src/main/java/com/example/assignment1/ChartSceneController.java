package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.sql.SQLException;
import java.util.List;

public class ChartSceneController {

    @FXML private BarChart<String, Number> barChart; // BarChart for displaying deforestation data
    @FXML private CategoryAxis xAxis; // X-axis for the BarChart
    @FXML private NumberAxis yAxis; // Y-axis for the BarChart

    /**
     * Initializes the controller. This method is automatically called
     * after the FXML file has been loaded.
     */
    public void initialize() {
        try {
            DeforestationDataDAO dao = new DeforestationDataDAO(); // Create DAO object to retrieve data
            List<DeforestationData> dataList = dao.getAllData(); // Retrieve all deforestation data from database

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            // Populate the series with data from the dataList
            for (DeforestationData data : dataList) {
                series.getData().add(new XYChart.Data<>(String.valueOf(data.getYear()), data.getAreaAffected()));
            }
            barChart.getData().add(series); // Add series to the BarChart
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException by printing the stack trace
        }
    }

}
