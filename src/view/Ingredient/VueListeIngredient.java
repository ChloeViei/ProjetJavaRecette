package view.Ingredient;

import controller.ControleurIngredient;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Ingredient;

import java.util.List;

public class VueListeIngredient extends Scene {

    protected GridPane grilleIngredient;

    private ControleurIngredient controleurIngredient = null;

    private Button actionNaviguerAjouterIngredient;
    public VueListeIngredient() {
        super(new GridPane(), 400, 400);
        grilleIngredient = (GridPane) this.getRoot();
        this.actionNaviguerAjouterIngredient = new Button("Ajouter un ingrédient");
    }

    public void afficherListeIngredient(List<Ingredient> listeIngredients) {
        this.grilleIngredient.getChildren().clear();

        int numero = 0;
        this.grilleIngredient.add(new Label("Nom"), 0, numero);

        for (Ingredient ingredient : listeIngredients) {
            Button actionEditerIngredient = new Button("Editer");

            // TODO : action pour afficher information de l'ingredient

            numero ++;

            this.grilleIngredient.add(new Label(ingredient.getNom_ingredient()), 0, numero);
            this.grilleIngredient.add(actionEditerIngredient, 2, numero);
        }

        // TODO : faire l'ajout d'un ingredient possible depuis la liste

    }

    public void setControleurIngredient(ControleurIngredient controleurIngredient) {
        this.controleurIngredient = controleurIngredient;
    }
}
