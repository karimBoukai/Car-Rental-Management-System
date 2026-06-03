package carrentalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    
    public static Connection connectDb(){
        try {
            // Updated driver class for modern MySQL Connector/J versions
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // SETUP NOTE:
            // If this project is moved to another computer, change these MySQL settings
            // to match that computer's MySQL Server: host/port/database name, username,
            // and password. The database must also contain the required rentcar tables.
            String password = "basilasli123"; 
            
            Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rentcar?useSSL=false&serverTimezone=UTC", 
                "root", 
                password
            );
            return connect;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
