package snl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by sabbir on 11/30/16.
 */
public class SplashScreen extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/register/profiles.fxml"));

        Scene scene=new Scene(root);

        primaryStage.setTitle("SNL");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
