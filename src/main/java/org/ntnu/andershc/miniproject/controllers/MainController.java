package org.ntnu.andershc.miniproject.controllers;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ntnu.andershc.miniproject.App;
import org.ntnu.andershc.miniproject.fileHandling.Read;
import org.ntnu.andershc.miniproject.model.PostalCode;
import org.ntnu.andershc.miniproject.views.FileTypeDialog;

import java.io.File;
import java.util.Optional;

public class MainController {
    @FXML
    private TextField searchField;
    @FXML
    private TableView<PostalCode> tableView;
    @FXML
    private TableColumn<PostalCode, String> postalCodeColumn;
    @FXML
    private TableColumn<PostalCode, String> postalNameColumn;
    @FXML
    private TableColumn<PostalCode, String> municipalCodeColumn;
    @FXML
    private TableColumn<PostalCode, String> municipalNameColumn;
    @FXML
    private TableColumn<PostalCode, String> categoryColumn;
    @FXML
    private Label status;


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
        searchFilter();
        tableView.getSortOrder().addAll(postalCodeColumn);
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
     * A filter that updates the table depending on what you typed in the search filed.
     * When you type in the field it searches both postal code and postal name.
     */
    private void searchFilter(){
        FilteredList<PostalCode> filteredData = new FilteredList(App.getObservableList(), (b) -> true);
        this.searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((postalCode) -> {
                if (newValue != null && !newValue.isEmpty()) {
                    String filter = newValue.toLowerCase();
                    if (postalCode.getPostalCode().toLowerCase().contains(filter)) {
                        return true;
                    } else {
                        return postalCode.getPostalName().toLowerCase().contains(filter);
                    }
                } else {
                    return true;
                }
            });
        });
        SortedList<PostalCode> sortedData = new SortedList(filteredData);
        sortedData.comparatorProperty().bind(this.tableView.comparatorProperty());
        this.tableView.setItems(sortedData);
    }
    /**
     * Method is called when pressing Import File...
     * Let's you choose a file to import, the file must be a .txt file.
     * If the file selected is not .txt, a dialog is shown.
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
                    if(read.getNotRead() != 0){
                        status.setText(read.getNotRead() + " objects were not registered...");
                    }
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
