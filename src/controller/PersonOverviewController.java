package controller;

import com.sun.tools.javac.Main;
import data.AlimentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

    // Reference to the main application.
    private Main mainApp;


    public PersonOverviewController() {
        System.out.println("Initialisation du controleur ingredient");
        this.alimentDAO = new AlimentDAO();
        buildData();
    }


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        idAliment.setCellValueFactory(cellData -> cellData.getValue().idAlimentProperty().asObject());
        nomAliment.setCellValueFactory(cellData -> cellData.getValue().nomAlimentProperty());
        
        // Clear person details.
        showAlimentsDetails(null);

        // Listen for selection changes and show the person details when changed.
        alimentTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAlimentsDetails(newValue));
    }


    public void buildData() {
        // Récupère les données de la base de donnée pour les affichers
        ObservableList<Aliment> liste = FXCollections.observableArrayList();
        liste = alimentDAO.listerAliment();

//        System.out.println(liste.get(0).getIdAliment());
        alimentTableView.setItems(liste);
    }


    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param aliment the person or null
     */
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
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
//        int selectedIndex = alimentTableView.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//            alimentTableView.getItems().remove(selectedIndex);
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//
//            alert.showAndWait();
//        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
//        Person tempPerson = new Person();
//        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
//        if (okClicked) {
//            mainApp.getPersonData().add(tempPerson);
//        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
//        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
//        if (selectedPerson != null) {
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
//        }
    }

}