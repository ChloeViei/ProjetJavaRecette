package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Aliment;
import model.Ingredient;

import java.sql.*;

public class AlimentDAO implements IngredientSQL {

    private Connection connexion = null;

    public AlimentDAO() {
        System.out.println("Connexion à la base de donnée PHPmyadmin");
        this.connexion = BaseDeDonnees.getInstance().getConnexion();
    }

    public ObservableList<Aliment> listerAliment() {

        ObservableList<Aliment> listeAliments = FXCollections.observableArrayList();
        Statement requeteListeAliments;

        try {
            requeteListeAliments = connexion.createStatement();
            ResultSet curseurListeAliments = requeteListeAliments.executeQuery(IngredientSQL.SQL_LISTER_INGREDIENTS);

            while (curseurListeAliments.next()){
                int id_aliment = curseurListeAliments.getInt("id_ingredient");
                String nom_aliment = curseurListeAliments.getString("nom_ingredient");
                String categorie_aliment = curseurListeAliments.getString("categorie_ingredient");
                int prix_aliment = curseurListeAliments.getInt("prix_ingredient");
                int quantite_aliment = curseurListeAliments.getInt("quantite_ingredient");

                // Generate aliment
                Aliment ali = new Aliment();
                ali.setIdAliment(id_aliment);
                ali.setNomAliment(nom_aliment);
                ali.setCategorieAliment(categorie_aliment);
                ali.setPrixAliment(prix_aliment);
                ali.setQuantiteAliment(quantite_aliment);

                // Ajouter l'aliment à la liste
                listeAliments.add(ali);


//                System.out.println("Ingredient (" + id_aliment + ") nom : " + nom_aliment);
//                Aliment aliment = new Aliment(id_aliment, nom_aliment, categorie_aliment, prix_aliment, quantite_aliment);
//                listeAliments.add(aliment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeAliments;
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
