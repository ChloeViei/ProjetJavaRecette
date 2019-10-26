package data;

import model.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO implements IngredientSQL {

    private Connection connexion = null;

    public IngredientDAO() {
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
}
