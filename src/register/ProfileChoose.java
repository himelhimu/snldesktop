package register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by sabbir on 11/30/16.
 */
public class ProfileChoose {

    @FXML
    public Button buttonRegister;

    public void onButtonClicked(ActionEvent event)
    {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("/register/registration.fxml"));
            Scene scene=new Scene(root);
            Stage registerStage=(Stage) ((Node) event.getSource()).getScene().getWindow();
            registerStage.setScene(scene);
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
