package view;

import controller.ControleurIngredient;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.Ingredient.VueAjouterIngredient;
import view.Ingredient.VueEditerIngredient;
import view.Ingredient.VueIngredient;
import view.Ingredient.VueListeIngredient;

public class NavigateurVues extends Application {

    private Stage fenetre;
    private BorderPane menu;

    private VueListeIngredient vueListeIngredient = null;
    private VueIngredient vueIngredient = null;
    private VueAjouterIngredient vueAjouterIngredient = null;
    private VueEditerIngredient vueEditerIngredient = null;

    private ControleurIngredient controleurIngredient = null;

    public NavigateurVues() {
        this.vueListeIngredient = new VueListeIngredient();
        this.vueIngredient = new VueIngredient();
        this.vueAjouterIngredient = new VueAjouterIngredient();
        this.vueEditerIngredient = new VueEditerIngredient();
    }

    @Override
    public void start(Stage fenetre) throws Exception {
        this.fenetre = fenetre;
        this.fenetre.setTitle("Projet Recette");

//        // Création d'un bar de menu pour selectionner l'affichage de la fenetre
//        Menu menuIngredient = new Menu("Ingrédient");
//        Menu menuRecette = new Menu("Recette");
//        Menu menuListeCourse = new Menu("Liste course");
//        MenuBar menuBar = new MenuBar();
//        menuBar.getMenus().addAll(menuIngredient, menuRecette, menuListeCourse);
//        VBox vBox = new VBox(menuBar);
//        Scene scene = new Scene(vBox, 500, 500);
//
//        this.fenetre.setScene(scene);
//        this.fenetre.show();

        this.fenetre.setScene(null);
        this.fenetre.show();

        this.controleurIngredient = ControleurIngredient.getInstance();
        this.controleurIngredient.activerVues(this);
        this.vueListeIngredient.setControleurIngredient(controleurIngredient);
        this.vueIngredient.setControleur(controleurIngredient);
        this.vueAjouterIngredient.setControleur(controleurIngredient);
        this.vueEditerIngredient.setControleur(controleurIngredient);
    }

    public VueListeIngredient getVueListeIngredient() {
        return vueListeIngredient;
    }

    public VueIngredient getVueIngredient() {
        return vueIngredient;
    }

    public VueAjouterIngredient getVueAjouterIngredient() {
        return vueAjouterIngredient;
    }

    public VueEditerIngredient getVueEditerIngredient() {
        return vueEditerIngredient;
    }

    public void naviguerVersVueListeIngredient() {
        fenetre.setScene(this.vueListeIngredient);
        fenetre.show();
    }

    public void naviguerVersVueIngredient() {
        fenetre.setScene(this.vueIngredient);
        fenetre.show();
    }

    public void naviguerVersVueAjouterIngredient() {
        fenetre.setScene(this.vueAjouterIngredient);
        fenetre.show();
    }

    public void naviguerVersVueEditerIngredient() {
        fenetre.setScene(this.vueEditerIngredient);
        fenetre.show();
    }
}
