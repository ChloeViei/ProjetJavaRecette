package controller;

import data.AlimentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Aliment;

import java.io.IOException;

public class IngredientOverviewController {

    private final AlimentDAO alimentDAO;

    //FXML element
    @FXML
    private TableColumn<Aliment, Integer> idAliment;
    @FXML
    private TableColumn<Aliment, String> nomAliment;
    @FXML
    private TableView<Aliment> alimentTableView = new TableView<Aliment>();

    @FXML
    private Label nomLabel;
    @FXML
    private Label categorieLabel;
    @FXML
    private Label prixLabel;
    @FXML
    private Label quantiteLabel;


    private Stage fenetre;


    public IngredientOverviewController() {
        System.out.println("Initialisation du controleur ingredient");
        this.alimentDAO = new AlimentDAO();
    }

    public void setStage(Stage stage){
        this.fenetre = stage;
    }


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        idAliment.setCellValueFactory(cellData -> cellData.getValue().idAlimentProperty().asObject());
        nomAliment.setCellValueFactory(cellData -> cellData.getValue().nomAlimentProperty());
        
        // Clear person details.
        showAlimentsDetails(null);


        // Récupère les données de la base de donnée pour les affichers
        ObservableList<Aliment> liste = FXCollections.observableArrayList();
        liste = alimentDAO.listerAliment();
        this.alimentTableView.setItems(liste);

        // Listen for selection changes and show the person details when changed.
        alimentTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAlimentsDetails(newValue));
    }


    private void showAlimentsDetails(Aliment aliment) {

        if (aliment != null) {
            // Fill the labels with info from the person object.
            nomLabel.setText(aliment.getNomAliment());
            categorieLabel.setText(aliment.getCategorieAliment());
            prixLabel.setText(Integer.toString(aliment.getPrixAliment()));
            quantiteLabel.setText(Integer.toString(aliment.getQuantiteAliment()));
        } else {
            // Person is null, remove all the text.
            nomLabel.setText("");
            categorieLabel.setText("");
            prixLabel.setText("");
            quantiteLabel.setText("");
        }
    }
    

    @FXML
    private void handleDeleteAliment() {
        int selectedIndex = alimentTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            alimentTableView.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(this.fenetre);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Aliment Selected");
            alert.setContentText("Please select a aliment in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewAliment() {
        Aliment tempAliment = new Aliment();
        boolean okClicked = showIngredientEditDialog(tempAliment);
        if (okClicked) {
            alimentDAO.listerAliment().add(tempAliment);
        }
    }


    @FXML
    private void handleEditAliment() {
        Aliment selectedAliment = alimentTableView.getSelectionModel().getSelectedItem();
        if (selectedAliment != null) {
            boolean okClicked = showIngredientEditDialog(selectedAliment);
            if (okClicked) {
                showAlimentsDetails(selectedAliment);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(this.fenetre);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    public boolean showIngredientEditDialog(Aliment aliment) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(IngredientOverviewController.class.getResource("../view/Aliment/IngredientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Aliment");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.fenetre);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the ingredient into the controller.
            IngredientEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);

//            System.out.println(aliment.getIdAliment() + " nom : " + aliment.getNomAliment());

            controller.setIngredient(aliment);

            // Set the dialog icon.
//            dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}