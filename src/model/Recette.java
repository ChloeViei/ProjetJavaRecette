package model;

public class Recette {

    protected int id_recette;
    protected  String nom_recette;
    protected String description_recette;
    protected String etape_recette;
    protected int temps_preparation;
    protected int nombre_personne;
    protected int difficulte_recette;


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

    public Recette(String nom, int difficulte) {
        super();
        this.nom_recette = nom;
        this.difficulte_recette = difficulte;
    }

    public Recette(String nom, String description, String etape_recette) {
        super();
        this.nom_recette = nom;
        this.description_recette = description;
        this.etape_recette = etape_recette;
    }

    public Recette(String nom, String description, String etape_recette, int temps_preparation) {
        super();
        this.nom_recette = nom;
        this.description_recette = description;
        this.etape_recette = etape_recette;
        this.temps_preparation = temps_preparation;
    }

    public Recette(String nom, String description, String etape_recette, int temps_preparation, int nombre) {
        super();
        this.nom_recette = nom;
        this.description_recette = description;
        this.etape_recette = etape_recette;
        this.temps_preparation = temps_preparation;
        this.nombre_personne = nombre;
    }

    public Recette(String nom, String description, String etape_recette, int temps_preparation, int nombre, int difficulte) {
        super();
        this.nom_recette = nom;
        this.description_recette = description;
        this.etape_recette = etape_recette;
        this.temps_preparation = temps_preparation;
        this.nombre_personne = nombre;
        this.difficulte_recette = difficulte;
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

    public String getEtape_recette() {
        return etape_recette;
    }

    public void setEtape_recette(String etape_recette) {
        this.etape_recette = etape_recette;
    }

    public int getTemps_preparation() {
        return temps_preparation;
    }

    public void setTemps_preparation(int temps_preparation) {
        this.temps_preparation = temps_preparation;
    }

    public int getNombre_personne() {
        return nombre_personne;
    }

    public void setNombre_personne(int nombre_personne) {
        this.nombre_personne = nombre_personne;
    }

    public int getDifficulte_recette() {
        return difficulte_recette;
    }

    public void setDifficulte_recette(int difficulte_recette) {
        this.difficulte_recette = difficulte_recette;
    }
}
