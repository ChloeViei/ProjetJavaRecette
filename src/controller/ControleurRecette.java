package controller;

import data.IngredientDAO;
import data.RecetteDAO;
import model.Ingredient;
import model.Recette;
import view.Ingredient.VueAjouterIngredient;
import view.Ingredient.VueEditerIngredient;
import view.Ingredient.VueIngredient;
import view.Ingredient.VueListeIngredient;
import view.NavigateurVues;
import view.Recette.VueAjouterRecette;
import view.Recette.VueEditerRecette;
import view.Recette.VueListeRecette;
import view.Recette.VueRecette;

import java.util.List;

public class ControleurRecette {

    private NavigateurVues navigateurVues;
    private VueListeRecette vueListeRecette = null;
    private VueRecette vueRecette = null;
    private VueAjouterRecette vueAjouterRecette = null;
    private VueEditerRecette vueEditerRecette = null;
    private RecetteDAO recetteDAO = null;

    private ControleurRecette() {
        System.out.println("Initialisation du controleur recette");
        this.recetteDAO = new RecetteDAO();
    }

    public void activerVues(NavigateurVues navigateur) {

        this.navigateurVues = navigateur;
        this.vueListeRecette = navigateur.getVueListeRecette();
        this.vueRecette = navigateur.getVueRecette();
        this.vueAjouterRecette = navigateur.getVueAjouterRecette();
        this.vueEditerRecette = navigateur.getVueEditerRecette();

//        this.navigateurVues.naviguerVersVueListeIngredient();



//        /// TEST ///
//        List<Recette> listeRecetteTest = recetteDAO.listerRecette();
//        this.vueListeRecette.afficherListeRecette(listeRecetteTest); // Appel de ma fonction avant de la programmer (pour tester)
//
//        this.navigateurVues.naviguerVersVueListeRecette();
    }


    // Singleton
    private static ControleurRecette instance = null;

    public static ControleurRecette getInstance() {
        if (null == instance) {
            instance = new ControleurRecette();
        }
        return instance;
    }
    // fin singleton


    public void notifierEnregistrerNouvelleRecette()
    {
        System.out.println("ControleurRecette.notifierEnregistrerNouvelleRecette()");
        Recette recette = this.navigateurVues.getVueAjouterRecette().demanderRecette();
        this.recetteDAO.ajouterRecette(recette);
        this.vueListeRecette.afficherListeRecette(this.recetteDAO.listerRecette()); // TODO optimiser
        this.navigateurVues.naviguerVersVueListeRecette();
    }

    public void notifierEnregistrerRecette()
    {
        System.out.println("ControleurRecette.notifierEnregistrerRecette()");
        Recette recette = this.navigateurVues.getVueEditerRecette().demanderRecette();
        this.recetteDAO.modifierRecette(recette);
        this.vueListeRecette.afficherListeRecette(this.recetteDAO.listerRecette()); // TODO optimiser
        this.navigateurVues.naviguerVersVueListeRecette();
    }

    public void notifierNaviguerAjouterRecette() {
        System.out.println("ControleurRecette.notifierNaviguerAjouterRecette()");
        this.navigateurVues.naviguerVersVueAjouterRecette();
    }

    public void notifierNaviguerEditerRecette(int idRecette) {
        System.out.println("ControleurRecette.notifierNaviguerEditerRecette(" + idRecette + ")");
        // récuperation des informations du mouton selectionner
        this.vueEditerRecette.afficherRecette(this.recetteDAO.rapporterRecette(idRecette));
        this.navigateurVues.naviguerVersVueEditerRecette();
    }
}
