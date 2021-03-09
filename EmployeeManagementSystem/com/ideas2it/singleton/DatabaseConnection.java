package com.ideas2it.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection class provides databaseConnevtivity
 * @author PRAVEEN KANDHAN
 * @version 09/03/2021
 */
public class DatabaseConnection {
    private static DatabaseConnection databaseConnection = null;
	
    /**
     * DatabaseConnection method return databaseConnection status
     * @return it returns databaseConnection
     */
    public static DatabaseConnection getInstance() {
        if(null == databaseConnection) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    /**
     * This method connected to the  database
     * @return it returns connection if database connection
     *         is success else it returns null
     */
    public Connection connectDatabase() {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/employeemanagementsystem",
                    "root", "ideas2it");
            return connection;
        } catch (SQLException e) {    
            System.out.println("Connection failed");
            e.printStackTrace();
        } 
        return null;
    }
}	