package view.Ingredient;

import controller.ControleurIngredient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Ingredient;


public class VueAjouterIngredient extends Scene {

    protected TextField valeurNom;
    protected TextField valeurCategorie;

    private ControleurIngredient controleurIngredient = null;
    protected Button actionEnregistrerIngredient = null;

    public VueAjouterIngredient() {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleIngredient = new GridPane();
        this.actionEnregistrerIngredient = new Button("Enregistrer");

        this.actionEnregistrerIngredient.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                controleurIngredient.notifierEnregistrerNouveauIngredient();

            }});

        valeurNom = new TextField();
        grilleIngredient.add(new Label("Nom : "), 0, 0);
        grilleIngredient.add(valeurNom, 1, 0);

        valeurCategorie = new TextField("");
        grilleIngredient.add(new Label("Catégorie : "), 0, 1);
        grilleIngredient.add(valeurCategorie, 1, 1);

        // Todo : retirer les textes magiques
        panneau.getChildren().add(new Label("Ajouter un ingrédient")); // Todo : cr�er un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleIngredient);
        panneau.getChildren().add(this.actionEnregistrerIngredient);
    }

    public Ingredient demanderIngredient() {
        Ingredient ingredient = new Ingredient(this.valeurNom.getText(), this.valeurCategorie.getText());
        return ingredient;
    }

    public void setControleur(ControleurIngredient controleur) {
        this.controleurIngredient = controleur;
    }
}
