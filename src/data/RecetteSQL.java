package data;

public interface RecetteSQL {

    public static final String SQL_LISTER_RECETTES = "SELECT * FROM recette";
    public static final String SQL_AJOUTER_RECETTE = "INSERT INTO recette(nom_recette, description_recette, etape_recette, temps_preparation, nombre_personne, diffuculte_recette) VALUES(?, ?, ?, ?, ?, ?)";
    public static final String SQL_MODIFIER_RECETTE = "UPDATE recette SET nom_recette = ?, description_recette = ?, etape_recette = ?, temps_preparation = ?, nombre_personne = ?, difficulte_recette = ? WHERE id_recette = ?";
    public static final String SQL_RAPPORTER_RECETTE = "SELECT * FROM recette WHERE id_recette = ?";

}
