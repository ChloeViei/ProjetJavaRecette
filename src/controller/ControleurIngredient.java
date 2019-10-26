package controller;

import data.IngredientDAO;
import model.Ingredient;
import view.NavigateurVues;
import view.Ingredient.VueIngredient;
import view.Ingredient.VueListeIngredient;

public class ControleurIngredient {

    private NavigateurVues navigateurVues;
    private VueListeIngredient vueListeIngredient = null;
    private VueIngredient vueIngredient = null;
    private IngredientDAO ingredientDAO = null;

    private ControleurIngredient() {
        System.out.println("Initialisation du controleur ingredient");
        this.ingredientDAO = new IngredientDAO();
    }

    public void activerVues(NavigateurVues navigateur) {
        this.navigateurVues = navigateur;
        this.vueIngredient = navigateurVues.getVueIngredient();
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
        this.ingredientDAO.(mouton);
        this.vueListeMouton.afficherListeMouton(this.moutonDAO.listerMoutons()); // TODO optimiser
        this.navigateur.naviguerVersVueListeMouton();
    }

}
