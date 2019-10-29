package model;

public class Recette {

    protected int id_recette;
    protected  String nom_recette;
    protected String description_recette;


    public int getId_recette() {
        return id_recette;
    }

    public void setId_recette(int id) {
        this.id_recette = id;
    }

    public Recette(String nom) {
        super();
        this.nom_recette = nom;
    }

    public Recette(String nom, String description) {
        super();
        this.nom_recette = nom;
        this.description_recette = description;
    }

    public String getNom_recette() {
        return nom_recette;
    }

    public void setNom_recette(String nom_recette) {
        this.nom_recette = nom_recette;
    }

    public String getDescription_recette() {
        return description_recette;
    }

    public void setDescription_recette(String description_recette) {
        this.description_recette = description_recette;
    }
}
