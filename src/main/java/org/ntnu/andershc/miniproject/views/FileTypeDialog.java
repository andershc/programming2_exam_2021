package org.ntnu.andershc.miniproject.views;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileTypeDialog extends Dialog<File> {
    private File file;
    private final ButtonType selectFile;

    /**
     * Constructor for the dialog.
     */
    public FileTypeDialog() {
        super();
        file = null;
        selectFile = new ButtonType("Select File");
        createDialog();
    }

    /**
     * Method for creating the objects in the dialog, and returns the chosen file.
     */
    private void createDialog() {
        getDialogPane().getButtonTypes().setAll(selectFile, ButtonType.CANCEL);
        setTitle("Select import file");
        setHeaderText("The chosen file type is not valid.");
        setContentText("Please choose another file by clicking on Select File or cancel the operation");
        setResultConverter((ButtonType button) -> {
            if(button == selectFile){
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select a file");
                file = fileChooser.showOpenDialog(stage);
            }
            return file;
        });
    }
}
