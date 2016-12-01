package register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by sabbir on 12/1/16.
 */
public class Main extends Application {
    public static boolean isSplashLoaded=false;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent= FXMLLoader.load(getClass().getResource("profiles.fxml"));

        Scene scene=new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Splash Scene");
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
