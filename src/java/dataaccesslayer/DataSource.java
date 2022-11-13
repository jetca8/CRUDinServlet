package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

import java.util.Properties;
import transferobjects.CredentialsDTO;

/**
 * main() class that accesses a SQL database serves as the starter class for
 * Assignment1 of 22F_CST8288 The intent of the assignment is refactor this
 * class into DAO pattern
 *
 * @author kriger, Jian Zhou
 */
public class DataSource {

    Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false&allowPublicKeyRetrieval=true";
    private String username;
    private String password;
    /**
     * empty parameter constructor
     */
    public DataSource(CredentialsDTO creds) {
        username=creds.getUsername();
        password=creds.getPassword();
    }


    public Connection createConnection() {



        //try with resources
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}//end of class
