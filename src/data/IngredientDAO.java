package data;

import model.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO implements IngredientSQL {

    private Connection connexion = null;

    public IngredientDAO() {
        System.out.println("Connexion à la base de donnée PHPmyadmin");
        this.connexion = BaseDeDonnees.getInstance().getConnexion();
    }

    public List<Ingredient> listerIngredient() {

        List<Ingredient> listeIngredients = new ArrayList<Ingredient>();
        Statement requeteListeIngredients;

        try {
            requeteListeIngredients = connexion.createStatement();
            ResultSet curseurListeIngredients = requeteListeIngredients.executeQuery(IngredientSQL.SQL_LISTER_INGREDIENTS);

            while (curseurListeIngredients.next()){
                int id_ingredient = curseurListeIngredients.getInt("id_ingredient");
                String nom_ingredient = curseurListeIngredients.getString("nom_ingredient");

                System.out.println("Ingredient " + nom_ingredient);
                Ingredient ingredient = new Ingredient(nom_ingredient);
                ingredient.setId_ingredient(id_ingredient);
                listeIngredients.add(ingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeIngredients;
    }

    public void ajouterIngredient(Ingredient ingredient)
    {
        System.out.println("IngredientDAO.ajouterIngredient()");
        try {
            PreparedStatement requeteAjouterIngredient = connexion.prepareStatement(SQL_AJOUTER_INGREDIENT);
            requeteAjouterIngredient.setString(1, ingredient.getNom_ingredient());
            requeteAjouterIngredient.setString(2, ingredient.getCategorie_ingredient());
            requeteAjouterIngredient.setDouble(3, ingredient.getPrix_ingredient());
            requeteAjouterIngredient.setDouble(4, ingredient.getQuantite_ingredient());

            System.out.println("SQL : " + SQL_AJOUTER_INGREDIENT);
            requeteAjouterIngredient.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierIngredient(Ingredient ingredient)
    {
        System.out.println("IngredientDAO.modifierIngredient()");
        try {
            PreparedStatement requeteModifierIngredient = connexion.prepareStatement(SQL_MODIFIER_INGREDIENT);
            requeteModifierIngredient.setString(1, ingredient.getNom_ingredient());
            requeteModifierIngredient.setString(2, ingredient.getCategorie_ingredient());
            requeteModifierIngredient.setDouble(3, ingredient.getPrix_ingredient());
            requeteModifierIngredient.setDouble(4, ingredient.getQuantite_ingredient());
            requeteModifierIngredient.setInt(5, ingredient.getId_ingredient());

            System.out.println("SQL : " + SQL_MODIFIER_INGREDIENT);
            requeteModifierIngredient.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ingredient rapporterIngredient(int idIngredient) {
        PreparedStatement requeteIngredient;

        try {
            requeteIngredient = connexion.prepareStatement(SQL_RAPPORTER_INGREDIENT);
            requeteIngredient.setInt(1, idIngredient);
            System.out.println(SQL_RAPPORTER_INGREDIENT);

            ResultSet curseurIngredient = requeteIngredient.executeQuery();
            curseurIngredient.next();

            int id = curseurIngredient.getInt("id_ingredient");
            String nomIngredient = curseurIngredient.getString("nom_ingredient");
            String categorieIngredient = curseurIngredient.getString("categorie_ingredient");
            double prixIngredient = curseurIngredient.getDouble("prix_ingredient");
            double quantiteIngredient = curseurIngredient.getDouble("quantite_ingredient");
            System.out.println("Ingredient : " + nomIngredient + " categorie : " + categorieIngredient + " prix :" + prixIngredient + " quantite : " + quantiteIngredient);
            Ingredient ingredient = new Ingredient(nomIngredient, categorieIngredient, prixIngredient, quantiteIngredient);
            ingredient.setId_ingredient(id);
            return ingredient;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
