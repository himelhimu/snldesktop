package register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sabbir on 12/1/16.
 */
public class DatabaseHelper {

    //public static  Connection connection=null;
    //Class.forName("org.sqlite.JDBC");


    public static boolean isDatabseAvilaable() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:sqlite:/home/sabbir/snl.db");
           /* Statement statement=connection.createStatement();
            statement.setQueryTimeout(30);*/
            return true;
           /* statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person(id integer,name string)");*/
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
