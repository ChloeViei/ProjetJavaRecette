package view.Recette;

import controller.ControleurIngredient;
import controller.ControleurRecette;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Ingredient;
import model.Recette;


public class VueEditerRecette extends Scene {

    protected TextField valeurNom;
    protected TextField valeurDescription;
    protected TextField valeurEtape;
    protected TextField valeurTemps;
    protected TextField valeurNombrePersonne;
    protected TextField valeurDifficulte;

    private ControleurRecette controleurRecette = null;
    protected Button actionEnregistrerRecette = null;

    private int idRecette = 0;

    public VueEditerRecette()  {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleRecette = new GridPane();

        this.actionEnregistrerRecette = new Button("Enregistrer");

        this.actionEnregistrerRecette
                .setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                controleurRecette.notifierEnregistrerRecette();

            }});


        valeurNom = new TextField();
        grilleRecette.add(new Label("Nom : "), 0, 0);
        grilleRecette.add(valeurNom, 1, 0);

        valeurDescription = new TextField("");
        grilleRecette.add(new Label("Description : "), 0, 1);
        grilleRecette.add(valeurDescription, 1, 1);

        valeurEtape = new TextField("");
        grilleRecette.add(new Label("Etapes de la recette  : "), 0, 2);
        grilleRecette.add(valeurEtape, 1, 2);

        // TODO : faire une selection de int grâce à un spinner


        panneau.getChildren().add(new Label("Editer une recette")); // Todo : cr�er un sous-type de Label ou Text pour les titres
        panneau.getChildren().add(grilleRecette);
        panneau.getChildren().add(this.actionEnregistrerRecette);
    }

    public void afficherRecette(Recette recette)
    {
        this.idRecette = recette.getId_recette();
        this.valeurNom.setText(recette.getNom_recette());
        this.valeurDescription.setText(recette.getDescription_recette());
        this.valeurEtape.setText(recette.getEtape_recette());
    }

    public Recette demanderRecette()
    {
        Recette recette = new Recette(this.valeurNom.getText(), this.valeurDescription.getText(), this.valeurEtape.getText());
        recette.setId_recette(idRecette);
        return recette;
    }

    public void setControleur(ControleurRecette controleur) {
        this.controleurRecette = controleur;
    }
}
