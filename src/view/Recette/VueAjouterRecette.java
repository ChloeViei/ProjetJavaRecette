package view.Recette;

import controller.ControleurIngredient;
import controller.ControleurRecette;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Ingredient;
import model.Recette;


public class VueAjouterRecette extends Scene {

    protected TextField valeurNom;
    protected TextField valeurCategorie;

    private ControleurRecette controleurRecette = null;
    protected Button actionEnregistrerRecette = null;

    public VueAjouterRecette() {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleIngredient = new GridPane();
        this.actionEnregistrerRecette = new Button("Enregistrer");

        this.actionEnregistrerRecette.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                controleurRecette.notifierEnregistrerNouvelleRecette();

            }});

        valeurNom = new TextField();
        grilleIngredient.add(new Label("Nom : "), 0, 0);
        grilleIngredient.add(valeurNom, 1, 0);

        valeurCategorie = new TextField("");
        grilleIngredient.add(new Label("Catégorie : "), 0, 1);
        grilleIngredient.add(valeurCategorie, 1, 1);

        // Todo : retirer les textes magiques
        panneau.getChildren().add(new Label("Ajouter un recette")); // Todo : cr�er un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleIngredient);
        panneau.getChildren().add(this.actionEnregistrerRecette);
    }

    public Recette demanderRecette() {
        Recette recette = new Recette(this.valeurNom.getText(), this.valeurCategorie.getText());
        return recette;
    }

    public void setControleur(ControleurRecette controleur) {
        this.controleurRecette = controleur;
    }
}
