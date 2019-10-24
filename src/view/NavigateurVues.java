package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurVues extends Application {

    private Stage fenetre;

    public NavigateurVues() {
    }

    @Override
    public void start(Stage fenetre) throws Exception {
        this.fenetre = fenetre;

        this.fenetre.setScene(null);
        this.fenetre.show();
    }
}
