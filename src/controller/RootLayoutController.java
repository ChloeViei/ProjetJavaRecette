package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RootLayoutController {

    @FXML
    private void handleIngredient() {
//        navigateurVues.getPersonData().clear();
//        navigateurVues.setPersonFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleRecette() {
//        FileChooser fileChooser = new FileChooser();
//
//        // Set extension filter
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
//                "XML files (*.xml)", "*.xml");
//        fileChooser.getExtensionFilters().add(extFilter);
//
//        // Show save file dialog
//        File file = fileChooser.showOpenDialog(navigateurVues.getPrimaryStage());
//
//        if (file != null) {
//            navigateurVues.loadPersonDataFromFile(file);
//        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleListeCourse() {
//        File personFile = navigateurVues.getPersonFilePath();
//        if (personFile != null) {
//            navigateurVues.savePersonDataToFile(personFile);
//        } else {
//            handleSaveAs();
//        }
    }


    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information sur le logiciel");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Chloé Vieille ");

    	alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

}