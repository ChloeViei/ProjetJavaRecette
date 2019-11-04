import controller.PersonOverviewController;
import controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private Stage primaryStage;
    BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Application FX test");

        initRootLayout();

        // TODO: afficher par défaut la liste des ingrédients au lancement du logiciel
        showAlimentOverview();

    }

    public void initRootLayout() {
        try {

            // Give the controller access to the main app.
            RootLayoutController controller = new RootLayoutController();
//            controller.setMainApp(this);

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            URL url = getClass().getResource("view/Menu/RootLayout.fxml");
            loader.setLocation(url);
            loader.setController(controller);
            loader.setClassLoader(getClass().getClassLoader());

            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            System.out.println(scene);

            this.primaryStage.setScene(scene);

            this.primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showAlimentOverview() {
        try {

            // Give the controller access to the fxml page.
            PersonOverviewController controller = new PersonOverviewController();

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Aliment/PersonOverview.fxml"));
            loader.setController(controller);
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
