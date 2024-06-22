package com.example.assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class MainController {

    @FXML private BarChart<String, Number> barChart; // BarChart for displaying deforestation data
    @FXML private CategoryAxis xAxis; // X-axis for the BarChart
    @FXML private NumberAxis yAxis; // Y-axis for the BarChart
    @FXML private TableView<DeforestationData> tableView; // TableView for displaying deforestation data
    @FXML private TableColumn<DeforestationData, String> yearColumn; // TableColumn for year in TableView
    @FXML private TableColumn<DeforestationData, Double> areaAffectedColumn; // TableColumn for area affected in TableView
    @FXML private Button toggleButton; // Button to toggle between TableView and BarChart

    private boolean isTableViewVisible = false; // Flag to track visibility of TableView

    @FXML
    private void initialize() {
        setupTableView(); // Initialize TableView
        loadChartData(); // Load data into BarChart and TableView
    }

    // Setup TableView columns
    private void setupTableView() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year")); // Map year data to yearColumn
        areaAffectedColumn.setCellValueFactory(new PropertyValueFactory<>("areaAffected")); // Map areaAffected data to areaAffectedColumn
    }

    // Load data into BarChart and TableView
    private void loadChartData() {
        try {
            DeforestationDataDAO dao = new DeforestationDataDAO(); // Create DAO object to retrieve data
            List<DeforestationData> dataList = dao.getAllData(); // Retrieve all deforestation data from database

            // Create series for BarChart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (DeforestationData data : dataList) {
                series.getData().add(new XYChart.Data<>(String.valueOf(data.getYear()), data.getAreaAffected()));
            }
            barChart.getData().add(series); // Add series to BarChart

            // Populate TableView with the same data
            ObservableList<DeforestationData> data = FXCollections.observableArrayList(dataList);
            tableView.setItems(data); // Set items in TableView
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Toggle between TableView and BarChart visibility
    @FXML
    private void toggleTableViewAndChartView() {
        if (!isTableViewVisible) {
            // Show TableView and hide BarChart
            tableView.setVisible(true);
            barChart.setVisible(false);
            toggleButton.setText("Show Chart View"); // Update button text
        } else {
            // Show BarChart and hide TableView
            tableView.setVisible(false);
            barChart.setVisible(true);
            toggleButton.setText("Show Table View"); // Update button text
        }
        isTableViewVisible = !isTableViewVisible; // Toggle visibility flag
    }

}
