package register;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.net.HttpResponse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.javarosa.form.api.FormEntryController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;


/**
 * Created by sabbir on 12/4/16.
 */
public class LogInController implements Initializable {

    Dialog dialog;

    public static final String URL="http://demo.mpower-social.com:8001";
    @FXML
    public JFXButton loginSubmit;
    @FXML
    public  JFXTextField userNameField,passwordField;

    public  String userName,password;

    @FXML
    public AnchorPane anchorPaneLogin;

    public  MouseEvent mouseEvent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        loginSubmit.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            mouseEvent=event;
            login(event);



        });
    }

    public void login(MouseEvent event) {
        //dialog.setTitle("PLease,Wait");
       // dialog.setContentText("Loading.....");
        //dialog.show();
        userName=userNameField.getText().trim();
        password=passwordField.getText().trim();

        System.out.println(userName+password);
        System.out.println("I'm in LoginController");

        LoginTask loginTask=new LoginTask();
        try {
            loginTask.doInBackground();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public class LoginTask extends SwingWorker {

        @Override
        protected Object doInBackground() throws Exception {
            HttpURLConnection httpURLConnection=null;
            java.net.URL url=null;

            url=new URL(URL);
            httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            int httpResponse=httpURLConnection.getResponseCode();

            if (httpResponse==200)
            {
                showMessage();
            }

            if (userName.equalsIgnoreCase("himel") || password.equalsIgnoreCase("1234")) showHomePage();
            else showError();
            return null;

        }
    }

    private void showMessage() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Web Response");
        alert.setHeaderText("Response");
        alert.showAndWait();
    }

    private void showError() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("LogIn Message");
        alert.setHeaderText("Login Error");
        alert.setContentText("UserName,Password mismatch");

        alert.showAndWait();
    }

    private void showHomePage()
    {
        try {
            anchorPaneLogin= FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene homeScene=new Scene(anchorPaneLogin);
            Stage homeStage=(Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            homeStage.setScene(homeScene);
            homeStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
