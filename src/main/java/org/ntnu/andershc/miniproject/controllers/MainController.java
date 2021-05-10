package org.ntnu.andershc.miniproject.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ntnu.andershc.miniproject.App;
import org.ntnu.andershc.miniproject.fileHandling.Read;
import org.ntnu.andershc.miniproject.views.FileTypeDialog;

import java.io.File;
import java.util.Optional;

public class MainController {

    public MenuItem importCSV;
    public MenuItem exportCSV;
    public MenuItem exit;
    public TextField searchField;
    public TableColumn postalCodeColumn;
    public TableColumn postalNameColumn;
    public TableColumn municipalCodeColumn;
    public TableColumn municipalNameColumn;
    public TableColumn categoryColumn;
    public Label status;
    public TableView tableView;

    /**
     * Method that runs when the window is opened up.
     * Calls other methods to set the content of the table view.
     */
    public void initialize() {
        tableView.setEditable(true);
        updateList();
        columFactory();
        status.setText("application initialized...");
    }
    /**
     * A method to update the table view and the register.
     */
    private void updateList(){
        App.updateObservableList();
        tableView.setItems(App.getObservableList());
    }
    /**
     * Initializes the columns of the tableview.
     */
    private void columFactory(){
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        postalNameColumn.setCellValueFactory(new PropertyValueFactory<>("postalName"));
        municipalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("municipalCode"));
        municipalNameColumn.setCellValueFactory(new PropertyValueFactory<>("municipalName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }
    /**
     * Method is called when pressing Import .CSV...
     * Let's you choose a file to import, the file must be a .csv file.
     * If the file selected is not .csv a dialog is shown.
     */
    @FXML
    public void importFile() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            while (true) {
                Read read = new Read(file.getPath());
                try {
                    read.readFile(App.getRegister());
                    updateList();
                    status.setText("imported successfully...");
                    break;
                } catch (IllegalArgumentException e) {
                    status.setText("import failed...");
                    FileTypeDialog fileTypeDialog = new FileTypeDialog();
                    fileTypeDialog.setHeaderText(e.getMessage());
                    Optional<File> result = fileTypeDialog.showAndWait();
                    if (result.isPresent()) {
                        file = result.get();
                    }else{
                        break;
                    }
                }
            }
        }
    }
    /**
     * Called when pressing the about button.
     * An alert is shown displaying information about the application.
     */
    @FXML
    public void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Information Dialog - About");
        alert.setHeaderText("Postal Code Register\nv0.1-SNAPSHOT");
        alert.setContentText("A brilliant application created by" +
                "\n\u00A9Anders Heftøy Carlsen\n2021-05-14 ");
        alert.showAndWait();

    }
    /**
     * Called when pressing exit
     */
    @FXML
    private void exit(){
        App.alertOnExit();
    }
}
