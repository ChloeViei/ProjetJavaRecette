package controller;

import data.AlimentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Aliment;

public class PersonOverviewController {

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


    public PersonOverviewController() {
        System.out.println("Initialisation du controleur ingredient");
        this.alimentDAO = new AlimentDAO();
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
        System.out.println("showAlimentDetails");
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
//            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Aliment Selected");
            alert.setContentText("Please select a aliment in the table.");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewAliment() {
        Aliment tempAliment = new Aliment();
//        boolean okClicked = mainApp.showPersonEditDialog(tempAliment);
//        if (okClicked) {
//            alimentDAO.listerAliment().add(tempAliment);
//        }
    }


    @FXML
    private void handleEditAliment() {
        Aliment selectedAliment = alimentTableView.getSelectionModel().getSelectedItem();
        if (selectedAliment != null) {
//            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
//            if (okClicked) {
//                showPersonDetails(selectedPerson);
//            }
//
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//
//            alert.showAndWait();
        }
    }

}