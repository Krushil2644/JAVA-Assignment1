package com.example.assignment1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class TableSceneController {

    @FXML private TableView<DeforestationData> tableView; // TableView for displaying deforestation data

    @FXML private TableColumn<DeforestationData, Integer> idCol; // TableColumn for ID
    @FXML private TableColumn<DeforestationData, Integer> yearCol; // TableColumn for year
    @FXML private TableColumn<DeforestationData, Double> areaCol; // TableColumn for area affected
    @FXML private TableColumn<DeforestationData, String> causeCol; // TableColumn for cause
    @FXML private TableColumn<DeforestationData, String> descCol; // TableColumn for description

    /**
     * Initializes the controller. This method is automatically called
     * after the FXML file has been loaded.
     */
    public void initialize() {
        // Set cell value factories to populate table columns
        idCol.setCellValueFactory(new PropertyValueFactory<>("id")); // Map 'id' property to idCol
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year")); // Map 'year' property to yearCol
        areaCol.setCellValueFactory(new PropertyValueFactory<>("areaAffected")); // Map 'areaAffected' property to areaCol
        causeCol.setCellValueFactory(new PropertyValueFactory<>("cause")); // Map 'cause' property to causeCol
        descCol.setCellValueFactory(new PropertyValueFactory<>("description")); // Map 'description' property to descCol

        // Retrieve data from database and populate TableView
        DeforestationDataDAO dao;
        try {
            dao = new DeforestationDataDAO(); // Create DAO object to retrieve data
            List<DeforestationData> dataList = dao.getAllData(); // Retrieve all deforestation data from database
            ObservableList<DeforestationData> data = FXCollections.observableArrayList(dataList); // Create ObservableList from dataList
            tableView.setItems(data); // Set items in TableView
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQLException by printing the stack trace
        }
    }
}
