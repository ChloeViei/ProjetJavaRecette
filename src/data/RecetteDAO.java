package data;

import model.Recette;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAO implements RecetteSQL {

    private Connection connexion = null;

    public RecetteDAO() {
        System.out.println("Connexion à la base de donnée PHPmyadmin");
        this.connexion = BaseDeDonnees.getInstance().getConnexion();
    }

    public List<Recette> listerRecette() {

        List<Recette> listeRecettes = new ArrayList<Recette>();
        Statement requeteListeRecettes;

        try {
            requeteListeRecettes = connexion.createStatement();
            ResultSet curseurListeRecettes = requeteListeRecettes.executeQuery(RecetteSQL.SQL_LISTER_RECETTES);

            while (curseurListeRecettes.next()){
                int id_recette = curseurListeRecettes.getInt("id_recette");
                String nom_recette = curseurListeRecettes.getString("nom_recette");

                System.out.println("Recette " + nom_recette);
                Recette recette = new Recette(nom_recette);
                recette.setId_recette(id_recette);
                listeRecettes.add(recette);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeRecettes;
    }

    public void ajouterRecette(Recette recette)
    {
        System.out.println("RecetteDAO.ajouterRecette()");
        try {
            PreparedStatement requeteAjouterRecette = connexion.prepareStatement(SQL_AJOUTER_RECETTE);
            requeteAjouterRecette.setString(1, recette.getNom_recette());
            requeteAjouterRecette.setString(2, recette.getDescription_recette());

            System.out.println("SQL : " + SQL_AJOUTER_RECETTE);
            requeteAjouterRecette.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierRecette(Recette recette)
    {
        System.out.println("RecetteDAO.modifierRecette()");
        try {
            PreparedStatement requeteModifierRecette = connexion.prepareStatement(SQL_MODIFIER_RECETTE);
            requeteModifierRecette.setString(1, recette.getNom_recette());
            requeteModifierRecette.setString(2, recette.getDescription_recette());
            requeteModifierRecette.setInt(3, recette.getId_recette());

            System.out.println("SQL : " + SQL_MODIFIER_RECETTE);
            requeteModifierRecette.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Recette rapporterRecette(int idRecette) {
        PreparedStatement requeteRecette;

        try {
            requeteRecette = connexion.prepareStatement(SQL_RAPPORTER_RECETTE);
            requeteRecette.setInt(1, idRecette);
            System.out.println(SQL_RAPPORTER_RECETTE);

            ResultSet curseurRecette = requeteRecette.executeQuery();
            curseurRecette.next();

            int id = curseurRecette.getInt("id_recette");
            String nomRecette = curseurRecette.getString("nom_recette");
            String descriptionRecette = curseurRecette.getString("description_recette");
            System.out.println("Recette : " + nomRecette + " description : " + descriptionRecette);
            Recette recette = new Recette(nomRecette, descriptionRecette);
            recette.setId_recette(id);
            return recette;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
