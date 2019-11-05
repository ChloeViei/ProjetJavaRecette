import controller.IngredientOverviewController;
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
        this.primaryStage.setTitle("Food Wars");

        initRootLayout();

        showAlimentOverview();

    }

    public void initRootLayout() {
        try {

            // Give the controller access to the main app.
            RootLayoutController controller = new RootLayoutController();

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
            IngredientOverviewController controller = new IngredientOverviewController();

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Aliment/IngredientOverview.fxml"));
            loader.setController(controller);
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public boolean showIngredientEditDialog(Aliment aliment) {
//        try {
//            // Load the fxml file and create a new stage for the popup dialog.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("Aliment/IngredientEditDialog.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//
//            // Create the dialog Stage.
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Edit Aliment");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
////            dialogStage.initOwner(primaryStage);
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
//
//            // Set the ingredient into the controller.
//            IngredientEditDialogController controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            controller.setPerson(person);
//
//            // Set the dialog icon.
//            dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
//
//            // Show the dialog and wait until the user closes it
//            dialogStage.showAndWait();
//
//            return controller.isOkClicked();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
