package com.example.assignment1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeforestationDataDAO {

    // Method to retrieve all deforestation data from the database
    public List<DeforestationData> getAllData() throws SQLException {
        // List to store the retrieved data
        List<DeforestationData> dataList = new ArrayList<>();

        // SQL query to select all records from the deforestation_data table
        String query = "SELECT * FROM deforestation_data";

        // Try-with-resources statement to manage database resources
        try (Connection connection = DBConnector.connect(); // Establish connection to the database
             Statement stmt = connection.createStatement(); // Create a statement to execute the query
             ResultSet rs = stmt.executeQuery(query)) { // Execute the query and get the result set

            // Iterate through the result set and populate the data list
            while (rs.next()) {
                // Retrieve data from the current row of the result set
                int id = rs.getInt("id");
                int year = rs.getInt("year");
                double areaAffected = rs.getDouble("area_affected");
                String cause = rs.getString("cause");
                String description = rs.getString("description");

                // Create a new DeforestationData object and add it to the list
                dataList.add(new DeforestationData(id, year, areaAffected, cause, description));
            }
        }

        // Return the list of deforestation data
        return dataList;
    }
}
