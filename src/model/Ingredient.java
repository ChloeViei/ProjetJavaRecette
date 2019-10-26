package model;

public class Ingredient {

    protected int id_ingredient;
    protected  String nom_ingredient;
    protected String categorie_ingredient;


    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id) {
        this.id_ingredient = id;
    }

    public Ingredient(String nom) {
        super();
        this.nom_ingredient = nom;
    }

    public Ingredient(String nom, String categorie) {
        super();
        this.nom_ingredient = nom;
        this.categorie_ingredient = categorie;
    }

    public String getNom_ingredient() {
        return nom_ingredient;
    }

    public void setNom_ingredient(String nom_ingredient) {
        this.nom_ingredient = nom_ingredient;
    }

    public String getCategorie_ingredient() {
        return categorie_ingredient;
    }

    public void setCategorie_ingredient(String categorie_ingredient) {
        this.categorie_ingredient = categorie_ingredient;
    }
}
