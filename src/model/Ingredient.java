package model;

public class Ingredient {

    protected int id_ingredient;
    protected  String nom_ingredient;


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

    public String getNom_ingredient() {
        return nom_ingredient;
    }

    public void setNom_ingredient(String nom_ingredient) {
        this.nom_ingredient = nom_ingredient;
    }
}
