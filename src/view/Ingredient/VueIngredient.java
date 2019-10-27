package view.Ingredient;

import controller.ControleurIngredient;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Ingredient;

public class VueIngredient extends Scene {

    protected Label valeurNom;
    protected Label valeurCategorie;

    private ControleurIngredient controleurIngredient = null;

    public VueIngredient() {
        super(new GridPane(), 400, 400);
        GridPane grilleMouton = (GridPane) this.getRoot();

        valeurNom = new Label("");
        grilleMouton.add(new Label("Nom : "), 0, 0);
        grilleMouton.add(valeurNom, 1, 0);

        valeurCategorie = new Label("");
        grilleMouton.add(new Label("Catégorie : "), 0, 1);
        grilleMouton.add(valeurCategorie, 1, 1);
    }

    public void afficherIngredient(Ingredient ingredient) {
        this.valeurNom.setText(ingredient.getNom_ingredient());
        this.valeurCategorie.setText(ingredient.getCategorie_ingredient());
    }

    public void setControleur(ControleurIngredient controleur) {
        this.controleurIngredient = controleur;
    }

}
