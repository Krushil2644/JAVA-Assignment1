package com.example.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the main interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/assignment1/main.fxml"));
        Parent root = loader.load();

        // Set the application icon (ensure the icon path is correct)
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/assignment1/icon.png"))));

        // Create the main scene with the loaded interface, setting the window size to 750x800 pixels
        Scene scene = new Scene(root, 750, 800); // Setting a smaller window size (16:9 ratio)

        // Add the stylesheet to the scene (ensure the stylesheet path is correct)
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/example/styles.css")).toExternalForm());

        // Set the scene for the primary stage
        primaryStage.setScene(scene);
        // Set the title of the application window
        primaryStage.setTitle("Deforestation Analyzer");
        // Display the primary stage
        primaryStage.show();
    }

    // The main method launches the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
