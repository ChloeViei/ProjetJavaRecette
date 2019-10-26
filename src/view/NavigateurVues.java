package view;

import controller.ControleurIngredient;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVues extends Application {

    private Stage fenetre;

    private VueListeIngredient vueListeIngredient = null;

    private ControleurIngredient controleurIngredient = null;

    public NavigateurVues() {
        this.vueListeIngredient = new VueListeIngredient();
    }

    @Override
    public void start(Stage fenetre) throws Exception {
        this.fenetre = fenetre;

        this.fenetre.setScene(null);
        this.fenetre.show();

        this.controleurIngredient = ControleurIngredient.getInstance();
        this.controleurIngredient.activerVues(this);
        this.vueListeIngredient.setControleurIngredient(controleurIngredient);

        // TODO : Ajouter les autres fonctionnalité possible a faire sur un ingredient
    }

    public VueListeIngredient getVueListeIngredient() {
        return vueListeIngredient;
    }

    public void naviguerVersVueListeIngredient() {
        fenetre.setScene(this.vueListeIngredient);
        fenetre.show();
    }
}
