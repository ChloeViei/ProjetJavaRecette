package view;

import controller.ControleurIngredient;
import controller.ControleurRecette;
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
import view.Recette.VueAjouterRecette;
import view.Recette.VueEditerRecette;
import view.Recette.VueListeRecette;
import view.Recette.VueRecette;

public class NavigateurVues extends Application {

    private Stage fenetre;

    // Pour les ingrédients
    private VueListeIngredient vueListeIngredient = null;
    private VueIngredient vueIngredient = null;
    private VueAjouterIngredient vueAjouterIngredient = null;
    private VueEditerIngredient vueEditerIngredient = null;

    // Pour les recettes
    private VueListeRecette vueListeRecette = null;
    private VueRecette vueRecette = null;
    private VueAjouterRecette vueAjouterRecette = null;
    private VueEditerRecette vueEditerRecette = null;

    private ControleurIngredient controleurIngredient = null;
    private ControleurRecette controleurRecette = null;

    public NavigateurVues() {
        this.vueListeIngredient = new VueListeIngredient();
        this.vueIngredient = new VueIngredient();
        this.vueAjouterIngredient = new VueAjouterIngredient();
        this.vueEditerIngredient = new VueEditerIngredient();

        this.vueListeRecette = new VueListeRecette();
        this.vueRecette = new VueRecette();
        this.vueAjouterRecette = new VueAjouterRecette();
        this.vueEditerRecette = new VueEditerRecette();
    }

    @Override
    public void start(Stage fenetre) throws Exception {
        this.fenetre = fenetre;
        this.fenetre.setTitle("Projet Recette");

        this.fenetre.setScene(null);
        this.fenetre.show();

        this.controleurIngredient = ControleurIngredient.getInstance();
        this.controleurIngredient.activerVues(this);
        this.vueListeIngredient.setControleurIngredient(controleurIngredient);
        this.vueIngredient.setControleur(controleurIngredient);
        this.vueAjouterIngredient.setControleur(controleurIngredient);
        this.vueEditerIngredient.setControleur(controleurIngredient);

        this.controleurRecette = ControleurRecette.getInstance();
        this.controleurRecette.activerVues(this);
        this.vueListeRecette.setControleurRecette(controleurRecette);
        this.vueRecette.setControleur(controleurRecette);
        this.vueAjouterRecette.setControleur(controleurRecette);
        this.vueEditerRecette.setControleur(controleurRecette);
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

    public VueListeRecette getVueListeRecette() {
        return vueListeRecette;
    }

    public void setVueListeRecette(VueListeRecette vueListeRecette) {
        this.vueListeRecette = vueListeRecette;
    }

    public VueRecette getVueRecette() {
        return vueRecette;
    }

    public void setVueRecette(VueRecette vueRecette) {
        this.vueRecette = vueRecette;
    }

    public VueAjouterRecette getVueAjouterRecette() {
        return vueAjouterRecette;
    }

    public void setVueAjouterRecette(VueAjouterRecette vueAjouterRecette) {
        this.vueAjouterRecette = vueAjouterRecette;
    }

    public VueEditerRecette getVueEditerRecette() {
        return vueEditerRecette;
    }

    public void setVueEditerRecette(VueEditerRecette vueEditerRecette) {
        this.vueEditerRecette = vueEditerRecette;
    }


    /// Liste méthode pour le changement de page

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

    public void naviguerVersVueListeRecette() {
        fenetre.setScene(this.vueListeRecette);
        fenetre.show();
    }

    public void naviguerVersVueRecette() {
        fenetre.setScene(this.vueRecette);
        fenetre.show();
    }

    public void naviguerVersVueAjouterRecette() {
        fenetre.setScene(this.vueAjouterRecette);
        fenetre.show();
    }

    public void naviguerVersVueEditerRecette() {
        fenetre.setScene(this.vueEditerRecette);
        fenetre.show();
    }
}
