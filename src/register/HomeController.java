package register;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by sabbir on 12/4/16.
 */
public class HomeController implements Initializable {
    @FXML
    private JFXButton exitButton,logoutButton;

    @FXML
    private AnchorPane homePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void exit(ActionEvent actionEvent)
    {
        System.exit(0);
    }

    @FXML
    private void logout(ActionEvent event){


    }
}
