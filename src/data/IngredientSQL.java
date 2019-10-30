package data;

public interface IngredientSQL {

    public static final String SQL_LISTER_INGREDIENTS = "SELECT * FROM ingredient";
    public static final String SQL_AJOUTER_INGREDIENT = "INSERT INTO ingredient(nom_ingredient, categorie_ingredient, prix_ingredient, quantite_ingredient) VALUES(?, ?, ?, ?)";
    public static final String SQL_MODIFIER_INGREDIENT = "UPDATE ingredient SET nom_ingredient = ?, categorie_ingredient = ?, prix_ingredient = ?, quantite_ingredient = ? WHERE id_ingredient = ?";
    public static final String SQL_RAPPORTER_INGREDIENT = "SELECT * FROM ingredient WHERE id_ingredient = ?";

}
