package view.Recette;

import controller.ControleurIngredient;
import controller.ControleurRecette;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Ingredient;
import model.Recette;

public class VueRecette extends Scene {

    protected Label valeurNom;
    protected Label valeurCategorie;

    private ControleurRecette controleurRecette = null;

    public VueRecette() {
        super(new GridPane(), 400, 400);
        GridPane grilleRecette = (GridPane) this.getRoot();

        valeurNom = new Label("");
        grilleRecette.add(new Label("Nom : "), 0, 0);
        grilleRecette.add(valeurNom, 1, 0);
    }

    public void afficherRecette(Recette recette) {
        this.valeurNom.setText(recette.getNom_recette());
        this.valeurCategorie.setText(recette.getDescription_recette());
    }

    public void setControleur(ControleurRecette controleur) {
        this.controleurRecette = controleur;
    }

}
