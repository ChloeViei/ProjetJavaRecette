package view;

import controller.ControleurIngredient;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.Ingredient.VueAjouterIngredient;
import view.Ingredient.VueEditerIngredient;
import view.Ingredient.VueIngredient;
import view.Ingredient.VueListeIngredient;

public class NavigateurVues extends Application {

    private Stage fenetre;
    private BorderPane rootLayout;

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
