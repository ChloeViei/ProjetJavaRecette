package controller;

import data.IngredientDAO;
import view.NavigateurVues;
import view.VueIngredient;
import view.VueListeIngredient;

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

}
