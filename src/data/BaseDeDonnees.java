package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {
    private Connection connexion = null;

    private BaseDeDonnees(){
        try {
            Class.forName(AccesBaseDonnee.BASEDEDONNEES_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connexion = DriverManager.getConnection(AccesBaseDonnee.BASEDEDONNEES_URL, AccesBaseDonnee.BASEDEDONNEES_USAGER, AccesBaseDonnee.BASEDEDONNEES_MOTDEPASSE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    // Création d'un singleton permettant seulement d'instancié à cette classe que de un objet //
    /////////////////////////////////////////////////////////////////////////////////////////////
    private static BaseDeDonnees instance = null;

    public static BaseDeDonnees getInstance() {
        if (null == instance) {
            instance = new BaseDeDonnees();
        }
        return instance;
    }
    // Fin de la création du singleton


    public Connection getConnexion() {
        return this.connexion;
    }
}
