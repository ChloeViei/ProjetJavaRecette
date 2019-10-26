package view.Ingredient;

import controller.ControleurIngredient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import model.Ingredient;


public class VueEditerIngredient extends Scene {

    protected TextField valeurNom;
    protected TextField valeurCategorie;

    private ControleurIngredient controleurIngredient = null;
    protected Button actionEnregistrerIngredient = null;

    private int idIngredient = 0;

    public VueEditerIngredient()  {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleIngredient = new GridPane();

        this.actionEnregistrerIngredient = new Button("Enregistrer");

        this.actionEnregistrerIngredient
                .setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                controleurIngredient.notifierEnregistrerIngredient();

            }});

        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
        valeurNom = new TextField();
        grilleIngredient.add(new Label("Nom : "), 0, 0);
        grilleIngredient.add(valeurNom, 1, 0);

        valeurCategorie = new TextField("");
        grilleIngredient.add(new Label("Catégorie : "), 0, 1);
        grilleIngredient.add(valeurCategorie, 1, 1);

        // Todo : retirer les textes magiques
        panneau.getChildren().add(new Label("Editer un ingrédient")); // Todo : cr�er un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleIngredient);
        panneau.getChildren().add(this.actionEnregistrerIngredient);
    }

    public void afficherIngredient(Ingredient ingredient)
    {
        this.idIngredient = ingredient.getId_ingredient();
        this.valeurNom.setText(ingredient.getNom_ingredient());
        this.valeurCategorie.setText(ingredient.getCategorie_ingredient());
    }

    public Ingredient demanderIngredient()
    {
        Ingredient ingredient = new Ingredient(this.valeurNom.getText(), this.valeurCategorie.getText());
        ingredient.setId_ingredient(idIngredient);
        return ingredient;
    }

    public void setControleur(ControleurIngredient controleur) {
        this.controleurIngredient = controleur;
    }
}
