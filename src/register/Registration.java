package register;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by sabbir on 11/30/16.
 */
public class Registration implements Initializable {
    @FXML
    private JFXButton buttonRegister;

    @FXML
    private JFXPasswordField textPassword,textConfirmPassword;

    @FXML
    private JFXTextField textName,textVillage,textPo,textMobile,textEmail,textAddress,textDistrict;

    @FXML
    private AnchorPane rootRegistration;



   public String name,district,postOffice,phone,email,address,division,village,userPassword;

    public static final String INSERT_INTO_TABLE="insert into user"+"(userName,password) values"+"(?,?)";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name=textName.getText().trim();
        district=textDistrict.getText().trim();
        userPassword=textConfirmPassword.getText().toLowerCase();

        buttonRegister.setOnMouseClicked(event -> {
            try {
                if (DatabaseHelper.isDatabseAvilaable())
                {
                    registerUser();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });


    }

    private void registerUser() {
        try {
            insertIntoDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       /* try {

           // statement.executeUpdate("insert into user('name','password')");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

    private void insertIntoDatabase() throws SQLException{
         Connection connection=null;
        connection= DriverManager.getConnection("jdbc:sqlite:/home/sabbir/snl.db");
         PreparedStatement preparedStatement=null;

        Statement statement=connection.createStatement();
        statement.setQueryTimeout(30);
        //preparedStatement=connection
        statement.executeUpdate("create table user(userName string,password string)");
        preparedStatement=connection.prepareStatement(INSERT_INTO_TABLE);

        preparedStatement.setString(1,name);
        preparedStatement.setString(2,userPassword);

        preparedStatement.executeUpdate();
        System.out.println("Inserted");



    }
}
