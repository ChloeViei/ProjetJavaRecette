package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aliment {

    private IntegerProperty idAliment;
    private StringProperty nomAliment;
    private StringProperty categorieAliment;
    private IntegerProperty prixAliment;
    private IntegerProperty quantiteAliment;


    public Aliment() {
        this.idAliment = new SimpleIntegerProperty();
        this.nomAliment = new SimpleStringProperty();
        this.categorieAliment = new SimpleStringProperty();
        this.prixAliment = new SimpleIntegerProperty();
        this.quantiteAliment = new SimpleIntegerProperty();
    }

    public Aliment(int id, String nom, String categorie, int prix, int quantite) {
        setIdAliment(id);
        setNomAliment(nom);
        setCategorieAliment(categorie);
        setPrixAliment(prix);
        setQuantiteAliment(quantite);
    }


//    public Aliment(String nom) {
//        super();
//        this.nomAliment = new SimpleStringProperty(nom);
//
//        // Some initial dummy data, just for convenient testing.
//        this.categorieAliment = new SimpleStringProperty("céréale");
//        this.prixAliment = new SimpleIntegerProperty(0);
//        this.quantiteAliment = new SimpleIntegerProperty(100);
//    }


//    public Aliment(String nom, String categorie) {
//        super();
//        this.nomAliment = new SimpleStringProperty(nom);
//        this.categorieAliment = new SimpleStringProperty(categorie);
//
//        // Some initial dummy data, just for convenient testing.
//        this.prixAliment = new SimpleIntegerProperty(0);
//        this.quantiteAliment = new SimpleIntegerProperty(100);
//    }

    public int getIdAliment() {
        return idAliment.get();
    }

    public void setIdAliment(int id) {
        this.idAliment.set(id);
    }

    public IntegerProperty idAlimentProperty() {
        return idAliment;
    }


    public String getNomAliment() {
        return nomAliment.get();
    }

    public void setNomAliment(String nom) {
        this.nomAliment.set(nom);
    }

    public StringProperty nomAlimentProperty() {
        return nomAliment;
    }

    public String getCategorieAliment() {
        return categorieAliment.get();
    }

    public void setCategorieAliment(String categorie) {
        this.categorieAliment.set(categorie);
    }

    public StringProperty categorieAlimentProperty() {
        return categorieAliment;
    }

    public int getPrixAliment() {
        return prixAliment.get();
    }

    public void setPrixAliment(int prix) {
        this.prixAliment.set(prix);
    }

    public IntegerProperty prixAlimentProperty() {
        return prixAliment;
    }

    public int getQuantiteAliment() {
        return quantiteAliment.get();
    }

    public void setQuantiteAliment(int quantite) {
        this.quantiteAliment.set(quantite);
    }

    public IntegerProperty quantiteAlimentProperty() {
        return quantiteAliment;
    }
}