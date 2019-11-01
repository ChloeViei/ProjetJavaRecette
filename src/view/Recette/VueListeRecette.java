package view.Recette;

import controller.ControleurRecette;
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
import model.Recette;

import java.util.List;

public class VueListeRecette extends Scene {

    protected BorderPane borderPane;
    protected GridPane grilleRecette;

    private ControleurRecette controleurRecette = null;

    private Button actionNaviguerAjouterRecette;

    public VueListeRecette() {
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

        this.actionNaviguerAjouterRecette = new Button("Ajouter une recette");
    }

    public void afficherListeRecette(List<Recette> listeRecettes) {
        this.grilleRecette = new GridPane();

        int numero = 1;
        this.grilleRecette.add(new Label("Nom"), 0, numero);

        for (Recette recette : listeRecettes) {
            Button actionEditerRecette = new Button("Editer");
            actionEditerRecette.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controleurRecette.notifierNaviguerEditerRecette(recette.getId_recette());
                }
            });

            numero ++;

            this.grilleRecette.add(new Label(recette.getNom_recette()), 0, numero);
            this.grilleRecette.add(actionEditerRecette, 1, numero);
        }

        this.actionNaviguerAjouterRecette.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controleurRecette.notifierNaviguerAjouterRecette();
            }
        });

        this.grilleRecette.add(this.actionNaviguerAjouterRecette, 1, ++numero);

        borderPane.setCenter(grilleRecette);
    }

    public void setControleurRecette(ControleurRecette controleurRecette) {
        this.controleurRecette = controleurRecette;
    }
}
