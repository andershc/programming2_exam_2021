package org.ntnu.andershc.miniproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.ntnu.andershc.miniproject.model.PostalCode;
import org.ntnu.andershc.miniproject.model.PostalCodeRegister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {
    private static PostalCodeRegister register = new PostalCodeRegister();
    private static ObservableList<PostalCode> observableList;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("main"), 707, 480);
        stage.setScene(scene);
        stage.setTitle("Postal Code Register v0.1-SNAPSHOT");
        stage.show();
        stage.setOnCloseRequest(event -> {
            alertOnExit();
            event.consume();
        });
    }

    /**
     * Loads an fxml file.
     * @param fxml
     * @return The fxml file
     * @throws IOException if the file is not found.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static PostalCodeRegister getRegister(){
        return register;
    }

    /**
     * Updates the observable list.
     */
    public static void updateObservableList(){
        observableList = FXCollections.observableList(new ArrayList<>(register.getAllPostalCodes().values()));
    }
    public static ObservableList<PostalCode> getObservableList() {
        return observableList;
    }
    /**
     * Shows a confirmation alert when trying to close the application.
     */
    public static void alertOnExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Do you want to exit the application?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(1);
        }
    }
}