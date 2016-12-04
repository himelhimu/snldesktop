package register;

import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static register.LogInController.*;

/**
 * Created by sabbir on 12/4/16.
 */
public class Login {
    public void login() {
        //dialog.setTitle("PLease,Wait");
        // dialog.setContentText("Loading.....");
        //dialog.show();
       /* userName=userNameField.getText().trim();
        password=passwordField.getText().trim();

        System.out.println(userName+password);
        System.out.println("I'm here");*/
    }


    public class LoginTask extends SwingWorker {

        @Override
        protected Object doInBackground() throws Exception {
            HttpURLConnection httpURLConnection=null;
            java.net.URL url=null;

            url=new URL(LogInController.URL);
            httpURLConnection= (HttpURLConnection) url.openConnection();



            return null;

        }
    }
}
