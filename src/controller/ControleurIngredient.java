package controller;

import data.IngredientDAO;
import model.Ingredient;
import view.Ingredient.VueAjouterIngredient;
import view.Ingredient.VueEditerIngredient;
import view.NavigateurVues;
import view.Ingredient.VueIngredient;
import view.Ingredient.VueListeIngredient;

import java.util.List;

public class ControleurIngredient {

    private NavigateurVues navigateurVues;
    private VueListeIngredient vueListeIngredient = null;
    private VueIngredient vueIngredient = null;
    private VueAjouterIngredient vueAjouterIngredient = null;
    private VueEditerIngredient vueEditerIngredient = null;
    private IngredientDAO ingredientDAO = null;

    private ControleurIngredient() {
        System.out.println("Initialisation du controleur ingredient");
        this.ingredientDAO = new IngredientDAO();
    }

    public void activerVues(NavigateurVues navigateur) {
        this.navigateurVues = navigateur;
        this.vueListeIngredient = navigateur.getVueListeIngredient();
        this.vueIngredient = navigateur.getVueIngredient();
        this.vueAjouterIngredient = navigateur.getVueAjouterIngredient();
        this.vueEditerIngredient = navigateur.getVueEditerIngredient();

        this.navigateurVues.naviguerVersVueListeIngredient();


//        //// TEST ////
//        Ingredient ingredient = new Ingredient("Pomme", "Fruit");
//        this.vueIngredient.afficherIngredient(ingredient); // Appel de ma fonction avant de la programmer (pour tester � mesure)
//
//        this.navigateurVues.naviguerVersVueIngredient();

//        /// TEST ///
//        List<Ingredient> listeIngredientTest = ingredientDAO.listerIngredient();
//        this.vueListeIngredient.afficherListeIngredient(listeIngredientTest); // Appel de ma fonction avant de la programmer (pour tester � mesure)
//
//        this.navigateurVues.naviguerVersVueListeIngredient();
    }


    // Singleton
    private static ControleurIngredient instance = null;

    public static ControleurIngredient getInstance() {
        if (null == instance) {
            instance = new ControleurIngredient();
        }
        return instance;
    }
    // fin singleton


    public void notifierEnregistrerNouveauIngredient()
    {
        System.out.println("ControleurIngredient.notifierEnregistrerNouveauIngredient()");
        Ingredient ingredient = this.navigateurVues.getVueAjouterIngredient().demanderIngredient();
        this.ingredientDAO.ajouterIngredient(ingredient);
        this.vueListeIngredient.afficherListeIngredient(this.ingredientDAO.listerIngredient()); // TODO optimiser
        this.navigateurVues.naviguerVersVueListeIngredient();
    }

    public void notifierEnregistrerIngredient()
    {
        System.out.println("ControleurIngredient.notifierEnregistrerIngredient()");
        Ingredient ingredient = this.navigateurVues.getVueEditerIngredient().demanderIngredient();
        this.ingredientDAO.modifierIngredient(ingredient);
        this.vueListeIngredient.afficherListeIngredient(this.ingredientDAO.listerIngredient()); // TODO optimiser
        this.navigateurVues.naviguerVersVueListeIngredient();
    }

    public void notifierNaviguerAjouterIngredient() {
        System.out.println("ControleurIngredient.notifierNaviguerAjouterIngredient()");
        this.navigateurVues.naviguerVersVueAjouterIngredient();
    }

    public void notifierNaviguerEditerIngredient(int idIngredient) {
        System.out.println("ControleurIngredient.notifierNaviguerEditerIngredient(" + idIngredient + ")");
        // récuperation des informations du mouton selectionner
        this.vueEditerIngredient.afficherIngredient(this.ingredientDAO.rapporterIngredient(idIngredient));
        this.navigateurVues.naviguerVersVueEditerIngredient();
    }
}
