package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aliment;

public class IngredientEditDialogController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField categorieField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField quantiteField;


    private Stage dialogStage;
    private Aliment aliment;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        
        // Set the dialog icon.
//        this.dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
    }


    public void setIngredient(Aliment aliment) {
        this.aliment = aliment;

        System.out.println(aliment.getIdAliment() + " nom : " + aliment.getNomAliment());

        nomField.setText(aliment.getNomAliment());
        categorieField.setText(aliment.getCategorieAliment());
        prixField.setText(Integer.toString(aliment.getPrixAliment()));
        quantiteField.setText(Integer.toString(aliment.getQuantiteAliment()));
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleOk() {
        if (isInputValid()) {
            aliment.setNomAliment(nomField.getText());
            aliment.setCategorieAliment(categorieField.getText());
            aliment.setPrixAliment(Integer.parseInt(prixField.getText()));
            aliment.setQuantiteAliment(Integer.parseInt(quantiteField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (nomField.getText() == null || nomField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (categorieField.getText() == null || categorieField.getText().length() == 0) {
            errorMessage += "No valid category!\n";
        }

        if (prixField.getText() == null || prixField.getText().length() == 0) {
            errorMessage += "No valid price!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(prixField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid price (must be an integer)!\n";
            }
        }

        if (quantiteField.getText() == null || quantiteField.getText().length() == 0) {
            errorMessage += "No valid quantity!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(quantiteField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid price (must be an integer)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}