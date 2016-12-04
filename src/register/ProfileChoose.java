package register;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import snl.SnlMain;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sabbir on 11/30/16.
 */
public class ProfileChoose implements Initializable {

    @FXML
    public ImageView doctorImage,nurseImage,fwvImage,sacmoImage;
    @FXML
    private JFXButton logInButton;
    @FXML
    private AnchorPane root;

    public static AnchorPane rootp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        if (!Main.isSplashLoaded)
        {
            loadSPlashScreen();
        }
        rootp=root;

        /*rootp.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            //loadRegister(event);
            Parent root= null;
            try {
                root = FXMLLoader.load(getClass().getResource("registration.fxml"));
                Scene scene=new Scene(root);
                Stage registerStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                registerStage.setScene(scene);
                registerStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/


    }

    @FXML
    private void loginPage(ActionEvent event){

        try {
                Parent root=null;
                root=FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene=new Scene(root);
                Stage loginStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                loginStage.setScene(scene);
                loginStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

   @FXML
   private void register(ActionEvent event){
       try {
            //Parent root=null;
           root=FXMLLoader.load(getClass().getResource("registration.fxml"));
           Scene registrationScene=new Scene(root);
           Stage registrationStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
           registrationStage.setScene(registrationScene);
           registrationStage.setMaximized(true);
           //registrationStage.setFullScreen(true);
           registrationStage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }



    private void loadSPlashScreen() {
        try{
            Main.isSplashLoaded=true;

            StackPane pane=FXMLLoader.load(getClass().getResource("splash.fxml"));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn=new FadeTransition(Duration.seconds(3),pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut=new FadeTransition(Duration.seconds(3),pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished(event -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished(event -> {
                try {
                    AnchorPane parentContent=FXMLLoader.load(getClass().getResource("profiles.fxml"));
                    root.getChildren().setAll(parentContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
           // e.printStackTrace();
            Logger.getLogger(ProfileChoose.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
