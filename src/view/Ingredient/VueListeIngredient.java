package view.Ingredient;

import controller.ControleurIngredient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Ingredient;

import java.util.List;

public class VueListeIngredient extends Scene {

    protected BorderPane borderPane;
    protected GridPane grilleIngredient;

    private ControleurIngredient controleurIngredient = null;

    private Button actionNaviguerAjouterIngredient;

    public VueListeIngredient() {
        super(new BorderPane(), 400, 400);

        // Création d'un bar de menu pour selectionner l'affichage de la fenetre
        Menu menuIngredient = new Menu("Ingrédient");
        Menu menuRecette = new Menu("Recette");
        Menu menuListeCourse = new Menu("Liste course");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuIngredient, menuRecette, menuListeCourse);
        VBox vBox = new VBox(menuBar);

        this.borderPane = (BorderPane) this.getRoot();
        this.borderPane.setTop(vBox);

        this.actionNaviguerAjouterIngredient = new Button("Ajouter un ingrédient");
    }

    public void afficherListeIngredient(List<Ingredient> listeIngredients) {
        this.grilleIngredient = new GridPane();

        int numero = 1;
        this.grilleIngredient.add(new Label("Nom"), 0, numero);

        for (Ingredient ingredient : listeIngredients) {
            Button actionEditerIngredient = new Button("Editer");
            actionEditerIngredient.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controleurIngredient.notifierNaviguerEditerIngredient(ingredient.getId_ingredient());
                }
            });

            numero ++;

            this.grilleIngredient.add(new Label(ingredient.getNom_ingredient()), 0, numero);
            this.grilleIngredient.add(actionEditerIngredient, 1, numero);
        }

        this.actionNaviguerAjouterIngredient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controleurIngredient.notifierNaviguerAjouterIngredient();
            }
        });

        this.grilleIngredient.add(this.actionNaviguerAjouterIngredient, 1, ++numero);

        borderPane.setCenter(grilleIngredient);
    }

    public void setControleurIngredient(ControleurIngredient controleurIngredient) {
        this.controleurIngredient = controleurIngredient;
    }
}
