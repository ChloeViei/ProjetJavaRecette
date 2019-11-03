import controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
//        showPersonOverview();

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            URL url = getClass().getResource("view/Menu/RootLayout.fxml");
            loader.setLocation(url);
            loader.setClassLoader(getClass().getClassLoader());

            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            System.out.println(scene);

            this.primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
//            controller.setMainApp(this);

            this.primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
