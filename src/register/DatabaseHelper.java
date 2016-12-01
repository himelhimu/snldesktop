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

    public static boolean isDatabseAvilaable()
    {
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("/home/sabbir/snl.db");
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
